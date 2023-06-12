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
        //设定req和resp的字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session1 = req.getSession(); //获取session对象 后续方法和ListServlet类中描述的大体相同
        List<Student> stu = null;
        Writer wr = resp.getWriter();
        //以下为从网页获取数据并初始化Student对象
        Student stu1 = new Student();
        stu1.setUserName(req.getParameter("userName"));
        stu1.setNumber(req.getParameter("number"));
        stu1.setSex(req.getParameter("sex"));
        stu1.setClassName(req.getParameter("className"));
        stu1.setDepartment(req.getParameter("department"));
        //新建临时列表并将初始化好的student对象添加进临时列表中
        List<Student> liststu = new ArrayList<Student>();
        liststu.add(stu1);
        //获取session对象 如没有则创建，若有则添加
        stu = (List)session1.getAttribute("student");
        if (stu == null){
            stu = liststu;
        } else {
            stu.add(stu1);
        }
        session1.setAttribute("student",stu);
        //完成此操作后将请求转发到list.jsp 书P95
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
