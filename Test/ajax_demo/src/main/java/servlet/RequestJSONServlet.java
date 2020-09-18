package servlet;

import com.bjsxt.pojo.Users;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 在请求中通过JSON格式传递数据
 */
@WebServlet("/json.do")
public class RequestJSONServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过字符输入流从请求体中获取提交的JSON格式的数据
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        //使用Jackson将JSON格式的字符串对象转换成java对象
        ObjectMapper objectMapper = new ObjectMapper();
        Users users = objectMapper.readValue(s, Users.class);
        System.out.println(users.getUserid()+" "+users.getUsername());
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();
        pw.print("OK");
        pw.flush();
        pw.close();
    }
}
