<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<link rel="icon" type="image/x-icon" href="img/faceat.ico">
	<%@ include file="topbar.html" %>
	
</head>

<body>

<!-- recommendation meal -->
	<section id="gtco-special-dishes" class="bg-grey section-padding">
	    <div class="container">
	        <div class="section-content">
	            <div class="heading-section text-center">
	                <br><br>
	                <h2>
	                    Special Meals 
	                </h2>
	            </div>
	            <div class="row mt-5">
	                <div class="col-lg-5 col-md-6 align-self-center py-5">
	                    <h2 class="special-number">01.</h2>
	                    <div class="dishes-text">
	                        <h3><span>On Sale<br>Just $80 Today Only!</span><br>Deep-Fried Pork Chop Meal Box</h3>
	                        <p class="pt-3">Get 33% Discount! <br>Cheaper than you think!</p>
	                        <p class="pt-3" style="color:red"><b>Original price : $120</b></p>
	                        <h3 class="special-dishes-price">$80</h3>
	                        <a href="#" class="btn-primary mt-3">order</a>
	                    </div>
	                </div>
	                <div class="col-lg-5 offset-lg-2 col-md-6 align-self-center mt-4 mt-md-0">
	                    <img src="mealimg/Deep-Fried Pork Chop Meal Box.jpg" alt="" class="img-fluid shadow w-100">
	                </div>
	            </div>
	            
	             <div class="row mt-5">
	                <div class="col-lg-5 col-md-6 align-self-center order-2 order-md-1 mt-4 mt-md-0">
	                    <img src="mealimg/bestcombo.jpg" alt="" class="img-fluid shadow w-100">
	                </div>
	                <div class="col-lg-5 offset-lg-2 col-md-6 align-self-center order-1 order-md-2 py-5">
	                    <h2 class="special-number">02.</h2>
	                    <div class="dishes-text">
	                        <h3><span>Best Choice</span><br>A Combo Meal</h3>
	                        <p class="pt-3">
	                        Meal: Signature Hao Wu Braised Beef<br>
	                        Beverage: Alpine Jinxuan Tea<br>
	                        Dessert: Chocolate Madeleine</p>
	                        <h3 class="special-dishes-price">$260</h3>
	                        <a href="#" class="btn-primary mt-3">order <span><i class="fa fa-long-arrow-right"></i></span></a>
	                    </div>
	                </div>
	            </div>
	            
	            <div class="row mt-5">
	                <div class="col-lg-5 col-md-6 align-self-center py-5">
	                    <h2 class="special-number">03.</h2>
	                    <div class="dishes-text">
	                    	<h3><span>Afternoon Tea</span><br> A Tea Combo</h3>
	                    	<p class="pt-3">
	                        Beverage: Orange and Passion Fruit Green Tea<br>
	                        Dessert: Matcha Cheeseckae</p>
	                        <h3 class="special-dishes-price">$160</h3>
	                        <a href="#" class="btn-primary mt-3">order</a>
	                    </div>
	                </div>
	                <div class="col-lg-5 offset-lg-2 col-md-6 align-self-center mt-4 mt-md-0">
	                    <img src="mealimg/teacombo.jpg" alt="" class="img-fluid shadow w-100">
	                </div>
	            </div>   
	            
	        </div>
	    </div>
	</section>


	<%@ include file="footer.html" %>
</body>
</html>