package com.you.listUser;

import com.you.dao.UserDao;
import com.you.model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by zhiyou on 16-4-13.
 */
@Controller
public class ListUser {
    @RequestMapping(value ="/studentlist",method = RequestMethod.POST)
        @ResponseBody

    public void listuser(HttpServletResponse response){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        JSONObject result = new JSONObject();
        JSONArray jsonArray=userDao.finall();
        int total = userDao.totle();
        result.put("rows",jsonArray);
        result.put("total",total);
        try {
            Responseutil.write(response,result);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        Map<String, Object> result = new HashMap<String, Object>(2) ;
//        List<User> list = userDao.list();
//        JSONArray jsonArray = new JSONArray();
//        for(User users:list){
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("id",users.getId());
//            jsonObject.put("username",users.getUsername());
//            jsonObject.put("password",users.getPassword());
//            jsonArray.add(jsonObject);
//        }
//            result.put("totle",list.size());
//            result.put("rows",jsonArray);
//            return JSONObject.fromObject(result);
    }
}
