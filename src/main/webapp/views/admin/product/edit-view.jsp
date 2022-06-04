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
        <form id="form-product" class="needs-validation p-5" method="POST" novalidate>
            <div class="row">
                <div class="col-6 mb-3">
                    <label for="createdBy">Created By</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="createdBy" name="createdBy" value="${productModel.createdBy}" readonly>
                    </div>
                </div>
                <div class="col-6 mb-3">
                    <label for="createdAt">Created At</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="createdAt" name="createdAt" value="${productModel.createdAt}"  readonly>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-6 mb-3">
                    <label for="modifiedBy">Modified By</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="modifiedBy" name="modifiedBy" value="${productModel.modifiedBy}" readonly>
                    </div>
                </div>
                <div class="col-6 mb-3">
                    <label for="modifiedAt">Modified At</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="modifiedAt" name="modifiedAt" value="${productModel.modifiedAt}" readonly>
                    </div>
                </div>
            </div>
            <div class="mb-3">
                <label for="thumbnail">Thumbnail</label>
                <div class="input-group">
                    <input id="thumbnail" name="thumbnail" onchange="showThumbnailImage(this);" type="file" accept="image/gif, image/jpeg, image/png" multiple required>
                    <div class="invalid-feedback" style="width: 100%;">
                        ThumbNail is required.
                    </div>
                </div>
            </div>
            <div class="row mb-3" id="thumbnail-imgs">

            </div>
            <script>
                function showThumbnailImage(input){
                    if(input.files && input.files.length!=0){
                        for(var i = 0; i < input.files.length; i++){
                            let reader = new FileReader();
                            let frameImage = $('<div class="col-3" id="thumbnail-img-' + i + '">' +
                                '<div onclick="removeImage('+ i + ');"><span data-feather="x-circle"></span></div>' +
                                '</div>');
                            let image = $('<img style="width:100%;" src="#" alt="thumbnail-img"/>');
                            reader.onload = function(inp){
                                image
                                    .attr('src', inp.target.result);
                                    // .width(400)
                                    // .height(300);
                            }
                            reader.readAsDataURL(input.files[i]);
                            frameImage.append(image);
                            $("#thumbnail-imgs").append(frameImage);
                            feather.replace();
                        }
                    }
                }
                function removeImage(i){
                    $("#thumbnail").files = $("#thumbnail").files.splice(i, 1);
                    $("#thumbnail-img-"+i).remove();
                }

            </script>
            <div class="mb-3">
                <label for="nameProduct">Name Product</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="nameProduct" name="nameProduct" placeholder="Name Product" value="${productModel.nameProduct}" required>
                    <div class="invalid-feedback" style="width: 100%;">
                        Name Product is required.
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label for="shortDescription">Short Description</label>
                <div class="input-group">
                    <input type="text" class="form-control" id="shortDescription" name="shortDescription" placeholder="Short Description" value="${productModel.shortDescription}" required>
                    <div class="invalid-feedback" style="width: 100%;">
                        Short Description is required.
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label for="description">Description</label>
                <div class="input-group">
                    <textarea type="text" class="form-control" id="description" name="description" placeholder="Description" required>${productModel.description}</textarea>
                    <div class="invalid-feedback" style="width: 100%;">
                        Description is required.
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="price">Price</label>
                    <div class="input-group">
                        <input type="number" class="form-control" id="price" name="price" placeholder="Price" value="${productModel.price}" required>
                        <div class="invalid-feedback" style="width: 100%;">
                            Price is required.
                        </div>
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="discountPrice">Discount Price</label>
                    <div class="input-group">
                        <input type="number" class="form-control" id="discountPrice" name="discountPrice" placeholder="Discount Price" value="${productModel.discountPrice}" required>
                        <div class="invalid-feedback" style="width: 100%;">
                            Discount Price is required.
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="quantity">Quantity</label>
                    <div class="input-group">
                        <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Quantity" value="${productModel.quantity}" required>
                        <div class="invalid-feedback" style="width: 100%;">
                            Quantity is required.
                        </div>
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="categoryCode">Category</label>
                    <select class="custom-select d-block w-100" id="categoryCode" name="categoryCode" required>
                        <option value="">--None--</option>
                        <c:if test="${not empty listCategories}">
                            <c:forEach var="catagory" items="${listCategories}">
                                <option value="${catagory.code}"<c:if test="${catagory.code == productModel.categoryCode}">selected</c:if>>${catagory.name}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                    <div class="invalid-feedback">
                        Please select category.
                    </div>
                </div>
            </div>
<%--            <hr class="mb-4">--%>
            <input id="id" name="id" type="hidden" value="${productModel.id}"/>
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
                                $("#form-product").serializeArray().forEach((e)=>{
                                    form_data[e.name] = e.value;
                                });
                                var product_id = $("#form-product #id").val();
                                if(product_id && product_id!=""){
                                    $.ajax({
                                        url:"<c:url value="/api-admin-product/products"/>",
                                        contentType:"application/json",
                                        data:JSON.stringify(form_data),
                                        type:"PUT",
                                        success:function (){
                                            alert("Cập nhật thành công");
                                            let url_list_products = "<c:url value="/admin-product?type=list-view"/>";
                                            window.location.href = url_list_products;
                                        },
                                        error:function(){
                                            alert("Cập nhật không thành công");
                                        }
                                    });
                                } else{
                                    $.ajax({
                                        url:"<c:url value="/api-admin-product/products"/>",
                                        contentType:"application/json",
                                        data:JSON.stringify(form_data),
                                        type:"POST",
                                        success:function (){
                                            alert("Tạo thành công");
                                            let url_list_products = "<c:url value="/admin-product?type=list-view"/>";
                                            window.location.href = url_list_products;
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