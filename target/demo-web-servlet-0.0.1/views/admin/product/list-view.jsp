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
                    <th>NameProduct</th>
                    <th>Short Description</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Discount Price</th>
                    <th>Quantity</th>
                    <th>Category</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty listProducts}">
                    <c:forEach var="product" items="${listProducts}">
                        <tr>
                            <td>1</td>
                            <td>${product.nameProduct}</td>
                            <td>${product.shortDescription}</td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td>${product.discountPrice}</td>
                            <td>${product.quantity}</td>
                            <td>${product.categoryName}</td>
                            <td>
                                <span>
                                    <button type="button" class="btn btn-primary" id="edit-category-${product.id}" onclick="edit_product(${product.id});">Edit</button>
                                </span>
                                <span>
                                    <button type="button" class="btn btn-secondary" id="delete-category-${product.id}" onclick="delete_product(${product.id});">Delete</button>
                                </span>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
        <script type="text/javascript">
            function edit_product(product_id){
                let url_edit_products = "<c:url value="/admin-product?type=edit-view"/>&id="+product_id;
                window.location.href = url_edit_products;
            }

            function delete_product(product_id){
                $.ajax({
                    url:"<c:url value="/api-admin-product/products"/>?id="+product_id,
                    type:"DELETE",
                    success:function (){
                        let url_edit_products = "<c:url value="/admin-product?type=list-view"/>";
                        window.location.href = url_edit_products;
                    },
                    error:function(){
                        alert("Xóa không thành công");
                    }
                });
            }
        </script>
    </body>
</html>