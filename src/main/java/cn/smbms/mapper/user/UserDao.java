package cn.smbms.mapper.user;

import java.sql.Connection;
import java.util.List;

import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    //删除
    int dele(Integer id);

    List<User> getList();

    int Update(User user);

    public boolean add(User user) throws Exception;


    public User getLoginUser(@Param("userCode") String userCode, @Param("userPassword") String userPassword) throws Exception;


    public List<User> getUserList(
            @Param("userName") String userName,
            @Param("userRole") Integer userRole,
            @Param("currentPageNo") Integer currentPageNo,
            @Param("pageSize") Integer pageSize) throws Exception;


    public int getUserCount(
            @Param("userName") String userName,
            @Param("userRole") Integer userRole) throws Exception;


    public int deleteUserById(Connection connection, Integer delId) throws Exception;


    public User getUserById( Integer id) throws Exception;


    public int modify(Connection connection, User user) throws Exception;


    public int updatePwd(Connection connection, int id, String pwd) throws Exception;


    User getLoginUser2(@Param("userCode") String userCode) throws Exception;

    List<User>userlist();

}
