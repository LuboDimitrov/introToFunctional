package functionalinterfaces;

import java.util.function.Supplier;


public class _Supplier {

    public static void main(String[] args) {

        System.out.println(getDBConnectionURSupplier.get());

    }

    //IMPERATIVE
    static String getDBConnectionURL(){
        return "http://localhost:8080/user";
    }

    //DECLARATIVE
    //So basically suppliers just return any kind of value, whereas
    //Functions modify a value and return it.
    static Supplier<String>getDBConnectionURSupplier =
            () -> "http://localhost:8080/user";
}
