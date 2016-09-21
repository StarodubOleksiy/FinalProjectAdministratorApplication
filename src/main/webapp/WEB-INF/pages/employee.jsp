<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="menu" >
  <nav>
    <ul>

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
<table style="align-items: center">
  <tr>
    <th>First Name </th>
    <th>Last Name </th>
    <th>Position</th>
    <th>Phone Number</th>
    <th>Salary</th>
  </tr>

  <tr>
    <td>${employee.name}</td>
    <td>${employee.surname}</td>
    <td>${employee.position}</td>
    <td>${employee.phoneNumber}</td>
    <td>${employee.salary}</td>

  </tr>
</table>
<c:if test="${employee.position == 'WAITER'}">
  <table style="align-items: center">
    <tr>
      <th>id </th>
      <th>Table number </th>
      <th>Order date</th>
      <th>State</th>
    </tr>
  <c:forEach var="orders" items="${orders}" >


    <tr>
      <td>${orders.id}</td>
      <td>${orders.tableNumber}</td>
      <td>${orders.orderDate}</td>
      <td>${orders.state}</td>
    </tr>


  </c:forEach>
    <tr>
      <td colspan="4">
        <form method="POST" action="addOrder">
          <table>
            <tr><th><h2>Додати новий заказ для цього офіціанта</h2></th></tr>
            <tr>
              <td>Введіть номер столика :</td>
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
  </c:if>

  <c:if test="${employee.position == 'COOK'}">
    <h1>Приготовлені страви цього кухаря</h1>
<table style="align-items: center">
  <tr>
    <th>id </th>
    <th>Dish </th>
    <th>Order</th>
    <th>Date</th>
  </tr>
    <c:forEach var="cooked_Dishes" items="${cooked_Dishes}" >


      <tr>
        <td>${cooked_Dishes.id}</td>
        <td>${cooked_Dishes.dish.name}</td>
        <td>${cooked_Dishes.order.id}</td>
        <td>${cooked_Dishes.orderDate}</td>
              </tr>

    </c:forEach>
  </table>
  <h1>Список відкритих замовлень</h1>
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
  <tr>
    <td colspan="4">
      <form method="POST" action="addCookedDish">
        <table>
          <tr><th><h2>Додати нову страву для цього кухаря</h2></th></tr>
          <tr>
            <td>Введіть назву страви :</td>
            <td><input type="text" name="dishname"/></td>
          </tr>
          <tr>
            <td>Введіть номер (id) замовлення :</td>
            <td><input type="text" name="ordernumber"/></td>
          </tr>
          <tr>
            <td colspan="2"><input type="submit"></td>
          </tr>
        </table>
      </form>
    </td>
  </tr>
</table>
  </c:if>

</body>
</html>

