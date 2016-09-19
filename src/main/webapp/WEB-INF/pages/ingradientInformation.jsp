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
  <h1>Склад</h1>
 <table style="align-items: center">
    <tr>
      <th>Id </th>
      <th>Name</th>
      <th>Numerosity</th>
    </tr>

   <tr>
     <td>${ingradient.id}</td>
     <td>${ingradient.name}</td>
     <td>${ingradient.numerosity}</td>
   </tr>
     <tr>
         <td colspan="3"> <a href="/removeIngradient" ><span>Remove this ingradient</span>
         </a></td>
     </tr>
  </table>
</div>

    <form method="GET" action="changeNumerosity">
      <table>
        <tr><th><h2>Поміняти кількість інградіентів на складі</h2></th></tr>
        <tr>
          <td>Введіть нову кількість інградіентів на складі :</td>
          <td><input type="text" name="name"/></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit"></td>
        </tr>
      </table>
    </form>


</body>
</html>
