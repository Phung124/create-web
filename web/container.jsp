<%-- 
    Document   : container
    Created on : Nov 16, 2022, 10:05:58 PM
    Author     : phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="Homecontrol"><img src="img/logo.jpg" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="Homecontrol">Home</a></li>
                            <li><a href="shop">Shop</a></li>
                            <li><a href="#">Pages</a>
                                <ul class="header__menu__dropdown">
                                  
                                    <li><a href="shoping-cart.jsp">Shoping Cart</a></li>
                                    <li><a href="./checkout.jsp">Check Out</a></li>
                                   
                                </ul>
                            </li>
                          
                            <li><a href="./contact.jsp">Contact</a></li>
                              <c:if test="${sessionScope.acc.admin==1}">  
                          <li>  <a href="managerproduct" class="nav-item nav-link">ManagerAdmin</a></li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                              <c:set var="size" value="${sessionScope.size}" />
                            <li><a href="shoping-cart.jsp"><i class="fa fa-shopping-bag"></i> <span>${size}</span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
