<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Demander mon crédit en ligne</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
<h1 class="titre-center m-t-l">Demander mon crédit en ligne</h1>
<div class="main">
    <!-- Header -->
    <div class="d-flex justify-b m-b-5">
        <div class="w-30 flexe">
            <div class="seconde w-100 titre-center color-four p-y-5">
                <p class="number">1</p>
                <p class="p-1">Simuler mon crédit</p>
            </div>
        </div>

        <div class="w-30 third titre-center p-y-5 white">
            <p class="number">2</p>
            <p class="p-1">Mes coordonnées</p>
        </div>
        <div class="w-30 third titre-center p-y-5 white">
            <p class="number">3</p>
            <p class="p-1">Mes infos personnelles</p>
        </div>
    </div>
    <!-- Header -->

    <div class="forms">
        <!-- Form -->
        <form data-multi-step class="multi-step-form">
            <!-- Step 1 -->
            <div class="card" data-step>
                <div class="form-group margin-x-1">
                    <p class="label">Mon projet</p>
                    <select class="minimal m-t-1" name="projet">
                        <option>J’ai besoin d’argent</option>
                        <option>Je finance mon véhicule d’occasion</option>
                        <option>Je Gère mes imprévus</option>
                        <option>Je finance mon véhicule neuf</option>
                        <option>J’équipe ma maison</option>
                    </select>
                    <p class="label m-t-5">Je suis</p>
                    <select class="minimal m-t-1" name="profession">
                        <option>Salarié du secteur privé</option>
                        <option>Fonctionnaire</option>
                        <option>Profession libérale</option>
                        <option>Commerçant</option>
                        <option>Artisan</option>
                        <option>Retraité</option>
                        <option>Autres professions</option>
                    </select>
                </div>

                <div class="slider-container">
                    <p class="label m-t-5">Montant (en DH)</p>
                    <input class="input1 w-8" type="number" id="sliderValue" step="1" value="5000" name="montant">
                    <input type="range" min="5000" max="600000" step="1000" value="5000" class="slider" id="mySlider" name="montant_slider">

                    <p class="label m-t-5">Durée (en mois)</p>
                    <input class="input1 w-5" type="number" id="durationValue" step="1" value="12" name="duree">
                    <input type="range" min="12" max="120" step="6" value="12" class="slider" id="durationSlider" name="duree_slider">

                    <p class="label m-t-5">Mensualités (en DH)</p>
                    <input class="input1 w-9" type="number" id="mensualiteValue" value="70" step="0.01" name="mensualite">
                    <input type="range" min="1" max="80000" step="100" value="70" class="slider" id="mensualiteSlider" name="mensualite_slider">
                </div>

                <div class="flex-center">
                    <button class="button1 m-t-5" type="button" data-next>
                        <p class="p-10">Continuer</p>
                        <p class="p-2">Sans engagement</p>
                    </button>
                </div>
            </div>
            <!-- End Step 1 -->

            <!-- Step 2 -->
            <div class="card" data-step>
                <div class="form-group m-t-5 input-container">
                    <input type="text" name="email" id="email" placeholder="" class="custom-input" required>
                    <label for="email" class="custom-label">Email*</label>
                </div>
                <div class="form-group m-t-9 input-container">
                    <input type="tel" name="phone" id="phone" placeholder="" class="custom-input border-bottom" required>
                    <label for="phone" id="phoneLabel" class="custom-label color">Téléphone mobile*</label>
                </div>
                <div class="flex-center">
                    <button type="button" class="button1 m-t-5" data-next>
                        <p class="p-10">Continuer</p>
                        <p class="p-2">Sans engagement</p>
                    </button>
                </div>
            </div>
            <!-- End Step 2 -->

            <!-- Step 3 -->
            <div class="card" data-step>
                <div class="form-group radio-container">
                    <label for="civilite" class="radio-title">Civilité</label>
                    <div class="radio-group" id="civilite">
                        <label class="custom-radio">
                            <input type="radio" name="civilite" value="monsieur" checked>
                            <div class="custom_field"></div>
                            <span class="fs1 color-four">Monsieur</span>
                        </label>
                        <label class="custom-radio">
                            <input type="radio" name="civilite" value="madame">
                            <div class="custom_field"></div>
                            <span class="fs1 color-four">Madame</span>
                        </label>
                        <label class="custom-radio">
                            <input type="radio" name="civilite" value="mademoiselle">
                            <div class="custom_field"></div>
                            <span class="fs1 color-four">Mademoiselle</span>
                        </label>
                    </div>
                </div>

                <div class="form-group m-t-5 input-container">
                    <input type="text" name="nom" id="nom" placeholder="" class="custom-input" required>
                    <label for="nom" class="custom-label">Nom*</label>
                </div>
                <div class="form-group m-t-9 input-container">
                    <input type="text" name="prenom" id="prenom" placeholder="" class="custom-input" required>
                    <label for="prenom" class="custom-label">Prénom*</label>
                </div>
                <div class="form-group m-t-9 input-container">
                    <input type="text" name="cin" id="cin" placeholder="" class="custom-input" required>
                    <label for="cin" class="custom-label">Numéro CIN / Carte de séjour*</label>
                </div>
                <div class="form-group m-t-9 input-container">
                    <input type="date" name="date_naissance" id="date_naissance" class="custom-input" required>
                    <label for="date_naissance" class="custom-label">Date de naissance*</label>
                </div>
                <div class="form-group m-t-9 input-container">
                    <input type="date" name="date_embauche" id="date_embauche" class="custom-input" required>
                    <label for="date_embauche" class="custom-label">Date d'embauche/début de l'activité*</label>
                </div>
                <div class="form-group m-t-9 input-container">
                    <input type="number" name="revenus" id="revenus" placeholder="" class="custom-input" required>
                    <label for="revenus" class="custom-label">Total revenus mensuels (net en DH)*</label>
                </div>

                <div class="form-group radio-container m-t-4">
                    <label for="credit" class="radio-title">Avez-vous des crédits en cours ?</label>
                    <div class="radio-group" id="credit">
                        <label class="custom-radio">
                            <input type="radio" name="credit" value="true" checked>
                            <div class="custom_field"></div>
                            <span class="fs1 color-four">Oui</span>
                        </label>
                        <label class="custom-radio">
                            <input type="radio" name="credit" value="false">
                            <div class="custom_field"></div>
                            <span class="fs1 color-four">Non</span>
                        </label>
                    </div>
                </div>

                <div class="flex-center m-b-10">
                    <button type="submit" class="button2 m-t-5">
                        <p class="p-9">Demander ce crédit</p>
                    </button>
                    <button class="button2 m-t-5" data-previous>
                        <p class="p-9">Voir mon récapitulatif</p>
                    </button>
                </div>
            </div>
            <!-- End Step 3 -->

        </form>

    </div>
</div>

<div></div>

<script src="app/js/script.js"></script>
<script src="app/js/calcule.js"></script>

</body>

</html>
