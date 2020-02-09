package cpp.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo6")
public class servletDemo6 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello,doGet..");
        String contextPath = req.getContextPath();//获取虚拟目录
        resp.sendRedirect(contextPath+"/demo7");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello,doPost");
        req.setAttribute("msg","haha");
        req.getRequestDispatcher("/demo7").forward(req,resp);
    }
}
