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
        resp.setContentType("text/html;charset=utf-8"); //设定字符集，防止乱码
        HttpSession session1 = req.getSession(false); //获取此次访问的session对象 书P107
        List<Student> stu = null; //学生对象使用List对象存储 此处先初始化List对象
        Writer wr = resp.getWriter(); //初始化writer
        if (session1 == null){wr.write("无学生信息<br>");} //如果getSession方法没有获取到正确初始化session则会返回null 此处对没获取到的情况进行处理
        else {
            stu = (List) session1.getAttribute("student"); //如果获取到了session对象 则从session中获取键为student的值对象并转化为List
            if (stu == null){wr.write("无学生信息<br>");} //此处对没有获取到student值的情况进行处理
            else{
                wr.write("学生信息为:<br>"); //若正确获取则循环输出学生信息
                for (Student stuinf:stu){
                    wr.write(stuinf.toString());
                    wr.write("<br>");
                }
            }
        }
        //在list.jsp中添加一个链接用来请求add.jsp页面
        wr.write("<a href=\"/1/add.jsp\">添加学生信息</a><br>");
        //以下为实验三内容
        wr.write("当前在线:" + this.getServletContext().getAttribute("onlineCount") + "<br>");
        wr.write("总访问量:" + this.getServletContext().getAttribute("historyCount"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
