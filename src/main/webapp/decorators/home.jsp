<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 20/10/2021
  Time: 10:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglib.jsp"%>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title><dec:title default="ADMIN HOME"/></title>
        <link rel="icon" type="image/x-icon" href="<c:url value="/template/web/assets/favicon.ico"/>" />
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="<c:url value="/template/admin/css/image-update.css"/>" rel="stylesheet" />
        <link href="<c:url value="/template/admin/css/styles.css"/>" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.ckeditor.com/4.8.0/full-all/ckeditor.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body class="sb-nav-fixed">
        <%-- Navigation --%>
        <%@ include file="/common/admin/header.jsp"%>
        <div id="layoutSidenav">
            <%@include file="/common/admin/menu.jsp"%>
            <%-- Body --%>
            <dec:body/>
        </div>
    </body>
    <script>
        CKEDITOR.replace( 'content' );
        CKEDITOR.on( 'instanceReady', function( evt )
        {
            var editor = evt.editor;

            editor.on('change', function (e) {
                var contentSpace = editor.ui.space('contents');
                var ckeditorFrameCollection = contentSpace.$.getElementsByTagName('iframe');
                var ckeditorFrame = ckeditorFrameCollection[0];
                var innerDoc = ckeditorFrame.contentDocument;
                var innerDocTextAreaHeight = $(innerDoc.body).height();
                console.log(innerDocTextAreaHeight);
            });
        });
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="<c:url value="/template/admin/js/scripts.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="<c:url value="/template/admin/assets/demo/chart-area-demo.js"/>"></script>
    <script src="<c:url value="/template/admin/assets/demo/chart-bar-demo.js"/>"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="<c:url value="/template/admin/js/datatables-simple-demo.js"/>"></script>
</html>
