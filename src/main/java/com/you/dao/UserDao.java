package com.you.dao;


import com.you.listUser.Pagebean;
import com.you.model.User;


import net.sf.json.JSONArray;
import org.aspectj.lang.JoinPoint;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * Created by zhiyou on 15-12-1.
 */
public class UserDao {
    private SimpleJdbcTemplate jdbcTemplate;

    public SimpleJdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    String sql = "insert into user(username,password) values(?,?)";

    public int addUser(User user) {

       int m= jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword());
        return m;
    }

    public int findtotal(String username, String password) {
        String sql = "select count(*) from user where username=? and password=?";
        int total = jdbcTemplate.queryForInt(sql, username, password);
        return total;
    }

    public int totle(){
        String sql = "select count(*) as total from user";
        int total = jdbcTemplate.queryForInt(sql);
        return total;
    }

//    public List<Map<String,Object>> finall(){
//        String sql = "select * from user";
////        Map<String,Object> map = jdbcTemplate.queryForMap(sql);
//        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
//        Map<String,Object> map = new HashMap<String, Object>();
//        String s= null
//        for(Map<String,Object> m:list){
//            for(String k : m.keySet()){
//                System.out.println(k + " : " + m.get(k));
//                s+=k+":"+m.get(k);
//            }
//        }
////        JSONObject obj = new JSONObject();
////        Iterator it = list.iterator();
////        for(int i=0;i<list.size();i++){
////           User o = (User)list.get(i);
////            obj.put("id",o.getId());
////            obj.put("username",o.getUsername());
////            obj.put("password",o.getPassword());
////        }

    public JSONArray finall(){
        String sql="select * from user ";

      //  List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

        List list = jdbcTemplate.queryForList(sql);

        JSONArray jsonList = JSONArray.fromObject(list);

        /**
         * 将list集合转化为map集合类
         * */
//        Map<String,Obj  JSONArray jsonList = JSONArray.fromObject(list);ect> map = new HashMap<String, Object>();
//            String s="";
//        for(Map<String,Object> m:list){
//            for(String k : m.keySet()){
//               s+=k+":"+m.get(k);
//                System.out.println(k + " : " + m.get(k));
//            }
//        }
//        System.out.println("***"+s);
//        JSONObject obj = new JSONObject();
//        Iterator it = list.iterator();
//        for(int i=0;i<list.size();i++){
//           User o = (User)list.get(i);
//            obj.put("id",o.getId());
//            obj.put("username",o.getUsername());
//            obj.put("password",o.getPassword());
//        }
        //测试取出list集合中的数据
//        Iterator it = list.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
        return jsonList;
    }
    public JSONArray finalllist(Pagebean pagebean){
        StringBuffer sql =new StringBuffer("select * from user ");
        if(pagebean!=null){
            sql.append(" limit " + pagebean.getStart() + "," + pagebean.getRows());
        }
        //  List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

        List list = jdbcTemplate.queryForList(sql.toString());

        JSONArray jsonList = JSONArray.fromObject(list);

        /**
         * 将list集合转化为map集合类
         * */
//        Map<String,Obj  JSONArray jsonList = JSONArray.fromObject(list);ect> map = new HashMap<String, Object>();
//            String s="";
//        for(Map<String,Object> m:list){
//            for(String k : m.keySet()){
//               s+=k+":"+m.get(k);
//                System.out.println(k + " : " + m.get(k));
//            }
//        }
//        System.out.println("***"+s);
//        JSONObject obj = new JSONObject();
//        Iterator it = list.iterator();
//        for(int i=0;i<list.size();i++){
//           User o = (User)list.get(i);
//            obj.put("id",o.getId());
//            obj.put("username",o.getUsername());
//            obj.put("password",o.getPassword());
//        }
        //测试取出list集合中的数据
//        Iterator it = list.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
        return jsonList;
    }


    public List list(){
        String sql = "select * from user";
        List<Map<String, Object>> user = jdbcTemplate.queryForList(sql);
        return user;
    }

    public int  changemanage(User user){
//        String sql = "update user set username="+user.getUsername()+",password="+user.getPassword()+" where id="+user.getId();
        String sql = "update user set username=?,password=? where id=?";

      int number=  jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.getId());
        return number;
    }
    public void check(String name){
        System.out.println("=====验证是否合法======="+name);
    }
    public void hello(){
        System.out.println("+++++++");
    }


}

