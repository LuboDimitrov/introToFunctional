package finalSection;

import java.util.function.Consumer;

public class Callbacks {

    public static void main(String[] args) {

        hello("John", null, value ->
                System.out.println("No last name not provided for " + value));

        helloRunnable("John", null, () ->
                System.out.println("No last name not provided "));
    }


    //JS callback simulation
    static void hello(String firstName, String lastName, Consumer<String> callback) {
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void helloRunnable(String firstName, String lastName, Runnable callback) {
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
