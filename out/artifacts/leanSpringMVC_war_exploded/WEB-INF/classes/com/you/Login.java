package com.you;

import com.you.dao.UserDao;
import com.you.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhiyou on 15-11-30.
 */
@Scope("prototype")
@Controller
@RequestMapping("/login")
public class Login {
    @RequestMapping(value ="/verify",method = RequestMethod.POST)
    public String verify(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
//        userDao.addUser(user);
        String view = "login";
       int total =   userDao.findtotal(username,password);
        request.setAttribute("name","<h1>"+username+"<h1>");
        if(total>0){
            return view;
        }
        else {
            return "index";
        }
    }
}
