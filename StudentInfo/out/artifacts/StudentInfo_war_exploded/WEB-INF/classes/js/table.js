$(function () {
    initTable();
});
$(document).ready(function(){//折叠菜单
    $("#flip").click(function(){
        $("#foldedContents").slideToggle("slow");
    });
});
function mDown(e){
    e.style.backgroundColor = "#F76C40";
}
function mUp(e){
    e.style.backgroundColor = "white";
}
function mOver(e){
    e.style.backgroundColor = "#F76C40";
}
function mOut(e){
    e.style.backgroundColor = "antiquewhite";
}
function test(){
    location.href = "/Table";
}

function initTable() {
    $("#table").bootstrapTable({
        url:'/Table',
        contentType: 'application/json',// 发送到服务器的数据编码格式
        method: 'get',
        dataType: 'json',
        search: false,
        striped: false,
        pagination: true,
        pageSize: 10,
        pageNumber: 1,
        showRefresh: false,
        pageList: [10, 20, 30],
        clickToSelect: true,
        cache: false, //禁用缓存
        toolbar: '#toolbar',//WHAT????
        columns: [{
            width: '3',
            align: "center",
            valign: "middle",
            checkbox: true,
        }, {
            title: '序号',
            align: 'center',
            valign: 'middle',
            width: '5',
            formatter: function (value, row, index) {
                return index + 1;
            }
        }, {
            field: 'stuId',
            title: '学生ID',
            align: 'center',
            valign: 'middle',
            width: '5',
        }, {
            field: 'stuName',
            title: '姓名',
            align: "center",
            valign: "middle",
            width: '10',
        }, {
            field: 'stuSex',
            title: '性别',
            align: "center",
            valign: "middle",
            width: '10',
        }, {
            field: 'stuAge',
            title: '年龄',
            align: "center",
            valign: "middle",
            width: '10',
        }, {
            field: 'stuGrade',
            title: '年级',
            align: "center",
            valign: "middle",
            width: '5',
        }, {
            field: 'stuBirthday',
            title: '生日',
            align: "center",
            valign: "middle",
            width: '30',
        }]
    });
}
function search1() {
    $('#table').bootstrapTable('destroy');
    initTable();
}