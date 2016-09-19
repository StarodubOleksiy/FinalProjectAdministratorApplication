<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
  <title></title>
</head>
<body>
<h1> Order information</h1>
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
<div >
  <table style="align-items: center">
    <tr>
      <th>Id </th>
      <th>Employee Id </th>
      <th>Table number </th>
      <th>Order date </th>
      <th>State </th>
    </tr>

      <tr>
        <td>${orderInformation.id}</td>

        <td>${orderInformation.tableNumber}</td>
        <td>${orderInformation.orderDate}</td>
        <td>${orderInformation.state}</td>
      </tr>


  </table>

  <table style="align-items: center">
    <tr>
      <th>Dish number </th>
      <th>Dish name</th>
    </tr>
    <c:forEach var="orderDish" items="${orderDishes}" >
      <tr>
        <td>${orderDish.id}</td>
        <td><a href="/dish?dishName=${orderDish.dish.name}">${orderDish.dish.name}</a></td>
      </tr>
    </c:forEach>
  </table>
</div>

</div>


</body>
</html>