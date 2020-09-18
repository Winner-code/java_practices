package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 在$.ajax()方法中提交数据
 */
@WebServlet("/data.do")
public class DataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String userid = req.getParameter("id");
         String username = req.getParameter("name");
        PrintWriter pw = resp.getWriter();
        pw.print(userid+" "+username);
        pw.flush();
        pw.close();
    }
}
