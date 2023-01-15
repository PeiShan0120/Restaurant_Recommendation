<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link rel="icon" type="image/x-icon" href="img/faceat.ico">
	<%@ include file="topbar.html" %>
	
	<script>
		//select all checkbox in one time
		function toggleAll(source) {
			var checkboxes = document.getElementsByName('no');
			for(var i=0, n=checkboxes.length; i<n; i++) {
				checkboxes[i].checked = source.checked;
			}
		}
		
		//select one checkbox and changed all selected checkbox
		function toggle(source) {
			var allChecked = true;
			if (source.checked) {
				var checkboxes = document.getElementsByName('no');
				for(var i=0, n=checkboxes.length; i<n; i++) {
					if (!checkboxes[i].checked) {
						allChecked = false;
						break;
					}
				}
			} else {
				allChecked = false;
			}
			$('#selectedCheckbox').prop('checked', allChecked);
		}
		
		//alert payment confirm
		function deleteItem(source) {
			var checkboxes = document.getElementsByName('no');
			
		    var ask = window.confirm('Are you sure you want to delete?');
		    if (ask) {
		    	window.alert("Successfully deleted.");
		    	for(var i=0, n=checkboxes.length; i<n; i++) {
		    		checkboxes[i].checked = source.checked;
		    		window.location.href = "deleteShop";
				}
			}
		}
		
		//alert payment confirm
		function payment() {
			var ask = window.confirm("Are you sure you want to ckekout?");
		    if (ask) {
		        window.alert("Please complete the payment in 20 minutes.");
		        window.open('Linepaypayment', '_blank');
		       	window.open('deleteAllShop');
		    }
		}
		
		//disabled delete if no selected checkbox
		function FunctionDisabled() {
			var hasChecked = false;
			if ($('#selectedCheckbox').is(':checked')) {
				hasChecked = true;
			} else {
				var checkboxes = document.getElementsByName('no');
				for(var i=0, n=checkboxes.length; i<n; i++) {
					if (checkboxes[i].checked) {
						hasChecked = true;
						break;
					}
				}
			}
			$("#disabledDelete").prop("disabled", !hasChecked);
		}
		
    </script>
	
</head>

<!-- ShopcartServlet 傳入資料 -->
<body>
<!-- <form method="post"> -->
<form method="post" action="deleteShop">
	<div class="row">

		<div class="container">
			<h3 class="text-center">Your List</h3>
			<hr>
			<div class="container text-left">
				<!-- <button type="submit" class="btn btn-primary w-20" onClick="deleteItem(source)">Remove Item</button> -->
				<input type="submit" class="btn btn-primary w-20" value="Remove Item" id="disabledDelete" disabled="disabled">
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>No</th>
						<th>Item</th>
						<th>Quantity</th>
						<th>Price</th>
						<th><input type="checkbox" onClick="toggleAll(this)" id="selectedCheckbox" onchange="FunctionDisabled()"></th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="shopcart" items="${shopcartlist}">
					
						<tr>
							<td><c:out value="${shopcart.no}"/></td>
							<td><c:out value="${shopcart.item}" /></td>
							<td>
								<input type="text" name="quantity" value="${shopcart.quantity}" disabled="disabled" style="width: 40px;"/>
								<a href="updateShopPlus?no=<c:out value='${shopcart.no}'/>">+</a>
								<a href="updateShopMinus?no=<c:out value='${shopcart.no}'/>">-</a>
							</td>
							<td><c:out value="${shopcart.price}" /></td>
							<td><input type="checkbox" onClick="toggle(this)" name="no" value="${shopcart.no}" onchange="FunctionDisabled()"></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="2" style="text-align:center"><c:out value="TOTAL PRICE"/></td>
						<td style="text-align:center"><c:out value="{shopcart.price}"/></td>
						<td colspan="2" style="text-align:center"><c:out value="{shopcart.price}" /></td>
						
					</tr>
				</tbody>
				
			</table>
			<div class="container text-right">
				<a href="<%=request.getContextPath()%>/listItem" class="btn btn-primary w-20" >Add Item</a>
				<input type="button" onClick="payment()" class="btn btn-primary w-20" style="right:200px" value="Pay">
			</div>
		</div>
	</div>
	</form>
	<%@ include file="footer.html" %>
</body>
</html>
