function inputMoney(item) {
    $(item).unbind('input propertychange').bind('input propertychange', function() {
        var $this = $(this);
        var val = $this.val();
        var reg = /^(\d*)(\.?)(\d{0,2})/g;
        val.replace(reg,function(rs,$1,$2,$3){
            val = $1 + $2 + $3;
        });
        $this.val(val);
    });
}

function inputYear(item) {
    $(item).unbind('input propertychange').bind('input propertychange', function() {
        var $this = $(this);
        var val = $this.val();
        var year = parseInt(val);
        var reg = /^(\d{0,4})/g;
        val.replace(reg,function(rs,$1){
            val = $1;
        });
        $this.val(val);
    });
}

function checkMoney(item, defVal) {
    var reg = /^(\d*)(\.?)(\d{0,2})/g;
    $(item).val().replace(reg,function(rs,$1,$2,$3){
        var money = 0;
        if (defVal != undefined) money = defVal;
        if ($2) $3 = $3.length == 0 ? '00' : ($3.length == 1 ? ($3 + '0') : $3);
        if ($1) money = $1 + $2 + $3;
        $(item).val(money);
    });
}

function inputNum(item) {
    $(item).unbind('input propertychange').bind('input propertychange', function() {
        var $this = $(this);
        var val = $this.val();
        $this.val(val.replace(/\D/g,''));
    });
}

function checkDate(item) {
    var isDate = true;

    var reg=/^(\d+)-(\d{1,2})-(\d{1,2})$/;
    var r=$(item).val().match(reg);
    if(r==null) {
        isDate = false;
    } else {
        r[2]=r[2]-1;
        var d= new Date(r[1],r[2],r[3]);
        if(d.getFullYear()!=r[1]) isDate = false;
        if(d.getMonth()!=r[2]) isDate = false;
        if(d.getDate()!=r[3]) isDate = false;
    }

    if (!isDate) $(item).val("");
}

function checkYear(item) {
    var year = $(item).val();
    var reg=/^(1949|19[5-9]\d|2\d{3})$/;
    if (!reg.test(year)) $(item).val('');
}
function val(a) {
    if (typeof(a) === "undefined" || a == null) return "";
    return a;
}

function valHtml(a) {
    if (typeof(a) === "undefined" || a == null) return "";
    return a.replace(/\n/g,'<br/>').replace(/\t/g,'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;').replace(/\s/g,'&nbsp;');
}

function searchAreaIndex(selectedUnitId) {
    for (x in areas) {
        for (y in areas[x].units) {
            if (areas[x].units[y].id == selectedUnitId) {
                return x;
            }
        }
    }
}

function initArea(selectedUnitId) {
    var selectedAreaIndex = searchAreaIndex(selectedUnitId);

    var selects = '<input id="unit-input" type="hidden" name="unit_id" value="' + selectedUnitId + '">'
        + '<select onchange="changeUnitSelect(this)">'
        + '<option value="">请选择</option>';

    for (x in areas) {
        selects += '<option value="' + x + '"' + (x==selectedAreaIndex? ' selected=true' : '') + '>' + areas[x].name + '</option>';
    }

    selects += '</select>'
        + '<select id="unit-select" onchange="$(\'#unit-input\').val($(this).val())">' + initUnitOption(areas[selectedAreaIndex] ? areas[selectedAreaIndex].units : null, selectedUnitId) + '</select>';
    $("#unit-select-box").html(selects);
}

function changeUnitSelect(item) {
    var index = $(item).val()
    $("#unit-input").val("");
    if (index) {
        $("#unit-select").html(initUnitOption(areas[index].units));
    } else {
        $("#unit-select").html(initUnitOption());
    }

}

function initUnitOption(units, selectedId) {
    var option = '<option value="">请选择</option>';
    for (x in units) {
        option += '<option value="' + units[x].id + '"' + (units[x].id==selectedId? ' selected=true' : '') + '>' + units[x].name + '</option>';
    }
    return option;
}

