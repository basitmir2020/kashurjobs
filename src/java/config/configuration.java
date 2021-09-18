package config;
public class configuration {
    // website 
    public static final String WEBPATH = "http://localhost:8080/SalaryManagement/";
    public static final String INDEXURL = "Admin/Admin-Login";
    public static final String DASHBOARDSURL = WEBPATH+"Admin/Admin-Dashboard";
    public static final String LOGOUTURL = "Admin/Admin-Logout";
    public static final String LOGINURL = WEBPATH+"Admin";
    
    //Admin Pannel
    public static final String DASHBOARD = "Admin/Admin-Dashboard";
    public static final String ENQUIRY = "Admin/Enquiry";
    public static final String ADDCOMPANY = "Admin/addCompany";
    public static final String MANAGECOMPANY = "Admin/manageCompany";
    
    //Companies Pannel
    public static final String COMPANY_DASHBOARD = "Companies/Company-Dashboard";
    public static final String CREATE_USER = "Companies/Create-User";
    public static final String MANAGE_USER = "Companies/Manage-User";
    public static final String CREATE_ROLE = "Companies/Create-Role";
    public static final String MANAGE_ROLE = "Companies/Manage-Role";
    public static final String CREATE_SALARIES = "Companies/Create-Salaries";
    public static final String MANAGE_SALARIES = "Companies/Manage-Salaries";
    public static final String CREATE_WEEKDAYS = "Companies/Create-Weekdays";
    public static final String MANAGE_WEEKDAYS = "Companies/Manage-Weekdays";
    public static final String CREATE_SCHEDULE = "Companies/Create-Schedule";
    public static final String MANAGE_SCHEDULE = "Companies/Manage-Schedule";
    public static final String ADD_EMPLOYEE = "Companies/Add-Employee";
    public static final String MANAGE_EMPLOYEE = "Companies/Manage-Employee";
    public static final String Add_ATTENDENCE = "Companies/Add-Attendence";
    public static final String MANAGE_ATTENDENCE = "Companies/Manage-Attendence";
    public static final String ISSUE_SALARY = "Companies/Issue-Salary";
    public static final String MANAGE_SALARY = "Companies/Manage-Salary";
    public static final String CHANGE_PASSWORD = "Companies/Change-Password";
    public static final String COMPANY_LOGOUT = "Companies/Company-Logout";
    
    public static final String TITLE = "Salary Management";
    public static final String ADMINTITLE = "Admin";
    public static final String IMAGES = "img/";
    public static final String STYLES = "css/";
    public static final String SCRIPTS = "js/";
    public static final String JQUERY = "js/jquery.min.js";
    public static final String FONTS   = STYLES+"asserts/font-awesome/css/font-awesome.css";
    
    // database
    public static final String DBHOST = "jdbc:mysql://localhost:3306/";
    public static final String DBNAME = "feemanagement";
    public static final String DBUSER = "root";
    public static final String DBPASS = ""; 
}
