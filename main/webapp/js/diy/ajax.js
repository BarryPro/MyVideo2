/**
 * Created by belong on 16-11-4.
 */
$(document).ready(function () {
    $("#slider3").responsiveSlides({
        auto: true,
        pager: false,
        nav: true,
        speed: 500,
        namespace: "callbacks",
        before: function () {
            $('.events').append("<li>before event fired.</li>");
        },
        after: function () {
            $('.events').append("<li>after event fired.</li>");
        }
    });
    //从cookie中得到用户参数
    cookies();

    //用户注册
    $("#register").click(function () {
        //注册检测&&提交
        if ($("#rusername").val() == '') {
            $("#label1").html("用户名不能为空哦!").show(300).delay(3000).hide(300);
            return;
        }
        if ($("#rpassword").val().length < 6) {
            $("#label1").html("密码至少6位哦!").show(300).delay(3000).hide(300);
            return;
        }
        if ($("#rpassword").val() != $("#repwd").val()) {
            $("#label1").html("两次输入得密码不一致哦!").show(300).delay(3000).hide(300);
            return;
        }
        if ($("#file0").val() == '') {
            $("#label1").html("你还没有选择文件哦!").show(300).delay(3000).hide(300);
            return;
        }
        $("#r_form").submit();
        $("#label1").show(300).delay(3000).hide(300);
    });

    //登陆
    $("#my_login").click(function () {
        $("#l_form").submit();
    });

    //取消提示消息
    $("#dispear").click(function () {
        $("#label1").attr("style", "display:none");
    });

    //上传电影
    $("#upload").click(function () {
        if($("#vname").val()== ''){
            $("#label1").html("你还没有编辑上传视频的名称哦!").show(300).delay(3000).hide(300);
            return ;
        }
        if($("#vdirector").val()== ''){
            $("#label1").html("你还没有编辑上传视频的导演呢!").show(300).delay(3000).hide(300);
            return ;
        }
        if($("#vactor").val()== ''){
            $("#label1").html("你还没有编辑上传视频的演员表哦!").show(300).delay(3000).hide(300);
            return ;
        }
        if($("#file2").val() == ''){
            $("#label1").html("你还没有选择上传视频的海报哦！").show(300).delay(3000).hide(300);
            return ;
        }
        if($("#vinfo").val() == ''){
            $("#label1").html("你还没有介绍你要上传的视频呐哦！，这样游客会没有兴趣的喔！").show(300).delay(3000).hide(300);
            return ;
        }
        if($("#file1").val() == ''){
            $("#label1").html("你还没有选择上传视频哦！").show(300).delay(3000).hide(300);
            return ;
        }
        $("#u_form").submit();
    });
    //得到数据库信息
    ajax_page(0,1);

    //得到电影
    $("#movie").click(function(){
        var n = 2;
        ajax_page(n,1);
    });
    //得到新闻
    $("#news").click(function(){
        var n = 4;
        ajax_page(n,1);
    });
    //得到TV
    $("#tv").click(function(){
        var n = 1;
        ajax_page(n,1);
    });
    //得到 MV
    $("#MV").click(function(){
        var n = 3;
        ajax_page(n,1);
    });

    //得到 主页
    $("#home").click(function(){
        var n = 0;
        ajax_page(n,1);
    });

    //查找
    $("#btn_search").click(function(){
        var userid = $("#my_image").attr("title");
        var cur = $("#cur_page").attr("title");
        var txt = $("#txt").val();
        var type = $("#type_id").attr("value");
        txt_search(userid,cur,txt,type);
    });

    //改变查找
    $("#txt").keyup(function(){
        var type = $("#type_id").attr("value");
        var userid = $("#my_image").attr("title");
        var cur = $("#cur_page").attr("title");
        var txt = $("#txt").val();
        txt_search(userid,cur,txt,type);
    })

    //获取访客

    vister();

    //处理页面布局
    $("#my_select").change(function () {
        _path = $("#_path").attr("value");
        $.ajax({
            url: _path+'/my_user/num_setting',
            type: "post",
            data: 'value=' + $("#my_select").val() + '&userid=' + $("#my_image").attr("title"),
            dataType: "text",
            success: function (data) {
                $("#label1").html(data).show(300).delay(3000).hide(300);
                //异步刷新界面
                ajax_page(0, 1);
            }
        });
    })

    //处理分页 首页
    $("#header").on('click','#first_page' ,function(){
        var type = $("#type_id").attr("value");
        var cur = $("#cur_page").attr("title");
        var userid = $("#my_image").attr("title");
        var txt = $("#txt").val();
        if (type == 6) {
            ajax_page_search(userid, cur, txt,type)
        } else {
            ajax_page(type, cur);
        }

    });

    //处理分页 上一页
    $("#header").on('click','a' ,function(){
        var type = $("#type_id").attr("value");
        var cur = $("#cur_page").attr("title");
        var userid = $("#my_image").attr("title");
        var txt = $("#txt").val();
        cur--;
        if(cur >= 1 && type != 6){
            ajax_page(type,cur);
        } else if(cur >=1 && type == 6){
            ajax_page_search(userid,cur,txt,type);
        }
    });

    //处理分页 下一页
    $("#tail").on('click','a' ,function(){
        var type = $("#type_id").attr("value");
        var cur = $("#cur_page").attr("title");
        var max = $("#last_page").attr("title");
        var userid = $("#my_image").attr("title");
        var txt = $("#txt").val();
        cur++;
        if(cur <= max && type != 6){
            ajax_page(type,cur);
        } else if (cur <= max && type == 6){
            ajax_page_search(userid,cur,txt,type);
        }
    });

    //处理分页 尾页
    $("#tail").on('click','#last_page' ,function(){
        var type = $("#type_id").attr("value");
        var cur = $("#last_page").attr("title");
        var userid = $("#my_image").attr("title");
        var txt = $("#txt").val();
        if(type == 6){
             ajax_page_search(userid,cur,txt,type);
        } else {
            ajax_page(type,cur);
        }

    });

    //处理分页 中间页
    $("#middle").on('click','a',function(){
        var type = $("#type_id").attr("value");
        var cur = $(this).attr("title");//this就是表示此时点击的那个超链的title了
        var userid = $("#my_image").attr("title");
        var txt = $("#txt").val();
        if(type == 6){
            ajax_page_search(userid,cur,txt,type);
        } else {
            ajax_page(type,cur);
        }
    });

    //处理设置
    $("#my_setting").click(function(){
        _path = $("#_path").attr("value");//得到项目的绝对路径
        location.href = _path+"/my_user/setting";
    })
});

