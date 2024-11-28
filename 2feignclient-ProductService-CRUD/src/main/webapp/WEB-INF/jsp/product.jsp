<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Profile</title>
</head>
<body>
 
    <h2>Product Profile</h2>
 
    <!-- UseBean Tag to instantiate and access the Employee Bean -->
    <jsp:useBean id="productBean" class="com.cg.model.Product" scope="request" />
    
    <!-- Set values using setProperty -->
    <jsp:setProperty name="productBean" property="id" value="${product.id}" />
    <jsp:setProperty name="productBean" property="name" value="${product.name}" />
    <jsp:setProperty name="productBean" property="price" value="${product.price}" />
 
    <!-- Get properties of the bean -->
    <p>ID: <jsp:getProperty name="productBean" property="id" /></p>
    <p>Name: <jsp:getProperty name="productBean" property="name" /></p>
    <p>Email: <jsp:getProperty name="productBean" property="email" /></p>
 
    <h3>Direct access to Product properties from the Model:</h3>
    <p>ID: ${product.id}</p>
    <p>Name: ${product.name}</p>
    <p>Email: ${product.email}</p>
 
</body>
</html>