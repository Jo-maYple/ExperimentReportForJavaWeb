import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

@WebFilter(filterName = "loginFilter", urlPatterns = {"/list.jsp", "/add.jsp"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Cookie[] cookies = req.getCookies();
        String logged = null;
        if (cookies != null){
            for (Cookie cok:cookies){
                if (cok.getValue().equals("logged")) {
                    logged = "logged";
                    break;
                }
            }
        }
        if (!Objects.equals(logged, "logged")){
            Writer wr = servletResponse.getWriter();
            wr.write("您还未登录，请登录后再执行此操作<br><a href=\"/1/login.jsp\">点击跳转回登录页面</a>");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
