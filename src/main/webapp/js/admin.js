function openPopup(demandeId) {
    var popup = document.getElementById("myPopup");
    var idInput = document.getElementById("demandeId");
    idInput.value = demandeId;

    popup.style.display = "block";
}

function closePopup() {
    var popup = document.getElementById("myPopup");
    popup.style.display = "none";
}

window.onclick = function(event) {
    var popup = document.getElementById("myPopup");
    if (event.target === popup) {
        popup.style.display = "none";
    }
}