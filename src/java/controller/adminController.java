package controller;

import catalog.validation;
import config.configuration;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.Cookie;
import model.userModel;
import persistence.dbContext;

public class adminController {

    public void Login(userModel um) {
        if (this.isValid(um)) {
            if (this.isAuthentic(um)) {
                this.Authorise(um);
            }
        }
    }

    private boolean isValid(userModel um) {
        if (!um.getUsername().equals("") || !um.getPassword().equals("")) {
            if (!um.getUsername().equals("")) {
                if (!um.getPassword().equals("")) {
                    if (um.getUsername().length() >= 4 && um.getUsername().length() <= 10) {
                        if (um.getPassword().length() >= 8 && um.getPassword().length() <= 20) {
                            if (validation.validateString(um.getUsername(), "4,10")) {
                                if (validation.validatePassword(um.getPassword(), "8,20")) {
                                    return true;
                                } else {
                                    um.setMessage("Invalid Characters In Password!");
                                    return false;
                                }
                            } else {
                                um.setMessage("Invalid Characters In Username!");
                                return false;
                            }
                        } else {
                            um.setMessage("Minimum 8 Characters And Maximum 20 Characters Allowed In Password!");
                            return false;
                        }
                    } else {
                        um.setMessage("Minimum 4 Characters And Maximum 10 Characters Allowed In Username!");
                        return false;
                    }
                } else {
                    um.setMessage("Password Fields Is Empty!");
                    return false;
                }

            } else {
                um.setMessage("Username Fields Is Empty!");
                return false;
            }

        } else {
            um.setMessage("All Fields Are Empty!");
            return false;
        }

    }

    private boolean isAuthentic(userModel um) {
        String pass = validation.encryptSha512(validation.encryptMd5(validation.encryptSha512(validation.encryptMd5(um.getPassword()))));
        try {
            um.setSql("SELECT * FROM `admin` WHERE `Username`= '" + um.getUsername() + "' AND `Password`= '" + pass + "';");
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            if (um.getResultset().next()) {
                return true;
            } else {
                um.setMessage("Invalid Credentials!");
                return false;
            }
        } catch (SQLException ex) {
            um.setMessage(ex.getMessage());
            return false;
        }finally {
            dbContext.Close(dbContext.connect());
        }
    }

    private void Authorise(userModel um) {
        try {
            if (um.getRemember() != null) {
                Cookie cookie = new Cookie("ADMINCOOKIE", um.getUsername());
                cookie.setHttpOnly(true);
                cookie.setMaxAge(60 * 60 * 20 * 12);
                um.getResponse().addCookie(cookie);
            } else {
                um.getRequest().getSession().setAttribute("ADMINSESSION", um.getUsername());
            }
            um.getResponse().sendRedirect(configuration.DASHBOARDSURL);
        } catch (IOException ex) {
            um.setMessage(ex.getMessage());
        }
    }

    public void Save(userModel um) {
        if (this.isValidCompany(um)) {
            if (this.saveCompany(um)) {
                um.setMessage("success");
            }
        }
    }

