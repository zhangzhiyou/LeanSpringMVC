package com.you.listUser;

import com.you.dao.UserDao;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhiyou on 16-4-15.
 */
@Controller
public class DeleteMange {
    @RequestMapping("/deleteMange")
    public void delete(HttpServletRequest request,HttpServletResponse response){
        String deiLds = request.getParameter("deiLds");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserDao userDao = context.getBean("userDao",UserDao.class);
        int delNums = userDao.deleteMasege(deiLds);
        JSONObject result = new JSONObject();
        if(delNums>0){
            result.put("success","true");
            result.put("delNums",delNums);//前台可以根据delNums获取删除的条数
            result.put("name","张志友");
        }
        else {
            result.put("errorMas","删除失败");
        }
        try {
            Responseutil.write(response,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
