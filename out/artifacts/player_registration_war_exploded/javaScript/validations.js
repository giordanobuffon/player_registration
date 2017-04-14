function heightValidation() {
    var height;
    height = document.getElementById('height');
    height.value.replace()


    if (isNaN(height.value) || parseFloat(height.value) < 0.50 || parseFloat(height.value) > 2.50) {
        height.style = "border-color: red;";
        height.value = '';
        height.focus();
        alert('Valor inválido! A altura deve ser maior que 0,50 e menor que 2,50 metros.');
    } else {
        height.style = "border-color: white;";
    }
}

function weightValidation() {
    var weight;
    weight = document.getElementById('weight');

    if (isNaN(weight.value) || parseFloat(weight.value) < 30 || parseFloat(weight.value) > 150) {
        weight.style = "border-color: red;";
        weight.value = '';
        weight.focus();
        alert('Valor inválido! O peso deve ser maior que 30 e menor que 150 kg.');
    } else {
        weight.style = "border-color: white;";
    }
}

function ageValidation() {
    var age;
    age = document.getElementById('age');

    if (isNaN(age.value) || parseFloat(age.value) < 18 || parseFloat(age.value) > 36) {
        age.style = "border-color: red;";
        age.value = '';
        age.focus();
        alert('Valor inválido! A idade deve ser maior que 18 e menor que 36 anos.');
    } else {
        age.style = "border-color: white;";
    }
}

function nameValidation() {
    var name;
    name = document.getElementById('name');

    if (name.value != "") {
        name.style = "border-color: white;";
    }
}

function teamValidation() {
    var team;
    team = document.getElementById('team');

    if (team.value != "empty_team") {
        team.style = "border-color: white;";
    }
}

function requiredField() {
    var name, team, height, weight, age;
    var test = true;

    name = document.getElementById('name');
    team = document.getElementById('team');
    height = document.getElementById('height');
    weight = document.getElementById('weight');
    age = document.getElementById('age');

    if (age.value == '') {
        age.style = "border-color: red;";
        age.focus();
        test = false;
    } else {
        age.style = "border-color: white;";
    }

    if (weight.value == '') {
        weight.style = "border-color: red;";
        weight.focus();
        test = false;
    } else {
        weight.style = "border-color: white;";
    }

    if (height.value == '') {
        height.style = "border-color: red;";
        height.focus();
        test = false;
    } else {
        height.style = "border-color: white;";
    }

    if (team.value == 'empty_team') {
        team.style = "border-color: red;";
        team.focus();
        test = false;
    } else {
        team.style = "border-color: white;";
    }

    if (name.value == '') {
        name.style = "border-color: red;";
        name.focus();
        test = false;
    } else {
        name.style = "border-color: white;";
    }

    if (!test) {
        alert('Campos obrigatórios! Por favor, preencha-os e tente novamente!');
    }

    return test;
}
