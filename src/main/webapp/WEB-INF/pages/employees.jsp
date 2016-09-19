<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div class="menu" >
  <nav>
    <ul>


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
<h1>Наш персонал</h1>
<div id="personal">
<table style="align-items: center">
  <tr>
    <th>Id </th>
    <th>Name </th>
    <th>Surname </th>
    <th>Phone number </th>
    <th>Position </th>
    <th>Salary </th>
  </tr>

  <c:forEach items="${employees}" var="employee">
    <tr>
      <td><a href="/employee?employeeId=${employee.id}">${employee.id}</a></td>
      <td>${employee.name}</td>
      <td>${employee.surname}</td>
      <td>${employee.phoneNumber}</td>
      <td>${employee.position}</td>
      <td>${employee.salary}</td>

    </tr>
  </c:forEach>

</table>
  <table>
    <tr>
      <td> <a href="/addWaiter">Add new waiter</a></td>
      <td> <a href="/addCook">Add new cook</a></td>
    </tr>
    </table>
  </div>


</body>
</html>
