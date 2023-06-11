import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineListener implements HttpSessionListener, ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context =  sce.getServletContext();
        context.setAttribute("onlineCount", Integer.valueOf(context.getInitParameter("onlineCount")));
        context.setAttribute("historyCount", Integer.valueOf(context.getInitParameter("historyCount")));
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        System.out.println(context.getAttribute("onlineCount"));
        System.out.println(context.getAttribute("historyCount"));
        int onlineCount = (int)context.getAttribute("onlineCount");
        int historyCount = (int)context.getAttribute("historyCount");
        context.setAttribute("onlineCount", onlineCount+1);
        context.setAttribute("historyCount", historyCount+1);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        int onlineCount = (int)context.getAttribute("onLineCount");
        context.setAttribute("onlineCount", onlineCount-1);
    }
}
