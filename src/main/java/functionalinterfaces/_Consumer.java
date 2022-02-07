package functionalinterfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/*
A consumer represents an operation that accepts a single argument
and returns no result
*/
public class _Consumer {

    public static void main(String[] args) {

        // IMPERATIVE
        Customer c1 = new Customer("John", "123456789");
        //greetConsumer(c1);

        //DECLARATIVE
        greetCustomer.accept(c1);
        greetCustomerBi.accept(c1, false);
    }

    /*IMPERATIVE
    static void greetConsumer(Customer customer){
        System.out.printf("Hello %s%n", customer.name);
    }
    */

    //DECLARATIVE WAY
    /*
    Definition: A consumer represents an operation that accepts a single argument
    and returns no result. It s like a void function
    */
    static Consumer<Customer> greetCustomer =
            customer -> System.out.printf("Hello %s%n", customer.name);
//             ^
    //         |
    //       parameter. It s what goes within the () in the imperative function
    //          |
// (Customer customer)
//     ^
//     |
//<Customer>


    //Every functional interface (Consumer, Function...) has the Bi version

    static BiConsumer<Customer, Boolean> greetCustomerBi =
            //parametres
            (customer, showPhoneNumber) ->
                    System.out.println("Hello "+ customer.name +
                    ", ty 4 registering phone number "
                    + (showPhoneNumber ? customer.phoneNumber : "********"));

    //Same as above but in imperative programming
    static void greetCustomerBiIMPERATIVE (Customer customer, Boolean showPhoneNumber){
        System.out.println("Hello "+ customer.name +
                ", ty 4 registering phone number "
                + (showPhoneNumber ? customer.phoneNumber : "********"));
    }




    static class  Customer {
        private final String name;
        private final String phoneNumber;

        public Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
