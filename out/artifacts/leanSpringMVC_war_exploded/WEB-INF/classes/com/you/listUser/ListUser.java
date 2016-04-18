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

        String page = request.getParameter("page");//获取jsp页面pags页数
        String rows = request.getParameter("rows");//获取jsp页面rows一页多少行
        String username = request.getParameter("username");//获取搜索时页面填入的用户名

        System.out.println("用户名"+username);

        if(username==null){//username 引用为空，没有分配空间，也没有实例化对向
         username="";//引用一个空的字符串，分配了空间，实列化了对象
     }

        User user = new User();
        user.setUsername(username);

        Pagebean pagebean = new Pagebean(Integer.parseInt(page),Integer.parseInt(rows));//实列化分页类，并强制类型转换

        //获取spring中定义的bean实例的对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");//
        UserDao userDao = (UserDao) context.getBean("userDao");

        /*
        *   将封装好JSONArray类型的数据和获取的数据总条数添加到JSONObject中
        * */
        JSONObject result = new JSONObject();
        JSONArray jsonArray=userDao.finalllist(pagebean,user);//得到查询后的数据，并将其封装成JSONArray类型的数据
        int total = userDao.totle();//户获取总的数据条数
        result.put("rows",jsonArray);
        result.put("total",total);
        try {
            Responseutil.write(response,result);//将JSONObject类型的数据写回页面
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
