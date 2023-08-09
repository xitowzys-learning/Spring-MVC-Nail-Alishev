package me.xitowzys.springcourse.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Person {

    private int id;
    private String name;

}
