package imperative;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("JJ", Gender.MALE),
                new Person("Aina", Gender.FEMALE),
                new Person("Davida", Gender.OTHER),
                new Person("Curro", Gender.OTHER)
        );

        //IMPERATIVE APPROACH
        /*
        List<Person> females = new ArrayList<>();

        for(Person p : people){
            if (p.gender.equals(FEMALE)) {
                //System.out.println(p.toString());
                females.add(p);
            }
        }

        for(Person f: females){
            System.out.println(f);
        }
        */

        //DECLARATIVE APPROACH (waaaay better)

        //stream is an abstract mode
        //Predicate<Person> personPredicate = person -> person.gender.equals(FEMALE);
        //so a prediacte returns true or false based on the given condition which in our
        //case is the gender

        List<Person> females = people.stream()
                //.filer(personPredicate)
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
                //.forEach(System.out::println);
        females.forEach(System.out::println);
    }


}
