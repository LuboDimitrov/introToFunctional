package functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        //DECLARATIVE

        //apply lets us "use" the function
        //Integer increment = incrementByOne.apply(1);
        //System.out.println(increment);

        //System.out.println(add1andMultBy10.apply(4));
        System.out.println(BiFunctionAddBy1andMultBy.apply(1,2));

        //IMPERATIVE

        //int increment = increment(1);
        //System.out.println(increment);
    }

    //DECLARATIVE
    //in: integer
    //out: integer
    //-> lambda
    //abans de -> parametres, despres de -> resultat

    //Definition: Functions are like the methods that PERFORM an action and return a value
    static Function<Integer, Integer>  incrementByOne = number -> ++number;

    static Function<Integer, Integer> multByTen = number -> number * 10;
    //we can chain functions with "andThen"
    static Function<Integer, Integer> add1andMultBy10 = incrementByOne.andThen(multByTen);

    //Bi Function takes two inputs and produces one output
    //1st: number to be added +1.  2nd Mult by 10    3rd Result
    static BiFunction<Integer, Integer, Integer> BiFunctionAddBy1andMultBy =
            (numberToIncrementBy1, numberToMultBy) -> (++numberToIncrementBy1) * numberToMultBy;

    //Imperative
    /*
    static int increment(int n){
        return n + 1;
    }

    //Bi function in imperative way <- peasants way (just kidding :))
    static int incrementAndMult(int a, int b){
        return (a+1)*b;
    }

    */
}
