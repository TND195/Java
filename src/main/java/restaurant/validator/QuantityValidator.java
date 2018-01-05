/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import restaurant.model.CartLineInfo;

/**
 *
 * @author Admin
 */
@Component
public class QuantityValidator  implements Validator{

    public boolean supports(Class<?> clazz) {
        return clazz == CartLineInfo.class;
    }

    public void validate(Object o, Errors errors) {
      CartLineInfo cartLineInfo = (CartLineInfo) o;
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "IsInt.quantity");
    }
//    public static boolean isInteger(String s) {
//      boolean isValidInteger = false;
//      try
//      {
//         Integer.parseInt(s);
// 
//         // s is a valid integer
// 
//         isValidInteger = true;
//      }
//      catch (NumberFormatException ex)
//      {
//         // s is not an integer
//      }
// 
//      return isValidInteger;
//   }
    
    
}
