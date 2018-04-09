var taskInfoList=new Array();//存储全部任务信息
function taskProduce() {
    var taskPlace=$("input[name='feedTask']:checked").val();
    var myDate=new Date();
    var taskTime=myDate.toLocaleString();
    var taskInfo=new Array();
    taskInfo.push(taskPlace);
    taskInfo.push(taskTime);//生成单条任务信息
    taskInfoList.push(taskInfo);
    var node =document.createElement('LI');
    var textNode=document.createTextNode(taskInfo);
    //生成删除按钮
    var btn=document.createElement('button');
    btn.textContent='删除';
    btn.value=taskInfoList.length-1;

    node.appendChild(textNode);
    node.appendChild(btn);
    document.getElementById("feed-task").appendChild(node);

    btn.onclick=function () {
        var taskElement=btn.parentNode;
        var parentTask=taskElement.parentNode;
        parentTask.removeChild(taskElement);//删除展示列表的任务

        taskInfoList.splice(parseInt(btn.value),1);//删除提交列表的任务
    }

}

function taskSubmit() {
    var taskListJson=JSON.stringify(taskInfoList);
    $.ajax({
        type:"POST",
        dataType: "json",
        url:"/feedtasksave",
        data:taskListJson,
        contentType:"application/json",
        success:function (result) {
            alert(result);
            window.location.href='/index.html';
        },
        error:function () {
            alert("fail!");
        }
    });
}

function taskCancel() {
    taskInfoList.splice(0,taskInfoList.length);
    window.location.href='/index.html';
}