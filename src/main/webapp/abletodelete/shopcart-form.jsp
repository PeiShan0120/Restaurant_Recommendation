<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link rel="icon" type="image/x-icon" href="img/faceat.ico">
	<%-- <%@ include file="topbar.html" %> --%>
	
	<script>
	//JSON國家
	window.onload = function countrylist() { //window開啟時就執行
        $('#country3').empty()
        $('#country3').append('<option value="select" selected="selected">select</option>')
        $.getJSON("/MyProject/countries.json", function(data) {
            for (var i = 0; i < data.length; i++) {
                var x = '<option value=' + data[i]["name"] + '>' + data[i]["name"] + '</option>'
                $('#country3').append(x)
            }
        })
    }
	
	 //SUBMIT按鈕disabled & undisabled
    function myFunction2() { //create
            if ($("#password3").val() != "" && $("#email3").val() != "" && $("#name3").val() != "") {
                $("#add").prop("disabled", false);
            } else {
                $("#add").prop("disabled", true);
            }
    }
	</script>
</head>
          <p><a href="<%=request.getContextPath()%>/listItem" class="nav-link">Item</a>
          <!-- <a href="signout" class="nav-link">Sign out</a></p> -->
		</nav>
</header>	
<body class="is-preload">
<!-- Wrapper -->
<div id="wrapper2">
	<div>
		<div>
			<div>
				<c:if test="${shopcart != null}">
					<form action="updateItem" method="post"><input type="button" value="update"></form>
				</c:if>
				<%-- <c:if test="${ShopCart == null}">
					<form action="insertItem" method="post"><input type="button" value="insert"></form>
				</c:if> --%>

				<%-- <section>
					<c:if test="${shopcart != null}">
						<form action="editItem" method="post"><input type="button" value="edit"></form>
            		</c:if>
					<c:if test="${ShopCart == null}"><%-- 
						<form action="newItem" method="post"><input type="button" value="new"></form>
            		</c:if> 
				</section> --%>
				<div class="container">
					<c:if test="${shopcart != null}">
						<input type="hidden" name="no" value="<c:out value='${shopcart.no}' />" />
					</c:if>
					<div class="container">
						<!-- <fieldset class="form-group"> -->
						<fieldset>
							<label>Item</label> <input type="text"
								value="<c:out value='${shopcart.item}' />"
								name="name" required="required" id="name3" onchange="myFunction2()">
						</fieldset><br>
		
						<!-- <fieldset class="form-group"> -->
						<fieldset>
							<label>Quantity</label> <input type="text"
								value="<c:out value='${shopcart.quantity}' />"
								name="email" id="email3" onchange="myFunction2()">
						</fieldset><br>
		
						<!-- <fieldset class="form-group"> -->
						<fieldset>
								<label>price</label> <select
									value="<c:out value='${shopcart.price}' />"
									name="country" id="country3"></select>
						</fieldset><br>
						<form action="" method="post">
						<button type="submit" id="add" disabled="true">Save</button>
						</form>
					</div>
				</div>
 			</div>
		</div>
	 </div>
	 </div>
 
 	<%-- <%@ include file="footer.html" %> --%>
	
	<!-- Scripts -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/browser.min.js"></script>
    <script src="assets/js/breakpoints.min.js"></script>
    <script src="assets/js/util.js"></script>
    <script src="assets/js/main.js"></script>
	
</body>
</html>