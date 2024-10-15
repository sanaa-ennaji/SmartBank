document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".multi-step-form");

    form.addEventListener("submit", function (event) {

        if (!validateForm()) {
            event.preventDefault();
        }
    });

    function validateForm() {
        let isValid = true;


        const email = document.getElementById("email");
        const phone = document.getElementById("phone");
        const nom = document.getElementById("nom");
        const prenom = document.getElementById("prenom");
        const cin = document.getElementById("cin");
        const dateNaissance = document.getElementById("date_naissance");
        const dateEmbauche = document.getElementById("date_embauche");
        const revenus = document.getElementById("revenus");


        if (!validateEmail(email.value)) {
            alert("Veuillez entrer une adresse e-mail valide.");
            isValid = false;
        }


        if (!validatePhone(phone.value)) {
            alert("Veuillez entrer un numéro de téléphone valide (10 chiffres).");
            isValid = false;
        }


        if (nom.value.trim() === "") {
            alert("Le champ Nom est requis.");
            isValid = false;
        }
        if (prenom.value.trim() === "") {
            alert("Le champ Prénom est requis.");
            isValid = false;
        }
        if (cin.value.trim() === "") {
            alert("Le champ CIN est requis.");
            isValid = false;
        }
        if (dateNaissance.value === "") {
            alert("Veuillez sélectionner votre date de naissance.");
            isValid = false;
        }
        if (dateEmbauche.value === "") {
            alert("Veuillez sélectionner la date d'embauche.");
            isValid = false;
        }
        if (revenus.value <= 0) {
            alert("Veuillez entrer un revenu mensuel valide.");
            isValid = false;
        }

        return isValid;
    }

    function validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(email).toLowerCase());
    }


    function validatePhone(phone) {
        const re = /^[0-9]{10}$/;
        return re.test(phone);
    }
});