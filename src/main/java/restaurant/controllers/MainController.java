/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import restaurant.dao.DishDAO;
import restaurant.dao.OrderDAO;
import restaurant.entity.Dish;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import restaurant.model.CartInfo;
import restaurant.model.CustomerInfo;
import restaurant.model.DishInfo;
import restaurant.model.PaginationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import restaurant.validator.CustomerInfoValidator;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import restaurant.dao.BranchDAO;
import restaurant.dao.HistoryDAO;
import restaurant.dao.OrderDetailDAO;
import restaurant.model.BranchInfo;
import restaurant.model.HistoryInfo;
import restaurant.util.SessionUtils;

@Controller
// Cần thiết cho Hibernate Transaction.
@Transactional
// Cần thiết để sử dụng RedirectAttributes
@EnableWebMvc
public class MainController {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private DishDAO dishDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private BranchDAO branchDAO;

    @Autowired
    private CustomerInfoValidator customerInfoValidator;
    
    @Autowired
    private HistoryDAO historyDAO;

    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        // Trường hợp update SL trên giỏ hàng.
        // (@ModelAttribute("cartForm") @Validated CartInfo cartForm)
        if (target.getClass() == CartInfo.class) {

        } // Trường hợp save thông tin khách hàng.
        // (@ModelAttribute("customerForm") @Validated CustomerInfo
        // customerForm)
        else if (target.getClass() == CustomerInfo.class) {
            dataBinder.setValidator(customerInfoValidator);
        }

    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "/403";
    }

    @RequestMapping("/")
    public String home(Model model,
            @RequestParam(value = "name", defaultValue = "") String likeName,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        List<DishInfo> dish = orderDetailDAO.getListTopSell();
        model.addAttribute("listDish", dish);
        
        final int maxResult = 5;
        final int maxNavigationPage = 10;

        PaginationResult<DishInfo> result = dishDAO.queryDishs(page, //
                maxResult, maxNavigationPage, likeName);

        model.addAttribute("paginationDish", result);
        return "index";
    }

    @RequestMapping("/branch")
    public String branch(Model model) {
        List<BranchInfo> branch = branchDAO.queryBranch();
        model.addAttribute("listBranch", branch);
        return "branch";
    }

    // Danh sách sản phẩm.
    @RequestMapping({"/productList"})
    public String listProductHandler(Model model, //
            @RequestParam(value = "name", defaultValue = "") String likeName,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        final int maxResult = 5;
        final int maxNavigationPage = 10;

        PaginationResult<DishInfo> result = dishDAO.queryDishs(page, //
                maxResult, maxNavigationPage, likeName);

        model.addAttribute("paginationDish", result);
        return "productList";
    }

    @RequestMapping({"/buyProduct"})
    public String listProductHandler(HttpServletRequest request, Model model, //
            @RequestParam(value = "id", defaultValue = "1") int id) {

        Dish dish = null;
        dish = dishDAO.findDish(id);

        if (dish != null) {

            // Thông tin giỏ hàng có thể đã lưu vào trong Session trước đó.
            CartInfo cartInfo = SessionUtils.getCartInSession(request);

            DishInfo productInfo = new DishInfo(dish);

            cartInfo.addProduct(productInfo, 1);
        }

        // Chuyển sang trang danh sách các sản phẩm đã mua.
        return "redirect:/shoppingCart";
    }

    @RequestMapping({"/shoppingCartRemoveProduct"})
    public String removeProductHandler(HttpServletRequest request, Model model, //
            @RequestParam(value = "id", defaultValue = "") int id) {
        Dish dish = null;

        dish = dishDAO.findDish(id);

        if (dish != null) {

            // Thông tin giỏ hàng có thể đã lưu vào trong Session trước đó.
            CartInfo cartInfo = SessionUtils.getCartInSession(request);

            DishInfo dishInfo = new DishInfo(dish);

            cartInfo.removeProduct(dishInfo);

        }

        // Chuyển sang trang danh sách các sản phẩm đã mua.
        return "redirect:/shoppingCart";
    }

    // POST: Cập nhập số lượng cho các sản phẩm đã mua.
    @RequestMapping(value = {"/shoppingCart"}, method = RequestMethod.POST)
    public String shoppingCartUpdateQty(HttpServletRequest request, //
            Model model, //
            @ModelAttribute("cartForm") CartInfo cartForm) {

        CartInfo cartInfo = SessionUtils.getCartInSession(request);
        cartInfo.updateQuantity(cartForm);

        // Chuyển sang trang danh sách các sản phẩm đã mua.
        return "redirect:/shoppingCart";
    }

    // GET: Hiển thị giỏ hàng.
    @RequestMapping(value = {"/shoppingCart"}, method = RequestMethod.GET)
    public String shoppingCartHandler(HttpServletRequest request, Model model) {
        CartInfo myCart = SessionUtils.getCartInSession(request);

        model.addAttribute("cartForm", myCart);
        return "shoppingCart";
    }

    // GET: Nhập thông tin khách hàng.
    @RequestMapping(value = {"/shoppingCartCustomer"}, method = RequestMethod.GET)
    public String shoppingCartCustomerForm(HttpServletRequest request, Model model) {

        CartInfo cartInfo = SessionUtils.getCartInSession(request);

        // Chưa mua mặt hàng nào.
        if (cartInfo.isEmpty()) {

            // Chuyển tới trang danh giỏ hàng
            return "redirect:/shoppingCart";
        }

        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
        if (customerInfo == null) {
            customerInfo = new CustomerInfo();
        }

        model.addAttribute("customerForm", customerInfo);

        return "shoppingCartCustomer";
    }

    // POST: Save thông tin khách hàng.
    @RequestMapping(value = {"/shoppingCartCustomer"}, method = RequestMethod.POST)
    public String shoppingCartCustomerSave(HttpServletRequest request, //
            Model model, //
            @ModelAttribute("customerForm") @Validated CustomerInfo customerForm, //
            BindingResult result, //
            final RedirectAttributes redirectAttributes) {

        // Kết quả Validate CustomerInfo.
        if (result.hasErrors()) {
            customerForm.setValid(false);
            // Forward to reenter customer info.
            // Forward tới trang nhập lại.
            return "shoppingCartCustomer";
        }

        customerForm.setValid(true);
        CartInfo cartInfo = SessionUtils.getCartInSession(request);

        cartInfo.setCustomerInfo(customerForm);

        // Chuyển hướng sang trang xác nhận.
        return "redirect:/shoppingCartConfirmation";
    }

    // GET: Xem lại thông tin để xác nhận.
    @RequestMapping(value = {"/shoppingCartConfirmation"}, method = RequestMethod.GET)
    public String shoppingCartConfirmationReview(HttpServletRequest request, Model model) {
        CartInfo cartInfo = SessionUtils.getCartInSession(request);

        // Chưa mua mặt hàng nào.
        if (cartInfo.isEmpty()) {

            // Chuyển tới trang danh giỏ hàng
            return "redirect:/shoppingCart";
        } else if (!cartInfo.isValidCustomer()) {

            // Chuyển tới trang nhập thông tin khách hàng.
            return "redirect:/shoppingCartCustomer";
        }

        return "shoppingCartConfirmation";
    }

    @RequestMapping(value = {"/shoppingCartConfirmation"}, method = RequestMethod.POST)
    public String shoppingCartConfirmationSave(HttpServletRequest request, HttpServletResponse response, Model model) {
        CartInfo cartInfo = SessionUtils.getCartInSession(request);
        int orderid = 0;
        // Chưa mua mặt hàng nào.
        if (cartInfo.isEmpty()) {

            // Chuyển tới trang danh giỏ hàng
            return "redirect:/shoppingCart";
        } else if (!cartInfo.isValidCustomer()) {

            // Chuyển tới trang nhập thông tin khách hàng.
            return "redirect:/shoppingCartCustomer";
        }
        try {
            orderid = orderDAO.saveOrder(cartInfo);
        } catch (Exception e) {

            // Cần thiết: Propagation.NEVER?
            return "shoppingCartConfirmation";
        }

        // Xóa rỏ hàng khỏi session.
        SessionUtils.removeCartInSession(request);

        // Lưu thông tin đơn hàng đã xác nhận mua.
        SessionUtils.storeLastOrderedCartInSession(request, cartInfo);

        if (orderid != 0) {
            Cookie cookie = new Cookie("idorder" + orderid, String.valueOf(orderid));
            response.addCookie(cookie);
        }

        // Chuyến hướng tới trang hoàn thành mua hàng.
        return "redirect:/shoppingCartFinalize";
    }

    @RequestMapping(value = {"/shoppingCartFinalize"}, method = RequestMethod.GET)
    public String shoppingCartFinalize(HttpServletRequest request, Model model) {

        CartInfo lastOrderedCart = SessionUtils.getLastOrderedCartInSession(request);

        if (lastOrderedCart == null) {
            return "redirect:/shoppingCart";
        }

        return "shoppingCartFinalize";
    }

    @RequestMapping(value = {"/history"}, method = RequestMethod.GET)
    public String historyCart(HttpServletRequest request, Model model) {
        List<HistoryInfo> list =null;
        
        Cookie cookies[] = request.getCookies();
       List<Integer> ids = new ArrayList<Integer>();
        for (Cookie cookie : cookies) {
            if(!cookie.getName().equals("JSESSIONID")) {
                ids.add(Integer.parseInt(cookie.getValue()));
            }
        }
        list = historyDAO.getListHistory(ids);

      
        model.addAttribute("listHistory", list);
        return "history";
    }
}
