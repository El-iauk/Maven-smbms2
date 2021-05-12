package cn.smbms.service.user;

import cn.smbms.mapper.user.UserDao;
import cn.smbms.pojo.User;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicatonContext.xml")
public class UserServiceImplTest extends TestCase {
    @Autowired
    UserDao userDao;


    public static void main(String[] args) {
        System.out.println("中文");
    }

    @Test
    public void testGetUserList() throws Exception {
        List<User> userList = userDao.getUserList("李", 1, 0, 5);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void cx() throws Exception {
        List<User> userList = userDao.userlist();
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void getUserById() throws Exception {
        User userById = userDao.getUserById(1);
        System.out.println(userById);

    }
    @Test
    public void dele() {
        int dele = userDao.dele(17);
        System.out.println(dele);
    }

    @Test
    public void add() throws Exception {
        User user = new User();
        user.setUserCode("111");
        user.setUserName("张三");
        boolean add = userDao.add(user);
        System.out.println(add);
    }

    @Test
    public void Update() {
        User user = new User();
        user.setId(21);
        user.setUserCode("222");
        user.setUserName("李四");
        int update = userDao.Update(user);
        System.out.println(update);
    }
//    public void cx() {
//        ApplicationContext context
//                = new ClassPathXmlApplicationContext("applicatonContext.xml");
//        UserService userService = context.getBean(UserService.class);
//        userService.getUserList();
//
//    }
}