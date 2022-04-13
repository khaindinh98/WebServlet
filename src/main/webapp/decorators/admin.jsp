<%--
  Created by IntelliJ IDEA.
  User: Sub4sa
  Date: 3/27/2022
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta charset="utf-8" />
        <title>Tables - Ace Admin</title>

        <meta name="description" content="Static &amp; Dynamic Tables" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

        <!-- bootstrap & fontawesome -->
        <link rel="stylesheet" href="<c:url value="/templates/admin/css/bootstrap.min.css" />" />
        <link rel="stylesheet" href="<c:url value="/templates/admin/font-awesome/4.2.0/css/font-awesome.min.css" />" />

        <!-- page specific plugin styles -->

        <!-- text fonts -->
        <link rel="stylesheet" href="<c:url value="/templates/admin/fonts/fonts.googleapis.com.css" />" />

        <!-- ace styles -->
        <link rel="stylesheet" href="<c:url value="/templates/admin/css/ace.min.css" />" class="ace-main-stylesheet" id="main-ace-style" />

        <!--[if lte IE 9]>
        <link rel="stylesheet" href="<c:url value="/templates/admin/css/ace-part2.min.css" />" class="ace-main-stylesheet" />
        <![endif]-->

        <!--[if lte IE 9]>
        <link rel="stylesheet" href="<c:url value="/templates/admin/css/ace-ie.min.css" />" />
        <![endif]-->

        <!-- inline styles related to this page -->

        <!-- ace settings handler -->
        <script src="<c:url value="/templates/admin/js/ace-extra.min.js" />"></script>

        <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

        <!--[if lte IE 8]>
        <script src="<c:url value="/templates/admin/js/html5shiv.min.js" />"></script>
        <script src="<c:url value="/templates/admin/js/respond.min.js" />"></script>
        <![endif]-->
        <dec:head/>
    </head>
    <body class="no-skin">
        <%@ include file="/common/admin/header.jsp" %>
        <div class="main-container" id="main-container">
            <script type="text/javascript">
                try{ace.settings.check('main-container' , 'fixed')}catch(e){}
            </script>
            <%@ include file="/common/admin/sidebar.jsp" %>

            <div class="main-content">
                <div class="main-content-inner">

                    <div class="page-content">
                        <%@ include file="/common/admin/ace-settings-container.jsp" %>
                        <div class="page-header">
                            <h1>
                                Tables
                                <small>
                                    <i class="ace-icon fa fa-angle-double-right"></i>
                                    Static &amp; Dynamic Tables
                                </small>
                            </h1>
                        </div><!-- /.page-header -->
                        <div class="row">
                            <div class="col-xs-12">
                                <dec:body/>
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                    </div><!-- /.page-content -->
                </div>
            </div><!-- /.main-content -->


            <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
                <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
            </a>
        </div><!-- /.main-container -->

        <!-- basic scripts -->

        <!--[if !IE]> -->
        <script src="<c:url value="/templates/admin/js/jquery.2.1.1.min.js" />"></script>

        <!-- <![endif]-->

        <!--[if IE]>
        <script src="<c:url value="/templates/admin/js/jquery.1.11.1.min.js" />"></script>
        <![endif]-->

        <!--[if !IE]> -->
        <script type="text/javascript">
            window.jQuery || document.write("<script src='<c:url value="/templates/admin/js/jquery.min.js" />'>"+"<"+"/script>");
        </script>

        <!-- <![endif]-->

        <!--[if IE]>
        <script type="text/javascript">
            window.jQuery || document.write("<script src='<c:url value="/templates/admin/js/jquery1x.min.js" />'>"+"<"+"/script>");
        </script>
        <![endif]-->
        <script type="text/javascript">
            if('ontouchstart' in document.documentElement) document.write("<script src='<c:url value="/templates/admin/js/jquery.mobile.custom.min.js" />'>"+"<"+"/script>");
        </script>
        <script src="<c:url value="/templates/admin/js/bootstrap.min.js" />"></script>

        <!-- page specific plugin scripts -->
        <c:if test="${model.type == 'edit-view'}">
            <!--[if lte IE 8]>
            <script src="<c:url value="/templates/admin/js/excanvas.min.js" />"></script>
            <![endif]-->
            <script src="<c:url value="/templates/admin/js/jquery-ui.custom.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/jquery.ui.touch-punch.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/chosen.jquery.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/fuelux.spinner.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/bootstrap-datepicker.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/bootstrap-timepicker.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/moment.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/daterangepicker.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/bootstrap-datetimepicker.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/bootstrap-colorpicker.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/jquery.knob.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/jquery.autosize.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/jquery.inputlimiter.1.3.1.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/jquery.maskedinput.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/bootstrap-tag.min.js" />"></script>
        </c:if>
        <!-- page specific plugin scripts -->
        <c:if test="${model.type == 'list-view'}">
            <script src="<c:url value="/templates/admin/js/jquery.dataTables.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/jquery.dataTables.bootstrap.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/dataTables.tableTools.min.js" />"></script>
            <script src="<c:url value="/templates/admin/js/dataTables.colVis.min.js" />"></script>
        </c:if>
        <!-- ace scripts -->
        <script src="<c:url value="/templates/admin/js/ace-elements.min.js" />"></script>
        <script src="<c:url value="/templates/admin/js/ace.min.js" />"></script>
    </body>
</html>
