package optionals;

import java.util.Optional;
import java.util.function.Supplier;

//Bottom line: Optional helps us deal with null pointer exceptions

public class Main {
    public static void main(String[] args) {
        /*
        Object value = Optional.ofNullable(null)
                .orElseGet(()-> "default value");

        Supplier<IllegalArgumentException> excpetion =
                        ()-> new IllegalArgumentException("exception");

        Optional.ofNullable(null)
                        .ifPresentOrElse(
                                email -> System.out.println("Sending email to " + email),
                                //empty-based action (the code that runs if is null)
                                ()-> System.out.println("No email provided"));

        System.out.println(value);

         */
        //Returns an empty Optional instance. No value is present for this Optional.
        Optional<Object> empty = Optional.empty();
        //When we use Optional.of we know for sure it s not null (we cant pass a null argument)
        Optional<String> something = Optional.of("Something");
        //Use ofNullable if u are not sure whether the value it s null or not
        Optional<String> something2 = Optional.ofNullable("Something 2");
        //isPresent() returns true if the wrapped value is not null.
        System.out.println(empty.isPresent());
        System.out.println(empty.isEmpty());

        //The orElse() method is used to retrieve the value wrapped inside an Optional instance.
        //String orElse = something.orElse("hiiii"); //IMPORTANT: this actually makes no sense since something will never be null cus is Optional.of
        String orElse2 = something2
                //Map allows us to do a transformation in case value it s present
                .map(String::toUpperCase)

                //- The orElseGet() method is similar to orElse(). However, instead of taking a value to return if the Optional value is not present,
                    // it takes a supplier functional interface, which is invoked and returns the value of the invocation:
                    //.orElseGet(()-> "u passed a null argument")
                //- The orElseThrow() method follows from orElse() and orElseGet() and adds a new approach for handling an absent value.
                    //Instead of returning a default value when the wrapped value is not present, it throws an exception
                //The orElse() method returns the wrapped value (Something) if it's present, and its argument otherwise (hiiii)
                    .orElse("u passed a null argument");

        //If a value is present, performs the given action with the value, otherwise does nothing. (Takes a consumer)
        something2.ifPresent(word->
                System.out.println(word));

        Person tom = new Person("Tom", null);
        System.out.println(tom.getEmail()
                            .orElseGet(()->"No email provided"));

    }

    static class Person{
        private final String name;
        private final String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
    }
}
