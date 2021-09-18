$('#btnLogin').click(function() {
    var login = {
        'Company': $('#txtCompany').val(),
        'Password': $('#txtPass').val()
    };
    $.ajax({
        url: "Ajax/companyLogin.jsp",
        type: "POST",
        data: {
            LOGIN: JSON.stringify(login)
        },
        success: function(s) {
            s = $.trim(s);
            if (s === "1") {
                 document.location = "../Companies/Company-Dashboard";
            } else {
                $('#errorMsg').html(s);
            }
        }
    });
    return false;
});

