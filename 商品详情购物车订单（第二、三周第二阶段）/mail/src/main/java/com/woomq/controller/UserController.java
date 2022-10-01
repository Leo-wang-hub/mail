package com.woomq.controller;

import com.woomq.pojo.User;
import com.woomq.service.CarService;
import com.woomq.service.GoodsService;
import com.woomq.service.TypeService;
import com.woomq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Woo-mq
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    CarService carService;
    @GetMapping("/user/toRegister/")
    public String toRegister(){
        return "register";
    }

    /**
     * 根据username查找用户是否已经被注册
     * @return
     */
    @GetMapping("/user/getUserByUsername")
    @ResponseBody
    public int getUserByUsername(String username){
        User userByUserName = userService.getUserByUserName(username);
        System.out.println(userByUserName);
        if(userByUserName==null){
            return 0;
        }
        else{
            return 1;
        }



    }

    /**
     *完成用户注册
     */
    @GetMapping("/user/register")
    public  String registerSubmit(User user){
        userService.addUser(user);
        return "login";

    }

    /**
     * 检查用户名和密码是否一致
     * @param username
     * @param password
     * @param model
     * @return
     */
   @GetMapping("/user/login")
    public String checkLogin(String username, int password, Model model, HttpSession httpSession, RedirectAttributes redirectAttributes){
       User userByUserName = userService.getUserByUserName(username);
       if(userByUserName.getPassword()==password){
           //用户名和密码匹配
           httpSession.setAttribute("user",userByUserName);
           model.addAttribute("carNum",carService.carNums());
           return "redirect:/main.html";

       }
       else{
           //用户名和密码不匹配
           model.addAttribute("msg","用户名或密码错误");
           return "login";
       }
   }

}
