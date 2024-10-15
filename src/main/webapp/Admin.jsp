<%--
  Created by IntelliJ IDEA.
  User: sanaa
  Date: 14/10/2024
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Demande Credit List</title>
    <link rel="stylesheet" href="css/admin.css">
</head>
<body>

<h2>Demande Credit List</h2>

<!-- Filter Form -->
<form method="get" action="demande">
    <label for="statusId">Filter by Status:</label>
    <select name="statusId" id="statusId">
        <option value="1">encours</option>
        <option value="2">refusee</option>
        <option value="3">accepter</option>
    </select>

    <label for="dateDebut">Filter by Date Debut:</label>
    <input type="date" name="dateDebut" id="dateDebut">

    <button type="submit">Filter</button>
</form>

<table>
    <thead>
    <tr>
        <th>Montant</th>
        <th>Duree</th>
        <th>Mensualites</th>
        <th>Email</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>CIN</th>
        <th>Date Debut</th>
        <th>Date Naissance</th>
        <th>Total</th>
        <th>Date Demande</th>
        <th>Update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="demande" items="${demandes}">
        <tr>
            <td>${demande.montant}</td>
            <td>${demande.duree}</td>
            <td>${demande.mensualites}</td>
            <td>${demande.email}</td>
            <td>${demande.nom}</td>
            <td>${demande.prenom}</td>
            <td>${demande.CIN}</td>
            <td>${demande.dateDebut}</td>
            <td>${demande.dateNaissance}</td>
            <td>${demande.total}</td>
            <td>${demande.dateDemande}</td>

            <td><button onclick="openPopup(${demande.id})">Update Status</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<div id="myPopup" class="popup">
    <div class="popup-content">
        <span class="close" onclick="closePopup()">&times;</span>
        <h2>Update Status</h2>
        <form action="updateStatus" method="post">
            <input type="hidden" name="demande_credit_id" id="demandeId">
            <label for="status_id">Select Status:</label>
            <select name="status_id" id="status_id">

                <option value="1">encours</option>
                <option value="2">refusee</option>
                <option value="3">accepter</option>
            </select>
            <br><br>
            <button type="submit">Update</button>
        </form>
    </div>
</div>
<script src="js/admin.js"></script>

</body>
</html>

