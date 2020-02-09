package cpp.demo;

import com.sun.javafx.iio.ImageStorage;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
/*
* 简易验证码
* */

@WebServlet("/demo9")
public class servletDemo9 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int width = 100;
        int height = 50;
        BufferedImage bufferedImage = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);

        Graphics graphics = bufferedImage.getGraphics();
        //1.填充背景颜色
        graphics.setColor(Color.pink);//设置画笔颜色
        graphics.fillRect(0,0,width,height);//填充矩形
        //2.画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);
        //3.写验证码

        String str = "QWERTYUIOPLKJHGFDSAZXCVBNMzxcvbnmlkjhgfdsaqwertyuiop0123456789";
        Random random = new Random();
        for(int i = 1; i <= 4; i++){
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            graphics.drawString(ch+"",width/5*i,height/2);
        }
        //4.划线
        graphics.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);

        }

        ImageIO.write(bufferedImage,"jpg",resp.getOutputStream());//输出流
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
