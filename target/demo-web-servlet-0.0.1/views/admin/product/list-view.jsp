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
            <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="<c:url value="/admin-product"/>">Product</a>
            <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
            <ul class="navbar-nav px-3">
                <li class="nav-item text-nowrap">
                    <a class="d-flex align-items-center text-muted" href="<c:url value="/admin-product?type=edit-view"/>" data-toggle="tooltip" title="Add Product">
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
                    <th>Name</th>
                    <th>Code</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty listCategories}">
                    <c:forEach var="category" items="${listCategories}">
                        <tr>
                            <td>1</td>
                            <td>${category.name}</td>
                            <td>${category.code}</td>
                            <td>
                                <span>
                                    <button type="button" class="btn btn-primary" id="edit-category-${category.id}" onclick="edit_news(${category.id});">Edit</button>
                                </span>
                                <span>
                                    <button type="button" class="btn btn-secondary" id="delete-category-${category.id}" onclick="delete_news(${category.id});">Delete</button>
                                </span>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
        <script type="text/javascript">
            $("#form-category #name").onkeyup(function(){
                let category_name =  $("#form-category #name").val();
                let category_name_arr = category_name.split("\s+");
                $("#form-category #name").val(category_name_arr.join("-"));
            });
            function edit_news(news_id){
                let url_edit_news = "<c:url value="/admin-category?type=edit-view"/>&id="+news_id;
                window.location.href = url_edit_news;
            }

            function delete_news(news_id){
                $.ajax({
                    url:"<c:url value="/api-admin-category/categories"/>?id="+news_id,
                    type:"DELETE",
                    success:function (){
                        let url_list_news = "<c:url value="/admin-category?type=list-view"/>";
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