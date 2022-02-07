package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) throws CustomerNotValidException {
        Customer customer = new Customer(
                "John",
                "john@gmail.com",
                "+072345621",
                LocalDate.of(1999, 05, 12)
        );

//        CustomerValidatorService validator = new CustomerValidatorService();
//
//        boolean test = validator.isValidCustomer.test(customer);
//        System.out.println(test);

        //Using the interface
        ValidationResult result =
                isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS) {
            throw new CustomerNotValidException(result.name());
        }


    }
}
