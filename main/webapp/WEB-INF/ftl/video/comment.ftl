<html lang="en">
<#include "common/header.ftl">
<#include "common/top.ftl">
<style>
    ._mycolor{
        color: #adadad;
    }
    ._my_img{
        width: 24px;
        height: 24px;
    }
</style>
<#include "video/particle.ftl">
<body>
<input type="hidden" id="_path" value="${mypath}"/>
<c:set var="review" value="${sessionScope.review}"></c:set>
<div align="center" style="padding-top: inherit">
    <table width="790px" cellpadding="0" cellspacing="1" border="1">
        <tr>
            <td rowspan="6" width="28%">
                <a href="${mypath}/my_video/src/Vid/${review.vid}">
                <img width="240" height="338" id="_views"
                     src="${mypath}/my_video/pic/Vid/${review.vid}" alt="tupian" /></a>
            </td>
            <td width="72%"><span class="_mycolor">影片名：</span>${review.video.vname}</td>
        </tr>
        <tr>
            <td><span class="_mycolor">导演名：</span>${review.vdirector}</td>
        </tr>
        <tr>
            <td><span class="_mycolor">演员表：</span>${review.vactor}</td>
        </tr>
        <tr>
            <td><span class="_mycolor">上传时间：</span>${review.video.vdate}</td>
        </tr>
        <tr>
            <td><span class="_mycolor">影片介绍：</td>
        </tr>
        <tr>
            <td>
                <DIV style="overflow-y:scroll; WIDTH:560px;HEIGHT:200px;background-color:white color:black">
                ${review.video.vinfo}</DIV>
            </td>
        </tr>
    </table>
</div>
<div align="center">
    <span id="article_head"></span>
    <span id="article_info"></span>
    <div align="center">
        <a id="del">上一页</a>
        <a id="first">首页</a>
        <span id="herf_num"></span>
        <a id="add">下一页</a>
    </div>
</div>
<div align="center">
    <textarea id="content" name="content" id="content" rows="5"
              cols="50"></textarea>
    <script type="text/javascript">
        //配置ckeditor
        CKEDITOR.replace('content',{
            filebrowserBrowseUrl : '${mypath}/ckfinder/ckfinder.html',
            filebrowserImageBrowseUrl : '${mypath}/ckfinder/ckfinder.html?type=Images',
            filebrowserFlashBrowseUrl : '${mypath}/ckfinder/ckfinder.html?type=Flash',
            filebrowserUploadUrl : '${mypath}/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
            filebrowserImageUploadUrl : '${mypath}/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
            filebrowserFlashUploadUrl : '${mypath}/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash'
        });
    </script>
