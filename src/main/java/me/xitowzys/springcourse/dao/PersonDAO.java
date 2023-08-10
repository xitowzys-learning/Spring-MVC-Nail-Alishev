package me.xitowzys.springcourse.dao;

import me.xitowzys.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));

//        System.out.println(this.show(3).getName());
    }

    public List<Person> index() {
        return people;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
    }


    public void delete(int id) {
//        Predicate<Person> idPredicate = new Predicate<Person>() {
//            @Override
//            public boolean test(Person person) {
//                return person.getId() == idToRemove;
//            }
//        };

        people.removeIf(p -> p.getId() == id);
    }
}
