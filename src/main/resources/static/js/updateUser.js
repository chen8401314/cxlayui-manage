/**
 * 修改用户密码
 * */
//获取路径uri
$(function(){
    layui.use(['form' ,'layer'], function() {
        var form = layui.form;
        var layer = layui.layer;
        //修改密码
        form.on("submit(updatePwd)",function () {
            updatePwd();
            return false;
        });
    })
})

function updatePwd(){
 var oldPassword=$("#oldPassword").val();
    var newPassword=$("#newPassword").val();
    var secondNewPassword=$("#secondNewPassword").val();
    if(secondNewPassword!=newPassword){
        //tips层-右
        $("#newPassword").val("");
        $("#secondNewPassword").val("");
        layer.tips("两次输入的密码不一致", '#newPassword', {
            tips: [2, '#78BA32'], //还可配置颜色
            tipsMore: true
        });
        return false;
    }
    if("ok"!=ValidateUtils.checkSimplePassword(secondNewPassword) || "ok"!=ValidateUtils.checkSimplePassword(newPassword)){
        //tips层-右
        $("#secondNewPassword").val("");
        $("#newPassword").val("");
        layer.alert("密码格式有误，请您重新输入");
        return false;
    }
    $.post("/user/setPwd",{"oldPassword":oldPassword,"newPassword":newPassword,"secondNewPassword":secondNewPassword},function(data){
        console.log("data:"+data);
        if(data.code=="1000"){
            layer.alert("操作成功",function () {
                layer.closeAll();
                window.location.href="/logout";
            });
        }else{
            layer.alert(data.message,function () {
                layer.closeAll();
                $("#secondNewPassword").val("");
                $("#newPassword").val("");
                $("#oldPassword").val("");
                //window.location.href="/index";
            });
        }
    });
}


/*var wait=60;
function sendMessage(o,flag){
    if (!flag) {
        return false;
    }
    //第一次秒数
    if (wait == 60) {
        o.setAttribute("disabled", true);
        //自定义验证规则
        $.post("/user/sendMessage", {"mobile":$("#telephone").val(),"picCode":$("#picCode").val()}, function (data) {
            console.log("data:" + data)
            if (data.code == "1000") {
                layer.msg("发送短信成功");
            } else {
                picCode = drawPic();
                $("#picCode").val("");
                layer.alert(data.message);
                //禁用发送短信验证码按钮
                o.removeAttribute("disabled");
                //o.value = "获取验证码";
                wait = 60;
                flag = false;
            }
            return false;
        });
    }
    if (wait == 0) {
        o.removeAttribute("disabled");
        $("#getMsgBtn").html("获取验证码");
        wait = 60;
    } else {
        o.setAttribute("disabled", true);
        if (wait <60) {
            $("#getMsgBtn").html("<span style='margin-left: -12px;'>"+wait + "s后可重新发送</span>");
        }
        wait--;
        setTimeout(function () {
            if (wait == 0) {
                flag = true
            };
            send(o, flag)
        }, 1000)
    }
}*/
