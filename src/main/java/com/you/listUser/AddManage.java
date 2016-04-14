package com.you.listUser;

import com.you.dao.UserDao;
import com.you.model.User;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhiyou on 16-4-13.
 */
@Controller
public class AddManage {
    @RequestMapping(value = "/saveUser",produces = "appllication/json;charset=UTF-8")
    public void addmasage(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String id = request.getParameter("id");
        User user = new User(username,password);
        if(StringUtil.isNotEmpty(id)){
            user.setId(Integer.parseInt(id));
        }
        int savenum=0;
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        JSONObject result = new JSONObject();
//            savenum = userDao.findtotal(user.getUsername(), user.getPassword());
        if(StringUtil.isNotEmpty(id)) {
           savenum= userDao.changemanage(user);
        }
        else {
        savenum = userDao.addUser(user);
        }
        if(savenum>0){
            result.put("success","true");
        }
        else {
            result.put("success","true");
            result.put("errorMas","修改成功");
        }
        try {
            Responseutil.write(response, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
