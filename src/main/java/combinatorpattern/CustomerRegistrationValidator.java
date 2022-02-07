package combinatorpattern;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.function.Function;
import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

//Recall
/*
        1.apply() :
            R apply(T t)
                Parameters: This method takes in only one parameter t which is the function argument
                Return Type: This method returns the function result which is of type R.

        2.andThen()
            default <V> Function<T, V>
            andThen(Function<? super R, ? extends V> after)
                Parameters: This method accepts a parameter after which is the function to be applied after the current one.
                Return Value: This method returns a composed function that applies the current function first and then the after function
        3.compose()
        4.identity()
*/

//extends Function es pq no ho haguem de posar a cada metode
public interface CustomerRegistrationValidator extends Function <Customer, ValidationResult>{

    /*
     Unlike other methods in Interface, the static methods contain the complete definition of
      the function and since the definition is complete and the method is static,
      therefore these methods cannot be overridden or changed in the implementation class.
     */

    //All these methods return a ValidatonResult (high order property) since all of them are of
    //CustomerRegistrationValidator type and it extends Function<Customer, ValidationResult>
    //Bottom line: we return another function
    static CustomerRegistrationValidator isEmailValid(){
        return customer ->
                customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid(){
        return customer ->
                customer.getPhoneNumber().startsWith("+0") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }


    static CustomerRegistrationValidator isAnAdult(){
        return customer ->
                LocalDate.now().getYear() - customer.getDoB().getYear() > 18 ? SUCCESS : AGE_UNDER_18;
    }

    //the combinated pattern allows us to change all of the functions together

    /*
    Before Java 8, interfaces could have only abstract methods.
    The implementation of these methods has to be provided in a separate class.
    So, if a new method is to be added in an interface,
    then its implementation code has to be provided in the class implementing the same interface.
    To overcome this issue, Java 8 has introduced the concept of default methods which allow
     the interfaces to have methods with implementation without affecting the classes that implement the interface.
     */
    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return  customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        AGE_UNDER_18
    }

    /*
    Difference between static and default methods

        Calling the method
            You can call a static method using the name of an interface.
            To call a default method you need to use the object of the implementing class.

        Overriding the method
            If you want, you can override a default method of an interface from the implementing class.
            Static methods cannot be overrided

     */


    /*
    DIFFERENCE BETWEEN == and equals()

     == checks if both objects point to the same memory location whereas .equals() evaluates to the comparison of values in the objects.

        String s1 = "HELLO";
        String s2 = "HELLO";
        String s3 =  new String("HELLO");

        Since strings s1 and s2 are declared as literals, they point to the
        same string in the string pool area (located in the heap) == will return true

        When we declare a String with new(), the object is created in the Heap Memory
        having a unique address.
        So, s1 == s3 will return false as the same content is not referenced by both the variables.

     */


}
