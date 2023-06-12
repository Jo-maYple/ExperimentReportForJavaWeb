import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//监听器相关见书P196
@WebListener
public class OnlineListener implements HttpSessionListener, ServletContextListener {

    //在web应用初始化时候会触发一次该监听器
    //在web应用初始化阶段将web.xml内的属性初始化为context全局属性
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context =  sce.getServletContext();
        context.setAttribute("onlineCount", Integer.valueOf(context.getInitParameter("onlineCount")));
        context.setAttribute("historyCount", Integer.valueOf(context.getInitParameter("historyCount")));
    }

    //在建立新session对象时会触发一次该监听器
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //从session对象初始化context对象
        ServletContext context = se.getSession().getServletContext();
        //将全局变量对应的值在有新访问时+1
        context.setAttribute("onlineCount", (int)context.getAttribute("onlineCount")+1);
        context.setAttribute("historyCount", (int)context.getAttribute("historyCount")+1);
    }

    //在session对象超时销毁时会触发一次该对象
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        //由于题目要求维护两个变量 其中一个访问量在仅需要增加而不需要减少。而这个在线量则需要在session过期时-1
        context.setAttribute("onlineCount", (int)context.getAttribute("onLineCount")-1);
    }
}
