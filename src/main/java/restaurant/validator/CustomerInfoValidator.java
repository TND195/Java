/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.validator;

import restaurant.model.CustomerInfo;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
  
// Khai báo là một @Component (Nghĩa là 1 Bean).
@Component
public class CustomerInfoValidator implements Validator {
 
   private EmailValidator emailValidator = EmailValidator.getInstance();
 
  
   // Validator này chỉ dùng để kiểm tra class CustomerInfo.
   @Override
   public boolean supports(Class<?> clazz) {
       return clazz == CustomerInfo.class;
   }
 
   @Override
   public void validate(Object target, Errors errors) {
       CustomerInfo custInfo = (CustomerInfo) target;
 
  
       // Kiểm tra các trường (field) của CustomerInfo.
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.customerForm.name");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.customerForm.address");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty.customerForm.phone");

   }
 
}
