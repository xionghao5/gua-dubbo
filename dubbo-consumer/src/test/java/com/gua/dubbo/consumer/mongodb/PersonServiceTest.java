package com.gua.dubbo.consumer.mongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 插入文档
     */
    @Test
    public void insert() {
        Person person = new Person();
        person.setId(1l);
        person.setUsername("张三");
        person.setPassWord("123456");
        person.setAge(18);
        Date now = new Date();
        person.setCreateTime(now);
        person.setUpdateTime(now);
        mongoTemplate.insert(person);


        mongoTemplate.updateFirst(new Query().addCriteria(Criteria.where("_id").is(1L)), new Update().set("username", "李四").set("age", 17), Person.class);

        Person fP = mongoTemplate.findOne(new Query(Criteria.where("_id").is(1L)), Person.class);
        System.out.println(fP);

        mongoTemplate.remove(Person.class);
        mongoTemplate.dropCollection(Person.class);
    }
}
