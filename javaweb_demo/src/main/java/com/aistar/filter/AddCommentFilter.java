package com.aistar.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AddCommentFilter",urlPatterns = "/addcomment")
public class AddCommentFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String commnet = req.getParameter("comment");
        if (commnet.contains("AAA")||commnet.contains("BBB")){
            req.setAttribute("commentmsg","评论非法");
            commnet = commnet.replace("AAA","***");
            commnet = commnet.replace("BBB","***");
            req.setAttribute("comment",commnet);
//            req.getRequestDispatcher("/add_comment.jsp").forward(req,resp);
        }else {
            req.setAttribute("comment",commnet);
        }
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
