package com.you;

import com.you.dao.UserDao;
import com.you.model.User;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhiyou on 15-11-30.
 */
@Scope("prototype")
@Controller
@RequestMapping("/login")
public class Login {
    @RequestMapping(value ="/verify",method = RequestMethod.POST)

    public ModelAndView verify(HttpServletRequest request,HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
//        userDao.addUser(user);
        String view = "login";

        /**
         * modelandview中的数据默认放到request里面
         * */
        ModelAndView modelAndView = new ModelAndView();
            userDao.finall();
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//          //  System.out.println("00000"+list.get(i).getId()+list.get(i).getUsername());
//        }
//        JSONObject obj = new JSONObject();
//        Iterator it = list.iterator();
//        for(int i=0;i<list.size();i++){
//            User o = (User)list.get(i);
//            System.out.println(o.getId()+"  "+o.getPassword()+" "+o.getUsername()+"****");
////            obj.put("id",o.getId());
////            obj.put("username",o.getUsername());
////            obj.put("password",o.getPassword());
//        }
       int total =   userDao.findtotal(username,password);
        if(total>0){
       //     PrintWriter out = null;
//            response.setContentType("application/json");
//
//            try {
//                out=response.getWriter();
//                out.write(userDao.finall());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println(result+"rrrrrr");
//            try {
//                out = response.getWriter();
//                out.print(userDao.finall());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            modelAndView.addObject("user",userDao.finall());
            modelAndView.setViewName(view);
        }
        else {
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }
}
