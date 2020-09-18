package servlet;

import common.JsonUtils;
import pojo.User;
import pojo.Users;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户管理Servlet
 */
@WebServlet("/user.do")
public class UserServlet extends HttpServlet {
    //生成模拟数据初始化
    @Override
    public void init() throws ServletException {
        User user = new User();
        user.setUserid(1);
        user.setUsername("Oldlu");
        user.setUsersex("male");
        user.setUserbirth(new Date());
        User user2 = new User();
        user2.setUserid(2);
        user2.setUsername("Kevin");
        user2.setUsersex("male");
        user2.setUserbirth(new Date());
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("list",list);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String flag = req.getParameter("flag");
            if("getData".equals(flag)){
                this.getData(req,resp);
            }else if("addUser".equals(flag)){
                this.addUser(req,resp);
            }else if("updateUser".equals(flag)){
                this.updateUser(req,resp);
            }else{
                this.deleteUser(req,resp);
            }
    }

    //获取页面初始化数据
    private void getData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = (List<User>) this.getServletContext().getAttribute("list");
        String s = JsonUtils.objectToJson(list);
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();
        pw.print(s);
        pw.flush();
        pw.close();
    }
    //处理添加用户请求
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            User user = this.createUser(req);
            ServletContext servletContext = this.getServletContext();
            List<User> list = (List<User>) servletContext.getAttribute("list");
            list.add(user);
            resp.setContentType("text/plain;charset=utf-8");
            PrintWriter pw = resp.getWriter();
            pw.print("添加成功");
            pw.flush();
            pw.close();
    }
    //获取请求数据
    private User createUser(HttpServletRequest req){
        String userid = req.getParameter("userid");
        String username = req.getParameter("username");
        String usersex = req.getParameter("usersex");
        String userbirth  = req.getParameter("userbirth");

        User user  = new User();
        user.setUserid(Integer.parseInt(userid));
        user.setUsername(username);
        user.setUsersex(usersex);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = sdf.parse(userbirth);
            user.setUserbirth(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return user;
    }

    //处理更新用户请求
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        User user = this.createUser(req);
        ServletContext servletContext = this.getServletContext();
        List<User> list = (List<User>) servletContext.getAttribute("list");
        User u = null;
        for(User temp : list){
            if(temp.getUserid() == user.getUserid()){
                u = temp;
                break;
            }
        }
        if(u != null){
            list.remove(u);
        }
        list.add(user);
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.print("更新成功");
        pw.flush();
        pw.close();
    }

    //处理删除用户请求
    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ServletContext servletContext = this.getServletContext();
        List<User> list = (List<User>) servletContext.getAttribute("list");
        String userid = req.getParameter("userid");
        User user = null;
        for(User temp:list){
            if((temp.getUserid()+"").equals(userid)){
                user = temp;
                break;
            }
        }
        if(user != null){
            list.remove(user);
        }
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.print("删除成功");
        pw.flush();
        pw.close();
    }
}
