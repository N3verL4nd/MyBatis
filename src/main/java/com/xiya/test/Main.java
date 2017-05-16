package com.xiya.test;

import com.xiya.dao.PersonMapper;
import com.xiya.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by N3verL4nd on 2017/5/9.
 */
public class Main {
    private static SqlSessionFactory sqlSessionFactory = null;

    static
    {
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
    public static void main(String[] args) {

        SqlSession sqlSession= getSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);


        //增加
        /*Person newPerson = new Person("阡陌", 24);
        personMapper.AddPerson(newPerson);
        sqlSession.commit();
        System.out.println(newPerson.getId());*/

        //删除
        /*personMapper.deletePersonById(12);
        sqlSession.commit();*/

        //修改
        /*Person person = personMapper.getPersonById(3);
        person.setAge(100);
        person.setName("芊漪");
        personMapper.updatePerson(person);
        sqlSession.commit();*/

        //查询（返回Person）
        /*Person person = personMapper.getPersonById(1);
        System.out.println(person);*/

        //查询（返回Person集合）
        List<Person> list = personMapper.getAllPersons();
        /*
        * 等价于：
        * List<Person> list = sqlSession.selectOne("com.xiya.dao.PersonDao.getAllPersons");
        * */
        for (Person p : list) {
            System.out.println("id = " + p.getId() + "  name = " + p.getName() + "  age = " + p.getAge());
        }

        //关闭 SqlSession
        sqlSession.close();
    }
}
