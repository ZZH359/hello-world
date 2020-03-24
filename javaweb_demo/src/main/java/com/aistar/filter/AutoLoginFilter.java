//package com.aistar.filter;
//
//import com.aistar.pojo.Customer;
//import com.aistar.service.CustomerService;
//import com.aistar.service.Impl.CustomerServiceImpl;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(filterName = "AutoLoginFilter",urlPatterns = "/*",initParams = {
//                    @WebInitParam(name="ignorePath",value =
//                        "autologin.jsp;customer/autologin;customer/logout")
//})
//public class AutoLoginFilter implements Filter {
//    private String[] ignorePath;
//    public void init(FilterConfig config) throws ServletException {
//        String ignorePathStr = config.getInitParameter("ignorePath");
//        ignorePath =ignorePathStr.split(";");
//    }
//
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        //获得请求资源，并排除非过滤请求
//        HttpServletRequest request  = (HttpServletRequest)req;
//        HttpServletResponse response = (HttpServletResponse)resp;
//        //如果请求为登录或登出，则不拦截，直接放行
//        for (String path:ignorePath){
//            if (request.getRequestURI().contains(path)){
//                //放行
//                chain.doFilter(req, resp);
//                return;
//            }
//        }
//        //拦截请求，并开始处理。。。
//        //先判断session信息，本次会话是否为登录状态
//        HttpSession session = request.getSession();
//        Customer customer = (Customer) session.getAttribute("logincustomer");
//        //有用户信息，说明已登陆，直接放行
//        if (customer !=null){
//            //放行
//            chain.doFilter(req, resp);
//        }else {//没有用户信息，则要开始判断cookie有无自动登录
//            Cookie[] cookies = request.getCookies();
//            if (cookies == null){//cookie为空，则直接跳转去登陆页面
//                response.sendRedirect(request.getContextPath()+"/customer/autologin.jsp");
//            }else {//cookie不为空，则要查看是否有自动登录cookie：autologincustomer
//                for (Cookie cookie:cookies){
//                    //如果存在自动登录cookie，则获取cookie中的账号、密码，执行登录操作
//                    if (cookie.getName().equals("autologincustomer")){
//                        String username=cookie.getValue().split("&")[0];
//                        String userpwd=cookie.getValue().split("&")[1];
//                        //执行登录
//                        CustomerService service = new CustomerServiceImpl();
//                        Customer loginCustomer = service.getByUsernameAndPwd(username,userpwd);
//                        //判断是否登录成功，即账号、密码正确
//                        if (loginCustomer !=null){//登录成功
//                            session.setAttribute("logincustomer",loginCustomer);
//                            session.setAttribute("logincustomername",username);
//                            //跳转到首页
//                            response.sendRedirect(request.getContextPath()+"/index.jsp");
//                            return;
//                        }else {//登录失败，则直接跳转到登录页面
//                            response.sendRedirect(request.getContextPath()+"/customer/autologin.jsp");
//                            return;
//                        }
//                    }
//                }
//                //cookie中没有自动登录，直接跳转到登录页面
//                response.sendRedirect(request.getContextPath()+"/customer/autologin.jsp");
//            }
//        }
//    }
//
//
//    public void destroy() {
//    }
//}