    private boolean isValidCompany(userModel um) {
        if (!um.getCompany().equals("") || !um.getPhone().equals("") || !um.getUsername().equals("") || !um.getPassword().equals("") || um.getStatus() != (0) || !um.getAddress().equals("")) {
            if (!um.getCompany().equals("")) {
                if (!um.getPhone().equals("")) {
                    if (!um.getUsername().equals("")) {
                        if (!um.getPassword().equals("")) {
                            if (um.getStatus() != (0)) {
                                if (!um.getAddress().equals("")) {
                                    if (um.getCompany().length() >= 10 && um.getCompany().length() <= 30) {
                                        if (um.getPhone().length() >= 10 && um.getPhone().length() <= 16) {
                                            if (um.getUsername().length() >= 10 && um.getUsername().length() <= 20) {
                                                if (um.getPassword().length() >= 8 && um.getPassword().length() <= 15) {
                                                    if (um.getAddress().length() >= 10 && um.getAddress().length() <= 20) {
                                                        if (validation.validateString(um.getCompany(), "10,30")) {
                                                            if (validation.validatePhone(um.getPhone(), "10,16")) {
                                                                if (validation.validateString(um.getUsername(), "10,20")) {
                                                                    if (validation.validatePassword(um.getPassword(), "8,15")) {
                                                                        if (validation.validateQuali(um.getAddress(), "10,20")) {
                                                                            return true;
                                                                        } else {
                                                                            um.setMessage("Invalid Characters Address!");
                                                                            return false;
                                                                        }
                                                                    } else {
                                                                        um.setMessage("Invalid Characters Password!");
                                                                        return false;
                                                                    }
                                                                } else {
                                                                    um.setMessage("Invalid Characters Username!");
                                                                    return false;
                                                                }
                                                            } else {
                                                                um.setMessage("Invalid Characters Contact!");
                                                                return false;
                                                            }
                                                        } else {
                                                            um.setMessage("Invalid Characters Company Name!");
                                                            return false;
                                                        }
                                                    } else {
                                                        um.setMessage("Minimum 10 Characters And Maximum 20 Characters Allowed In Address!");
                                                        return false;
                                                    }
                                                } else {
                                                    um.setMessage("Minimum 8 Characters And Maximum 15 Characters Allowed In Password!");
                                                    return false;
                                                }
                                            } else {
                                                um.setMessage("Minimum 10 Characters And Maximum 20 Characters Allowed In Username!");
                                                return false;
                                            }
                                        } else {
                                            um.setMessage("Minimum 10 Characters And Maximum 16 Characters Allowed In Contact!");
                                            return false;
                                        }
                                    } else {
                                        um.setMessage("Minimum 10 Characters And Maximum 30 Characters Allowed In Company Name!");
                                        return false;
                                    }
                                } else {
                                    um.setMessage("Address Field Is Empty!");
                                    return false;
                                }
                            } else {
                                um.setMessage("Status Is Not Selected!");
                                return false;
                            }
                        } else {
                            um.setMessage("Password Field Is Empty!");
                            return false;
                        }
                    } else {
                        um.setMessage("Username Field Is Empty!");
                        return false;
                    }
                } else {
                    um.setMessage("Contact Field Is Empty!");
                    return false;
                }
            } else {
                um.setMessage("Company Name Fields Is Empty!");
                return false;
            }
        } else {
            um.setMessage("All Fields Are Empty!");
            return false;
        }
    }

