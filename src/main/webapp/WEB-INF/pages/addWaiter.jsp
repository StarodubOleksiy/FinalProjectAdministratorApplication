<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>New waiter</title>
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
<h2>Enter waiter information</h2>
<form:form method="post" action="newWaiter">
  <table>
    <tr>
      <td>Name</td>
      <td><form:input path="name" /></td>
    </tr>
    <tr>
      <td>Surname</td>
      <td><form:input path="surname" /></td>
    </tr>
    <tr>
      <td>Phone number</td>
      <td><form:input path="phoneNumber" /></td>
    </tr>
    <tr>
      <td>Salary</td>
      <td><form:input path="salary" /></td>
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