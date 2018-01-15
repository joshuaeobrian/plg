function login(method,url,data) {
    let request = $.ajax({
        url: url,
        method: method,
        data: data,
    }).done(function (response) {
        console.log(response);
        $("#account-btn").text(response);
        $("#account-btn").attr("data-toggle","dropdown");
        $("#account-btn").addClass("dropdown-toggle");
        $("#account-btn").removeAttr("data-target");
        $("#login-signup").modal('hide');
    });

}


$("#sign-up-link").on("click",function(){
    $("#login").hide();
    $("#sign-up").show();
});
$("#submit-account").on('click',function () {
    let url = "/api/account";
    let data = {};
    if($("#login").is(":visible")){
        url += "/login";
        data.username = $("#login input[name=login]").val();
        data.password = $("#login input[name=password]").val();
    }else{
        /**********************************
         * @route /api/account/new
         * @param firstName
         * @param lastName
         * @param email
         * @param username
         * @param password
         * @param phone
         * @param gender
         * @type {object}
         **********************************/
        url += "/new";
        data.firstName = $("#sign-up input[name=firstName]").val();
        data.lastName = $("#sign-up input[name=lastName]").val();
        data.email = $("#sign-up input[name=email]").val();
        data.username = $("#sign-up input[name=username]").val();
        data.password = $("#sign-up input[name=password]").val();
        data.phone = $("#sign-up input[name=phone]").val();
        data.gender = $("#sign-up select[name=gender]").val();

    }
    login("POST", url, data);
});