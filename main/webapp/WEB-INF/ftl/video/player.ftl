<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MyPlayer</title>
    <script src="${mypath}/js/jquery-1.11.1.min.js"></script>
    <link href="${mypath}/css/player.css" rel="stylesheet">
</head>
<body background="${mypath}/images/bg.jpg">
   <div align="center">
       <img src="${mypath}/images/加载.gif" alt="加载" id="my_img" class="player">
       <video id="video_play" src="${srcpath}" controls="controls"
              autoplay="autoplay" width="1024" height="576" poster="${mypath}/images/loading.gif.gif">
       </video>
   </div>
<script type="text/javascript">
    $(function(){
        if($("#video_play").attr("src") != ""){
            $("#my_img").attr("style","display:none");
        }
    })
</script>

</body>
</html>
