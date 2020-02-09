<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/2/9
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script>

        window.onload = function(){
            var img = document.getElementById("checkCode");
            img.onclick = function () {
                var date = new Date().getTime();
               // console.log(date);
                img.src = "/demo9?"+date;
            }

        }


    </script>

</head>
<body>

    <img id="checkCode" src="/demo9"/>

    <a id="change" href="">看不清，换一张</a>

</body>
</html>
