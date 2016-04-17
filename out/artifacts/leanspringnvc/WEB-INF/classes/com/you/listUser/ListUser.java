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

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping(value ="/studentlist")
        @ResponseBody
    public void listuser(HttpServletRequest request,HttpServletResponse response){
        // todo 获取页面传过来的行数和列数
        String page = request.getParameter("page");//获取jsp页面传过来的参数pags
        String rows = request.getParameter("rows");
        System.out.println(page+"几页几行"+rows);
        // todo 进行分页
        Pagebean pagebean = new Pagebean(Integer.parseInt(page),Integer.parseInt(rows));
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        JSONObject result = new JSONObject();
        JSONArray jsonArray=userDao.finalllist(pagebean);
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
