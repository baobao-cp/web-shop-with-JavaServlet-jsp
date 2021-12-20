<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
       <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
        .nav-item{
        
        padding: 0px 20px;
        }
        
        #navbarsExampleDefault .nav-link{
        
        color:rgb(146, 145, 145);
        }
        .text-wrap{
         background-color:rgb(155, 152, 152);
        }
        
        // đẩy hình lên trên
		 .zoom {
	
		  transition: transform .2s; /* Animation */
		 
		 }

		.zoom:hover {
			  transform: scale(1.1); /* (150% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
		 }
       	 
       	 
       	 .rcorners {
       	  height: 450px;
  		  width: 210px;
		  border-radius: 25px;
		  border: 2px solid #73AD21;
		  padding: 20px; 
		  margin:10px 10px;
		  
		}
		.fas fa-check{
			background-color:#73AD21;
		}
		
		.btn-primary {
			  float: right;
			}
        </style>
    </head>
    <body>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home">Phone</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        
                        
                        
                        <c:if test="${sessionScope.acc!=null}">
                        <li class="nav-item">
                            <a class="nav-link" href="manager">Manager Account</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="out">Logout</a>
                        </li>
                        <li class="nav-item">
                           <i class='fas fa-check' style='font-size:24px;color:green;margin-top:10px'> Hello  ${sessionScope.acc.name } </i>
                        </li>
                        
                        </c:if>
                        
                       <c:if test="${sessionScope.acc==null}">
                        <li class="nav-item">
                            <a class="nav-link" href="Login.jsp">Login</a>
                        </li>
                                 
                         </c:if>
                    </ul>

                    <form action="search" method="get" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="show">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">0</span>
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        
        
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Cửa hàng điện thoại</h1>
                <p class="lead text-muted mb-0">Với các dòng sản phẩm nhập khẩu từ châu Âu</p>
            </div>
        </section>
        <!--end of menu-->
        
        
        
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Category</a></li>
                            <li class="breadcrumb-item active" aria-current="#">Sub-category</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
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
                        <div class="card-header bg-success text-white text-uppercase">NEW Product</div>
                        <div class="card-body">
                             <a href="detail?pid=${MAXID.id}" title="View Product"><img class="img-fluid" src="${MAXID.image}" /></a>
                            <br></br>
                            <h5 class="card-title">${MAXID.name}</h5>
                            <p class="card-text">${MAXID.title}</p>
                            <p class="btn btn-danger btn-block">${MAXID.price} $</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-9">
                    <div id="content" class="row">
                        <c:forEach items="${product}" var="o">
                            <div  class="product col-12 col-md-4 col-lg-3">
                                <div class="card rcorners">
                                 <a href="detail?pid=${o.id}" title="View Product"><img class="card-img-top zoom" src="${o.image}" alt="Card image cap" ></a>
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">${o.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${o.price} $</p>
                                            </div>
                                            <div class="col">
                                                <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                                 
                    </div>
                    <div>
                        <button onclick="loadMore()" class="btn btn-primary">Load more</button>
                        </div>
                </div>

            </div>
        </div>
		<hr>
		<hr>
        <!-- Footer -->
        
         <jsp:include page="Footer.jsp"></jsp:include>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
        				// var count = 4;
                        function loadMore() {
                            var amount = document.getElementsByClassName("product").length;
                            //count+=4;
                            $.ajax({
                                url: "/product/load",
                                type: "get", //send it through get method
                                data: {
                                    exits: amount
                                },
                                success: function (data) {
                                    var row = document.getElementById("content");
                                    row.innerHTML += data;
                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }
        </script>  
    </body>
</html>



