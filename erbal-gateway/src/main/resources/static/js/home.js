
$.ajax({
    url: '/user/current',
    type: 'get',
    headers: {'X-Requested-With': 'XMLHttpRequest'},
    success: function (data) {

        alert(JSON.stringify(data));
    },
    error: function () {

        alert("error");
    }
});