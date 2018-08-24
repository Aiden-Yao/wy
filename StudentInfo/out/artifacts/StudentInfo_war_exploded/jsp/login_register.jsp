<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2018/8/17
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   /* String fh = request.getParameter("result");
    System.out.println(fh);*/
%>
<html>
<head>
    <title>登录界面</title>
    <link href="../css/login_RegisterPage.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
      <div class="box1"><div class="box5"><div class="box3">
          <div class="box2">
          <input class="PageBtn btn" type="button" value="login" onclick="loginDisplay()">
              <input class="PageBtn btn" type="button" value="register" onclick="registerDisplay()">
          </div>

         <div class="box4">
             <div id="Login" class="box6">
             <br> <div class="input-group">
             <span class="input-group-addon glyphicon glyphicon-user"></span>
             <input class="input1 form-control" type="text" id="username" placeholder="please enter username here"></div>
                 <div id="hide1" class="check" style="color: red"></div>
                 <br><br>
             <div class="input-group">
                 <span class="input-group-addon glyphicon glyphicon-lock"></span>
                 <input class="input1 form-control" type="password" id="password" placeholder="please enter password here"></div>
                 <div id="hide2" class="check" style="color: red"></div>
                 <br><input type="checkbox" id="autologin">Automatic login<span>&#160&#160&#160&#160&#160&#160&#160&#160</span>
                 <input type="checkbox" id="memorypass">Remember the password
                 <br><br>
              <input class="btn1 btn btn-info" id="loginBtn" type="button" value="login" onclick="loginServer()">
              </div>

           <div id="Register" style="display: none" class="box6">
               <br><div class="input-group">
               <span class="input-group-addon glyphicon glyphicon-user"></span>
               <input class="input1 form-control" type="text" id="registername" placeholder="please enter username here"></div>
               <div id="hide3" class="check" style="color: red"></div>
               <br><br>
               <div class="input-group">
                   <span class="input-group-addon glyphicon glyphicon-lock"></span>
                   <input class="input1 form-control" type="password" id="registerpass" placeholder="please enter password here"></div>
                    <div id="hide4" class="check" style="color: red"></div>
                    <br><br>
                   <input class="btn1 btn btn-info" type="button" value="register" onclick="registerServer()">
           </div></div></div>
          </div>
      </div>
</body>
</html>
<%--<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>--%>
<%--<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>--%>
<%--<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/login_register.js"></script>

<%--<script>--%>
    <%--var xmlHttp = false;--%>
    <%--xmlHttp = new XMLHttpRequest();--%>
    <%--function loginServer(){--%>
        <%--var username = document.getElementById("username").value;--%>
        <%--var password = document.getElementById("password").value;//这两行是要传的值--%>
        <%--if((username == null)||(username == "")){--%>
            <%--alert("登录帐号不能为空");--%>
            <%--return;--%>
        <%--}--%>
        <%--if((password == null)||(password == "")){--%>
            <%--alert("登录密码不能为空");--%>
            <%--return;--%>
        <%--}--%>

        <%--var url = "/Login?username=" + escape(username) + "&password=" + escape(password);--%>
        <%--xmlHttp.open("GET",url,true);--%>
        <%--//xmlHttp.onreadystatechange = updatePage;--%>
        <%--xmlHttp.onreadystatechange = function (){--%>
            <%--if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {--%>
                <%--// alert(xmlHttp.responseText);--%>
                <%--if(xmlHttp.responseText == "true"){--%>
                <%--// window.open("jsp/Panel.jsp");//打开一个新的界面--%>
                <%--//     window.location.href = "jsp/Panel.jsp";//不打开新的界面--%>
                <%--location.href = "/searchAllInfo";//不打开新的界面--%>
                <%--} else{--%>
                    <%--document.getElementById("password").value = "";--%>
                    <%--alert("用户名或密码错误！请重新输入");--%>
                <%--}--%>
            <%--}--%>
            <%--// else {--%>
            <%--//     alert(xmlHttp.statusText);--%>
            <%--//--%>
            <%--// }--%>
        <%--};--%>
        <%--xmlHttp.send(null);--%>
    <%--}--%>
    <%--function registerServer(){--%>
        <%--var registername = document.getElementById("registername").value;--%>
        <%--var registerpass = document.getElementById("registerpass").value;//这两行是要传的值--%>
        <%--if((registername == null)||(registername == "")){--%>
            <%--alert("注册账号不能为空");--%>
            <%--return;--%>
        <%--}--%>
        <%--if((registerpass == null)||(registerpass == "")){--%>
            <%--alert("注册密码不能为空");--%>
            <%--return;--%>
        <%--}--%>

        <%--var url = "/Register?registername=" + escape(registername) + "&registerpass=" + escape(registerpass);--%>
        <%--xmlHttp.open("GET",url,true);--%>
        <%--//xmlHttp.onreadystatechange = updatePage;--%>
        <%--xmlHttp.onreadystatechange = function (){--%>
            <%--if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {--%>
                <%--// alert(xmlHttp.responseText);--%>
                <%--if(xmlHttp.responseText == "true"){--%>
                <%--// window.open("jsp/Panel.jsp");//打开一个新的界面--%>
                    <%--alert("注册成功！即将返回登录界面");--%>
                    <%--location.href = "";//刷新界面--%>
                   <%--}--%>
                <%--// else--%>
                <%--//     alert("用户名或密码错误！请重新输入")--%>
            <%--}--%>
            <%--// else {--%>
            <%--//     alert(xmlHttp.statusText);--%>
            <%--//--%>
            <%--// }--%>
        <%--};--%>
        <%--xmlHttp.send(null);--%>
    <%--}--%>
    <%--function updatePage() {--%>
        <%--if (xmlHttp.readyState == 4) {--%>
            <%--var response = xmlHttp.responseText;--%>
        <%--}--%>
    <%--}--%>
    <%--function registerDisplay() {//这两个函数表示同一界面上点击不同按钮出现不同界面：登录或者注册--%>
        <%--document.getElementById("Login").style.display = "none";--%>
        <%--document.getElementById("Register").style.display = "block";--%>
    <%--}--%>
    <%--function loginDisplay(){--%>
        <%--document.getElementById("Register").style.display = "none";--%>
        <%--document.getElementById("Login").style.display = "block";--%>
    <%--}--%>
<%--</script>--%>

