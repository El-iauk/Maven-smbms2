package cn.smbms.service.user;

import java.util.List;

import cn.smbms.mapper.user.UserDao;
import cn.smbms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int dele(Integer id) {
        return userDao.dele(id);
    }

    @Override
    public int Update(User user) {
        return userDao.Update(user);
    }

    @Override
    public boolean add(User user) throws Exception {
        return userDao.add(user);
    }

    @Override
    public User login(String userCode, String userPassword) throws Exception {
        return userDao.getLoginUser(userCode,userPassword);
    }

    @Override
    public List<User> getUserList(String queryUserName, Integer queryUserRole, Integer currentPageNo, Integer pageSize) throws Exception {
        return userDao.getUserList(queryUserName,queryUserRole,currentPageNo,pageSize);
    }
    @Override
    public int getUserCount(String queryUserName, Integer queryUserRole) throws Exception {
        return userDao.getUserCount(queryUserName,queryUserRole);
    }

    @Override
    public User selectUserCodeExist(String userCode) throws Exception {
        return userDao.getLoginUser2(userCode);
    }

    @Override
    public boolean deleteUserById(Integer delId) {
        return false;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public boolean modify(User user) {
        return false;
    }

    @Override
    public boolean updatePwd(int id, String pwd) {
        return false;
    }

    @Override
    public List<User> userlist() {
        return userDao.userlist();
    }
}
