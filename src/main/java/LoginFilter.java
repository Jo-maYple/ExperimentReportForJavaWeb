import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

//Filter的相关用法见书P186
@WebFilter(filterName = "loginFilter", urlPatterns = {"/list.jsp", "/add.jsp"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设定字符集
        servletResponse.setContentType("text/html;charset=utf-8");
        //转换Servlet对象以实现方法
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //使用req对象初始化cookies对象
        Cookie[] cookies = req.getCookies();
        String logged = null;
        //以下获取用户浏览器内名为logged的cookie 只有此cookie的值为logged时才会放行正常进入页面，否则会拦截并提示还未登录
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
