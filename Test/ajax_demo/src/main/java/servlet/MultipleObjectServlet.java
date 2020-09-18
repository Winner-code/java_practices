package servlet;

import pojo.Users;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过JSON格式响应多个对象
 */
@WebServlet("/multiple.do")
public class MultipleObjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users1 = new Users();
        users1.setUserid(1);
        users1.setUsername("oldlu");
        Users users2 = new Users();
        users2.setUserid(2);
        users2.setUsername("kevin");

        //需要将多个对象放入到集合中
        List<Users> list = new ArrayList<>();
        list.add(users1);
        list.add(users2);

        //通过jackson将List转换为JSON格式的字符串对象
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(list);
        System.out.println(string);
         resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();
        pw.print(string);
        pw.flush();
        pw.close();
    }
}
