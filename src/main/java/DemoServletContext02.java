import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/context02")
public class DemoServletContext02 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this.getServletContext() = " + this.getServletContext());
        ServletContext context = this.getServletContext();
        System.out.println("loginId:" + context.getInitParameter("loginid") + ",loginpwd:"+ context.getInitParameter("loginpwd"));
        System.out.println("msg:" + context.getAttribute("msg"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
