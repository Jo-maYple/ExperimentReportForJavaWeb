import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(urlPatterns = "/context01")
public class DemoServletContext01 extends HttpServlet {

    static void printString(File file) throws IOException {
        if (file.exists()){
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String line = null;
            while ((line = bf.readLine()) != null){
                System.out.println(line);
            }
            bf.close();
        } else {
            System.out.println("文件不存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this.getServletContext() = " + this.getServletContext());
        ServletContext context = this.getServletContext();
        System.out.println("loginId:" + context.getInitParameter("loginid") + ",loginpwd:"+ context.getInitParameter("loginpwd"));
        context.setAttribute("msg", "登录成功！");
        File file1 = new File(context.getRealPath("/WEB-INF/classes/jdbc.properties"));
        File file2 = new File(context.getRealPath("/jdbc.properties"));
        File file3 = new File(context.getRealPath("/WEB-INF/jdbc.properties"));
        printString(file1);
        printString(file2);
        printString(file3);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
