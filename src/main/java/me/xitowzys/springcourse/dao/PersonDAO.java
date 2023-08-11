package me.xitowzys.springcourse.dao;

import me.xitowzys.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class PersonDAO {


    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:mariadb://localhost:3306/spring_lesson";
    private static final String USERNAME = "georgekalinka";
    private static final String PASSWORD = "12345678";


    private static Connection connection;

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> index() {
        List<Person> personList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                personList.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return personList;
    }

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person(name, age, email) VALUES ('" +
                    person.getName() + "', " + person.getAge() + ", '" + person.getEmail() + "')";

            statement.executeUpdate(SQL);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
    }

    public Person show(int id) {
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }

    public void update(int id, Person updatedPerson) {
//        Person personToBeUpdated = show(id);
//
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }


    public void delete(int id) {
//        Predicate<Person> idPredicate = new Predicate<Person>() {
//            @Override
//            public boolean test(Person person) {
//                return person.getId() == idToRemove;
//            }
//        };

//        people.removeIf(p -> p.getId() == id);
    }
}
