// function loginServer() {
//     // var username = $("#username").val();
//     // var password = $("#password").val();
//     var username = document.getElementById("username").value;
//     var password = document.getElementById("password").value;
//     if((username == null)||(username == "")){
//         alert("登录帐号不能为空");
//         return;
//     }
//     if((password == null)||(password == "")){
//         alert("登录密码不能为空");
//         return;
//     }
//     $.ajax({
//         url:'/Login',
//         method:'get',
//         async:false,
//         data:{
//             username: username,
//             password: password
//         },
//         success:function(result){
//             if(result == "true") {
//                 setInterval(function () {
//                     // window.location.href = "http://localhost:8080/searchAllInfo";
//                     window.location.href = "/searchAllInfo";
//                 }, 2000);
//             } else{
//                 alert("用户名或密码错误！请重新输入");
//                 document.getElementById("password").value = "";
//             }
//         },
//         error:function () {
//             alert("wrong")
//         }
//     });
// }
// function registerServer() {
//     // var registername = $("#registername").val();
//     // var registerpass = $("#registerpass").val();
//     var registername = document.getElementById("registername").value;
//     var registerpass = document.getElementById("registerpass").value;//这两行是要传的值
//     if((registername == null)||(registername == "")){
//         alert("注册账号不能为空");
//         return;
//     }
//     if((registerpass == null)||(registerpass == "")){
//         alert("注册密码不能为空");
//         return;
//     }
//     $.ajax({
//         url:'/Register',
//         method:'get',
//         async:false,
//         data:{
//             registername: registername,
//             registerpass: registerpass
//         },
//         success:function(result){
//             if(result == "true") {
//                 setInterval(function () {
//                     alert("注册成功！即将返回登录界面");
//                     window.location.href = "";
//                 }, 2000);
//             } else{
//
//             }
//         },
//         error:function () {
//             alert("wrong")
//         }
//     });
// }
// function registerDisplay() {//这两个函数表示同一界面上点击不同按钮出现不同界面：登录或者注册
//     document.getElementById("Login").style.display = "none";
//     document.getElementById("Register").style.display = "block";
//     // $("#Login").style.display = "none";
//     // $("#Register").style.display = "block";
// }
// function loginDisplay(){
//     document.getElementById("Register").style.display = "none";
//     document.getElementById("Login").style.display = "block";
//     // $("#Register").style.display = "none";
//     // $("#Login").style.display = "block";
// }
var xmlHttp = false;
xmlHttp = new XMLHttpRequest();
function loginServer(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;//这两行是要传的值
    var chk1 = $("#autologin").is(":checked");//自动登录的复选框
    // if(chk1.checked){
    //     alert("1111");
    // }
    if((username == null)||(username == "")){
        alert("登录帐号不能为空");
        return;
    }
    if((password == null)||(password == "")){
        alert("登录密码不能为空");
        return;
    }

    var url = "/Login?username=" + escape(username) + "&password=" + escape(password) + "&chk1=" + escape(chk1);
    // var url = "/Login?username=" + escape(username) + "&password=" + escape(password);
    xmlHttp.open("GET",url,true);
    //xmlHttp.onreadystatechange = updatePage;
    xmlHttp.onreadystatechange = function (){
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            // alert(xmlHttp.responseText);
            if(xmlHttp.responseText == "true"){
                // window.open("jsp/Panel.jsp");//打开一个新的界面
                //     window.location.href = "jsp/Panel.jsp";//不打开新的界面
                location.href = "/searchAllInfo";//不打开新的界面
            } else{
                document.getElementById("password").value = "";
                alert("用户名或密码错误！请重新输入");
            }
        }
        // else {
        //     alert(xmlHttp.statusText);
        //
        // }
    };
    xmlHttp.send(null);
}
function registerServer(){
    var registername = document.getElementById("registername").value;
    var registerpass = document.getElementById("registerpass").value;//这两行是要传的值
    if((registername == null)||(registername == "")){
        alert("注册账号不能为空");
        return;
    }
    if((registerpass == null)||(registerpass == "")){
        alert("注册密码不能为空");
        return;
    }

    var url = "/Register?registername=" + escape(registername) + "&registerpass=" + escape(registerpass);
    xmlHttp.open("GET",url,true);
    //xmlHttp.onreadystatechange = updatePage;
    xmlHttp.onreadystatechange = function (){
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
            // alert(xmlHttp.responseText);
            if(xmlHttp.responseText == "true"){
                // window.open("jsp/Panel.jsp");//打开一个新的界面
                alert("注册成功！即将返回登录界面");
                location.href = "";//刷新界面
            }
            // else
            //     alert("用户名或密码错误！请重新输入")
        }
        // else {
        //     alert(xmlHttp.statusText);
        //
        // }
    };
    xmlHttp.send(null);
}
function registerDisplay() {//这两个函数表示同一界面上点击不同按钮出现不同界面：登录或者注册
    document.getElementById("Login").style.display = "none";
    document.getElementById("Register").style.display = "block";
}
function loginDisplay(){
    document.getElementById("Register").style.display = "none";
    document.getElementById("Login").style.display = "block";
}
$("#username").bind("input propertychange",function (event) {
   if($("#username").val() == ""){
       $("#hide1").text("用户名不能为空");
   } else{
       $("#hide1").text("");
   }
});
$("#password").bind("input propertychange",function (event) {
    if($("#password").val() == ""){
        $("#hide2").text("密码不能为空");
    } else if($("#password").val().length<=5){
        $("#hide2").text("密码不能少于五位");
    }else{
        $("#hide2").text("");
    }
});
$("#registername").bind("input propertychange",function (event) {
    if($("#registername").val() == ""){
        $("#hide3").text("注册名不能为空");
    } else{
        $("#hide3").text("");
    }
});
$("#registerpass").bind("input propertychange",function (event) {
    if($("#registerpass").val() == ""){
        $("#hide2").text("注册密码不能为空");
    } else if($("#registerpass").val().length<=5){
        $("#hide4").text("密码不能少于五位");
    }else{
        $("#hide4").text("");
    }
});
