package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用Map模型传递数据
 */
@WebServlet("/map.do")
public class MapModelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //一个Map对象表示的是一个JSON格式的对象
        Map<String,Object> map = new HashMap<>();
        map.put("userid",1);
        map.put("url","map.do");

        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(map);
        System.out.println(string);
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();
        pw.print(string);
        pw.flush();
        pw.close();
    }
}
