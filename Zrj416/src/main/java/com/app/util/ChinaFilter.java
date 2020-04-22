package com.app.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ChinaFilter",urlPatterns = "/*",initParams = @WebInitParam(name = "encoding", value = "utf-8"))
public class ChinaFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
        System.out.println("ChinaFilter 处理");
    }
    String encoding="";
    public void init(FilterConfig config) throws ServletException {
        encoding=config.getInitParameter("encoding");
        System.out.println(config.getInitParameter("encoding"));
    }

}
