<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add dish</title>
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
<h2>Enter dish information</h2>
<form:form method="post" action="newDish">
  <table>
     <tr>
      <td>Name</td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
      <td>Category</td>
      <td>
        <form:select path="dishCategory">
          <option>FIRSTDISH</option>
          <option>SECONDDISH</option>
          <option>THIRDDISH</option>
          <option>DESSERT</option>
        </form:select>
      </td>
    </tr>
    <tr>
      <td>price</td>
      <td><form:input path="price" /></td>
    </tr>
    <tr>
      <td>weight</td>
      <td><form:input path="weight" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit"/>
      </td>
    </tr>
  </table>
</form:form>

</body>
</html>
