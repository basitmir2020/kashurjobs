

$('#tblsubmit').click(function() {
    var details = {
        'Name': $('#txtName').val(),
        'Phone': $('#txtContact').val(),
        'Enquiry': $('#txtEnquiry').val()
    };
    $.ajax({
        type: 'POST',
        url: "process/company.jsp",
        data: {DETAILS:JSON.stringify(details)},
        beforesend: function() {
            $('#loader').show();
        },
        success: function(s) {
            s = $.trim(s);
            if (s === "1") {
                $('#errorMsg').html("<p class='alert alert-success'>Successfully Posted!</p>");
               document.getElementById("ui").reset();
            } else {
                $('#errorMsg').html(s);
            }
        },
        complete: function() {
            $('#loader').hide();
        }
    });
    return false;
});
