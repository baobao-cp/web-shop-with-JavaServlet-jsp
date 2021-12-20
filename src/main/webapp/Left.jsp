

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
           <c:forEach items="${category}" var="c">
             	<li class= "list-group-item list-group-item-action" ><a href="category?id=${c.cid}">${c.cname}</a></li>
           </c:forEach>

        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Last product</div>
        <div class="card-body">
           <a href="detail?pid=${MAXID.id}" title="View Product"><img class="img-fluid" src="${MAXID.image}" /></a>
            <h5 class="card-title">${MAXID.name}</h5>
            <p class="card-text">${MAXID.title}</p>
            <p class="btn btn-danger btn-bloc">${MAXID.price} $</p>
        </div>
    </div>
</div>