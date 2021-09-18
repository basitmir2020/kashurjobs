$(document).ready(function() {
    $(".has-dropdown").on('click', function(e) {
        $(this).children('.dropdown').slideToggle();
    });
});

$('#btnSubmit').click(function() {
    var save = {
        'Fname': $('#txtFirst').val(),
        'Lname': $('#txtLast').val(),
        'Username': $('#txtUsername').val(),
        'Password': $('#txtPassword').val(),
        'Moblie': $('#txtmobile1').val(),
        'Phone': $('#txtmobile2').val(),
        'Email': $('#txtEmail').val(),
        'Address': $('#txtAddress').val(),
        'Gender': $('#txtGender').val()
    };
    $.ajax({
        url: "Ajax/user.jsp",
        type: "POST",
        data: {
            SAVE: JSON.stringify(save)
        },
        success: function(s) {
            s = $.trim(s);
            if (s === "1") {
                $('#errorMsg').html("<p class='alert alert-success'>User Registered Successfully!</p>");

            } else {
                $('#errorMsg').html(s);
            }
        }
    });
    return false;
});

function loadAllUsers() {
    $.ajax({
        url: "Ajax/user.jsp",
        type: "GET",
        data: {
            DISPLAY: $('#txtLimit').val(),
            SORT: $('#txtOrder').val(),
            SEARCH: $('#txtSearch').val()
        },
        success: function(s) {
            s = $.trim(s);
            $('#UsersList').html(s);
        }
    });
}

$('#txtbtnrole').click(function() {
    var role = {
        'Role': $('#txtrole').val()
    };
    $.ajax({
        url: "Ajax/role.jsp",
        type: "POST",
        data: {
            ROLE: JSON.stringify(role)
        },
        success: function(s) {
            s = $.trim(s);
            if (s === "1") {
                $('#errorMsg').html("<p class='alert alert-success'>Role Created Successfully!</p>");

            } else {
                $('#errorMsg').html(s);
            }
        }
    });
    return false;
});

function loadAllRole() {
    $.ajax({
        url: "Ajax/role.jsp",
        type: "GET",
        data: {
            DISPLAY: $('#txtLimit').val(),
            SORT: $('#txtOrder').val(),
            SEARCH: $('#txtSearch').val()
        },
        success: function(s) {
            s = $.trim(s);
            $('#RoleList').html(s);
        }
    });
}

$('#btnSalary').click(function() {
    var salary = {
        'Name': $('#txtSalary').val(),
        'SalaryFrom': $('#txtFrom').val(),
        'SalaryTo': $('#txtTo').val(),
        'id': $('#txtCreate').val(),
        'Ta': $('#txtTa').val(),
        'Da': $('#txtDa').val(),
        'Pf': $('#txtPf').val(),
        'Other': $('#txtOther').val(),
        'DayDec': $('#txtDay').val(),
        'MinDec': $('#txtMin').val(),
        'MaxDec': $('#txtTim').val(),
        'Leaves': $('#txtLeaves').val()
    };
    $.ajax({
        url: "Ajax/salary.jsp",
        type: "POST",
        data: {
            SALARY: JSON.stringify(salary)
        },
        success: function(s) {
            s = $.trim(s);
            if (s === "1") {
                $('#errorMsg').html("<p class='alert alert-success'>Salary Created Successfully!</p>");

            } else {
                $('#errorMsg').html(s);
            }
        }
    });
    return false;
});

function loadAllSalaries() {
    $.ajax({
        url: "Ajax/salary.jsp",
        type: "GET",
        data: {
            DISPLAY: $('#txtLimit').val(),
            SORT: $('#txtOrder').val(),
            SEARCH: $('#txtSearch').val()
        },
        success: function(s) {
            s = $.trim(s);
            $('#salaryList').html(s);
        }
    });
}

$('#btnWeekdays').click(function(){
    var weekdays ={
       'Week': $('#txtWeek').val(),
       'id':$('#txtCre').val()
   };
     $.ajax({
        url: "Ajax/weekdays.jsp",
        type: "POST",
        data: {
            WEEKDAYS: JSON.stringify(weekdays)
        },
        success: function(s) {
            s = $.trim(s);
            if (s === "1") {
                $('#errorMsg').html("<p class='alert alert-success'>Weekdays Created Successfully!</p>");

            } else {
                $('#errorMsg').html(s);
            }
        }
    });
    return false;
});

function loadAllWeekdays(){
  $.ajax({
        url: "Ajax/weekdays.jsp",
        type: "GET",
        data: {
            DISPLAY: $('#txtLimit').val(),
            SORT: $('#txtOrder').val(),
            SEARCH: $('#txtSearch').val()
        },
        success: function(s) {
            s = $.trim(s);
            $('#weekdaysList').html(s);
        }
    });   
}

