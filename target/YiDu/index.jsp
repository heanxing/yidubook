<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/js/jquery-1.12.4.min.js"></script>
    <title>主页</title>


</head>
<body>
<%--<ul>--%>
 <%--<h3>管理员管理</h3>--%>

 <%--<br/>  <li>GET:<a href="/api/User/get">api/User/get</a></li><br/>--%>
 <%--描述：对数据进行查--%>

 <%--<br/>  <li>GET:<a href="/api/User/login">api/User/login</a></li><br/>--%>
 <%--描述：进行登录--%>
 <%--参数： username（账号） password（密码） 返回一个userID值--%>






<%--<h3>学生管理</h3>--%>
   <%--<li>POST:<a href="/api/Student/insertTest">api/Student/insertTest</a></li><br/>--%>
    <%--描述：对数据进行增加--%>
    <%--参数：username（账号），password（密码）--%>


 <%--<br/><br/> <li>POST:<a href="/api/Student/delectTest">api/Student/delectTest</a></li><br/>--%>
    <%--描述：对数据进行删除--%>
    <%--参数：id--%>

 <%--<br/>  <li>GET:<a href="/api/Student/get">api/Student/get</a></li><br/>--%>
    <%--描述：对数据进行查--%>

 <%--<br/>  <li>POST:<a href="/api/Student/updateTest">api/Student/updateTest</a></li><br/>--%>
    <%--描述：对数据进行更新--%>
    <%--参数：id username（账号） password（密码）--%>

 <%--<br/>  <li>GET:<a href="/api/Student/login">api/Student/login</a></li><br/>--%>
 <%--描述：进行登录--%>
 <%--参数： username（账号） password（密码） 返回一个userID值--%>

 <%--<br/>  <li>GET:<a href="/api/Student/modifi">api/Student/modifi</a></li><br/>--%>
 <%--描述：用户进行修改--%>
 <%--参数：id password--%>






 <%--<h3>查询种类</h3>--%>
 <%--<br/>  <li>GET:<a href="/api/Book/selectBook">api/Book/selectBook</a></li><br/>--%>



  <%--<h3>预约功能</h3>--%>

 <%--<br/>  <li>POST:<a href="/api/Appoint/appointSuccess">api/Appoint/appointSuccess</a></li><br/>--%>
 <%--描述：预约成功--%>
 <%--参数： User_id    B_id  Stime  Htime   status--%>
 <%--<br/>  <li>POST:<a href="/api/Appoint/selectUserId">api/Appoint/selectUserId</a></li><br/>--%>
 <%--描述，通过user_id来查询所有信息--%>
 <%--<br/>  <li>GET:<a href="/api/Appoint/get">api/Appoint/get</a></li><br/>--%>
 <%--描述：查询预约成功的记录--%>
 <%--参数：user_id--%>


 <%--<h3>拿书功能</h3>--%>

 <%--<br/>  <li>POST:<a href="/api/Borrow/insertTest">/api/Borrow/insertTest</a></li><br/>--%>
 <%--描述：借书成功--%>
 <%--参数： User_id book_Id   Br_start  Br_stop    status--%>

 <%--<br/>  <li>POST:<a href="/api/Appoint/delectTest">/api/Appoint/delectTest</a></li><br/>--%>
 <%--描述：拿完书就删除预约表里的记录--%>
 <%--参数: id--%>

 <%--<br/>  <li>POST:<a href="/api/Borrow/updateTest">/api/Borrow/updateTest</a></li><br/>--%>
 <%--描述：续借成功--%>
 <%--参数： id Br_stop,status=2--%>



 <%--<br/>  <li>POST:<a href="/api/Borrow/selecion">/api/Borrow/selection</a></li><br/>--%>
 <%--描述：查询借书成功和续借成功--%>
 <%--参数： User_id--%>

 <%--<br/>  <li>POST:<a href="/api/Borrow/selectBySuccess">/api/Borrow/selectBySuccess</a></li><br/>--%>
 <%--描述：单独查询借书成功--%>
 <%--参数： User_id--%>

 <%--<br/>  <li>POST:<a href="/api/Borrow/selectByStatus">/api/Borrow/selectByStatus</a></li><br/>--%>
 <%--描述：查询已还的状态--%>
 <%--参数：User_id--%>


 <%--<br/>  <li>GET:<a href="/api/Borrow/returnTest">/api/Borrow/returnTest</a></li><br/>--%>
 <%--描述：还书功能(管理员)向服务器请求修改--%>
 <%--参数：id  book_Id Br_stop--%>

 <%--<br/>  <li>GET:<a href="/api/Borrow/result">/api/Borrow/result</a></li><br/>--%>
 <%--描述：前端返回请求结果  <input type="submit" value="提交"/><br/>--%>
 <%--</form>--%>
 <%--参数：id--%>

 <%--<h3>评论区功能</h3>--%>
 <%--<br/>  <li>POST:<a href="/api/Moments/insert">/api/Moments/insert</a></li><br/>--%>
 <%--描述：分享内容--%>
 <%--参数：user_id（用户id） times（分享的时间） dsc（主要内容）--%>
 <%--<br/>  <li>POST:<a href="/api/Moments/get">/api/Moments/get</a></li><br/>--%>
 <%--描述：查看所有评论区--%>





 <%--<form action="${pageContext.request.contextPath}/api/Sort/uploade" method="post"  enctype="multipart/form-data">--%>
  <%--添加：--%>
  <%--图片：<input type="file" name="image"/><br/>--%>
<%--</ul>--%>

<%--<div>--%>

 <%--<form action="/api/Student/login" method="post">--%>
  <%--账号 ：<input type="text" name="username"/><br/>--%>
  <%--密码：<input type="password" name="password"/><br/>--%>
  <%--<input type="submit" value="登录" id="login">--%>


 <%--</form>--%>


<%--</div>--%>

$!velocityTool.out()
<ul>
    <li><a href="/swagger/index.html">api接口文档</a></li>
</ul>


<div>
 <h3>发布说说</h3>
 <form action=${pageContext.request.contextPath}"/api/Moments/insert" method="post" enctype="multipart/form-data" >
  用户id：<input type="text" name="user_id"/><br/>
  内容：<input type="text" name="content"/><br/>
  请选择图片:<input id="multipartFiles" name="file" type="file" multiple="multiple"/>
  <br/>
  <input  type="submit" value="发表">
 </form>
</div>

</body>
</html>
