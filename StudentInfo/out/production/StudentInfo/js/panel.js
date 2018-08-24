var xmlHttp = false;
xmlHttp = new XMLHttpRequest();
$(document).ready(function(){//折叠菜单
    $("#flip").click(function(){
        $("#foldedContents").slideToggle("slow");
    });

});
// function mDown(e){
//     e.style.backgroundColor = "#F76C40";
// }
// function mUp(e){
//     e.style.backgroundColor = "white";
// }
function mOver(e){
    e.style.backgroundColor = "#F76C40";
}
function mOut(e){
    e.style.backgroundColor = "rgba(255,255,255,0)";
}
function test1(){
    location.href = "/searchAllInfo";
}
function test2(){
    location.href = "/searchAllMark";
}
function transfer(stuId,stuName,stuSex,stuAge,stuGrade,stuBirthday) {
    $("#stuId1,#stuId2").val(stuId);
    $("#stuName1,#stuName2").val(stuName);
    $("#stuSex1,#stuSex2").val(stuSex);
    $("#stuAge1,#stuAge2").val(stuAge);
    $("#stuGrade1,#stuGrade2").val(stuGrade);
    $("#stuBirthday1,#stuBirthday2").val(stuBirthday);
}
function transfer1(stuId,stuName,stuSex,stuAge,stuGrade,stuBirthday){
    $("#stuId1,#stuId2").val(stuId);
    $("#stuName1,#stuName2").val(stuName);
    $("#dataStructure1,#dataStructure2").val(stuSex);
    $("#math1,#math2").val(stuAge);
    $("#English1,#English2").val(stuGrade);
    $("#computer1,#computer2").val(stuBirthday);
}
function modifyBtn(){
    var stuId = $("#stuId1").val();
    var stuName = $("#stuName1").val();
    var stuSex = $("#stuSex1").val();
    var stuAge = $("#stuAge1").val();
    var stuGrade = $("#stuGrade1").val();
    var stuBirthday = $("#stuBirthday1").val();
    $.ajax({
        url:'/Hi1',
        method:'get',
        data:{
            stuId:stuId,
            stuName:stuName,
            stuSex:stuSex,
            stuAge:stuAge,
            stuGrade:stuGrade,
            stuBirthday:stuBirthday
        },
        success:function (result){
            if(result == "true"){
                alert("修改成功");
                window.location.href = "/searchAllInfo";
            }
            else {
                alert("修改失败");
            }
        },
        error:function () {
            alert("wrong");
        }
    })
}
function deleteBtn(){
    var stuId2 = $("#stuId2").val();
    var stuSex2 = $("#stuSex2").val();
    $.ajax({
        url:'/Hi2',
        method:'get',
        data:{
            stuId2:stuId2,
            stuSex2:stuSex2
        },
        success:function (result){
            if(result == "true"){
                alert("删除成功");
                window.location.href = "/searchAllInfo";
            }
            else {
                alert("删除失败");
            }
        },
        error:function () {
            alert("wrong");
        }
    })
}
function addInfoBtn() {
    var stuId = $("#stuId3").val();
    var stuName = $("#stuName3").val();
    var stuSex = $("#stuSex3").val();
    var stuAge = $("#stuAge3").val();
    var stuGrade = $("#stuGrade3").val();
    var stuBirthday = $("#stuBirthday3").val();
    $.ajax({
        url:'/Hi3',
        method:'get',
        data:{
            stuId:stuId,
            stuName:stuName,
            stuSex:stuSex,
            stuAge:stuAge,
            stuGrade:stuGrade,
            stuBirthday:stuBirthday
        },
        success:function (result){
            if(result == "true"){
                alert("添加成功");
                window.location.href = "/searchAllInfo";
            }
            else {
                alert("添加失败");
            }
        },
        error:function () {
            alert("wrong");
        }
    })
}
function modifyMarkBtn(){
    var stuId = $("#stuId1").val();
    var stuName = $("#stuName1").val();
    var dataStructure = $("#dataStructure1").val();
    var math = $("#math1").val();
    var English = $("#English1").val();
    var computer = $("#computer1").val();
    $.ajax({
        url:'/Hi6',
        method:'get',
        data:{
            stuId:stuId,
            stuName:stuName,
            dataStructure:dataStructure,
            math:math,
            English:English,
            computer:computer
        },
        success:function (result){
            if(result == "true"){
                alert("修改成功");
                window.location.href = "/searchAllMark";
            }
            else {
                alert("修改失败");
            }
        },
        error:function () {
            alert("wrong");
        }
    })
}
function deleteMarkBtn(){
    var stuId2 = $("#stuId2").val();
    $.ajax({
        url:'/Hi5',
        method:'get',
        data:{
            stuId2:stuId2
        },
        success:function (result){
            if(result == "true"){
                alert("删除成功");
                window.location.href = "/searchAllMark";
            }
            else {
                alert("删除失败");
            }
        },
        error:function () {
            alert("wrong");
        }
    })
}
function addMarkBtn() {
    var stuId = $("#stuId3").val();
    var stuName = $("#stuName3").val();
    var dataStructure = $("#dataStructure3").val();
    var math = $("#math3").val();
    var English = $("#English3").val();
    var computer = $("#computer3").val();//这里获取值没有问题
    // alert(stuId);
    // alert(stuName);
    // alert(dataStructure);
    // alert(math);
    // alert(English);
    // alert(computer);
    $.ajax({
        url:'/Hi4',
        method:'get',
        data:{
            stuId:stuId,
            stuName:stuName,
            dataStructure:dataStructure,
            math:math,
            English:English,
            computer:computer
        },
        success:function (result){
            if(result == "true"){
                alert("添加成功");
                window.location.href = "/searchAllMark";
            }
            else {
                alert("添加失败");
            }
        },
        error:function () {
            alert("wrong");
        }
    })
}

















// function modifyBtn(){
//     var stuId = document.getElementById("stuId1").value;
//     var stuName = document.getElementById("stuName1").value;
//     var stuSex = document.getElementById("stuSex1").value;
//     var stuAge = document.getElementById("stuAge1").value;
//     var stuGrade = document.getElementById("stuGrade1").value;
//     var stuBirthday = document.getElementById("stuBirthday1").value;
//     var url = "/Hi1?stuId=" + escape(stuId) + "&stuName=" + escape(stuName) + "&stuSex=" + escape(stuSex) +
//         "&stuAge=" + escape(stuAge) + "&stuGrade=" + escape(stuGrade) + "&stuBirthday=" + escape(stuBirthday);
//     xmlHttp.open("GET",url,true);
//     if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
//         if(xmlHttp.responseText == "true"){
//             alert("修改成功");
//             location.href = "/searchAllInfo";//不打开新的界面
//         } else{
//             alert("wrong");
//         }
//     }
//     xmlHttp.send(null);
// }