$('#btnSchedule').click(function() {
    var schedule = {
        'Name': $('#txtSchName').val(),
        'SchFrom': $('#txtSchFrom').val(),
        'SchTo': $('#txtSchTo').val(),
        'id': $('#txtWeek').val(),
        'signIn': $('#txtSignIn').val(),
        'signOut': $('#txtSignOut').val(),
        'Create': $('#txtCreate').val()
    };
    $.ajax({
        url: "Ajax/schedule.jsp",
        type: "POST",
        data: {
            SCHEDULE: JSON.stringify(schedule)
        },
        success: function(s) {
            s = $.trim(s);
            if (s === "1") {
                $('#errorMsg').html("<p class='alert alert-success'>Schedule Created Successfully!</p>");
            } else {
                $('#errorMsg').html(s);
            }
        }
    });
    return false;
});

function loadAllSchedule() {
    $.ajax({
        url: "Ajax/schedule.jsp",
        type: "GET",
        data: {
            DISPLAY: $('#txtLimit').val(),
            SORT: $('#txtOrder').val(),
            SEARCH: $('#txtSearch').val()
        },
        success: function(s) {
            s = $.trim(s);
            $('#scheduleList').html(s);
        }
    });
}

$('#btnEmployee').click(function() {
    var employee = {
        'id': $('#txtEmp').val(),
        'Salary': $('#txtSalary').val(),
        'SalaryFrom': $('#txtRange').val(),
        'SalaryTo': $('#txtTotal').val(),
        'signIn': $('#txtAdmitted').val(),
        'signOut': $('#txtRelived').val(),
        'Time': $('#txtTime').val(),
        'schedule': $('#txtSchedule').val(),
        'salaryDate': $('#txtSalaryDate').val(),
        'roles': $('#txtRole').val()
    };
    $.ajax({
        url: "Ajax/employee.jsp",
        type: "POST",
        data: {
            EMPLOYEE: JSON.stringify(employee)
        },
        success: function(s) {
            s = $.trim(s);
            if (s === "1") {
                $('#errorMsg').html("<p class='alert alert-success'>Employee Registered Successfully!</p>");

            } else {
                $('#errorMsg').html(s);
            }
        }
    });
    return false;
});

function loadAllEmployee() {
    $.ajax({
        url: "Ajax/employee.jsp",
        type: "GET",
        data: {
            DISPLAY: $('#txtLimit').val(),
            SORT: $('#txtOrder').val(),
            SEARCH: $('#txtSearch').val()
        },
        success: function(s) {
            s = $.trim(s);
            $('#EmployeeList').html(s);
        }
    });
}

$('#btnAttendence').click(function() {
    var attendence = {
        'id': $('#txtEmp').val(),
        'schedule': $('#txtSch').val(),
        'signIn': $('#txtSignIn').val(),
        'signOut': $('#txtSignOut').val(),
        'signInDelay': $('#txtSignInDelay').val(),
        'signOutDelay': $('#txtSignOutDelay').val(),
        'Overtime': $('#txtOverTime').val()
    };
    $.ajax({
        url: "Ajax/attendence.jsp",
        type: "POST",
        data: {
            ATTENDENCE: JSON.stringify(attendence)
        },
        success: function(s) {
            s = $.trim(s);
            if (s === "1") {
                $('#errorMsg').html("<p class='alert alert-success'>Attendence Added Successfully!</p>");

            } else {
                $('#errorMsg').html(s);
            }
        }
    });
    return false;
});


function loadAllAttendence() {
    $.ajax({
        url: "Ajax/attendence.jsp",
        type: "GET",
        data: {
            DISPLAY: $('#txtLimit').val(),
            SORT: $('#txtOrder').val(),
            SEARCH: $('#txtSearch').val()
        },
        success: function(s) {
            s = $.trim(s);
            $('#AttendenceList').html(s);
        }
    });
}

function SignInDelay() {
    $.ajax({
        url: "Ajax/signIn.jsp",
        type: "GET",
        data: {
            SigInDelay: $('#txtEmp').val()
        },
        success: function(s) {
            s = $.trim(s);
             $('#hh').html(s);
        },
        error: function(s) {
            alert(s); 
        }
    });
}

function issue() {
    $.ajax({
        url: "Ajax/issue.jsp",
        type: "GET",
        data: {
            issue: $('#txtEmp').val(),
            Taken :$('#txtSalaryTaken').val()
        },
        success: function(s) {
            s = $.trim(s);
             $('#all').html(s);
        },
        error: function(s) {
            alert(s); 
        }
    });
    return false;
}







