package servlet;

import pojo.Users;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过JSON格式响应单个对象
 */
@WebServlet("/single.do")
public class SingleObjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //创建Users对象
        Users users = new Users();
        users.setUserid(1);
        users.setUsername("oldlu");

        //使用jackson的API将Users对象转换为JSON格式的字符串对象
        ObjectMapper objectMapper = new ObjectMapper();

        //将Users对象转换为JSON格式的字符串对象
        String string = objectMapper.writeValueAsString(users);
        System.out.println(string);

        //设置响应类型为application/json
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();
        pw.print(string);
        pw.flush();
        pw.close();
    }
}
