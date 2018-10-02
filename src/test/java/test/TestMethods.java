package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.qiaosoftware.sssp.entities.Person;
import com.qiaosoftware.sssp.entities.User;
import com.qiaosoftware.sssp.service.PersonService;
import com.qiaosoftware.sssp.service.UserService;

public class TestMethods {
    
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    private UserService userService = ioc.getBean(UserService.class);
    private PersonService personService = ioc.getBean(PersonService.class);
    
    @Test
    public void test12() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 1; i < 10; i++) {
            Person person = new Person(null, "黄黄"+i, "huang_"+i+"@163.com", new Date());
            persons.add(person);
        }
        System.out.println(persons);
        
        System.out.println("****************************");
        
        Person[] personArr = persons.toArray(new Person[persons.size()]);
        for (Person person : personArr) {
            System.out.println(person);
        }
    }
    
    @Test
    public void test11() {
        Person person = new Person();
        person.setLastName("张三");
        person.setEmail("zhangsan@163.com");
        person.setBirthday(new Date());
        personService.save(person);
        
        System.out.println(person.getId());
    }
    
    @Test
    public void test10() {
        int i = userService.updateUsername("李四", 56);
        System.out.println(i);
    }
    
    @Test
    public void test09() {
        //List<User> list = userService.queryListByUsernameLike("王五");
        List<User> list = userService.queryListByEmail("2wangwu@163.com");
        for (User user : list) {
            
            System.out.println(user);
        }
        
    }
    
    @Test
    public void test08() {
        //userService.delete(63);
        User user = new User();
        user.setUsername("王五_0");
        userService.save(user);
        /*List<Integer> ids = Arrays.asList(23,25,27,28);
        List<User> list = userService.findAll(ids);
        for (User user : list) {
            System.out.println(user);
        }*/
    }
    
    @Test
    public void test07() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = format.parse("1990-09-30");
        List<User> list = userService.queryListByBirthday(birthday);
        for (User user : list) {
            System.out.println(user);
        }
    }
    
    @Test
    public void test06() throws ParseException {
        //System.out.println(userService.findByUsernameAndPassword("王五_5", "1234565"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = format.parse("1990-09-30");
        //Sort sort = new Sort(Direction.ASC,"id");//顺序
        //Sort sort = new Sort(Direction.DESC,"id");//逆序
        //List<User> list = userService.findByBirthday(birthday, sort);
        
        Pageable pageable = new PageRequest(0, 5);
        Page<User> page = userService.findByBirthday(birthday, pageable);
        for (User user : page.getContent()) {
            System.out.println(user);
        }
    }
    
    @Test
    public void test05() {
        int pageNo = 3;     //查询第一页
        int pageSize = 5;   //每页5条数据
        //Sort sort = new Sort(Direction.ASC,"email");
        //Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
        Pageable pageable = new PageRequest(pageNo - 1, pageSize);
        Page<User> page = userService.findPage(pageable);
        for (User user : page.getContent()) {
            System.out.println(user);
        }
    }
    
    @Test
    public void test04() {
        //userService.deleteAll();
        //Sort sort = new Sort(Direction.ASC,"email");
        Sort sort = new Sort(Direction.DESC,"email");
        List<User> list = userService.findAll(sort);
        for (User user : list) {
            System.out.println(user.getEmail());
        }
    }
    
    @Test
    public void test03() {
        //System.out.println(userService.count());
        //userService.delete(22);
        List<User> list = new ArrayList<User>();
        for (int i = 10; i < 20; i++) {
            User user = new User();
            user.setId(i);
            list.add(user);
        }
        userService.deleteInBatch(list);
        
        //userService.delete(user);
    }
    
    @Test
    public void test02() {
        //System.out.println(userService.findById(2));
        //System.out.println(userService.exists(10));
        List<User> list = userService.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
    
    @Test
    public void test01() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = format.parse("1990-09-30");
        List<User> list = new ArrayList<User>();
        for (int i = 20; i < 40; i++) {
            User user = new User(null, "王五_"+i, "123456"+i, i+"wangwu@163.com", "1372456236"+i, birthday, new Date(), new Date());
            list.add(user);
        }
        userService.save(list);
    }

}
