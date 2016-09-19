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
  <h1>Список меню ресторана</h1>

  <table style="align-items: center">
    <tr>
      <th> Id </th>
      <th> Name </th>
      </tr>

    <c:forEach items="${menu}" var="menu">
      <tr>
        <td>${menu.id}</td>
       <td> <a href="/menuDishes?menuName=${menu.name}">${menu.name}</a></td>
      </tr>
    </c:forEach>
   <tr>
     <td colspan="2"> <a href="/newMenu">Add new menu</a></td>
    </tr>
  </table>

</div>

</body>
</html>
