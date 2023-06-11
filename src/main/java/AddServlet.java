import main.java.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session1 = req.getSession();
        List<Student> stu = null;
        Writer wr = resp.getWriter();
        Student stu1 = new Student();
        stu1.setUserName(req.getParameter("userName"));
        stu1.setNumber(req.getParameter("number"));
        stu1.setSex(req.getParameter("sex"));
        stu1.setClassName(req.getParameter("className"));
        stu1.setDepartment(req.getParameter("department"));
        List<Student> liststu = new ArrayList<Student>();
        liststu.add(stu1);
        stu = (List)session1.getAttribute("student");
        if (stu == null){
            stu = liststu;
        } else {
            stu.add(stu1);
        }
        session1.setAttribute("student",stu);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
