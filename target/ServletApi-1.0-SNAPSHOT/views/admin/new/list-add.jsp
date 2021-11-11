<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 28/10/2021
  Time: 11:49 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url value="/api-admin-new" var="APIurl"/>
<c:url value="/admin-new" var="Homeurl"/>
<body>
<div id="layoutSidenav_content">
  <main>
    <div class="container-fluid px-4">
      <h1 class="mt-4">Tables</h1>
      <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
        <li class="breadcrumb-item active">Tables</li>
      </ol>
      <form id="form-insert" enctype="multipart/form-data">
        <div class="card mb-4">
          <div class="card-header">
            <i class="fas fa-table me-1"></i>
            DataTable Add
          </div>
          <div class="form-group">
            <label for="categoryId">Category</label>
            <textarea type="text" class="form-control" id="categoryId" name="categoryId" placeholder="Your name"></textarea>
          </div>
          <div class="form-group">
            <label for="title">Title</label>
            <textarea type="text" class="form-control" id="title" name="title" placeholder="Your name"></textarea>
          </div>
          <div class="form-group">
            <label for="shortDescription">Short Description</label>
            <textarea type="text" class="form-control" id="shortDescription" name="shortDescription" placeholder="Your name"></textarea>
          </div>
          <div class="form-group">
<%--            <label for="">Thumb mail</label>--%>
<%--            <textarea type="text" class="form-control" id="thumbmail" name="thumbmail" placeholder="Your name"></textarea>--%>
            <label for="thumbmail">Short Description</label>
            <textarea type="text" class="form-control" id="thumbmail" name="thumbmail" placeholder="Your name"></textarea>
          </div>
          <div class="form-group">
            <label for="content">Content</label>
            <textarea name="content" id="content">Type here and show console to see editor's height</textarea>
          </div>
          <button type="submit" class="btn btn-primary" id="insert">Add New</button>
        </div>
      </form>
    </div>
  </main>
</div>
<script>
    $('#insert').click(function (e){
        e.preventDefault();
        // var title = $('#title').val();
        // var sel1 = $('#sel1').val();
        // var shortDescription = $('#short_description').val();
        // var thumbmail = $('#thumbmail').val();
        // var content = $('#editor1').val();
        var data = {};
        var formData = $('#form-insert').serializeArray();
        $.each(formData, function (i, v){
            data[""+v.name+""] = v.value;
        });
        insert(data);
    });
    function insert(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location = "${Homeurl}";
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
</script>
</body>