function getPuk(bindform, callback) {
    if (bindform.find("#pwd").length && bindform.find("#pwd").val().trim() == '') return showDialog("密码不能为空");
    if (bindform.find("#pwdR").length && bindform.find("#pwd").val() != bindform.find("#pwdR").val()) return showDialog("两次输入密码不一致");

    $.ajax({
        url: "/api/user/pubkey",
        type: "post",
        dataType: "json",
        cache: false,
        beforeSend: function() {
        },
        complete: function() {
        },
        success: function (result) {
            if (!authcCheck(result)) return;

            if (result.code == 200) {
                var pwd = bindform.find("#pwd").val();
                var modulus = result.data.modulus;
                var exponent = result.data.exponent;

                //加密
                var key = RSAUtils.getKeyPair(exponent, "", modulus);
                var apwd = RSAUtils.encryptedString(key, JSON.stringify({"password":pwd}));

                bindform.find("input[name=password]").val(apwd);
                callback();
            } else {
                alert(result.msg);
            }
        },error: function (result) {
            alert("网络连接失败！");
        }
    });
}

function editPwd(item) {
    $(item).closest("form").append('<input type="hidden" name="password">');
    $(item).parent().html('<input type="password" id="pwd" autocomplete="off">');
}

var dialog_callback;
function showDialog(msg,fun) {
    // initCoverDiv(true);
    initDialogDiv(msg,"must");

    dialog_callback = fun;
    $(document).unbind("keyup").keyup(function(event){
        switch(event.keyCode) {
            case 27:
                cancelDialog(true);
                $(document).unbind("keyup");
        }
    });
}
function showConfirm(msg,fun) {
    // initCoverDiv(true);
    initDialogDiv(msg);

    dialog_callback = fun;
    $(document).unbind("keyup").keyup(function(event){
        switch(event.keyCode) {
            case 27:
                cancelDialog();
                $(document).unbind("keyup");
        }
    });
}
function showDialogWithFail() {
    showDialog("网络连接出错！");
}
function cancelDialog(isOk) {
    $("#cover-div").hide();
    $("#dialog-div-box").animate({"margin-top":"0",filter: "Alpha(Opacity=0, Style=0)", opacity: 0},"fast", function() {
        $("#dialog-div").hide();
    });

    if (isOk) {
        if (dialog_callback) {
            dialog_callback();
            dialog_callback = null;
        }
    }

}
function initCoverDiv(isTransform) {
    var cover_div = $("#cover-div");
    if (cover_div.length == 0) {
        $("body").append('<div id="cover-div" style="width: 100%; height: 100%; position: fixed; top: 0; left: 0; z-index: 900; background: #000000; filter: Alpha(Opacity=40, Style=0); opacity: 0.40;"></div>');
        cover_div = $("#cover-div");
    }
    cover_div.show();
    if (isTransform) {
        cover_div.css({filter: "Alpha(Opacity=0, Style=0)", opacity: 0});
    } else {
        cover_div.css({filter: "Alpha(Opacity=40, Style=0)", opacity: 0.40});
    }

    return cover_div;
}

