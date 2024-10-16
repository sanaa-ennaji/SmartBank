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
    <style>
        body{
            margin-inline: 8px;
        }
        a {
        background-color: #FDDF35;
        color: #fff;
        padding: 6px 12px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 14px;
    }

    button[type="submit"]:hover {
        background-color: #02AFBC;
    }


    .filter-form {
        display: flex;
        justify-content: space-between;
        align-items: center;
        gap: 20px;
    }


    .filter-form label {
        margin-right: 10px;
        font-weight: bold;
    }

    .filter-form select, .filter-form input {
        padding: 5px;
        font-size: 1rem;
    }

    .filter-form button {
        padding: 8px 16px;
        background-color: #02AFBC;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    .filter-form button:hover {
        background-color: #02AFBC;
    }
    </style>
</head>
<body>

<h2>Demande Credit List</h2>

<div class="form-container">
    <!-- Filter Form -->
    <form class="filter-form" method="get" action="demande">
        <div>
        <label for="statusId">Filter by Status:</label>
        <select name="statusId" id="statusId">
            <option value="1">encours</option>
            <option value="2">refusee</option>
            <option value="3">accepter</option>
        </select>
        </div>
        <div>
        <label for="dateDebut">Filter by Date Debut:</label>
        <input type="date" name="dateDebut" id="dateDebut">
</div>
        <button type="submit">Filter</button>
    </form>
</div>

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
        <th>View Historique</th>
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
            <td><a href="historiqueDemande?demandeCreditId=${demande.id}">Historique</a></td>
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

