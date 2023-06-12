import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/config01", initParams = { //使用@WebServlet注解配置Servlet 参照书P78
        @WebInitParam(name = "name", value = "张三"), @WebInitParam(name = "sex", value = "男")}) //初始化数据，参照书P78、81
public class DemoServletConfig01 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this.getServletConfig() = " + this.getServletConfig()); //获取ServletConfig对象并输出
        System.out.println("姓名：" + this.getInitParameter("name") + ",性别:" + this.getInitParameter("sex")); //获取初始化参数并输出 书P81
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
