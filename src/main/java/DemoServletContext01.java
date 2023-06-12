import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(urlPatterns = "/context01")
public class DemoServletContext01 extends HttpServlet {

    /**
     * 此函数输入一个文件，若文件不存在或不正确将会输出”文件不存在“。
     * 否则输出文件内容在控制台。
     */
    static void printString(File file) throws IOException {
        if (file.exists()){
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String line;
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
        System.out.println("this.getServletContext() = " + this.getServletContext());//获取此应用的ServletContext实例ID
        ServletContext context = this.getServletContext();
        //下面这行代码会获取在web.xml中初始化的数据并输出 书P80
        System.out.println("loginId:" + context.getInitParameter("loginid") + ",loginpwd:"+ context.getInitParameter("loginpwd"));
        context.setAttribute("msg", "登录成功！"); //设定域属性，第一个参数为属性名，第二个参数为属性值 Context的接口方法 书P82
        File file1 = new File(context.getRealPath("/WEB-INF/classes/jdbc.properties")); //设定初始化三个文件对象获取方式见书P84
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
