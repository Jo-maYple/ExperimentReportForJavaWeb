import main.java.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(urlPatterns = "/list.jsp")
public class ListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session1 = req.getSession(false);
        List<Student> stu = null;
        Writer wr = resp.getWriter();
        if (session1 == null){wr.write("无学生信息<br>");}
        else {
            stu = (List) session1.getAttribute("student");
            if (stu == null){wr.write("无学生信息<br>");}
            else{
                wr.write("学生信息为:<br>");
                for (Student stuinf:stu){
                    wr.write(stuinf.toString());
                    wr.write("<br>");
                }
            }
        }
        wr.write("<a href=\"/1/add.jsp\">添加学生信息</a><br>");
        wr.write("当前在线:" + this.getServletContext().getAttribute("onlineCount") + "<br>");
        wr.write("总访问量:" + this.getServletContext().getAttribute("historyCount"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
