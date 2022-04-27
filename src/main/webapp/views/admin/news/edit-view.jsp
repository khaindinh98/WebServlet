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
        <form class="needs-validation p-5" novalidate onsubmit="create_news();">
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
                    <label for="updatedBy">Updated By</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="updatedBy" name="updatedBy" readonly>
                    </div>
                </div>
                <div class="col-6 mb-3">
                    <label for="updatedAt">Updated At</label>
                    <div class="input-group">
                        <input type="datetime-local" class="form-control" id="updatedAt" name="updatedAt" readonly>
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
                    <input type="text" class="form-control" id="shortDescription" name="shortDescription" placeholder="Short Description" required>
                    <div class="invalid-feedback" style="width: 100%;">
                        Short Description is required.
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label for="category">Category</label>
                <select class="custom-select d-block w-100" id="category" name="category" required>
                    <option value="">--None--</option>
                    <c:if test="${not empty listCategories}">
                        <c:forEach var="catagory" items="${listCategories}">
                            <option value="${catagory.code}">${catagory.name}</option>
                        </c:forEach>
                    </c:if>
                </select>
                <div class="invalid-feedback">
                    Please select category.
                </div>
            </div>

            <div class="mb-3">
                <label for="description">Description</label>
                <div class="input-group">
                    <textarea type="text" class="form-control" id="description" name="description" placeholder="Description" required></textarea>
                    <div class="invalid-feedback" style="width: 100%;">
                        Description is required.
                    </div>
                </div>
            </div>
<%--            <hr class="mb-4">--%>

            <button class="btn btn-primary btn-lg btn-block" type="submit">Submit</button>
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

                function create_news(){
                    $("#");
                }

            })();
        </script>
    </body>
</html>