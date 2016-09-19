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
        <a href="/orders" >
          <span>Orders</span>
        </a>
      </li>
    </ul>
  </nav>
</div>
<div class="dish">
<h1>All dishes of this restaurant</h1>

<table style="align-items: center">
  <tr>
    <th> Name </th>
    <th>Weight</th>
    <th>Cost</th>
</tr>

  <c:forEach items="${dishes}" var="dish">
    <tr>
      <td> <a href="/dish?dishName=${dish.name}">${dish.name}</a></td>
      <td>${dish.weight}</td>
      <td>${dish.price}</td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="2"> <a href="/addDish">Add new dish</a></td>
  </tr>
</table>
  </div>

</body>
</html>
