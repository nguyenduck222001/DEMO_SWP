<%-- 
    Document   : discount-details
    Created on : Feb 12, 2025, 1:51:44 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
        <div class="container">
            <h1 style="text-align: center">Discount Details</h1>
            <div class="row">
                <div class="col-md-6">
                    <img src="${discount.image}" class="card-img-top" alt="discount 1">
                </div>
                <div class="col-md-6">
                    <h2>${discount.code}</h2>     
                    <p>Description: ${discount.description}</p>
                    <p>$${discount.percentage}</p>
                    <form action="add-cart" method="POST">
                        <input type="hidden" name="productId" value="${discount.id}">
                        <!<!-- button add cart -->
                        <button type="submit" class="btn btn-primary">Add to Cart</button>
                    </form>
                </div>
            </div>
        </div>

<jsp:include page="footer.jsp"></jsp:include>
