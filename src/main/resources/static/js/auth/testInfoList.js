/**
 * 权限列表
 */
var pageCurr;
$(function() {
    layui.use('table', function(){
        var table = layui.table
            ,form = layui.form;

        tableIns=table.render({
            elem: '#testInfoList'
            ,url:'/testInfo/getTestInfoList'
            ,cellMinWidth: 80
            ,page: true,
            request: {
                pageName: 'page' //页码的参数名称，默认：page
                ,limitName: 'limit' //每页数据量的参数名，默认：limit
            },response:{
                statusName: 'code' //数据状态的字段名称，默认：code
                ,statusCode: 200 //成功的状态码，默认：0
                ,countName: 'totals' //数据总数的字段名称，默认：count
                ,dataName: 'list' //数据列表的字段名称，默认：data
            }
            ,cols: [[
                {type:'numbers'}
                ,{field:'id', title:'ID', width:90, unresize: true, sort: true}
                ,{field:'name', title:'名字'}
                ,{field:'age', title:'年龄'}
                ,{field:'createTime', title: '添加时间'}
                ,{fixed:'right', title:'操作', width:120,align:'center', toolbar:'#optBar'}
            ]]
            ,  done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                //console.log(curr);
                //得到数据总量
                //console.log(count);
                pageCurr=curr;
            }
        });

        //监听工具条
        table.on('tool(testInfoTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                delTestInfo(data,data.id);
            } else if(obj.event === 'edit'){
                //编辑
                getTestInfo(data,data.id);
            }
        });
        //监听提交
        form.on('submit(testInfoSubmit)', function(data){
            // TODO 校验
            formSubmit(data);
            return false;
        });
        //监听搜索框
        form.on('submit(searchSubmit)', function(data){
            //重新加载table
            load(data);
            return false;
        });

    });
});
//提交表单
function formSubmit(obj){
    $.ajax({
        type: "POST",
        data: $("#testInfoForm").serialize(),
        url: "/testInfo/addTestInfo",
        success: function (data) {
            if (data == "ok") {
                layer.alert("操作成功",function(){
                    layer.closeAll();
                    //加载页面
                    load(obj);
                });
            } else {
                layer.alert(data);
            }
        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试",function(){
                layer.closeAll();
                //加载load方法
                load(obj);//自定义
            });
        }
    });
}
//开通用户
function addTestInfo(title){
	if(title=='添加信息'){
		$("#testInfoForm")[0].reset();
		$("#id").val('0');
	}
	  layer.open({
	        type:1,
	        title: title,
	        fixed:false,
	        resize :false,
	        shadeClose: true,
	        area: ['550px'],
	        content:$('#setTestInfo')/*,
	        end:function(){
	            if(obj==null){
	                window.location.href="/user/userList";
	            }else{
	                load(obj);
	            }
	        }*/
	    });
}
function delTestInfo(obj,id) {
    if(null!=id){
        layer.confirm('您确定要删除ID为'+id+'用户吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            $.post("/testInfo/delTestInfo",{"id":id},function(data){
                if(data=="ok"){
                    //回调弹框
                    layer.alert("删除成功！",function(){
                        layer.closeAll();
                        //加载load方法
                        load(obj);//自定义
                    });
                }else{
                    layer.alert(data);//弹出错误提示
                }
            });
        }, function(){
            layer.closeAll();
        });
    }
}

function load(obj){
    //重新加载table
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}
function getTestInfo(obj,id) {
    //回显数据
    $.get("/testInfo/getTestInfo",{"id":id},function(data){
        if(data!=null ){
            $("#id").val(data.id==null?'':data.id);
            $("#name").val(data.name==null?'':data.name);
            $("#age").val(data.age==null?'':data.age);
            addTestInfo("设置用户");
        }else{
            //弹出错误提示
            layer.alert(data.msg,function () {
                layer.closeAll();
            });
        }
    });
}
