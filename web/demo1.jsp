<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%

        //获取所有的cookie
        Cookie[] c = request.getCookies();
        boolean flag = false;
        if(c != null && c.length >0){
            for (Cookie cookie : c) {
                String name = cookie.getName();
                //判断名字是否是lastTime
                if("lastTime".equals(name)){
                    flag = true;
                    String value = cookie.getValue();
                    //将最新范文的时间存入cookie
                    Date date = new Date();
                    SimpleDateFormat s= new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String currentDate = s.format(date);
                    System.out.println(currentDate);
                    //url编码
                    currentDate = URLEncoder.encode(currentDate,"utf-8");
                    //Cookie cs = new Cookie("lastTime", currentDate);
                    cookie.setValue(currentDate);
                    //设置cookie存活时间
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);


                    //响应数据，获取上次cookie的value值
                    //String value = cookie.getValue();
                    value = URLDecoder.decode(value,"utf-8");
                    currentDate = URLDecoder.decode(currentDate,"utf-8");
                    System.out.println("1-----"+value);
                    response.getWriter().write("<h1>欢迎回来，上次访问的时间是"+value+"<br> 欢迎回来, 本次使用时间为"+currentDate+"</h1>");
                }


            }
        }

        if(c == null || c.length == 0 || flag == false){

            //将最新范文的时间存入cookie
            Date date = new Date();
            SimpleDateFormat s= new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String value = s.format(date);
            value = URLEncoder.encode(value,"utf-8");
            Cookie cs = new Cookie("lastTime", value);
            //设置cookie存活时间
            cs.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cs);

            response.getWriter().write("<h1>欢迎首次访问</h1>");
        }


    %>

</body>
</html>
