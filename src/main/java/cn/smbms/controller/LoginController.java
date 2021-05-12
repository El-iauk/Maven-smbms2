package cn.smbms.controller;
import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public String login(@RequestParam String userCode, @RequestParam String userPassword, HttpSession session, Model model) throws Exception {
        User user = userService.login(userCode, userPassword);
        if (user != null) {
            session.setAttribute(Constants.USER_SESSION, user);
            return "redirect:frame.do";
        } else {
            model.addAttribute("error", "用户名或者密码错误");
            return "../login";
        }

    }
    @RequestMapping("/frame.do")
    public String frame() {
        return "frame";
    }
}