</div>
<link href="${mypath}/css/diy.css" rel='stylesheet' type='text/css' media="all"/>
<div align="center">
    <table width="800px" id="tabelarticle" class="table-striped table-bordered">
        <tr>
            <td width="90%"><span style="color: #00CCFF">你对这部电影有什么看法，快和大家一起分享一下吧?</span></td>
            <td width="10%"><input style="background: chocolate" type="button" id="article" value="   发   表   "/></td>
        </tr>
    </table>
    <div style="display: none"><#include "common/user.ftl"></div>
    <script>
        $(function(){
            //显示评论信息
            show_article(1);
            $("#article").click(function() {
                //只有登陆的用户才有发评论的资格
                context = CKEDITOR.instances.content.getData();
                add_Article(context);
            })
            //显示评论信息表
            function showArticle(data){
                $("#article_head").empty();
                $("#article_head").append(
                        '<table width="800px" class="table-striped table-bordered">'+
                        '<tr>' +
                            '<th width="10%""><span>头像</span></th>' +
                            '<th width="10%">评论人</th>' +
                            '<th width="40%">评论内容</th>' +
                            '<th width="20%">评论日期</th>' +
                            '<th width="20%">操作</th>' +
                        '</tr></table>'
                );
                $("#article_info").empty();
                $(data.articles).each(function(i,article){
                    _path = $("#_path").attr("value");
                    if($("#my_image").attr("title") == article.uid){
                        article_info_delete(data,article);
                    } else {
                        article_info(data,article);
                    }

                });
                $("#herf_num").empty();
                for(var j = 2;j<=data.page_total;j++){
                    if(j==data.page_total){
                        $("#herf_num").append(
                                '<a title="'+j+'">尾页</a>'
                        );
                    } else {
                        $("#herf_num").append(
                                '<a title="'+j+'"> '+j+' </a>'
                        );
                    }
                }
                //处理回复
                $("#operation2").on('click','img',function(){
                    username = $(this).attr("title");
                    alert(username);
                    reply(username);
                })

                $("#operation1").on('click','a',function(){
                    username = $(this).attr("title");
                    alert(username);
                    reply(username);
                })
            }
            function show_article(n){
                _path = $("#_path").attr("value");
                $.ajax({
                    url:_path+'/my_review/query',
                    type:'post',
                    data:'content='+CKEDITOR.instances.content.getData()+
                    '&userid='+$("#my_image").attr("title")+'&rootid='+0+'&Vid='+
                    ${review.vid}+'&cur_page='+n,
                    dataType:'json',
                    success:showArticle
                });
            }

            function add_Article(context){
                if($("#my_image").attr("title") != -1){
                    if(CKEDITOR.instances.content.getData() != ''){
                        _path = $("#_path").attr("value");
                        $.ajax({
                            url:_path+'/my_review/add_article',
                            type:'post',
                            data:'acontent='+context+
                            '&uid='+$("#my_image").attr("title")+'&arootid='+0+'&Vid='+
                            ${review.vid}+'&cur_page='+$("#max_page_hidden").attr("title"),
                            dataType:'json',
                            success:showArticle
                        });
                    }
                } else {
                    alert("登录后才可以发帖哦！");
                }
                //清空在线编辑器的内容
                CKEDITOR.instances.content.setData("");
                show_article(1);
            }

            function article_info(data,article){
                $("#article_info").append(
                        '<table id="_table" width="800px" class="table-striped table-bordered">'+
                        '<tr>' +
                        '<td width="10%">' +
                        '<div style="width:48px; height:48px; border-radius:50%;overflow: hidden">' +
                        '<img width="48px" height="48px" src='+_path+'/my_user/pic/userid/'+article.uid+' class="user_avatar" ' +
                        'style="width:100% "/></div></td>' +
                        '<td width="10%">'+article.user.username+'</td>' +
                        '<td width="40%">'+article.acontent+'</td>' +
                        '<td width="20%">'+article.adate+'</td>' +
                        '<td width="20%" id="operation2">' +
                        '<img src='+_path+'/images/reply.png class="_my_img" id="my_reply_2">' +
                        '</td>' +
                        '</table>'+
                        '<label style="display:none" id="cur_page_hidden" title='+data.cur_page+'/>'+
                        '<label style="display:none" id="max_page_hidden" title='+data.page_total+'/>'
                );
            }

            function article_info_delete(data,article){
                $("#article_info").append(
                        '<table id="_table" width="800px" class="table-striped table-bordered">'+
                        '<tr>' +
                        '<td width="10%">' +
                        '<div style="width:48px; height:48px; border-radius:50%;overflow: hidden">' +
                        '<img width="48px" height="48px" src='+_path+'/my_user/pic/userid/'+article.uid+' class="user_avatar" ' +
                        'style="width:100% "/></div></td>' +
                        '<td width="10%">'+article.user.username+'</td>' +
                        '<td width="40%">'+article.acontent+'</td>' +
                        '<td width="20%">'+article.adate+'</td>' +
                        '<td width="20%" id="operation1">' +
                        '<a href="javascript:void(0)"  title='+article.aid+'><img src='+_path+'/images/reply.png class="_my_img" id="my_reply_1">'+
                        '<a href='+_path+'/my_review/delete/Aid/'+article.aid+'><img src='+_path+'/images/delete.png class="_my_img"></a></td>' +
                        '</tr>'+
                        '</table>'+
                        '<label style="display:none" id="cur_page_hidden" title='+data.cur_page+'/>'+
                        '<label style="display:none" id="max_page_hidden" title='+data.page_total+'/>'
                );
            }

            function reply(username){
                context = '@'+username+'\n';
                context += CKEDITOR.instances.content.getData();
                add_Article(context);
            }
            //处理分页
            $("#first").click(function(){
                show_article(1);
            })
            $("#herf_num").on('click','a',function(){                ;
                show_article($(this).attr("title"));
            })
            $("#del").click(function(){
                var cur = $("#cur_page_hidden").attr("title");
                if(cur != 1){
                    show_article(cur-1);
                }
            })
            $("#add").click(function(){
                var cur = $("#cur_page_hidden").attr("title");
                cur++;
                var max = $("#max_page_hidden").attr("title");
                if( cur <= max){
                    show_article(cur);
                }
            })
        })

    </script>
</div>
</body>
</html>
