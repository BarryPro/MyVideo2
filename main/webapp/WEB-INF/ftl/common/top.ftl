<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html"><h1><img src="${mypath}/images/logo.png" alt=""/></h1></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <div class="top-search">
                <form class="navbar-form navbar-right">
                    <input type="text" class="form-control" placeholder="Search...">
                    <input type="submit" value=" ">
                </form>
            </div>
            <div class="header-top-right">
                <div class="signin">
                    <!-- pop-up-box -->
                    <script type="text/javascript" src="${mypath}/js/modernizr.custom.min.js"></script>
                    <link href="${mypath}/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
                    <script src="${mypath}/js/jquery.magnific-popup.js" type="text/javascript"></script>
                    <!--//pop-up-box -->
                    <div id="small-dialog2" class="mfp-hide">
                        <h3>注册</h3>
                    <#include "common/left_page.ftl">
                        <div class="signup">
                            <form id="r_form" method="post" enctype="multipart/form-data" action="UserControl">
                                <input type="text" class="email" placeholder="用户名" name="rusername" id="rusername"/>
                                <input type="password" placeholder="密码" name="rpassword" id="rpassword"/>
                                <input type="password" placeholder="确认密码" id="repwd"/>
                                <a href="javascript:;" class="file">选择文件.jpg|.png|.gif|.bmp
                                    <input type="file" name="file0" id="file0">
                                </a>
                                <br/><br/><br/><br/>
                                <hr/>
                                <input type="button" class="button" value="注册" id="register"/>
                            </form>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div id="small-dialog3" class="mfp-hide">
                        <h3>上传</h3>
                        <#include "common/left_page.ftl">
                        <div class="">
                            <form id="u_form" method="post" enctype="multipart/form-data" action="VideoControl?action=upload&id=${user.id}">
                                <input type="text" class="email" placeholder="电影名字" name="vname" id="vname"/><br/>
                                <input type="text" class="email" placeholder="导演名" name="vdirector" id="vdirector"/><br/>
                                <input type="text" class="email" placeholder="演员表" name="vactor" id="vactor"/><br/>
                                <div align="left"><b>海报支持得格式：.jpg .gif .bmp .png</b></div>
                                <a href="javascript:;" class="file">选择你要上传的海报文件
                                    <input type="file" name="file2" id="file2">
                                </a><br/><br/><br/>
                                <input type="hidden" name="userid" value="${user.id}"/>
                                选择上传视频类型:
                                <select name="type" id="type">
                                    <option value="1">电视</option>
                                    <option value="2" selected>电影</option>
                                    <option value="3">MV</option>
                                    <option value="4">新闻</option>
                                    <option value="5">其他</option>
                                </select>
                                <textarea style="width: 90%;" name="vinfo" placeholder="电影描述" id="vinfo"></textarea><br/>
                                <div align="left"><b>视频支持得格式：.mp4 .avi</b></div>
                                <a href="javascript:;" class="file">选择你要上传的电影文件
                                    <input type="file" name="file1" id="file1" onchange="filesize(this)">
                                </a><br/><br/><br/>
                                <hr/>
                                <input type="button" class="button" value="上传" id="upload"/>
                            </form>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <script>
                        $(document).ready(function () {
                            $('.popup-with-zoom-anim').magnificPopup({
                                type: 'inline',
                                fixedContentPos: false,
                                fixedBgPos: true,
                                overflowY: 'auto',
                                closeBtnInside: true,
                                preloader: false,
                                midClick: true,
                                removalDelay: 300,
                                mainClass: 'my-mfp-zoom-in'
                            });

                        });
                    </script>
                </div>

                <div class="signin">
                    <#include "video/dropdown.ftl">
                    <div id="small-dialog" class="mfp-hide">
                        <h3>Login</h3>
                        <div class="social-sits">
                            <div class="facebook-button">
                                <a href="#">Connect with Facebook</a>
                            </div>
                            <div class="chrome-button">
                                <a href="#">Connect with Google</a>
                            </div>
                            <div class="button-bottom">
                                <p>New account? <a href="#small-dialog2"
                                                   class="play-icon popup-with-zoom-anim">Signup</a></p>
                            </div>
                        </div>
                        <div class="signup">
                            <form>
                                <input type="text" class="email" placeholder="Enter email / mobile" required="required"
                                       pattern="([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?"/>
                                <input type="password" placeholder="Password" required="required" pattern=".{6,}"
                                       title="Minimum 6 characters required" autocomplete="off"/>
                                <input type="submit" value="LOGIN"/>
                            </form>
                            <div class="forgot">
                                <a href="#">Forgot password ?</a>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</nav>
