package essentials;

import config.configuration;

public class adminEssentials {

    private static String header(String title) {
        String str = "";
        str += "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <title>" +configuration.ADMINTITLE + " &raquo; " + title + " </title>\n"
                + "         <link href=" +"../"+ configuration.STYLES + "default.css rel=\"stylesheet\" type=\"text/css\"/>\n"
                + "        <script src=" +"../"+  configuration.JQUERY + " type=\"text/javascript\"></script>\n"
                + "        <link href=" +"../"+  configuration.FONTS + " rel=\"stylesheet\" type=\"text/css\"/>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <main class=\"container\">";
        return str;
    }

    private static String topNav(String title) {
        String topNav = "";
        topNav = " <section class=\"row adminTopNav\">\n"
                + "                <div class=\"column-3\">\n"
                + "                    <!--<img src=\"\">-->\n"
                + "                    <h1>"+title+"<span>Pannel</span></h1>\n"
                + "                </div>\n"
                + "                <div class=\"column-offset-4 column-5\">\n"
                + "                    <ul>\n"
                + "                        <li><a href=\""+"../"+ configuration.LOGOUTURL+"?stat=102\"><i class=\"fa fa-sign-out\"></i> Logout</a></li>\n"
                + "                        <li><a href=\"#\"><i class=\"fa fa-gear\"></i> Setting</a></li>\n"
                + "                        <li><a href=\"#\"><i class=\"fa fa-key\"></i> Change Password</a></li>\n"
                + "                    </ul>\n"
                + "                </div>\n"
                + "            </section>";
        return topNav;
    }

    private static String mainNav(String title) {
        String content = "";
        content = "<section class=\"row\">\n"
                + "                    <div class=\"column-3 adminSideNav\">\n"
                + "                        <ul>\n"
                + "                            <li>\n"
                + "                                <a href=\"" +"../"+ configuration.DASHBOARD + "\">\n"
                + "                                    <i class=\"fa fa-dashboard\"></i> \n"
                + "                                    Dashboard \n"
                + "                                </a>\n"
                + "                            </li>\n"
                + "                            <li>\n"
                + "                                <a href=\"" +"../"+  configuration.ENQUIRY +  "\">\n"
                + "                                    <i class=\"fa fa-link\"></i> \n"
                + "                                      ENQUIRY &raquo; \n"
                + "                                </a>\n"
                + "                            </li>\n"
                + "                            <li>\n"
                + "                                <a href=\"" +"../"+  configuration.ADDCOMPANY+ "\">\n"
                + "                                    <i class=\"fa fa-link\"></i> \n"
                + "                                      ADD COMPANY &raquo;\n"
                + "                                </a>\n"
                + "                            </li>\n"
                + "                            <li>\n"
                + "                                <a href=\"" + "../"+ configuration.MANAGECOMPANY + "\">\n"
                + "                                    <i class=\"fa fa-link\"></i> \n"
                + "                                      MANAGE COMPANY &raquo;\n"
                + "                                </a>\n"
                + "                            </li>\n"
                + "                        </ul>\n"
                + "                    </div>\n"
                + "                    <div class=\"column-9\">\n"
                + "                        <div class=\"mainContent\">\n"
                + "                            <div class=\"heading\">\n"
                + "                                " + title + "\n"
                + "                            </div>";
        return content;
    }

    public static String footer() {
        String footer = "";
        footer = "</div>\n"
                + "                    </div>\n"
                + "                </section>\n"
                + "            <section class=\"row\">\n"
                + "                <div class=\"column-12 copyright \">\n"
                + "                    <p>Copyright &copy; 2020 &raquo; Salary Management</p>\n"
                + "                </div> \n"
                + "            </section>\n"
                + "        </main>\n"
                + " <script src=" + configuration.SCRIPTS+ "accounts.js type=\"text/javascript\"></script>\n"
                + "    </body>\n"
                + "</html>";
        return footer;
    }

    public static String getPage(String title,String head) {
        String str = "";
        str += header(title);
        str += topNav(head);
        str += mainNav(title);
        return str;
    }
}