function initDialogDiv(msg,type) {
    var dialog_div = $("#dialog-div");
    if (dialog_div.length == 0) {
        $("body").append('<div id="dialog-div" style="width: 100%; height: 100%; position: fixed; top: 0; left: 0; z-index: 999; display: none;">' +
            '<div style="position: absolute; left: 50%; top: 0; transform: translateX(-50%)">' +
            '<div id="dialog-div-box" class="shadow-box" style="width: 500px; background: white; margin-top: 100px; border-radius: 3px; position: relative;">' +
            '<p style="margin: 0; padding: 10px 20px; font-size: 18px;">提示</p>' +
            '<div id="dialog-div-content" style="padding: 0 20px; word-break:break-all; word-wrap:break-word; color: #808080"></div>' +
            '<div style="padding: 10px; text-align: right;">' +
            '<a class="btn btn-cancel" style="padding: 4px 15px;" onclick="cancelDialog()">取消</a>' +
            '<a class="btn btn-sure" style="padding: 4px 15px;" onclick="cancelDialog(true)">确定</a>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>');
        dialog_div = $("#dialog-div");
    }
    dialog_div.find("#dialog-div-content").text(msg);

    if (type == "must") {
        dialog_div.find(".btn-cancel").hide();
    } else {
        dialog_div.find(".btn-cancel").show();
    }

    var dialog_div_box = dialog_div.find("#dialog-div-box");
    if ($("#dialog-div").is(":hidden")) {
        dialog_div_box.css({"margin-top":"0",filter: "Alpha(Opacity=0, Style=0)", opacity: 0});
        dialog_div.show();
    }
    dialog_div_box.stop().animate({"margin-top":"100px", filter: "Alpha(Opacity=100, Style=0)", opacity: 1},"fast");

    return dialog_div;
}

function clickBtnSure(item) {
    $(item).addClass('btn-sure-click');
}
function unclickBtnSure(item) {
    $(item).removeClass('btn-sure-click');
}

function enterBtn(e, fun) {
    // 兼容FF和IE和Opera
    var theEvent = e || window.event;
    var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
    if (code == 13) {
        if (fun) fun();
    }
}

function authcCheck(result) {
    switch (result.code) {
        case 1001:
        case 1002:
            showDialog(result.msg, function () {
                openUrl("/");
            });
            return false;
    }
    return true;
}

var upload_color = "#e5e5e5";
var upload_color_complete = "#3285ff";
function uploadProgress(item, val) {
    val = val < 0 ? 0 : (val > 100 ? 100 : val);
    $(item).find('.circle-mask span').text(val);
    if(val <= 50 ){
        $(item).find('.circle-left').css({'transform':'rotate(0deg)',"background":upload_color});
        $(item).find('.circle-right').css({'transform':'rotate('+(val*3.6)+'deg)',"background":upload_color});
    }else{
        $(item).find('.circle-left').css({'transform':'rotate('+((val-50)*3.6)+'deg)',"background":upload_color});
        $(item).find('.circle-right').css({'transform':'rotate(0deg)', "background":upload_color_complete});
    }
}

function uploadFile(item) {
    var file = $(item)[0].files[0];
    var btn = $(item).siblings('.btn');
    var circle = $(item).siblings('.circle-box');

    var fileNames = '';
    var formData = new FormData();
    formData.append("file", file);
    if(file == undefined) return;

    $.ajax({
        url: "/api/upload/file",
        type: "POST",
        data: formData,
        contentType: false,
        processData: false,
        beforeSend: function() {
            $(item).data("uploading", true);
            btn.hide();
            circle.show();
            circle.find('.circle-mask span').text(val);
        },
        complete: function() {
            $(item).data("uploading", false);
            btn.show();
            circle.hide();
            $(item).val('');
        },
        xhr: function(){
            myXhr = $.ajaxSettings.xhr();
            if(myXhr.upload){
                myXhr.upload.addEventListener('progress',function (ev) {
                    var percent = (ev.loaded / ev.total * 100).toFixed(0);
                    uploadProgress(circle,percent);
                }, false);
            }
            return myXhr;
        },
        success: function (result) {
            // uploadProgress(10);
            $(item).siblings('input[type=hidden]').val(result.data.id);
            $(item).siblings('span').html('<a href="' + result.data.file_uri + '" style="margin-left: 5px;">' + result.data.filename + '</a>');
            btn.text("重新上传");
        },
        error: function () {
            showDialog("上传失败");
        }
    });
}

function enterEvent(e,fun){
    var ev = document.all ? window.event : e;
    if(ev.keyCode == 13){
        if (fun) fun();
    }
}