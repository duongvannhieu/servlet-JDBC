<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 28/10/2021
  Time: 9:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new"/>
<body>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Tables</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                <li class="breadcrumb-item active">Tables</li>
            </ol>
            <form id="formUpdate">
<%--                <c:forEach var="item" items="${editModel.listResult}">--%>
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        DataTable Edit
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <label for="id">ID</label>--%>
<%--                        <textarea type="text" class="form-control" id="id" name="id">${editModel.id}</textarea>--%>
<%--                    </div>--%>
                    <div class="form-group">
<%--                        <label for="category">Category</label>--%>
<%--                        <textarea type="text" class="form-control" id="category" name="category">${item.categoryId}</textarea>--%>
                        <label for="categoryId">Select list (select one):</label>
                        <select class="form-control" id="categoryId" name="categoryId">
                            <c:forEach var="item" items="${categories}">
                                <c:if test="${item.code == editModel.categoryCode}">
                                    <option selected="selected" value="${item.id}">${item.name}</option>
                                </c:if>
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="title">Title</label>
                        <textarea type="text" class="form-control" id="title" name="title">${editModel.title}</textarea>
                    </div>
                    <div class="form-group">
                        <label for="short_description">Short Description</label>
                        <textarea type="text" class="form-control" id="short_description" name="shortDescription">${editModel.shortDescription}</textarea>
                    </div>
                    <div class="form-group">
                        <label for="thumbmail">Thumb mail</label>
                        <textarea class="form-control" id="thumbmail" name="thumbmail">${editModel.thumbmail}</textarea>
                    </div>
                    <div class="form-group">
                        <label for="content">Content</label>
                        <textarea name="content" id="content">${editModel.content}</textarea>
                    </div>
                    <button type="submit" class="btn btn-primary" id="update">Update</button>
                    <input type="hidden" value="${editModel.id}" id="id" name="id"/>
                </div>
<%--                </c:forEach>--%>
            </form>
        </div>
    </main>
</div>
<script>
    $('#update').click(function (e){
        e.preventDefault();
        // var title = $('#title').val();
        // var sel1 = $('#sel1').val();
        // var shortDescription = $('#short_description').val();
        // var thumbmail = $('#thumbmail').val();
        // var content = $('#editor1').val();
        var data = {};
        var formData = $('#formUpdate').serializeArray();
        $.each(formData, function (i, v){
            data[""+v.name+""] = v.value;
        });
        var id = $('#id').val();
        update(data);
    });
    function update(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                console.log(result);
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
</script>
</body>