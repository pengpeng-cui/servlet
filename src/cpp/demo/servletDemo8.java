package cpp.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo8")
public class servletDemo8 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置该流的默认编码
        //resp.setCharacterEncoding("UTF-8");

        //告诉浏览器服务器发送的消息体的编码格式，建议浏览器使用的编码
        //resp.setHeader("content-type","text/html;charset=utf-8");

        //简单的形式，设置编码，是在获取流之前设置
        resp.setContentType("text/html;charset=utf-8");
        //获取字符输出流
        PrintWriter p = resp.getWriter();
        p.write("<h1> hello...你好 </h1>");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
