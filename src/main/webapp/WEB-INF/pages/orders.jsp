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

    </ul>
  </nav>
</div>
<h1>Order history</h1>
<div id="personal">
  <table style="align-items: center">
    <tr>
      <th>Id </th>
      <th>Employee Id </th>
      <th>Table number </th>
      <th>Order date </th>
      <th>State </th>
     </tr>

    <c:forEach items="${orders}" var="order">
      <tr>
        <td><a href="/orderInformation?orderId=${order.id}">${order.id}</a></td>
        <td><a href="/employee?employeeId=${order.waiter.id}">${order.waiter.id}</a></td>
         <td>${order.tableNumber}</td>
        <td>${order.orderDate}</td>
        <td>${order.state}</td>
       </tr>
    </c:forEach>

  </table>
  <table>
    <tr>
      <td>
        <form method="GET" action="findByTableNumber">
          <table>
            <tr><th><h2>Пошук заказів по номеру столика</h2></th></tr>
            <tr>
              <td>Введіть номер стола :</td>
              <td><input type="text" name="name"/></td>
            </tr>
            <tr>
              <td colspan="2"><input type="submit"></td>
            </tr>
          </table>
        </form>
      </td>
      <td>
        <form method="GET" action="findByWaiterId">
          <table>
            <tr><th><h2>Пошук заказів по ід офіціанта</h2></th></tr>
            <tr>
              <td>Введіть id офіціанта :</td>
              <td><input type="text" name="name"/></td>
            </tr>
            <tr>
              <td colspan="2"><input type="submit"></td>
            </tr>
          </table>
        </form>
      </td>
    </tr>
  </table>
</div>


</body>
</html>
