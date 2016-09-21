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
  <h1>Список інградіентів на складі</h1>

  <table style="align-items: center">
    <tr>
      <th> Id </th>
      <th> Name </th>
      <th> Numerosity </th>
    </tr>

    <c:forEach items="${ingradients}" var="ingradients">
      <tr>
        <td>${ingradients.id}</td>
        <td>${ingradients.name}</td>
        <td>${ingradients.numerosity}</td>
      </tr>
    </c:forEach>
    <tr>
      <td colspan="2"> <a href="/newIngradient">Add new Ingradient</a></td>
    </tr>
  </table>

</div>

<div id="right">



  <table style="align-items: center" class="dish">
    <tr><th>Id</th>
      <th>Name</th>
    </tr>
     <tr>
       <td>${ingradient.id}</td>
      <td><a href="/ingradientInformation?ingradientName=${ingradient.name}">${ingradient.name}</a></td>
    </tr>
  </table>

  <form method="GET" action="findByWord">
    <table>
      <tr><th><h2>Пошук</h2></th></tr>
      <tr>
        <td>Введіть назву iнградіенту :</td>
        <td><input type="text" name="name"/></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit"></td>
      </tr>
    </table>
  </form>

  </div>

</body>
</html>