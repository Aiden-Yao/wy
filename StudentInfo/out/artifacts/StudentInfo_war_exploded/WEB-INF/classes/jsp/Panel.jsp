<%@ page import="dao.base.EntityDao" %>
<%@ page import="dao.base.EntityDaoImpl" %>
<%@ page import="entity.Info" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2018/8/17
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Info> Infos = (List<Info>)request.getAttribute("studentInfos"); %>
<html>
<head>
    <title>学生信息管理系统</title>
    <link href="../css/Panel.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="systemTitle"><span class="systemTitle_style">Welcome to student information management system</span></div>
<div class="box1">

    <div class="leftMenuBar">
        <div class="menuTitle"><span class="menuTitle_style">Menu</span></div>
        <div class="foldableMenu">
            <div id="flip"><span class="menuTitle_style">Stu-Info-Mag</span></div>
            <div id="foldedContents">
                <div class="a1_height" onmouseover="mOver(this)" onmouseout="mOut(this)" onclick="test1()"><span class="menuTitle_style">Essential information</span></div>
                <div class="a1_height" onmouseover="mOver(this)" onmouseout="mOut(this)" onclick="test2()"><span class="menuTitle_style">Achievement information</span></div>
            </div>
        </div>
    </div>
    <div class="box2">
        <div class="box3">
            <div class="functionBar">
                <button class="btn Btn1 btn-success" data-toggle="modal" data-target="#myModal2">add</button>
                <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel2">
                                    添加信息
                                </h4>
                            </div>
                            <div class="modal-body">

                                <button class="btn Btn2 btn-lg" data-toggle="modal" data-target="#myModal3"><span>添加学生基本信息</span></button>
                                <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                    &times;
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel3">
                                                    <span>添加学生基本信息</span>
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                学号:<input id="stuId3" type="text" style="text-align: center" value=""><br><br>
                                                姓名:<input id="stuName3" type="text" style="text-align: center" value=""><br><br>
                                                性别:<input id="stuSex3" type="text" style="text-align: center" value=""><br><br>
                                                年龄:<input id="stuAge3" type="text" style="text-align: center" value=""><br><br>
                                                年级:<input id="stuGrade3" type="text" style="text-align: center" value=""><br><br>
                                                生日:<input id="stuBirthday3" type="text" style="text-align: center" value=""><br>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                </button>
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="addInfoBtn()">提交</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="box4">
            <div class="tablePanel">
                <div id="tt" class="tablePanel">
                    <% if(Infos != null) {%>
                    <table id="infoTable" class="table table-striped">
                        <thead style="text-align:center">
                        <tr>
                            <th><span>&#160&#160&#160</span>Student-ID</th>
                            <th><span>&#160&#160&#160&#160&#160</span>Student-Name</th>
                            <th><span>&#160&#160&#160&#160&#160</span>Student-Sex</th>
                            <th><span>&#160&#160&#160&#160</span>Student-Age</th>
                            <th><span>&#160&#160&#160&#160&#160&#160</span>Student-Grade</th>
                            <th><span>&#160&#160&#160&#160&#160&#160&#160&#160</span>Student-Birthday</th>
                        </tr>
                        </thead>
                        <tbody style="text-align:center">
                        <% for(int i = 0; i < Infos.size(); i++) { %>
                        <tr>
                            <td><%=Infos.get(i).getStuId()%></td>
                            <td><%=Infos.get(i).getStuName()%></td>
                            <td><%=Infos.get(i).getStuSex()%></td>
                            <td><%=Infos.get(i).getStuAge()%></td>
                            <td><%=Infos.get(i).getStuGrade()%></td>
                            <td><%=Infos.get(i).getStuBirthday()%></td>
                            <td>
                                <button class="btn Btn1 btn-info" data-toggle="modal" data-target="#myModal"
                                        onclick="transfer('<%=Infos.get(i).getStuId()%>','<%=Infos.get(i).getStuName()%>',
                                                '<%=Infos.get(i).getStuSex()%>',<%=Infos.get(i).getStuAge()%>,
                                                '<%=Infos.get(i).getStuGrade()%>','<%=Infos.get(i).getStuBirthday()%>'
                                                )">modify</button>
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                    &times;
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel">
                                                    修改信息
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                <input id="stuID" type="text" style="display: none" value="<%=Infos.get(i).getStuId()%>">
                                                学号:<input id="stuId1" type="text" style="text-align: center" value=""><br><br>
                                                姓名:<input id="stuName1" type="text" style="text-align: center" value=""><br><br>
                                                性别:<input id="stuSex1" type="text" style="text-align: center" value=""><br><br>
                                                年龄:<input id="stuAge1" type="text" style="text-align: center" value=""><br><br>
                                                年级:<input id="stuGrade1" type="text" style="text-align: center" value=""><br><br>
                                                生日:<input id="stuBirthday1" type="text" style="text-align: center" value=""><br>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                </button>
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="modifyBtn()">
                                                    修改
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <button class="btn Btn1 btn-warning" data-toggle="modal" data-target="#myModal1"
                                        onclick="transfer('<%=Infos.get(i).getStuId()%>','<%=Infos.get(i).getStuName()%>',
                                                '<%=Infos.get(i).getStuSex()%>',<%=Infos.get(i).getStuAge()%>,
                                                '<%=Infos.get(i).getStuGrade()%>','<%=Infos.get(i).getStuBirthday()%>'
                                                )">delete</button>
                                <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                    &times;
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel1">
                                                    删除信息
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                学号:<input id="stuId2" type="text" style="text-align: center" value=""><br><br>
                                                姓名:<input id="stuName2" type="text" style="text-align: center" value=""><br><br>
                                                性别:<input id="stuSex2" type="text" style="text-align: center" value=""><br><br>
                                                年龄:<input id="stuAge2" type="text" style="text-align: center" value=""><br><br>
                                                年级:<input id="stuGrade2" type="text" style="text-align: center" value=""><br><br>
                                                生日:<input id="stuBirthday2" type="text" style="text-align: center" value=""><br>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                </button>
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="deleteBtn()">
                                                    删除
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <%}%>
                        </tbody>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
        <div class="box5"></div>
        </div>
    </div>
</body>
</html>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/panel.js"></script>
