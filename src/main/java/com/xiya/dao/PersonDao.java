package com.xiya.dao;

import com.xiya.entity.Person;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by N3verL4nd on 2017/5/9.
 */
public interface PersonDao {
//    boolean insertPerson(Person person);
//    boolean deletePerson(int id);
    //@Select("SELECT * FROM persons WHERE id = #{id}")
    Person getPersonById(int id);

    //@Select("SELECT * FROM persons")
    List<Person> getAllPersons();

    void deletePersonById(int id);
    void AddPerson(Person person);
    void updatePerson(Person person);
}
