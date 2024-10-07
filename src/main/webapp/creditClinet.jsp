 <%--
  Created by IntelliJ IDEA.
  User: sanaa
  Date: 02/10/2024
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <!DOCTYPE html>
 <html lang="en">
 <head>
     <meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <title>Demande de Crédit</title>
     <link rel="stylesheet" href="styles.css">
 </head>
 <body>
 <h1>Liste des Demandes de Crédit</h1>

 <table border="1">
     <tr>
         <th>ID</th>
         <th>Montant</th>
         <th>Durée</th>
         <th>État</th>
         <th>Remarques</th>
         <th>Date de Demande</th>
     </tr>
     <c:forEach var="demande" items="${demandes}">
         <tr>
             <td>${demande.id}</td>
             <td>${demande.montant}</td>
             <td>${demande.duree}</td>
             <td>${demande.etat}</td>
             <td>${demande.remarques}</td>
             <td>${demande.dateDemande}</td>
         </tr>
     </c:forEach>
 </table>

 <h2>Ajouter une nouvelle Demande de Crédit</h2>
 <form action="${pageContext.request.contextPath}/demande" method="post">
     <label for="montant">Montant:</label>
     <input type="text" id="montant" name="montant" required>

     <label for="duree">Durée:</label>
     <input type="text" id="duree" name="duree" required>

     <label for="etat">État:</label>
     <input type="text" id="etat" name="etat" required>

     <label for="remarques">Remarques:</label>
     <textarea id="remarques" name="remarques" required></textarea>

     <button type="submit">Soumettre</button>
 </form>
 </body>
 </html>
