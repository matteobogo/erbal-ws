//Login

var currentUser = {};

function User(email, firstname, lastname, greenhouse) {

    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.greenhouse = greenhouse;
}

function initCurrentUser(user) {

    currentUser = new User(user.email, user.firstname, user.lastname, user.greenhouseName);

    alert(currentUser);
}

function login() {

    var email = $("#email-form").val();
    var password = $("#password-form").val();

    //obtain OAuth Token
    if(requestOauthToken(email,password)) {

        initCurrentUser(getCurrentUser());

        alert(currentUser);

        window.location.replace("index.html");
    }
    else {
        alert("Something went wrong. Check credentials");
    }
}

function requestOauthToken(email, password) {

    var success = false;

    //request token
    $.ajax({
        url: '/erbal-uaa/oauth/token',
        datatype: 'json',
        type: 'post',
        headers: {'Authorization': 'Basic '+btoa(email + ":" + password)},
        async: false,
        data: {
            scope: 'ui',
            username: email,
            password: password,
            grant_type: password
        },
        success: function (data) {
            localStorage.setItem('token', data.access_token);
            success = true;

            alert("success");
        },
        error: function (data) {
            removeOauthTokenFromStorage();

            alert("error");
        }
    });

    return success;
}

function getOauthTokenFromStorage() {
    return localStorage.getItem('token');
}

function removeOauthTokenFromStorage() {
    return localStorage.removeItem('token');
}

function getCurrentUser() {

    var token = getOauthTokenFromStorage();
    var currentUser = null;

    if(token) {
        $.ajax({
            url: '/erbal-uaa/user/current',
            datatype: 'json',
            type: 'get',
            headers: {'Authorization': 'Bearer ' + token},
            async: false,
            success: function (data) {
                currentUser = data;
            },
            error: function () {
                removeOauthTokenFromStorage();
            }
        });
    }

    return currentUser;
}