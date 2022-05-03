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
        <form id="form-category" class="needs-validation p-5" method="POST" novalidate>
            <div class="row">
                <div class="col-6 mb-3">
                    <label for="createdBy">Created By</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="createdBy" name="createdBy" value="${newsModel.createdBy}" readonly>
                    </div>
                </div>
                <div class="col-6 mb-3">
                    <label for="createdAt">Created At</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="createdAt" name="createdAt" value="${newsModel.createdAt}"  readonly>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-6 mb-3">
                    <label for="modifiedBy">Modified By</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="modifiedBy" name="modifiedBy" value="${newsModel.modifiedBy}" readonly>
                    </div>
                </div>
                <div class="col-6 mb-3">
                    <label for="modifiedAt">Modified At</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="modifiedAt" name="modifiedAt" value="${newsModel.modifiedAt}" readonly>
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label for="name">Name</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="name" name="name" placeholder="Name" value="${categoryModel.name}" required>
                    <div class="invalid-feedback" style="width: 100%;">
                        Name is required.
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label for="code">Code</label>
                <div class="input-group">
                    <textarea type="text" class="form-control" id="code" name="code" placeholder="Code" required>${categoryModel.code}</textarea>
                    <div class="invalid-feedback" style="width: 100%;">
                        Code is required.
                    </div>
                </div>
            </div>
<%--            <hr class="mb-4">--%>
            <input id="id" name="id" type="hidden" value="${categoryModel.id}"/>
            <button id="btn-submit" class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>
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
                            event.preventDefault();
                            event.stopPropagation();
                            if (form.checkValidity() === true) {
                                form.classList.add('was-validated');
                                var form_data = {};
                                $("#form-category").serializeArray().forEach((e)=>{
                                    form_data[e.name] = e.value;
                                });
                                var news_id = $("#form-news #id").val();
                                if(news_id && news_id!=""){
                                    $.ajax({
                                        url:"<c:url value="/api-admin-category/categories"/>",
                                        contentType:"application/json",
                                        data:JSON.stringify(form_data),
                                        type:"PUT",
                                        success:function (){
                                            alert("Cập nhật thành công");
                                            let url_list_news = "<c:url value="/admin-category?type=list-view"/>";
                                            window.location.href = url_list_news;
                                        },
                                        error:function(){
                                            alert("Cập nhật không thành công");
                                        }
                                    });
                                } else{
                                    $.ajax({
                                        url:"<c:url value="/api-admin-category/categories"/>",
                                        contentType:"application/json",
                                        data:JSON.stringify(form_data),
                                        type:"POST",
                                        success:function (){
                                            alert("Tạo thành công");
                                            let url_list_news = "<c:url value="/admin-category?type=list-view"/>";
                                            window.location.href = url_list_news;
                                        },
                                        error:function(){
                                            alert("Tạo không thành công");
                                        }
                                    });
                                }
                            }
                        }, false);
                    });
                }, false);
            })();
        </script>
    </body>
</html>