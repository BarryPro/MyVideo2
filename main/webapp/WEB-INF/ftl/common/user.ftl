<#--
  Created by IntelliJ IDEA.
  User: belong
  Date: 16-11-16
  Time: 下午8:05
  To change this template use File | Settings | File Templates.
-->


<#if Session["user"]??>
    <input type="hidden" title="${user.id}" id="my_image"/>
    <img src="${mypath}/my_user/pic/userid/${user.id}"
         alt="" class="user_avatar myimg" style="border-radius:50%;overflow:hidden"/>
    <b><i>${user.username}</i></b>
<#else>
    <input type="hidden" title="-1" id="my_image"/>
    <img src="${mypath}/images/login.png"
         alt="" class="user_avatar myimg" style="border-radius:50%;overflow:hidden"/>
    <b class="my_font"><i>游客</i></b>
</#if>
