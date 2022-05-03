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
        <nav class="navbar navbar-light bg-light flex-md-nowrap p-0">
            <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="<c:url value="/admin-news"/>">News</a>
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
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Title</th>
                    <th>Short Description</th>
                    <th>Category</th>
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
                            <td>${news.categoryName}</td>
                            <td>${news.content}</td>
                            <td>
                                <span>
                                    <button type="button" class="btn btn-primary" id="edit-news-${news.id}" onclick="edit_news(${news.id});">Edit</button>
                                </span>
                                <span>
                                    <button type="button" class="btn btn-secondary" id="delete-news-${news.id}" onclick="delete_news(${news.id});">Delete</button>
                                </span>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
        <script type="text/javascript">
                function edit_news(news_id){
                    let url_edit_news = "<c:url value="/admin-news?type=edit-view"/>&id="+news_id;
                    window.location.href = url_edit_news;
                }

                function delete_news(news_id){
                    $.ajax({
                        url:"<c:url value="/api-admin-news/news"/>?id="+news_id,
                        type:"DELETE",
                        success:function (){
                            let url_list_news = "<c:url value="/admin-news?type=list-view"/>";
                            window.location.href = url_list_news;
                        },
                        error:function(){
                            alert("Xóa không thành công");
                        }
                    });
                }
        </script>
    </body>
</html>