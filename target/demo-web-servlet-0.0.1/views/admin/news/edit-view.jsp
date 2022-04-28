<%@ page import="java.time.LocalDateTime" %><%--
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
        <form id="form-news" class="needs-validation p-5" novalidate>
            <div class="row">
                <div class="col-6 mb-3">
                    <label for="createdBy">Created By</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="createdBy" name="createdBy" readonly>
                    </div>
                </div>
                <div class="col-6 mb-3">
                    <label for="createdAt">Created At</label>
                    <div class="input-group">
                        <input type="datetime-local" class="form-control" id="createdAt" name="createdAt" readonly>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-6 mb-3">
                    <label for="modifiedBy">Updated By</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="modifiedBy" name="modifiedBy" readonly>
                    </div>
                </div>
                <div class="col-6 mb-3">
                    <label for="modifiedAt">Updated At</label>
                    <div class="input-group">
                        <input type="datetime-local" class="form-control" id="modifiedAt" name="modifiedAt" readonly>
                    </div>
                </div>
            </div>
            <script>
                $("#createdAt").val("<%=LocalDateTime.now()%>");
                $("#updatedAt").val("<%=LocalDateTime.now()%>");
            </script>

            <div class="mb-3">
                <label for="shortDescription">Short Description</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="shortDescription" name="shortDescription" placeholder="Short Description" value="${newsModel.title}" required>
                    <div class="invalid-feedback" style="width: 100%;">
                        Short Description is required.
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label for="categoryCode">Category</label>
                <select class="custom-select d-block w-100" id="categoryCode" name="categoryCode" required>
                    <option value="">--None--</option>
                    <c:if test="${not empty listCategories}">
                        <c:forEach var="catagory" items="${listCategories}">
                            <option value="${catagory.code}"<c:if test="${catagory.name == newsModel.categoryName}">selected</c:if>>${catagory.name}</option>
                        </c:forEach>
                    </c:if>
                </select>
                <div class="invalid-feedback">
                    Please select category.
                </div>
            </div>

            <div class="mb-3">
                <label for="content">Content</label>
                <div class="input-group">
                    <textarea type="text" class="form-control" id="content" name="content" placeholder="Content" required>${newsModel.content}</textarea>
                    <div class="invalid-feedback" style="width: 100%;">
                        Description is required.
                    </div>
                </div>
            </div>
<%--            <hr class="mb-4">--%>

            <button id="btn-submit" class="btn btn-primary btn-lg btn-block" type="button">Submit</button>
        </form>
        <script>
            // Example starter JavaScript for disabling form submissions if there are invalid fields
            (function() {
                'use strict';

                window.addEventListener('load', function() {
                    // Fetch all the forms we want to apply custom Bootstrap validation styles to
                    var forms = document.getElementsByClassName('needs-validation');

                    // Loop over them and prevent submission
                    var validation = Array.prototype.filter.call(forms, function(form) {
                        form.addEventListener('submit', function(event) {
                            if (form.checkValidity() === false) {
                                event.preventDefault();
                                event.stopPropagation();
                            }
                            form.classList.add('was-validated');
                        }, false);
                    });
                }, false);

                $("#btn-submit").click(function () {
                    var form_data = {};
                    $("#form-news").serializeArray().forEach((e)=>{
                        form_data[e.name] = e.value;
                    });
                    $.ajax({
                        url:"<c:url value="/api-admin-news/news"/>",
                        contentType:"application/json",
                        data:JSON.stringify(form_data),
                        type:"POST",
                        success:function (){
                            let url_list_news = "<c:url value="/admin-news?type=list"/>";
                            window.location.href = url_list_news;
                        },
                        error:function(){
                            alert("Tạo thành công");
                        }
                    });
                });

            })();
        </script>
    </body>
</html>