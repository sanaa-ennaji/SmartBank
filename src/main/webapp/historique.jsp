<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Historique des Modifications</title>
    <link rel="stylesheet" href="css/admin.css">
</head>
<body>

<h2>Historique des Modifications</h2>

<table>
    <thead>
    <tr>

        <th>Status</th>
        <th>Date de Modification</th>
        <th>Raison</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="historique" items="${historiqueList}">
        <tr>
            <td>${historique.status.name}</td>
            <td>${historique.dateModification}</td>
            <td>${historique.raison}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
