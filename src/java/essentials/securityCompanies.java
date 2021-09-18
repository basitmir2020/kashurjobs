package essentials;

public class securityCompanies {

    public static String getMessage(String code, model.userModel um) {
        String msg = "";
        switch (code) {
            case "101":
                msg = "<p class='alert alert-danger'>You Are Not Authorized!</p>";
                break;
            case "102":
                if (um.getRequest().getSession().getAttribute("COMPANYSESSION") != null) {
                    um.getRequest().getSession().removeAttribute("COMPANYSESSION");
                }
                msg = "<p class='alert alert-danger'>Logged Out Successfully!</p>";
                break;
            }
        return msg;
    }
}
