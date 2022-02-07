package streams;


import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {


        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("JJ", Gender.MALE),
                new Person("Aina", Gender.FEMALE),
                new Person("Davida", Gender.OTHER),
                new Person("Curro", Gender.OTHER)
        );

        //List<Gender> genders =
        //Function<Person, Gender> personGenderFunction = person -> person.getGender();
        //Consumer<Gender> println = System.out::println;
        people.stream()
                .map(/*personGenderFunction*/ person -> person.getGender())
                .collect(Collectors.toList())
                .forEach(/*println*/ System.out::println);


        Predicate<Person> personPredicate = person -> "FEMALE".equals(person.getGender());
        boolean allFemales = people.stream()
                //We wanna know if we have just females in our list of people
                .allMatch(personPredicate);

    }
}
