$(document).ready(function(){

    $('#btn-login').click(function(){
        var _name = $('#username').val();
        var _pass = $('#password').val();

        $.ajax({
            type: 'post',
            url: 'http://dd7b5591.ngrok.io/doLogin',
            data: {
                username: _name,
                password: _pass
            },
            dataType: 'json',
            success: function(data){
                switch(data){
                    case 0:
                        window.confirm('没有此用户');
                        break;
                    case 1:
                        location.href = "http://dd7b5591.ngrok.io/index";
                        break;
                    case 2:
                        location.href = "http://dd7b5591.ngrok.io/adminIndex";
                        break;
                    case 3:
                        window.confirm('用户密码错误');
                        break;
                    default: break;
                }
            }
        })
    })

})