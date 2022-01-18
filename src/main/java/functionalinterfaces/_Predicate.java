package functionalinterfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

//Represents a predicate (boolean-valued function) of one argument.
public class _Predicate {

    public static void main(String[] args) {

        //test evaluates this predicate on the given argument.
        isPhoneNumberValidPredicate.test("07000000000");

        //We can combine predicates, the same way as we did earlier with Functions using "andThen". In this case we use boolean operators
        //AND -> both of them have to be true
        //OR -> either one of them needs to be true
        boolean b = isPhoneNumberValidPredicate.and(containsNumber3).test("07000000030");
        System.out.println(b);
    }

    //IMPERATIVE
    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    //DECLARATIVE
    static Predicate<String>isPhoneNumberValidPredicate =
            phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;


    static Predicate<String> containsNumber3 =
            phoneNumber -> phoneNumber.contains("3");

    //Bi predicates takes 2 arguments insteadOfOne.
    static BiPredicate<String, Boolean> something;


}

//Personal notes:
/*
Predicats venen a ser els metodes que retornen un boolean
de tota sa vida
 */
