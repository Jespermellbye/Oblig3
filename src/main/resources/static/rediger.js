$(function () {
    const id = window.location.search.substring(1);
    const url = "/getOneTicket?" + id;
    $.get(url, function (ticket) {
        $("#film").val(ticket.movie),
            $("#antall").val(ticket.numberOfTickets),
            $("#fornavn").val(ticket.fname),
            $("#etternavn").val(ticket.lname),
            $("#epost").val(ticket.email),
            $("#telefon").val(ticket.phone);
    });
});

function kjopBillett() {
    let film = document.getElementById("film").value;
    let antall = document.getElementById("antall").value;
    let fornavn = document.getElementById("fornavn").value;
    let etternavn = document.getElementById("etternavn").value;
    let epost = document.getElementById("epost").value;
    let telefon = document.getElementById("telefon").value;

    let errorMessage = false;

    if (film === "") {
        document.getElementById("feilFilm").innerHTML = "Vennligst velg en film";
        errorMessage = true;
    } else {
        document.getElementById("feilFilm").innerHTML = "";
    }

    if (!antall || antall <= 0) {
        document.getElementById("feilAntall").innerHTML = "Må skrive noe inn i antallet";
        errorMessage = true;
    } else {
        document.getElementById("feilAntall").innerHTML = "";
    }

    if (!gyldigFornavn(fornavn)) {
        document.getElementById("feilFornavn").innerHTML = "Må skrive noe inn i fornavnet";
        errorMessage = true;
    } else {
        document.getElementById("feilFornavn").innerHTML = "";
    }

    if (!gyldigEtternavn(etternavn)) {
        document.getElementById("feilEtternavn").innerHTML = "Må skrive noe inn i etternavnet";
        errorMessage = true;
    } else {
        document.getElementById("feilEtternavn").innerHTML = "";
    }

    if (!gyldigEpost(epost)) {
        document.getElementById("feilEpost").innerHTML = "Må skrive noe inn i epost";
        errorMessage = true;
    } else {
        document.getElementById("feilEpost").innerHTML = "";
    }

    if (!gyldigTelefon(telefon)) {
        document.getElementById("feilTelefon").innerHTML = "Må skrive noe inn i telefonnr.";
        errorMessage = true;
    } else {
        document.getElementById("feilTelefon").innerHTML = "";
    }

    if (!errorMessage) {
        let billettInput = {
            film: film,
            antall: antall,
            fornavn: fornavn,
            etternavn: etternavn,
            epost: epost,
            telefon: telefon
        };

        $.ajax({
            url: '/editTicket',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(billettInput),
            success: function() {
                window.location.href = "index.html"; // Redirect etter vellykket post
            },
            error: function(error) {
                console.log('Error: ', error);
            }
        });
    }
}

function slettInput() {
    document.getElementById("film").value = "";
    document.getElementById("antall").value = "";
    document.getElementById("fornavn").value = "";
    document.getElementById("etternavn").value = "";
    document.getElementById("epost").value = "";
    document.getElementById("telefon").value = "";
}

function clearErrorMessages() {
    document.getElementById("feilFilm").innerHTML = "";
    document.getElementById("feilAntall").innerHTML = "";
    document.getElementById("feilFornavn").innerHTML = "";
    document.getElementById("feilEtternavn").innerHTML = "";
    document.getElementById("feilEpost").innerHTML = "";
    document.getElementById("feilTelefon").innerHTML = "";
}