//获取电影界面
function movie_page(i,list){
    _path = $("#_path").attr("value");
    $("#1").append(
        '<div class="col-md-3 resent-grid recommended-grid slider-top-grids">' +
        '<div class="resent-grid-img recommended-grid-img">' +
        '<a href='+_path+'/my_video/src/Vid/'+list.vid+'>' +
        '<img width="200px" height="200px" id="views" src='+_path+'/my_video/pic/Vid/' + list.vid + ' alt="tupian" />' +
        '</a>' +
        '<div class="time"><p>' + list.vdate + '</p></div>' +
        '</div>' +
        '<div class="resent-grid-info recommended-grid-info">' +
        '<h3><a href='+_path+'/my_review/review/Vid/' + list.vid + ' class="title title-info"><b>' +
        list.vname + '</b><br/>简介：' + list.vinfo + '</a></h3>' +
        '<ul>' +
        '<li><p class="author author-info"><label id="author">' +
        //获得作者名字
        '上传者:' + list.user.username +
        '</label></p></li>' +
        '<li class="right-list">' +
        '<p class="views views-info">' +
        '<a href="'+list.srcpath+'" download="'+list.srcpath+'">'+
        '<i class="fa fa-download" aria-hidden="true" title="下载"></i></a>&nbsp;&nbsp;'+list.views+'次播放</p></li>' +
        '</ul>' +
        '</div>' +
        '<div class="clearfix"></div>'
    );
}

