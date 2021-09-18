

$('#btnSubmit').click(function() {
    var details = {
        'Company': $('#txtCompany').val(),
        'Phone': $('#txtContact').val(),
        'Username': $('#txtUsername').val(),
        'Password': $('#txtPassword').val(),
        'Status': $('#txtStatus').val(),
        'Address': $('#txtAddress').val()
    };
    $.ajax({
        type: 'POST',
        url: "../Admin/Ajax/Admin.jsp",
        data: {DETAILS: JSON.stringify(details)},
        beforesend: function() {
            $('#loader').show();
        },
        success: function(s) {
            s = $.trim(s);
            if (s === "1") {
                $('#errorMsg').html("<p class='alert alert-success'>Successfully Saved!</p>");
                company.reset();
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

function loadAllCompanies() {
 $.ajax({
     url:"../Admin/Ajax/Admin.jsp",
     type:"GET",
     data:{
            DISPLAY: $('#txtLimit').val(),
            SORT: $('#txtOrder').val(),
            SEARCH: $('#txtSearch').val()
     },
     success:function(s){
         s=$.trim(s);
         $('#categoriesList').html(s);
     }
 }); 
}

function loadAllEnquires() {
 $.ajax({
     url:"../process/company.jsp",
     type:"GET",
     data:{
            DISPLAY: $('#txtLimit').val(),
            SORT: $('#txtOrder').val(),
            SEARCH: $('#txtSearch').val()
     },
     success:function(s){
         s=$.trim(s);
         $('#EnquiryList').html(s);
     }
 }); 
}
