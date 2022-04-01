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
<html lang="vi">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="<c:url value='/templates/admin/favicon.ico'/>">

        <title>Dashboard Template for Bootstrap</title>

        <!-- Bootstrap core CSS -->
        <link href="<c:url value='/templates/admin/css/bootstrap.min.css'/>" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="<c:url value='/templates/admin/css/dashboard.css'/>" rel="stylesheet">

        <!-- Bootstrap core JavaScript
     ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="'+'<c:url value="/templates/admin/js/jquery-slim.min.js"/>'+'"><\/script>')</script>
        <script src="<c:url value='/templates/admin/js/popper.min.js'/>"></script>
        <script src="<c:url value='/templates/admin/js/bootstrap.min.js'/>"></script>
        <script src="<c:url value='/templates/admin/js/holder.min.js'/>"></script>



        <dec:head/>
    </head>
    <body>
<%--        <dl>--%>
<%--            <c:forEach items="${headerValues}" var="entry">--%>
<%--                <dt>${entry.key}</dt>--%>
<%--                <c:forEach items="${entry.value}" var="headerValue">--%>
<%--                    <dd>${headerValue}</dd>--%>
<%--                </c:forEach>--%>
<%--            </c:forEach>--%>
<%--        </dl>--%>
        <%@ include file="/common/admin/header.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                    <%@ include file="/common/admin/sidebar.jsp"%>
                </nav>
                <main role="main" class="col-md-9 col-lg-10 ml-sm-auto p-0">
<%--                     pt-3 px-4--%>

                    <c:if test="${not empty model.type}">
                        <nav class="navbar navbar-light bg-light flex-md-nowrap p-0">
                            <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="<c:url value="/admin-news"/>">Section</a>
    <%--                        <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">--%>
                            <ul class="navbar-nav px-3">
                                <li class="nav-item text-nowrap">
    <%--                                <a class="nav-link" href="#">Sign out</a>--%>
                                    <a class="d-flex align-items-center text-muted" href="<c:url value="/admin-news?type=edit-view"/>" data-toggle="tooltip" title="Add News">
                                        <span data-feather="plus-circle"></span>
                                    </a>
                                </li>
                            </ul>
                        </nav>

                    </c:if>
                    <dec:body/>
                </main>
            </div>
        </div>
        <%@ include file="/common/admin/footer.jsp" %>

        <!-- Icons -->
        <script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
        <script>
            feather.replace()
        </script>

    </body>
</html>