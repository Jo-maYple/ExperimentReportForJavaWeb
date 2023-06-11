import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/config01", initParams = {
        @WebInitParam(name = "name", value = "张三"), @WebInitParam(name = "sex", value = "男")})
public class DemoServletConfig01 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this.getServletConfig() = " + this.getServletConfig());
        System.out.println("姓名：" + this.getInitParameter("name") + ",性别:" + this.getInitParameter("sex"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
