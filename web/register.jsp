<%-- 
    Document   : register
    Created on : Nov 16, 2022, 10:02:30 PM
    Author     : phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                                <li>Free Shipping for all Order of $99</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                            </div>
                            <div class="header__top__right__language">
                                <img src="img/language.png" alt="">
                                <div>English</div>
                                <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="#">Spanis</a></li>
                                    <li><a href="#">English</a></li>
                                </ul>
                            </div>
                            <c:if test="${sessionScope.acc !=null}">
                                <div class="header__top__right__auth">
                                    <a href="" class="nav-item nav-link">${sessionScope.acc.user}</a>
                                <a href="logout"><i class="fa fa-user"></i> Logout</a>
                            </div>
                            </c:if>
                            <c:if test="${sessionScope.acc ==null}">
                                 <a href="login.jsp"><i class="fa fa-user"></i> Login</a>
                             
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
