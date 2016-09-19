
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title></title>
</head>
<body>
<div class="menu" >
  <nav>
    <ul>
     
      <li>
        <a href="/employees" >
          <span>Employees</span>
        </a>
      </li>
      <li>
        <a href="/menu" >
          <span>Menu</span>
        </a>
      </li>
      <li>
        <a href="/storage" >
          <span>Storage</span>
        </a>
      </li>
      <li>
        <a href="/dishes" >
          <span>Dishes</span>
        </a>
      </li>
      <li>
        <a href="/orders" >
          <span>Orders</span>
        </a>
      </li>
    </ul>
  </nav>
</div>
<div class="dish">
<h1>${dish.name}</h1>
<table style="align-items: center">
  <tr>

    <th>Dish category </th>
    <th>Price</th>
    <th>Weight</th>

  </tr>

  <tr>
       <td>${dish.dishCategory}</td>
    <td>${dish.price}</td>
    <td>${dish.weight}</td>
  </tr>
</table>

<table style="align-items: center">
  <tr>
    <th>Ingradients </th>
  </tr>
  <c:forEach var="ingradients" items="${ingradients}" >
  <tr>
    <td>${ingradients.name}</td>
  </tr>
  </c:forEach>
</table>


</div>
<div class="menu" >
  <nav>
    <ul>
      <li>
        <a href="/ingradientToDish" >
          <span>Add Ingradient  to this dish</span>
        </a>
      </li>
      <li>
        <a href="/ingradientFromDish" >
          <span>Remove ingradient from this dish</span>
        </a>
      </li>
      <li>
        <a href="/removeDish" >
          <span>Remove this dish</span>
        </a>
      </li>

    </ul>
  </nav>
</div>


</body>
</html>
