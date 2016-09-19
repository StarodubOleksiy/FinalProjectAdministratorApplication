<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
  <h1>Меню ресторана</h1>
  <h1>${menu}</h1>
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
  </table>
    <div class="menu" >
        <nav>
            <ul>
                <li>
                    <a href="/dishToMenu" >
                        <span>Add Dish To Menu</span>
                    </a>
                </li>
                <li>
                    <a href="/dishFromMenu" >
                        <span>Remove Dish From Menu</span>
                    </a>
                </li>
                <li>
                    <a href="/removeMenu" >
                        <span>Remove this menu</span>
                    </a>
                </li>

            </ul>
        </nav>
    </div>


 </div>

</body>
</html>
