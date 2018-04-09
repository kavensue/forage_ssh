
function problemSave() {
    var problemid=document.getElementById("form_problem").feedProblem;
    $.ajax({
        type:"POST",
        dataType: "json",
        url:"/problemSave",
        data: $('form_problem').serialize(),
        success:function (result) {
            alert(result);
            window.location.href='/index.html';
        },
        error:function () {
            alert("fail!");
        }
    })
}