package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

//So this class is OK but we can do better (with an interface)

public class CustomerValidatorService {

    private Predicate<String> isEmailValid =
            email -> email.contains("@");

    private Predicate<String> isPhoneNumberValid =
            phoneNumber -> phoneNumber.startsWith("+0");

    private Predicate<LocalDate> isAdult =
            //dob -> Period.between(dob, LocalDate.now()).getYears() > 18;
            dob -> LocalDate.now().getYear() - dob.getYear() > 18;

    public Predicate<Customer> isValidCustomer =
            customer -> isEmailValid.test(customer.getEmail()) &&
                        isPhoneNumberValid.test(customer.getPhoneNumber()) &&
                        isAdult.test(customer.getDoB());
}
