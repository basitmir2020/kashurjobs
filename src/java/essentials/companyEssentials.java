package essentials;

import config.configuration;
import controller.companyController;
import model.userModel;
public class companyEssentials {

    private static String header() {
        String str = "";
        str += "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <title>" + configuration.TITLE + "</title>\n"
                + "        <link href=\"../" + configuration.STYLES + "default.css\" rel=\"stylesheet\" type=\"text/css\"/>\n"
                + "        <script src=../" + configuration.JQUERY + " type=\"text/javascript\"></script>\n"
                + "        <link href=../" + configuration.FONTS + " rel=\"stylesheet\" type=\"text/css\"/>\n"
                + ""
                + "    </head>\n"
                + "    <body>\n"
                + "    <main class=\"container\">";
        return str;
    }

    private static String topNav(String title,userModel um) {
        companyController cc = new companyController();
        String topNav = "";
        topNav = " <section class=\"row header\">  \n"
                + "            <div class=\"column-3\">\n"
                + "                <h1>" + title + " <span>Pannel</span></h1>\n"
                + "            </div>   \n"
                + "            <div class=\"column-offset-3 column-6\">\n"
                + "                <ul>\n"
                + "                    <li><a href=\""+"../"+configuration.COMPANY_LOGOUT+"?stat=102\"><i class=\"fa fa-sign-out\"></i> Logout</a></li>\n"
                + "                    <li><a href=\""+"../"+configuration.CHANGE_PASSWORD+"\"><i class=\"fa fa-key\"></i> Change Password</a></li>\n"
                + "                    <li><a href=\"#\"><i class=\"fa fa-gear\"></i> Setting</a></li>\n"
                + "                    <li><a href=\"#\"><i class=\"fa fa-user\"></i> "+cc.getCompanies((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"),um)+"</a></li>\n"
                + "                </ul>\n"
                + "            </div>\n"
                + "        </section>   ";
        return topNav;
    }

    private static String mainNav(String title) {
        String content = "";
        content = " <section class=\"row\">\n"
                + "            <div class=\"column-3 sideheader\">\n"
                + "                <ul class=\"links\">\n"
                + "                    <li><a href=\""+"../"+configuration.COMPANY_DASHBOARD+"\"><i class=\"fa fa-dashboard\"></i> Dashboard </a></li>\n"
                + "                </ul>\n"
                + "                    <li class=\"has-dropdown\" style='margin-top:25px;'>"
                + "                         <a href=\"#\"><i class=\"fa fa-user\"></i> User</a>"
                + "                         <ul class=\"dropdown\">\n"
                + "                               <li><a href=\""+"../"+configuration.CREATE_USER+"\">Create User</a></li>\n"
                + "                               <li><a href=\""+"../"+configuration.MANAGE_USER+"\">Manage User</a></li>\n"
                + "                         </ul>\n"
                + "                    </li>\n"
                + "                    <li class=\"has-dropdown\">"
                + "                         <a href=\"#\"><i class=\"fa fa-cubes\"></i> Role</a>"
                + "                          <ul class=\"dropdown\">\n"
                + "                               <li><a href=\""+"../"+configuration.CREATE_ROLE+"\">Create Role</a></li>\n"
                + "                               <li><a href=\""+"../"+configuration.MANAGE_ROLE+"\">Manage Role</a></li>\n"
                + "                          </ul>\n"
                + "                    </li>\n"
                + "                    <li class=\"has-dropdown\">"
                + "                        <a href=\"#\"><i class=\"fa fa-rupee\"></i> Salaries</a>"
                + "                          <ul class=\"dropdown\">\n"
                + "                               <li><a href=\""+"../"+configuration.CREATE_SALARIES+"\">Create Salaries</a></li>\n"
                + "                               <li><a href=\""+"../"+configuration.MANAGE_SALARIES+"\">Manage Salaries</a></li>\n"
                + "                          </ul>\n"
                + "                    </li>\n"
                + "                    <li class=\"has-dropdown\">"
                + "                       <a href=\"#\"><i class=\"fa fa-calendar\"></i> Weekdays</a>"
                + "                          <ul class=\"dropdown\">\n"
                + "                               <li><a href=\""+"../"+configuration.CREATE_WEEKDAYS+"\">Create Weekdays</a></li>\n"
                + "                               <li><a href=\""+"../"+configuration.MANAGE_WEEKDAYS+"\">Manage Weekdays</a></li>\n"
                + "                          </ul>\n"
                + "                    </li>\n"
                + "                    <li class=\"has-dropdown\">"
                + "                         <a href=\"#\"><i class=\"fa fa-clock-o\"></i> Work Schedule</a>"
                + "                          <ul class=\"dropdown\">\n"
                + "                               <li><a href=\""+"../"+configuration.CREATE_SCHEDULE+"\">Create Schedule</a></li>\n"
                + "                               <li><a href=\""+"../"+configuration.MANAGE_SCHEDULE+"\">Manage Schedule</a></li>\n"
                + "                          </ul>\n"
                + "                    </li>\n"
                + "                    <li class=\"has-dropdown\">"
                + "                     <a href=\"#\"><i class=\"fa fa-users\"></i> Employee</a>"
                + "                          <ul class=\"dropdown\">\n"
                + "                               <li><a href=\""+"../"+configuration.ADD_EMPLOYEE+"\">Add Employee</a></li>\n"
                + "                               <li><a href=\""+"../"+configuration.MANAGE_EMPLOYEE+"\">Manage Employee</a></li>\n"
                + "                          </ul>\n"
                + "                    </li>"
                + "                    <li class=\"has-dropdown\">"
                + "                       <a href=\"#\"><i class=\"fa fa-address-book\"></i> Attendence</a>"
                + "                          <ul class=\"dropdown\">\n"
                + "                               <li><a href=\""+"../"+configuration.Add_ATTENDENCE+"\">Add Attendence</a></li>\n"
                + "                               <li><a href=\""+"../"+configuration.MANAGE_ATTENDENCE+"\">Manage Attendence</a></li>\n"
                + "                          </ul>\n"
                + "                    </li>"
                + "                    <li class=\"has-dropdown\">"
                + "                        <a href=\"#\"><i class=\"fa fa-money\"></i> Issue Salaries</a>"
                + "                          <ul class=\"dropdown\">\n"
                + "                               <li><a href=\""+"../"+configuration.ISSUE_SALARY+"\">Issue Salary</a></li>\n"
                + "                               <li><a href=\""+"../"+configuration.MANAGE_SALARY+"\">Manage Salary</a></li>\n"
                + "                          </ul>\n"
                + "                    </li>"
                + "            </div>\n"
                + "            <div class=\"column-9\">\n"
                + "                <div class=\"main\">\n"
                + "                    <div class=\"heal\">\n"
                + "                        <p>" + title + "<p>\n"
                + "                    </div>";

        return content;
    }

    public static String footer() {
        String footer = "";
        footer = "</div>\n"
                + "            </div>"
                + "</section>\n"
                + "        \n"
                + "        <section class=\"row\">\n"
                + "            <div class=\"column-12 footer\">\n"
                + "                <p>Copyright &copy; 2020 &raquo; Salary Management</p>\n"
                + "            </div>\n"
                + "        </section>\n"
                + "    </main>\n"
                + "</body>\n"
                + "<script src=\"js/main.js\" type=\"text/javascript\"></script>"
                + "</html>";
        return footer;
    }

    public static String getPage(String title, String head,userModel um) {
        String str = "";
        str += header();
        str += topNav(head,um);
        str += mainNav(title);
        return str;
    }
}
