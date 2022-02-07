package finalSection;

import java.util.function.Function;

public class lambdas {

    public static void main(String[] args) {

        //This is only when u have 1 return statement (u return the value immediately)
        Function<String, String> upperCaseName = String::toUpperCase; // same as name -> name.toUpperCase()

        //If u dont return the value immediately, u may use {}
        Function<String, String> upperCaseName2 = name ->{
            //logic
            if(name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };
    }

    /*
    BEAR IN MIND:
    Functional interfaces only take the object type and not primitives
    YES: Function<Integer...
    NO: Function<int...

    We should not declare functional interfaces as static, yet in this course
    is okay cus we are using them in the main method.
     */
}
