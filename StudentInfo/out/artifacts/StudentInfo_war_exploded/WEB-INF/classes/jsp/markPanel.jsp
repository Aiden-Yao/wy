<%@ page import="dao.base.EntityDao" %>
<%@ page import="dao.base.EntityDaoImpl" %>
<%--<%@ page import="entity.Info" %>--%>
<%@ page import="entity.Mark" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2018/8/17
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<% List<Info> Infos = (List<Info>)request.getAttribute("studentInfos"); %>--%>
<% List<Mark> Marks = (List<Mark>)request.getAttribute("studentMarks"); %>
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

                                <button class="btn Btn2 btn-lg" data-toggle="modal" data-target="#myModal3">添加学生成绩信息</button>
                                <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                    &times;
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel3">
                                                    添加学生成绩信息
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                学号:<input id="stuId3" type="text" style="text-align: center" value=""><br><br>
                                                姓名:<input id="stuName3" type="text" style="text-align: center" value=""><br><br>
                                                数据:<input id="dataStructure3" type="text" style="text-align: center" value=""><br><br>
                                                数学:<input id="math3" type="text" style="text-align: center" value=""><br><br>
                                                英语:<input id="English3" type="text" style="text-align: center" value=""><br><br>
                                                电脑:<input id="computer3" type="text" style="text-align: center" value=""><br>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                </button>
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="addMarkBtn()">提交</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                            </div>
                            <div class="modal-footer">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="box4">
            <div class="tablePanel">
                <div id="tt" class="tablePanel">
                    <% if(Marks != null) {%>
                    <table id="markTable" class="table table-striped">
                        <thead style="text-align:center">
                        <tr>
                            <th><span>&#160&#160&#160&#160</span>Student-ID</th>
                            <th><span>&#160&#160&#160&#160&#160</span>Student-Name</th>
                            <th><span>&#160&#160&#160&#160&#160</span>DataStructure</th>
                            <th><span>&#160&#160&#160&#160&#160</span>HigherMathematics</th>
                            <th><span>&#160&#160&#160&#160&#160</span>CollegeEnglish</th>
                            <th><span>&#160&#160&#160&#160&#160&#160</span>Computer</th>
                        </tr>
                        </thead>
                        <tbody style="text-align:center">
                        <% for(int i = 0; i < Marks.size(); i++) { %>
                        <tr>
                            <td><%=Marks.get(i).getStuId()%></td>
                            <td><%=Marks.get(i).getStuName()%></td>
                            <td><%=Marks.get(i).getDataStructure()%></td>
                            <td><%=Marks.get(i).getMath()%></td>
                            <td><%=Marks.get(i).getEnglish()%></td>
                            <td><%=Marks.get(i).getComputer()%></td>
                            <td>
                                <button class="btn Btn1 btn-info" data-toggle="modal" data-target="#myModal"
                                        onclick="transfer1('<%=Marks.get(i).getStuId()%>','<%=Marks.get(i).getStuName()%>',
                                            <%=Marks.get(i).getDataStructure()%>,<%=Marks.get(i).getMath()%>,
                                            <%=Marks.get(i).getEnglish()%>,<%=Marks.get(i).getComputer()%>
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
                                                学号:<input id="stuId1" type="text" style="text-align: center" value=""><br><br>
                                                姓名:<input id="stuName1" type="text" style="text-align: center" value=""><br><br>
                                                数据:<input id="dataStructure1" type="text" style="text-align: center" value=""><br><br>
                                                数学:<input id="math1" type="text" style="text-align: center" value=""><br><br>
                                                英语:<input id="English1" type="text" style="text-align: center" value=""><br><br>
                                                电脑:<input id="computer1" type="text" style="text-align: center" value=""><br>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                </button>
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="modifyMarkBtn()">
                                                    修改
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <button class="btn Btn1 btn-warning" data-toggle="modal" data-target="#myModal1"
                                        onclick="transfer1('<%=Marks.get(i).getStuId()%>','<%=Marks.get(i).getStuName()%>',
                                            <%=Marks.get(i).getDataStructure()%>,<%=Marks.get(i).getMath()%>,
                                            <%=Marks.get(i).getEnglish()%>,<%=Marks.get(i).getComputer()%>
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
                                                数据:<input id="dataStructure2" type="text" style="text-align: center" value=""><br><br>
                                                数学:<input id="math2" type="text" style="text-align: center" value=""><br><br>
                                                英语:<input id="English2" type="text" style="text-align: center" value=""><br><br>
                                                电脑:<input id="computer2" type="text" style="text-align: center" value=""><br>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                </button>
                                                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="deleteMarkBtn()">
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