//显示电影加分页图标
function ajax_page(type,cur){
    _path = $("#_path").attr("value");//得到项目的绝对路径
    $.ajax({
        url: _path+"/my_video/db_info",
        type: "post",
        data: 'n='+type+'&userid='+$("#my_image").attr("title")+'&cur_page='+cur,
        dataType: "json",
        success: function (data) {
            $("#1").empty();
            $(data.data).each(function (i, list) {
                movie_page(i,list);
            });
            //分页超链
            page_href(type,data);
        }
    });
}

//显示分页超链图标
function page_href(n,data){
    $("#header").empty();
    $("#header").append(
        '<a href="javascript:void(0)" class="previous" title="上一页" id="del_page"><span class="Bg"><b>&nbsp;</b></span></a>' +
        '<a href="javascript:void(0)" class="cur" id="first_page" title="1"><span class="Bg"><b >首页</b></span></a>'+
        '<input type="hidden" id="type_id" value="'+n+'" />'+
            //cur_page 用于全局共享当前页（但是当前页是通过middle里面的类标签点击算出来的cur_page只是用来存储）
        '<label style="display:none" id="cur_page" title="'+data.cur_page+'"></label>'
    )

    $("#middle").empty();
    for( var j = 2;j<=data.page_total-1;j++){
        $("#middle").append(
            '<a href="javascript:void(0)" id="mid_page'+j+'" title="'+j+'"><span class="Bg"><b>' + j + '</b></span></a>'
        );
    }

    $("#tail").empty();
    $("#tail").append(
        '<a href="javascript:void(0)" id="last_page" title="'+data.page_total+'"><span class="Bg"><b>尾页</b></span></a>' +
        '<a href="javascript:void(0)" class="nextpage" title="下一页" id="add_page"><span class="Bg"><b>&nbsp;</b></span></a>'
        +'<label style="color: #03BAAD">&nbsp;&nbsp;&nbsp;总计：'+data.row_total+'部视频</label>'
    );

}

//访问者
function vister(){
    _path = $("#_path").attr("value");//得到项目的绝对路径
    $.ajax({
        url:_path+'/my_user/visitor',
        type:"post",
        success:function(data){
            $("#counter").empty();
            $("#counter").append(
                '&nbsp;&nbsp;第'+data+'位访客'
            );
        }
    });
}

//搜索引擎
function txt_search(userid,cur,txt){
    _path = $("#_path").attr("value");//得到项目的绝对路径
    if($("#txt").val() != ''){
        var url = _path+'/my_video/search';
        var data = 'userid='+userid+'&cur_page='+cur+'&txt='+txt;
        $.ajax({
            url:url,
            type:"post",
            data: data,
            dataType: "json",
            success: function (data) {
                for(var j = 1;j<=5;j++){
                    $("#"+j).empty();
                }
                if(data.data != ''){
                    $(data.data).each(function (i, list) {
                        movie_page(i,list);
                    });
                    page_href(6,data);
                } else {
                    $("#1").append(
                        '<div align="center">'+
                        '<label style="color: red"><h3>对不起没有找到亲要找到的电影，' +
                        '我们会尽快为你添加库源的，请先回到主页看看吧！</h3></label></div>'
                    )
                }
            }
        });
    }
}

//cookies
function cookies(){
    var username = $.cookie('com.belong.username');
    var password = $.cookie('com.belong.password');
    $("#username").val(username);
    $("#password").val(password);
    $("input[name='cookie']").attr("checked", "checked");
}

function ajax_page_search(userid,cur,txt,type){
    _path = $("#_path").attr("value");//得到项目的绝对路径
    var url = _path+'/my_video/search';
    var data = 'userid='+userid+'&cur_page='+cur+'&txt='+txt;
    $.ajax({
        url:url,
        type:"post",
        data: data,
        dataType: "json",
        success: function (data) {
            $("#1").empty();
            $(data.data).each(function (i, list) {
                movie_page(i,list);
            });
            //分页超链
            page_href(type,data);
        }
    });
}