    private boolean saveCompany(userModel um) {
        String pass = validation.encryptSha512(validation.encryptMd5(validation.encryptSha512(validation.encryptMd5(um.getPassword()))));
        um.setSql("INSERT INTO `company` VALUES (NULL,'" + um.getCompany() + "','" + um.getPhone() + "','" + um.getUsername() + "','" + pass + "','" + um.getStatus() + "','" + um.getAddress() + "',CURRENT_TIMESTAMP);");
        System.out.println(um.getSql());
        try {
            um.setStatement(dbContext.connect().createStatement());
            int result = um.getStatement().executeUpdate(um.getSql());
            return result != 0;
        } catch (SQLException ex) {
            um.setMessage("Something Went Wrong!");
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public String allCompanies(userModel um){
            String tr = "";
            int count = 0;
        um.setSql("SELECT * FROM `company` WHERE `cname` LIKE '%" + um.getSearch() + "%' ORDER BY `id` " + um.getOrderBy() + " LIMIT 0," + um.getLimit() + " ");	
         try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            while (um.getResultset().next()) {
                count++;
                tr += "<tr>";
                tr += "<th>" + count + "</th>";
                tr += "<td>" + um.getResultset().getString("cname").toUpperCase() + "</td>";
                tr += "<td>" + um.getResultset().getString("username").toUpperCase() + "</td>";
                tr += "<td>" + um.getResultset().getString("phone").toUpperCase() + "</td>";
                tr += "<td>" + this.getStatus(um.getResultset().getInt("Status")) + "</td>";
                tr += "<td><i class='edit'>Edit</i> ||"
                        + "<i class='Delete'>Delete</i></td>";
                tr += "</tr>";
            }
            
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }finally {
            dbContext.Close(dbContext.connect());
        }
        return tr;
    }

    public void Enquiry(userModel um) {
        if (this.isvalid(um)) {
            if (this.saveEnquiry(um)) {
                um.setMessage("success");
            }
        }
    }

    private boolean isvalid(userModel um) {
        if (!um.getName().equals("") || !um.getPhone().equals("") || !um.getEnquiry().equals("")) {
            if (!um.getName().equals("")) {
                if (!um.getPhone().equals("")) {
                    if (!um.getEnquiry().equals("")) {
                        if (validation.validateString(um.getName(), "4,15")) {
                            if (um.getPhone().length() >= 10 && um.getPhone().length() <= 16) {
                                if (validation.validateString(um.getEnquiry(), "10,30")) {
                                    return true;
                                } else {
                                    um.setMessage("Invalid Characters Enquiry!");
                                    return false;
                                }
                            } else {
                                um.setMessage("Invalid Characters Contact!");
                                return false;
                            }
                        } else {
                            um.setMessage("Invalid Characters In Name!");
                            return false;
                        }
                    } else {
                        um.setMessage("Enquiry Field Is Empty!");
                        return false;
                    }
                } else {
                    um.setMessage("Contact Field Is Empty!");
                    return false;
                }
            } else {
                um.setMessage("Username Field Is Empty!");
                return false;
            }
        } else {
            um.setMessage("All Fields Are Empty!");
            return false;
        }
    }

    private boolean saveEnquiry(userModel um) {
        um.setSql("INSERT INTO `enquiry` VALUES (NULL,'" + um.getName() + "','" + um.getPhone() + "','" + um.getEnquiry() + "',CURRENT_TIMESTAMP);");
        try {
            um.setStatement(dbContext.connect().createStatement());
            int result = um.getStatement().executeUpdate(um.getSql());
            return result != 0;
        } catch (SQLException ex) {
            um.setMessage("Something Went Wrong!");
            System.out.println(ex.getMessage());
            return false;
        } finally {
            dbContext.Close(dbContext.connect());
        }
    }
    
    public String allEnquiry(userModel um){
            String tr = "";
            int count = 0; 
            
           um.setSql("SELECT * FROM `enquiry` WHERE `name` LIKE '%" + um.getSearch() + "%' ORDER BY `id` " + um.getOrderBy() + " LIMIT 0," + um.getLimit() + "");
         
           try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            while (um.getResultset().next()) {
                count++;
                tr += "<tr>";
                tr += "<th>" + count + "</th>";
                tr += "<td>" + um.getResultset().getString("name").toUpperCase() + "</td>";
                tr += "<td>" + um.getResultset().getString("phone").toUpperCase() + "</td>";
                tr += "<td>" + um.getResultset().getString("about").toUpperCase() + "</td>";
                tr += "<td><i class='delete'>Delete</i>";
                tr += "</tr>";
            }
            
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }finally {
            dbContext.Close(dbContext.connect());
        }
        return tr;
    }
    
    public static int getEnquiryRows(userModel um){
        int rows= 0;
        um.setSql("SELECT count(*) FROM `enquiry`");
        try{
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql())); 
            while(um.getResultset().next()){
               rows= um.getResultset().getInt("count(*)");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage()); 
        }
        return rows;
    }
    
    public static int getCompanyRows(userModel um){
        int rows= 0;
        um.setSql("SELECT count(*) FROM `company`");
        try{
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql())); 
            while(um.getResultset().next()){
               rows= um.getResultset().getInt("count(*)");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage()); 
        }
        return rows;
    }
    
    private String getStatus(int val) {
        if (val == 1) {
            return "AA";
        } else if (val == 2) {
            return "ANA";
        } else if (val == 3) {
            return "AB";
        }else if (val == 4){
            return "TL";
        }else{
          return "";  
        }
    }
}
