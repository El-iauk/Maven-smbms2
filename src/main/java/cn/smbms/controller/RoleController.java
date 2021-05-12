package cn.smbms.controller;

import cn.smbms.pojo.Role;
import cn.smbms.service.role.RoleService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("/getlist")
    public String getList(HttpSession session) throws Exception {
        List<Role> list = roleService.getRoleList();
        session.setAttribute("list",list);
        return "a";
    }
}
