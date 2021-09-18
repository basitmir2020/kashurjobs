package essentials;

import javax.servlet.http.Cookie;

public class securityEssentials {
  public static String getMessage(String code,model.userModel um){
      String msg="";
      switch(code){
            case "101":
              msg="<p class='alert alert-danger'>You Are Not Authorized!</p>";
              break;
            case "102":
              Cookie[] cookies = um.getRequest().getCookies();
              if(um.getRequest().getSession().getAttribute("ADMINSESSION")!=null){
              um.getRequest().getSession().removeAttribute("ADMINSESSION");
              }else if(cookies !=null){
                 for(Cookie c: cookies){
                     if(c.getName().equalsIgnoreCase("ADMINCOOKIE")){
                         c.setMaxAge(0);
                         um.getResponse().addCookie(c);
                     }
                 }
              }
              msg="<p class='alert alert-danger'>Logged Out Successfully!</p>";
              break;
      }
      return msg;
  }  
}
