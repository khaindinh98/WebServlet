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
    </head>
    <body>
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Title</th>
                    <th>Short Description</th>
                    <th>Content</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty listNews}">
                    <c:forEach var="news" items="${listNews}">
                        <tr>
                            <td>1</td>
                            <td>${news.title}</td>
                            <td>${news.shortDescription}</td>
                            <td>${news.content}</td>
                            <td>
                                <span>
                                    <a class="d-flex align-items-center text-muted" href="<c:url value="/admin-news?type=edit-view&id=${news.id}"/>" data-toggle="tooltip" title="Add News">
                                        <span data-feather="plus-circle"></span>
                                    </a>
                                </span>
                                <span>
                                    <a class="d-flex align-items-center text-muted" href="<c:url value="/admin-news?type=edit-view"/>" data-toggle="tooltip" title="Add News">
                                        <span data-feather="plus-minus"></span>
                                    </a>
                                </span>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </body>
</html>