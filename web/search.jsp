<%-- 
    Document   : search
    Created on : Nov 16, 2022, 10:11:58 PM
    Author     : phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="search" method="post">
                                <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input value="${txtS}" name="txt" type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+84 396217522</h5>
                                <span>support 24/7 time</span>
                            </div>
                        </div>
                    </div>