<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<link rel="icon" type="image/x-icon" href="img/faceat.ico">
	<%@ include file="topbar.html" %>

	<script>
		//disabled delete if no selected checkbox
		function FunctionDisabled() {
			var hasChecked = false;
			var checkboxes = document.getElementsByName('item');
			var length = checkboxes.length;
			for(var i=0; i<length; i++) {
				if (checkboxes[i].checked) {
					hasChecked = true;
					break;
				}
			}
			if (length == 0) {
				hasChecked = false;
			}
			var addbutton = document.getElementsByName('add');
			for(var i=0;i < addbutton.length; i++){
				addbutton[i].disabled = !hasChecked;
			}
		}
	</script>
	
</head>

<body>

	<form method="post" action="insertShop" >
	
	<!-- Meal -->
	<section id="gtco-menu" id="meal">
	    <div class="container">
	        <div class="section-content">
	        
	           <div class="row mb-5">
	               <div class="col-md-12">
	                   <div class="heading-section text-center">
	                   	<br><br>
	                       <h2>
	                           Meal
	                       </h2>
	                   </div>  
	               </div>
	           </div>
		
			<div class="row">
	        	<div class="col-lg-4 menu-wrap">
	                
	                <c:forEach var="menu" items="${menulist}" begin="0" end="2">
	                    <div class="menus d-flex align-items-center">
	                        <div class="menu-img rounded-circle">
	                            <img class="img-fluid" src="${menu.image}" alt="wait">
	                        </div>
	                        <div class="text-wrap">
	                            <div class="row align-items-start">
	                                <div class="col-8">
	                                    <h4>${menu.item}</h4>
	                                </div>
	                                <div class="col-4">
	                                    <h4 class="text-muted menu-price">${menu.price}</h4>
	                                   	<input type="checkbox" name="item"  onchange="FunctionDisabled()" value="${menu.no}">
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	            	</c:forEach>
	        	</div>
	       
	      		<div class="col-lg-4 menu-wrap">
	            	<c:forEach var="menu" items="${menulist}" begin="3" end="5">
	                    <div class="menus d-flex align-items-center">
	                        <div class="menu-img rounded-circle">
	                            <img class="img-fluid" src="${menu.image}" alt="wait">
	                        </div>
	                        <div class="text-wrap">
	                            <div class="row align-items-start">
	                                <div class="col-8">
	                                    <h4>${menu.item}</h4>
	                                </div>
	                                <div class="col-4">
	                                    <h4 class="text-muted menu-price">${menu.price}</h4>
	                                    <input type="checkbox" name="item"  onchange="FunctionDisabled()" value="${menu.no}">
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	               	</c:forEach>
	       		</div>
	       		
	       		<div class="col-lg-4 menu-wrap">
	            	<c:forEach var="menu" items="${menulist}" begin="6" end="8">
	                    <div class="menus d-flex align-items-center">
	                        <div class="menu-img rounded-circle">
	                            <img class="img-fluid" src="${menu.image}" alt="mwait">
	                        </div>
	                        <div class="text-wrap">
	                            <div class="row align-items-start">
	                                <div class="col-8">
	                                    <h4>${menu.item}</h4>
	                                </div>
	                                <div class="col-4">
	                                    <h4 class="text-muted menu-price">${menu.price}</h4>
	                                    <input type="checkbox" name="item"  onchange="FunctionDisabled()" value="${menu.no}">
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	               	</c:forEach>
	       		</div>
	      	</div>
			
				<div class="row mb-5">
	                <div class="col-md-12">
	                    <div class="heading-section text-center">
		                    <a>
		                        <button type="submit" name="add" class="btn btn-primary w-20" disabled="disabled">Add</button>
		                    </a>
	                    </div>  
	                </div>
	            </div>
	            
			</div>
		</div>
	</section>
	
	<!-- Beverage -->
	<section id="gtco-menu" id="beverage">
	    <div class="container">
	        <div class="section-content">
	        
	           <div class="row mb-5">
	               <div class="col-md-12">
	                   <div class="heading-section text-center">
	                   	<br><br>
	                       <h2>
	                           Beverage
	                       </h2>
	                   </div>  
	               </div>
	           </div>
		
			<div class="row">
	        	<div class="col-lg-4 menu-wrap">
	                
	                <c:forEach var="menu" items="${menulist}" begin="9" end="11">
	                    <div class="menus d-flex align-items-center">
	                        <div class="menu-img rounded-circle">
	                            <img class="img-fluid" src="${menu.image}" alt="wait">
	                        </div>
	                        <div class="text-wrap">
	                            <div class="row align-items-start">
	                                <div class="col-8">
	                                    <h4>${menu.item}</h4>
	                                </div>
	                                <div class="col-4">
	                                    <h4 class="text-muted menu-price">${menu.price}</h4>
	                                   	<input type="checkbox" name="item"  onchange="FunctionDisabled()" value="${menu.no}">
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	            	</c:forEach>
	        	</div>
	       
	      		<div class="col-lg-4 menu-wrap">
	            	<c:forEach var="menu" items="${menulist}" begin="12" end="14">
	                    <div class="menus d-flex align-items-center">
	                        <div class="menu-img rounded-circle">
	                            <img class="img-fluid" src="${menu.image}" alt="wait">
	                        </div>
	                        <div class="text-wrap">
	                            <div class="row align-items-start">
	                                <div class="col-8">
	                                    <h4>${menu.item}</h4>
	                                </div>
	                                <div class="col-4">
	                                    <h4 class="text-muted menu-price">${menu.price}</h4>
	                                    <input type="checkbox" name="item" onchange="FunctionDisabled()" value="${menu.no}">
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	               	</c:forEach>
	       		</div>
	       		
	       		<div class="col-lg-4 menu-wrap">
	            	<c:forEach var="menu" items="${menulist}" begin="15" end="17">
	                    <div class="menus d-flex align-items-center">
	                        <div class="menu-img rounded-circle">
	                            <img class="img-fluid" src="${menu.image}" alt="wait">
	                        </div>
	                        <div class="text-wrap">
	                            <div class="row align-items-start">
	                                <div class="col-8">
	                                    <h4>${menu.item}</h4>
	                                </div>
	                                <div class="col-4">
	                                    <h4 class="text-muted menu-price">${menu.price}</h4>
	                                    <input type="checkbox" name="item" onchange="FunctionDisabled()" value="${menu.no}">
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	               	</c:forEach>
	       		</div>
	       		
	      	</div>
			
				<div class="row mb-5">
	                <div class="col-md-12">
	                    <div class="heading-section text-center">
		                    <a>
		                        <button type="submit"  name="add" class="btn btn-primary w-20" disabled="disabled">Add</button>
		                    </a>
	                    </div>  
	                </div>
	            </div>
	            
			</div>
		</div>
	</section>
	
	<!--Dessert -->
	<section id="gtco-menu" id="dessert">
	    <div class="container">
	        <div class="section-content">
	        
	           <div class="row mb-5">
	               <div class="col-md-12">
	                   <div class="heading-section text-center">
	                   	<br><br>
	                       <h2>
	                           Dessert
	                       </h2>
	                   </div>  
	               </div>
	           </div>
		
			<div class="row">
	        	<div class="col-lg-4 menu-wrap">
	                
	                <c:forEach var="menu" items="${menulist}" begin="18" end="20">
	                    <div class="menus d-flex align-items-center">
	                        <div class="menu-img rounded-circle">
	                            <img class="img-fluid" src="${menu.image}" alt="wait">
	                        </div>
	                        <div class="text-wrap">
	                            <div class="row align-items-start">
	                                <div class="col-8">
	                                    <h4>${menu.item}</h4>
	                                </div>
	                                <div class="col-4">
	                                    <h4 class="text-muted menu-price">${menu.price}</h4>
	                                   	<input type="checkbox" name="item"  onchange="FunctionDisabled()" value="${menu.no}">
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	            	</c:forEach>
	        	</div>
	       
	      		<div class="col-lg-4 menu-wrap">
	            	<c:forEach var="menu" items="${menulist}" begin="21" end="23">
	                    <div class="menus d-flex align-items-center">
	                        <div class="menu-img rounded-circle">
	                            <img class="img-fluid" src="${menu.image}" alt="wait">
	                        </div>
	                        <div class="text-wrap">
	                            <div class="row align-items-start">
	                                <div class="col-8">
	                                    <h4>${menu.item}</h4>
	                                </div>
	                                <div class="col-4">
	                                    <h4 class="text-muted menu-price">${menu.price}</h4>
	                                    <input type="checkbox" name="item"  onchange="FunctionDisabled()" value="${menu.no}">
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	               	</c:forEach>
	       		</div>
	       		
	       		<div class="col-lg-4 menu-wrap">
	            	<c:forEach var="menu" items="${menulist}" begin="24" end="26">
	                    <div class="menus d-flex align-items-center">
	                        <div class="menu-img rounded-circle">
	                            <img class="img-fluid" src="${menu.image}" alt="wait">
	                        </div>
	                        <div class="text-wrap">
	                            <div class="row align-items-start">
	                                <div class="col-8">
	                                    <h4>${menu.item}</h4>
	                                </div>
	                                <div class="col-4">
	                                    <h4 class="text-muted menu-price">${menu.price}</h4>
	                                    <input type="checkbox" name="item"  onchange="FunctionDisabled()" value="${menu.no}">
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	               	</c:forEach>
	       		</div>
	       		
	      	</div>
			
				<div class="row mb-5">
	                <div class="col-md-12">
	                    <div class="heading-section text-center">
		                    <a>
		                        <button type="submit"  name="add" class="btn btn-primary w-20" disabled="disabled">Add</button>
		                    </a>
	                    </div>  
	                </div>
	            </div>
	            
			</div>
		</div>
	</section>
	</form>
	
	<%@ include file="footer.html" %>
</body>
</html>
