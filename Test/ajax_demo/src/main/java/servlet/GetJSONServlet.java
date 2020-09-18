package servlet;

import com.bjsxt.common.JsonUtils;

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
 * getJSON方法传递数据并返回JSON格式数据
 */
@WebServlet("/getJson.do")
public class GetJSONServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("id");
        String username = req.getParameter("name");
        Map<String,String> map = new HashMap<>();
        map.put("userid",userid);
        map.put("username",username);
        String s = JsonUtils.objectToJson(map);
        resp.setContentType("application/json");
        PrintWriter pw = resp.getWriter();
        pw.print(s);
        pw.flush();
        pw.close();
    }
}
