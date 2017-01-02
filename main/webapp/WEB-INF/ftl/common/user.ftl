<#--
  Created by IntelliJ IDEA.
  User: belong
  Date: 16-11-16
  Time: 下午8:05
  To change this template use File | Settings | File Templates.
-->


<#if Session["user"]??>
    <input type="hidden" title="${user.id}" id="my_image"/>
    <img src="UserControl?action=pic&userid=${user.id}" alt="" class="user_avatar myimg"/>
    <b><i>${user.username}</i></b>
<#else>
    <input type="hidden" title="-1" id="my_image"/>
    <img src="${mypath}/images/login.png" alt="" class="user_avatar my_img"/>
    <b class="my_font"><i>游客</i></b>
</#if>
