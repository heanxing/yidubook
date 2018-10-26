/**
 * Created by notime on 17-3-20.
 */
//播放器实例
var player=videojs('videoPlayer');
var origin=getpath("lv_origin", "origin");
var fhd=getpath("lv_fhd", "videos");
var hd=getpath("lv_hd", "videos");
var fluent=getpath("lv_fluent", "videos");
var lv=document.getElementById("lv_default").innerText;

//播放器初始化操作面板清晰度菜单
function playerInitVideo() {
    var options='<div class="vjs-subtitles-button vjs-menu-button vjs-menu-button-popup vjs-control vjs-button" tabindex="0" role="menuitem" aria-live="polite" aria-expanded="false" aria-haspopup="true">'
        + '<div class="vjs-menu" role="presentation">'
        + '<ul class="vjs-menu-content" role="menu">';
    if(origin)options+='<li id="vjs_lv_origin" class="vjs-menu-item" tabindex="-1" role="menuitemcheckbox"  onclick="changeUrl(this)">原画</li>';
    if(fhd)options+='<li id="vjs_lv_fhd" class="vjs-menu-item" tabindex="-1" role="menuitemcheckbox"  onclick="changeUrl(this)">超清</li>';
    if(hd)options+='<li id="vjs_lv_hd" class="vjs-menu-item" tabindex="-1" role="menuitemcheckbox"  onclick="changeUrl(this)">高清</li>';
    if(fluent)options+='<li id="vjs_lv_fluent" class="vjs-menu-item" tabindex="-1" role="menuitemcheckbox"  onclick="changeUrl(this)">标清 </li>';
    options+='</ul></div><span class="vjs-control-text">清晰度</span></div>';
    $videoPanelMenu = $(".vjs-fullscreen-control");
    $videoPanelMenu.before(options);
}
function initlv() {
    $(".vjs-menu-item").removeClass("vjs-selected");
    if (lv == 4) {
        $("#vjs_lv_origin").addClass("vjs-selected");
    } else if (lv == 3) {
        $("#vjs_lv_fhd").addClass("vjs-selected");
    } else if (lv == 2) {
        $("#vjs_lv_hd").addClass("vjs-selected");
    } else {
        $("#vjs_lv_fluent").addClass("vjs-selected");
    }
}
//加载页面进行播放器初始化
player.ready(function () {
    playerInitVideo();
    initlv();
    //player.play();
    //setsrc(player,"rtmp://192.168.30.21/live/test3","rtmp/flv");
});
//通过id获取DOM
function getpath(index, path) {
    var url = document.getElementById(index).innerText;
    if (url)
    {
        // var basepath = window.location.protocol+"//"+window.location.host+"/" + path + "/";
        return url;
    } else {
        return "";
    }

}
//高清标清切换就是应用名加减HD
function changeUrl(video) {
    $(".vjs-menu-item").removeClass("vjs-selected");
    $(video).addClass("vjs-selected");
    var index = $(video).text();
    //获取播放进度：
    var currTime = player.currentTime();
    var remainTime = player.remainingTime();
    if (currTime > 2) {
        currTime -= 2;
    }
    var url = null;
    if (index == "原画") {
        if (lv == 4) {
            return;
        } else {
            lv = 4;
        }
        url = origin;
    } else if (index == "超清") {
        if (lv == 3) {
            return;
        } else {
            lv = 3;
        }
        url = fhd;
    } else if (index == "高清") {
        if (lv == 2) {
            return;
        } else {
            lv = 2;
        }
        url = hd;
    } else {
        if (lv == 1) {
            return;
        } else {
            lv = 1;
        }
        url = fluent;
    }

    player.src({ type: "video/mp4", src: url });
    // player.src(url);
    player.poster("");
    player.load();
    player.play();
    if (remainTime != 0) {
        setTimeout(function fun() { player.currentTime(currTime); }, 500);
    }

}
