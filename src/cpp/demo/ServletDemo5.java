package cpp.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/demo5")
public class ServletDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流
        BufferedReader br = request.getReader();
        //读数据
        String line = null;
        while ((line = br.readLine())!= null){
            System.out.println(line);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //Referer: http://localhost:8080/login.jsp

            String header = request.getHeader("Referer");
            System.out.println(header);
    }
}
