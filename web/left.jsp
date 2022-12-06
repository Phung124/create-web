<%-- 
    Document   : left
    Created on : Nov 16, 2022, 10:10:01 PM
    Author     : phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>All departments</span>
                        </div>
                        <c:forEach items="${listC}" var= "o">
                        <ul>
                            
                            <li><a href="category?did=${o.did}" ${tab==o.did?"active":""}>${o.dname}</a></li>
                        </ul>
                       
                        </c:forEach>
                    </div>
                </div>
