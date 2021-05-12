package cn.smbms.controller;

import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.role.RoleService;
import cn.smbms.service.user.UserService;
import cn.smbms.util.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @RequestMapping("/list.do")
    public String list(String queryUserName,
                       @RequestParam(defaultValue = "0") Integer queryUserRole,
                       @RequestParam(defaultValue = "1") Integer currentPageNo,
                       @RequestParam(defaultValue = "5") Integer pageSize, HttpSession session, Model model) throws Exception {

        int currentPageNo2 = 0;
        if (currentPageNo > 1) {
            currentPageNo2 = (currentPageNo - 1) * pageSize;
        }
        List<User> userlist = userService.userlist();
        session.setAttribute("userist",userlist);
        //查询总记录数,计算总页数
        int count = userService.getUserCount(queryUserName, queryUserRole);
        //对页码和每页大小兼容性处理
        PageSupport pageSupport = new PageSupport(currentPageNo, pageSize, count);
        //查询用户列表
        List<User> userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo2, pageSize);
        //获取角色列表
        List<Role> roleList = roleService.getRoleList();
        model.addAttribute("queryUserName", queryUserName);
        model.addAttribute("queryUserRole", queryUserRole);
        model.addAttribute("userList", userList);
        model.addAttribute("roleList", roleList);
        model.addAttribute("pageSupport", pageSupport);
        return "user/userlist";
    }

    @RequestMapping("/userlist.do")
    public String userlist() {
        return "user/userlist";
    }

    //跳转到添加用户页面
    @RequestMapping("/useradd.do")
    public String useradd(User user, Model model) throws Exception {
        return "user/useradd";
    }

    @RequestMapping("add.do")
    public String add(User user) throws Exception {
         userService.add(user);
        return "user/list";
    }

    @RequestMapping("/userCode_add")
    @ResponseBody
    public String userCode_add(String userCode) throws Exception {
        User user = userService.selectUserCodeExist(userCode);
        if (user != null) {
            return "true";
        } else {
            return "false";
        }
    }
    //通过id 查询用户信息
    @RequestMapping("/getUserById.do")
    public String getUserById(Integer id, Model model) throws Exception {
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user/userview";
    }

    @RequestMapping("/deleteUserById.do")
    @ResponseBody
    public String deleteUserById(Integer id) throws Exception {
        boolean user = userService.deleteUserById(id);
        if (user) {
            return "true";
        } else {
            return "false";
        }
    }

}
