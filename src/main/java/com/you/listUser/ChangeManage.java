package com.you.listUser;

import com.you.dao.UserDao;
import com.you.model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhiyou on 16-4-14.
 */
@Controller
public class ChangeManage {
    @RequestMapping("/changeManage")
    public void changuser(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);
        User user = new User(userId,username,password);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserDao userDao =  context.getBean("userDao",UserDao.class);
       int number= userDao.changemanage(user);
        JSONObject result = new JSONObject();
        if(number>0){
            result.put("result","true");
        }
        else {
            result.put("result","false");
        }
        try {
            Responseutil.write(response,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
