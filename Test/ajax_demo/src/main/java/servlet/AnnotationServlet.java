package servlet;

import com.bjsxt.common.JsonUtils;
import com.bjsxt.pojo.Users;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Jackson常用注解的使用
 */
@WebServlet("/ann.do")
public class AnnotationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = new Users();
        users.setUserid(1);
        users.setUsername("oldlu");
        users.setUserbirth(new Date());
       /* ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(users);*/
        String string = JsonUtils.objectToJson(users);
        System.out.println(string);

        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();
        pw.print("Jackson Annotation");
        pw.flush();
        pw.close();
    }
}
