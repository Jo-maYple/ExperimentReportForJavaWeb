import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.Writer;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设定字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        Writer wr = resp.getWriter();
        //对用户侧发送的内容进行判断，如果账号密码均正确则设定cookie的logged的值为logged 否则打印密码错误的返回内容
        if (req.getParameter("userName").equals("1001")){
            if (req.getParameter("passwd").equals("123")){
                resp.addCookie(new Cookie("logged", "logged"));
                wr.write("登录成功<br><a href=\"/1/list.jsp\">添加学生信息</a>");
            } else {
                wr.write("用户名或密码错误<br><a href=\"/1/login.jsp\">返回登录页面</a>");
            }
        } else {
            wr.write("用户名或密码错误<br><a href=\"/1/login.jsp\">返回登录页面</a>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
