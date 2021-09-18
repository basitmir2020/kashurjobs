package controller;

import catalog.dataBase;
import catalog.validation;
import java.sql.SQLException;
import java.util.Arrays;
import model.userModel;
import persistence.dbContext;

public class companyController {

    public void Login(userModel um) {
        if (this.isValid(um)) {
            if (this.isAuthentic(um)) {
                if (this.checkUser(um)) {
                    this.Authorise(um);
                }
            }
        }
    }

    private boolean isValid(userModel um) {
        if (!um.getCompany().equals("") || !um.getPassword().equals("")) {
            if (!um.getCompany().equals("")) {
                if (!um.getPassword().equals("")) {
                    if (validation.validateString(um.getCompany(), "4,20")) {
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
            um.setSql("SELECT * FROM `company` WHERE `Username`= '" + um.getCompany() + "' AND `Password`= '" + pass + "';");

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
        } finally {
            dbContext.Close(dbContext.connect());
        }
    }

    private boolean checkUser(userModel um) {
        boolean stat = false;
        String pass = validation.encryptSha512(validation.encryptMd5(validation.encryptSha512(validation.encryptMd5(um.getPassword()))));
        um.setSql("SELECT * FROM `company` WHERE `Username`='" + um.getCompany() + "' AND `Password`='" + pass + "'");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            while (um.getResultset().next()) {
                int status = Integer.parseInt(um.getResultset().getString("status"));
                switch (status) {
                    case 1:
                        stat = true;
                        break;
                    case 2:
                        um.setMessage("Account Not Activated Yet!");
                        stat = false;
                        break;
                    case 3:
                        um.setMessage("Account Blocked!");
                        stat = false;
                        break;
                    case 4:
                        um.setMessage("Temporary Locked");
                        stat = false;
                        break;
                }
            }
            return stat;
        } catch (SQLException ex) {
            um.setMessage(ex.getMessage());
            return false;
        }
    }

    private void Authorise(userModel um) {
        um.getRequest().getSession().setAttribute("COMPANYSESSION", um.getCompany());
        um.setMessage("success");
    }

    public String getCompanies(String user, userModel um) {
        String dat = "";
        um.setSql("SELECT * FROM `company` WHERE `username`='" + user + "'");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            while (um.getResultset().next()) {
                dat += um.getResultset().getString("username").toUpperCase();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dat;
    }

    public void save(userModel um) {
        if (this.isValidation(um)) {
            if (this.exist(um)) {
                if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
                    if (this.saveUser(um)) {
                        um.setMessage("success");
                    }
                }
            }
        }
    }

    private boolean isValidation(userModel um) {
        if (!um.getFname().equals("") || !um.getLname().equals("") || !um.getUsername().equals("") || !um.getPassword().equals("") || !um.getMoblie().equals("") || !um.getPhone().equals("") || !um.getEmail().equals("") || !um.getAddress().equals("") || um.getGender() != (0)) {
            if (!um.getFname().equals("")) {
                if (!um.getUsername().equals("")) {
                    if (!um.getPassword().equals("")) {
                        if (!um.getMoblie().equals("")) {
                            if (!um.getEmail().equals("")) {
                                if (!um.getAddress().equals("")) {
                                    if (um.getGender() != (0)) {
                                        if (um.getFname().length() >= 3 && um.getFname().length() <= 20) {
                                            if (um.getLname().length() >= 3 && um.getLname().length() <= 20) {
                                                if (um.getUsername().length() >= 8 && um.getUsername().length() <= 20) {
                                                    if (um.getPassword().length() >= 5 && um.getPassword().length() <= 20) {
                                                        if (um.getMoblie().length() >= 10 && um.getMoblie().length() <= 16) {
                                                            if (um.getPhone().length() >= 10 && um.getPhone().length() <= 16) {
                                                                if (um.getEmail().length() >= 10 && um.getEmail().length() <= 40) {
                                                                    if (um.getAddress().length() >= 5 && um.getAddress().length() <= 40) {
                                                                        if (validation.validateString(um.getFname(), "3,20")) {
                                                                            if (validation.validateString(um.getLname(), "3,20")) {
                                                                                if (validation.validateString(um.getUsername(), "8,20")) {
                                                                                    if (validation.validatePassword(um.getPassword(), "8,20")) {
                                                                                        if (validation.validatePhone(um.getMoblie(), "10,16")) {
                                                                                            if (validation.validatePhone(um.getPhone(), "10,16")) {
                                                                                                if (validation.validateEmail(um.getEmail(), "10,40")) {
                                                                                                    if (validation.validateString(um.getAddress(), "5,40")) {
                                                                                                        return true;
                                                                                                    } else {
                                                                                                        um.setMessage("Invalid Characters In Address!");
                                                                                                        return false;
                                                                                                    }
                                                                                                } else {
                                                                                                    um.setMessage("Invalid Characters In Email!");
                                                                                                    return false;
                                                                                                }
                                                                                            } else {
                                                                                                um.setMessage("Invalid Characters In Mobile2!");
                                                                                                return false;
                                                                                            }
                                                                                        } else {
                                                                                            um.setMessage("Invalid Characters In Mobile1!");
                                                                                            return false;
                                                                                        }
                                                                                    } else {
                                                                                        um.setMessage("Invalid Characters In Password!");
                                                                                        return false;
                                                                                    }
                                                                                } else {
                                                                                    um.setMessage("Invalid Characters In Username!");
                                                                                    return false;
                                                                                }
                                                                            } else {
                                                                                um.setMessage("Invalid Characters In Lname!");
                                                                                return false;
                                                                            }
                                                                        } else {
                                                                            um.setMessage("Invalid Characters In Fname!");
                                                                            return false;
                                                                        }
                                                                    } else {
                                                                        um.setMessage("Minimum 5 And Maximum 40 Characters Allowed In Address!");
                                                                        return false;
                                                                    }
                                                                } else {
                                                                    um.setMessage("Minimum 10 And Maximum 40 Characters Allowed In Email!");
                                                                    return false;
                                                                }
                                                            } else {
                                                                um.setMessage("Minimum 10 And Maximum 16 Characters Allowed In Mobile2!");
                                                                return false;
                                                            }
                                                        } else {
                                                            um.setMessage("Minimum 10 And Maximum 16 Characters Allowed In Mobile1!");
                                                            return false;
                                                        }
                                                    } else {
                                                        um.setMessage("Minimum 8 And Maximum 20 Characters Allowed In Password!");
                                                        return false;
                                                    }
                                                } else {
                                                    um.setMessage("Minimum 8 And Maximum 20 Characters Allowed In Username!");
                                                    return false;
                                                }
                                            } else {
                                                um.setMessage("Minimum 3 And Maximum 20 Characters Allowed In Lname!");
                                                return false;
                                            }
                                        } else {
                                            um.setMessage("Minimum 3 And Maximum 20 Characters Allowed In Fname!");
                                            return false;
                                        }
                                    } else {
                                        um.setMessage("Gender Field Is Empty!");
                                        return false;
                                    }
                                } else {
                                    um.setMessage("Address Field Is Empty!");
                                    return false;
                                }
                            } else {
                                um.setMessage("Email Field Is Empty!");
                                return false;
                            }
                        } else {
                            um.setMessage("Mobile1 Field Is Empty!");
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
                um.setMessage("Fname Field Is Empty!");
                return false;
            }
        } else {
            um.setMessage("All Fields Are Empty!");
            return false;
        }
    }

    private boolean exist(userModel um) {
        if (dataBase.CheckUser(um, "SELECT * FROM `users` WHERE username='" + um.getUsername() + "';")) {
            return true;
        } else {
            um.setMessage("User Already Taken!");
            return false;
        }
    }

    private boolean id(String user, userModel um) {
        if (dataBase.id(um, "SELECT `id` FROM `company` WHERE `username`='" + user + "';")) {
            return true;
        } else {
            um.setMessage("Id Not Generated!");
            return false;
        }
    }

    private boolean saveUser(userModel um) {
        String pass = validation.encryptSha512(validation.encryptMd5(validation.encryptSha512(validation.encryptMd5(um.getPassword()))));
        if (dataBase.saveDb(um, "INSERT INTO `users` VALUES(NULL,'" + um.getFname() + "','" + um.getLname() + "','" + um.getUsername() + "','" + pass + "','" + um.getMoblie() + "','" + um.getPhone() + "','" + um.getEmail() + "','" + um.getAddress() + "','" + um.getGender() + "','" + um.getCompanyId() + "',CURRENT_TIMESTAMP);")) {
            return true;
        } else {
            um.setMessage("Something Went Wrong!");
            return false;
        }
    }

    public String loadAllUsers(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.getUse(um);
        }
        return value;
    }

    public String getUse(userModel um) {
        String tr = "";
        int count = 0;
        um.setSql("SELECT * FROM `users` WHERE `companyId`='" + um.getCompanyId() + "' AND `fname` LIKE '%" + um.getSearch() + "%'  ORDER BY `id` " + um.getOrderBy() + " LIMIT 0," + um.getLimit() + " ");
        System.out.println(um.getSql() + "j");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            while (um.getResultset().next()) {
                String fullName = um.getResultset().getString("fname") + " " + um.getResultset().getString("lname");
                count++;
                tr += "<tr>";
                tr += "<th>" + count + "</th>";
                tr += "<td>" + fullName.toUpperCase() + "</td>";
                tr += "<td>" + um.getResultset().getString("username").toUpperCase() + "</td>";
                tr += "<td>" + um.getResultset().getString("mobile1").toUpperCase() + "</td>";
                tr += "<td>" + um.getResultset().getString("email").toUpperCase() + "</td>";
                tr += "<td>" + um.getResultset().getString("address").toUpperCase() + "</td>";
                tr += "<td>" + this.getGender(um.getResultset().getInt("gender")) + "</td>";
                tr += "<td><i class='fa fa-edit'></i> ||"
                        + " <i class='fa fa-trash-o'></i></td>";
                tr += "</tr>";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            dbContext.Close(dbContext.connect());
        }
        return tr;
    }

    private String getGender(int val) {
        if (val == 1) {
            return "MALE";
        } else {
            return "FEMALE";
        }
    }

    public void saveRole(userModel um) {
        if (this.valid(um)) {
            if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
                if (this.notexist(um)) {
                    if (this.role(um)) {
                        um.setMessage("success");
                    }
                }
            }
        }
    }

    private boolean valid(userModel um) {
        if (!um.getRole().equals("")) {
            if (um.getRole().length() >= 5 && um.getRole().length() <= 50) {
                if (validation.validateString(um.getRole(), "5,50")) {
                    return true;
                } else {
                    um.setMessage("Invalid Characters In Role!");
                    return false;
                }
            } else {
                um.setMessage("Minimum 5 And Maximum 50 Characters Allowed!");
                return false;
            }
        } else {
            um.setMessage("Role Field Is Empty!");
            return false;
        }
    }

    private boolean notexist(userModel um) {
        if (dataBase.CheckUser(um, "SELECT * FROM `role` WHERE `companyId` = '" + um.getCompanyId() + "' AND  name='" + um.getRole() + "';")) {
            return true;
        } else {
            um.setMessage("Role Already Created!");
            return false;
        }
    }

    private boolean role(userModel um) {
        if (dataBase.saveDb(um, "INSERT INTO `role` VALUES(NULL,'" + um.getRole() + "','" + um.getCompanyId() + "' ,CURRENT_TIMESTAMP);")) {
            return true;
        } else {
            um.setMessage("Something Went Wrong!");
            return false;
        }
    }

    public String loadAllRole(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.getRole(um);
        }
        return value;
    }

    public String getRole(userModel um) {
        String tr = "";
        int count = 0;
        um.setSql("SELECT * FROM `role` WHERE `companyId` = '" + um.getCompanyId() + "' AND `name` LIKE '%" + um.getSearch() + "%' ORDER BY `id` " + um.getOrderBy() + " LIMIT 0," + um.getLimit() + " ");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            while (um.getResultset().next()) {
                count++;
                tr += "<tr>";
                tr += "<th>" + count + "</th>";
                tr += "<td>" + um.getResultset().getString("name").toUpperCase() + "</td>";
                tr += "<td><i class='fa fa-edit'></i> ||"
                        + " <i class='fa fa-trash-o'></i></td>";
                tr += "</tr>";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            dbContext.Close(dbContext.connect());
        }
        return tr;
    }

    public void createSalary(userModel um) {
        if (this.validSalary(um)) {
            if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
                if (this.salaryExist(um)) {
                    if (this.saveSalary(um)) {
                        um.setMessage("success");
                    }
                }
            }
        }
    }

    private boolean validSalary(userModel um) {
        if (!um.getName().equals("") || !um.getSalaryFrom().equals("") || !um.getSalaryTo().equals("") || um.getId() != (0) || !um.getTa().equals("") || !um.getDa().equals("") || !um.getPf().equals("") || !um.getOther().equals("") || !um.getDayDec().equals("") || !um.getMinDec().equals("") || !um.getMaxDec().equals("") || !um.getLeaves().equals("")) {
            if (!um.getName().equals("")) {
                if (!um.getSalaryFrom().equals("")) {
                    if (!um.getSalaryTo().equals("")) {
                        if (um.getId() != (0)) {
                            if (!um.getTa().equals("")) {
                                if (!um.getDa().equals("")) {
                                    if (!um.getPf().equals("")) {
                                        if (!um.getOther().equals("")) {
                                            if (!um.getDayDec().equals("")) {
                                                if (!um.getMinDec().equals("")) {
                                                    if (!um.getMaxDec().equals("")) {
                                                        if (!um.getLeaves().equals("")) {
                                                            if (um.getName().length() >= 5 && um.getName().length() <= 100) {
                                                                if (um.getSalaryFrom().length() >= 4 && um.getSalaryFrom().length() <= 8) {
                                                                    if (um.getSalaryTo().length() >= 4 && um.getSalaryTo().length() <= 8) {
                                                                        if (um.getTa().length() >= 3 && um.getTa().length() <= 8) {
                                                                            if (um.getDa().length() >= 3 && um.getDa().length() <= 8) {
                                                                                if (um.getPf().length() >= 3 && um.getPf().length() <= 8) {
                                                                                    if (um.getOther().length() >= 3 && um.getOther().length() <= 8) {
                                                                                        if (um.getDayDec().length() >= 3 && um.getDayDec().length() <= 8) {
                                                                                            if (um.getMinDec().length() >= 3 && um.getMinDec().length() <= 8) {
                                                                                                if (um.getMaxDec().length() >= 4 && um.getMaxDec().length() <= 5) {
                                                                                                    if (um.getLeaves().length() >= 1 && um.getLeaves().length() <= 1) {
                                                                                                        if (validation.validateSalary(um.getSalaryFrom(), "3,8")) {
                                                                                                            if (validation.validateSalary(um.getSalaryTo(), "3,8")) {
                                                                                                                if (validation.validateSalary(um.getTa(), "3,8")) {
                                                                                                                    if (validation.validateSalary(um.getDa(), "3,8")) {
                                                                                                                        if (validation.validateSalary(um.getPf(), "3,8")) {
                                                                                                                            if (validation.validateSalary(um.getOther(), "3,8")) {
                                                                                                                                if (validation.validateSalary(um.getDayDec(), "3,8")) {
                                                                                                                                    if (validation.validateSalary(um.getMinDec(), "3,8")) {
                                                                                                                                        if (validation.validateSalary(um.getMaxDec(), "4,5")) {
                                                                                                                                            if (validation.validatePhone(um.getLeaves(), "1,1")) {
                                                                                                                                                return true;
                                                                                                                                            } else {
                                                                                                                                                um.setMessage("Invalid Caracters In  Leaves Allowed Field!");
                                                                                                                                                return false;
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            um.setMessage("Invalid Caracters In  Max Time Deduction Field!");
                                                                                                                                            return false;
                                                                                                                                        }

                                                                                                                                    } else {
                                                                                                                                        um.setMessage("Invalid Caracters In  Minute Deduction Field!");
                                                                                                                                        return false;
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    um.setMessage("Invalid Caracters In Day Deduction Field!");
                                                                                                                                    return false;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                um.setMessage("Invalid Caracters In Other Field!");
                                                                                                                                return false;
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            um.setMessage("Invalid Caracters In PF Field!");
                                                                                                                            return false;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        um.setMessage("Invalid Caracters In DA Field!");
                                                                                                                        return false;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    um.setMessage("Invalid Caracters In TA Field!");
                                                                                                                    return false;
                                                                                                                }
                                                                                                            } else {
                                                                                                                um.setMessage("Invalid Caracters In Salary To Field!");
                                                                                                                return false;
                                                                                                            }
                                                                                                        } else {
                                                                                                            um.setMessage("Invalid Caracters In Salary From Field!");
                                                                                                            return false;
                                                                                                        }
                                                                                                    } else {
                                                                                                        um.setMessage("Invalid Leaves Entered In Leaves Allowed Field!");
                                                                                                        return false;
                                                                                                    }
                                                                                                } else {
                                                                                                    um.setMessage("Invalid Rupees Entered In Time Deduction Field!");
                                                                                                    return false;
                                                                                                }
                                                                                            } else {
                                                                                                um.setMessage("Invalid Rupees Entered In Minute Deduction Field!");
                                                                                                return false;
                                                                                            }
                                                                                        } else {
                                                                                            um.setMessage("Invalid Rupees Entered In Day Deduction Field!");
                                                                                            return false;
                                                                                        }
                                                                                    } else {
                                                                                        um.setMessage("Invalid Salary Entered In Salary Other Field!");
                                                                                        return false;
                                                                                    }
                                                                                } else {
                                                                                    um.setMessage("Invalid Salary Entered In Salary PF Field!");
                                                                                    return false;
                                                                                }
                                                                            } else {
                                                                                um.setMessage("Invalid Salary Entered In Salary DA Field!");
                                                                                return false;
                                                                            }
                                                                        } else {
                                                                            um.setMessage("Invalid Salary Entered In Salary TA Field!");
                                                                            return false;
                                                                        }
                                                                    } else {
                                                                        um.setMessage("Invalid Salary Entered In Salary To Field!");
                                                                        return false;
                                                                    }
                                                                } else {
                                                                    um.setMessage("Invalid Salary Entered In Salary From Field!");
                                                                    return false;
                                                                }
                                                            } else {
                                                                um.setMessage("Minimum 5 And Maximum 100 Characters Allowed In Salary Name!");
                                                                return false;
                                                            }
                                                        } else {
                                                            um.setMessage("Leaves Allowed Field Is Empty!");
                                                            return false;
                                                        }
                                                    } else {
                                                        um.setMessage("Max Deduction Time Field Is Empty!");
                                                        return false;
                                                    }
                                                } else {
                                                    um.setMessage("Minute Deduction Field Is Empty!");
                                                    return false;
                                                }
                                            } else {
                                                um.setMessage("Day Deduction Field Is Empty!");
                                                return false;
                                            }
                                        } else {
                                            um.setMessage("Other Field Is Empty!");
                                            return false;
                                        }
                                    } else {
                                        um.setMessage("PF Field Is Empty!");
                                        return false;
                                    }
                                } else {
                                    um.setMessage("DA Field Is Empty!");
                                    return false;
                                }
                            } else {
                                um.setMessage("TA Field Is Empty!");
                                return false;
                            }
                        } else {
                            um.setMessage("Select Created By!");
                            return false;
                        }
                    } else {
                        um.setMessage("Salary To Field Is Empty!");
                        return false;
                    }
                } else {
                    um.setMessage("Salary From Field Is Empty!");
                    return false;
                }
            } else {
                um.setMessage("Salary Name Field Is Empty!");
                return false;
            }
        } else {
            um.setMessage("All Fields Are Empty!");
            return false;
        }
    }

    private boolean salaryExist(userModel um) {
        if (dataBase.CheckUser(um, "SELECT * FROM `salaries` WHERE `companiesId` = '" + um.getCompanyId() + "' AND name='" + um.getName() + "';")) {
            return true;
        } else {
            um.setMessage("Salary Already Created!");

            return false;
        }
    }

    private boolean saveSalary(userModel um) {
        if (dataBase.saveDb(um, "INSERT INTO `salaries` VALUES(NULL,'" + um.getName() + "','" + um.getSalaryFrom() + "','" + um.getSalaryTo() + "','" + um.getId() + "','" + um.getTa() + "','" + um.getDa() + "','" + um.getPf() + "','" + um.getOther() + "','" + um.getDayDec() + "','" + um.getMinDec() + "','" + um.getMaxDec() + "','" + um.getLeaves() + "','" + um.getCompanyId() + "' ,CURRENT_TIMESTAMP);")) {
            return true;
        } else {
            um.setMessage("Something Went Wrong!");
            return false;
        }
    }

    public String loadAllSalaries(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.getSalaries(um);
        }
        return value;
    }

    public String getSalaries(userModel um) {
        String tr = "";
        int count = 0;
        um.setSql("SELECT * FROM `salaries` WHERE `companiesId` = '" + um.getCompanyId() + "' AND `name` LIKE '%" + um.getSearch() + "%' ORDER BY `id` " + um.getOrderBy() + " LIMIT 0," + um.getLimit() + " ");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            while (um.getResultset().next()) {
                count++;
                tr += "<tr>";
                tr += "<th>" + count + "</th>";
                tr += "<td>" + um.getResultset().getString("name").toUpperCase() + "</td>";
                tr += "<td>" + um.getResultset().getFloat("salaryFrom") + "</td>";
                tr += "<td>" + um.getResultset().getFloat("salaryTo") + "</td>";
                tr += "<td>" + um.getResultset().getInt("createdBy") + "</td>";
                tr += "<td>" + um.getResultset().getInt("leavesAllowed") + "</td>";
                tr += "<td><i class='fa fa-edit'></i> ||"
                        + " <i class='fa fa-trash-o'></i></td>";
                tr += "</tr>";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            dbContext.Close(dbContext.connect());
        }
        return tr;
    }

    public void saveWeekdays(userModel um) {
        if (this.validWeekdays(um)) {
            if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
                if (this.weekExist(um)) {
                    if (this.saveweek(um)) {
                        um.setMessage("success");
                    }
                }
            }
        }
    }

    private boolean validWeekdays(userModel um) {
        if (!um.getWeekdays().equals("") || um.getId() != (0)) {
            if (!um.getWeekdays().equals("")) {
                if (um.getId() != (0)) {
                    if (um.getWeekdays().length() >= 5 && um.getWeekdays().length() <= 70) {
                        if (validation.validateWeek(um.getWeekdays(), "5,70")) {
                            return true;
                        } else {
                            um.setMessage("Invalid Characters In Weekdays Name!");
                            return false;
                        }
                    } else {
                        um.setMessage("Minimum 5 And Maximum 70 Characters Allowed In Weekdays Name!");
                        return false;
                    }
                } else {
                    um.setMessage("Select Created By!");
                    return false;
                }
            } else {
                um.setMessage("Weekday Field Is Empty!");
                return false;
            }
        } else {
            um.setMessage("All Fields Are Empty!");
            return false;
        }
    }

    private boolean weekExist(userModel um) {
        if (dataBase.CheckUser(um, "SELECT * FROM `weekdays` WHERE `companiesId` = '" + um.getCompanyId() + "' AND name = '" + um.getWeekdays() + "';")) {
            return true;
        } else {
            um.setMessage("Weekdays Already Exist");
            return false;
        }
    }

    private boolean saveweek(userModel um) {
        if (dataBase.saveDb(um, "INSERT INTO `weekdays` VALUES(NULL,'" + um.getWeekdays() + "','" + um.getId() + "','" + um.getCompanyId() + "',CURRENT_TIMESTAMP);")) {
            return true;
        } else {
            um.setMessage("Some Thing Went Wrong!");
            return false;
        }
    }

    public String loadWeekdays(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.loadAllWeekdays(um);
        }
        return value;
    }

    private String loadAllWeekdays(userModel um) {
        String tr = "";
        int count = 0;
        um.setSql("SELECT * FROM `weekdays` WHERE `companiesId` = '" + um.getCompanyId() + "' AND `name` LIKE '%" + um.getSearch() + "%' ORDER BY `id` " + um.getOrderBy() + " LIMIT 0," + um.getLimit() + "  ");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            while (um.getResultset().next()) {
                count++;
                tr += "<tr>";
                tr += "<th>" + count + "</th>";
                tr += "<td>" + um.getResultset().getString("name").toUpperCase() + "</td>";
                tr += "<td><i class='fa fa-edit'></i> ||"
                        + " <i class='fa fa-trash-o'></i></td>";
                tr += "</tr>";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            dbContext.Close(dbContext.connect());
        }
        return tr;
    }

    public String getweekDays(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.getdays(um);
        }
        return value;
    }

    protected String getdays(userModel um) {
        String option = "";
        um.setSql("SELECT * FROM `weekdays` WHERE companiesId = '" + um.getCompanyId() + "'");
        System.out.println(um.getSql());
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));

            while (um.getResultset().next()) {
                String days = um.getResultset().getString("name");
                String[] day = days.split(",");
                option += "<option  value='";
                option += um.getResultset().getInt("id");
                option += "'>";
                option += Arrays.toString(day);
                option += "</option>";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return option;
    }

    public String getUser(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.AllUser(um);
        }
        return value;
    }

    public String AllUser(userModel um) {
        String option = "";
        um.setSql("SELECT * FROM `users` WHERE `companyId` = '" + um.getCompanyId() + "';");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));

            while (um.getResultset().next()) {
                String fullName = um.getResultset().getString("fname") + " " + um.getResultset().getString("lname");
                option += "<option  value='";
                option += um.getResultset().getInt("id");
                option += "'>";
                option += fullName.toUpperCase();
                option += "</option>";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return option;
    }

    public void workSchedule(userModel um) {
        if (this.isValidSchedule(um)) {
            if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
                if (this.existSchedule(um)) {
                    if (this.saveSchedule(um)) {
                        um.setMessage("success");
                    }
                }
            }
        }
    }

    private boolean isValidSchedule(userModel um) {
        System.out.println(um.getSignIn());
        if (!um.getName().equals("") || !um.getSchFrom().equals("") || !um.getSchTo().equals("") || um.getId() != (0) || um.getSignIn() != null || !um.getSignOut().equals("") || um.getCreate() != (0)) {
            if (!um.getName().equals("")) {
                if (!um.getSchFrom().equals("")) {
                    if (!um.getSchTo().equals("")) {
                        if (um.getId() != (0)) {
                            if (!um.getSignIn().equals("")) {
                                if (!um.getSignOut().equals("")) {
                                    if (um.getCreate() != (0)) {
                                        if (um.getName().length() >= 5 && um.getName().length() <= 20) {
                                            if (um.getSchFrom().length() >= 3 && um.getSchFrom().length() <= 10) {
                                                if (um.getSchTo().length() >= 3 && um.getSchTo().length() <= 10) {
                                                    if (validation.SignIn(um.getSignIn(), "3,5")) {
                                                        if (validation.SignIn(um.getSignOut(), "3,5")) {
                                                            return true;
                                                        } else {
                                                            um.setMessage("Invalid Time In Sign Out Field!");
                                                            return false;
                                                        }
                                                    } else {
                                                        um.setMessage("Invalid Time In Sign In Field!");
                                                        return false;
                                                    }
                                                } else {
                                                    um.setMessage("Minimum 3 And Maximum 10 Characters Allowed In Schedule To Field!");
                                                    return false;
                                                }
                                            } else {
                                                um.setMessage("Minumum 3 And Maximum 10 Charcters Allowed In Schedule From Field!");
                                                return false;
                                            }
                                        } else {
                                            um.setMessage("Minimum 5 And Maximum 20 Characters Allowed In Work Schedule Name!");
                                            return false;
                                        }
                                    } else {
                                        um.setMessage("Select Created By!");
                                        return false;
                                    }
                                } else {
                                    um.setMessage("Please Provide SignOut Time!");
                                    return false;
                                }
                            } else {
                                um.setMessage("Please Provide SignIn Time!");
                                return false;
                            }
                        } else {
                            um.setMessage("Select Weekdays!");
                            return false;
                        }
                    } else {
                        um.setMessage("Schedule To Field Is Empty!");
                        return false;
                    }
                } else {
                    um.setMessage("Schedule From Field Is Empty!");
                    return false;
                }
            } else {
                um.setMessage("Name Field Is Empty!");
                return false;
            }
        } else {
            um.setMessage("All Fields Are Empty!");
            return true;
        }
    }

    private boolean existSchedule(userModel um) {
        if (dataBase.CheckUser(um, "SELECT * FROM `schedule` WHERE `companiesId` ='" + um.getCompanyId() + "' AND `name` = '" + um.getName() + "';")) {
            return true;
        } else {
            um.setMessage("Schedule Already Created!");
            return false;
        }
    }

    private boolean saveSchedule(userModel um) {
        String sql = "INSERT INTO `schedule` VALUES (NULL,'" + um.getName() + "','" + um.getSchFrom() + "','" + um.getSchTo() + "','" + um.getId() + "','" + um.getSignIn() + "','" + um.getSignOut() + "','" + um.getCreate() + "','" + um.getCompanyId() + "',CURRENT_TIMESTAMP);";
        System.out.println(um.getSignIn());
        System.out.println(sql);
        if (dataBase.saveDb(um, sql)) {
            return true;
        } else {
            um.setMessage("Something Went Wrong!");
            return false;
        }
    }

    public String loadAllWorkSchedule(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.getWorkSchedule(um);
        }
        return value;
    }

    private String getWorkSchedule(userModel um) {
        String tr = "";
        int count = 0;
        um.setSql("SELECT * FROM `schedule` WHERE `companiesId` = '" + um.getCompanyId() + "' AND `name` LIKE '%" + um.getSearch() + "%' ORDER BY `id` " + um.getOrderBy() + " LIMIT 0," + um.getLimit() + "  ");
        System.out.println(um.getSql() + "s");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            while (um.getResultset().next()) {
                count++;
                tr += "<tr>";
                tr += "<th>" + count + "</th>";
                tr += "<td>" + um.getResultset().getString("name").toUpperCase() + "</td>";
                tr += "<td>" + um.getResultset().getString("schFrom").toUpperCase() + "</td>";
                tr += "<td>" + um.getResultset().getString("schTo").toUpperCase() + "</td>";
                tr += "<td>" + um.getResultset().getInt("weekdaysId") + "</td>";
                tr += "<td>" + um.getResultset().getTime("signIn") + "AM" + "</td>";
                tr += "<td>" + um.getResultset().getTime("signOut") + "PM" + "</td>";
                tr += "<td>" + um.getResultset().getInt("userId") + "</td>";
                tr += "<td><i class='fa fa-edit'></i> ||"
                        + " <i class='fa fa-trash-o'></i></td>";
                tr += "</tr>";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            dbContext.Close(dbContext.connect());
        }
        return tr;
    }

    public String AllSalaries(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.Salaries(um);
        }
        return value;
    }

    public String Salaries(userModel um) {
        String option = "";
        um.setSql("SELECT * FROM `salaries` WHERE `companiesId` = '" + um.getCompanyId() + "';");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));

            while (um.getResultset().next()) {
                option += "<option  value='";
                option += um.getResultset().getInt("id");
                option += "'>";
                option += um.getResultset().getString("name").toUpperCase();
                option += "</option>";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return option;
    }

    public String AllSchedule(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.getSchedule(um);
        }
        return value;
    }

    public String getSchedule(userModel um) {
        String option = "";
        um.setSql("SELECT * FROM `schedule` WHERE `companiesId` = '" + um.getCompanyId() + "';");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));

            while (um.getResultset().next()) {
                option += "<option  value='";
                option += um.getResultset().getInt("id");
                option += "'>";
                option += um.getResultset().getString("name").toUpperCase();
                option += "</option>";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return option;
    }

    public String AllRole(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.getRoles(um);
        }
        return value;
    }

    private String getRoles(userModel um) {
        String option = "";
        um.setSql("SELECT * FROM `role` WHERE `companyId` = '" + um.getCompanyId() + "';");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));

            while (um.getResultset().next()) {
                option += "<option  value='";
                option += um.getResultset().getInt("id");
                option += "'>";
                option += um.getResultset().getString("name").toUpperCase();
                option += "</option>";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return option;
    }

    public void saveEmployee(userModel um) {
        if (this.validEmployee(um)) {
            if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
                if (this.existEmployee(um)) {
                    if (this.saveEmp(um)) {
                        um.setMessage("success");
                    }
                }
            }
        }
    }

    private boolean validEmployee(userModel um) {
        if (um.getId() != (0) || um.getSalary() != (0) || !um.getSalaryFrom().equals("") || !um.getSalaryTo().equals("") || !um.getSignIn().equals("") || !um.getSignOut().equals("") || !um.getTime().equals("") || um.getSchedule() != (0) || !um.getSalaryDate().equals("") || um.getRoles() != (0)) {
            if (um.getId() != (0)) {
                if (um.getSalary() != (0)) {
                    if (!um.getSalaryFrom().equals("")) {
                        if (!um.getSalaryTo().equals("")) {
                            if (!um.getSignIn().equals("")) {
                                if (!um.getSignOut().equals("")) {
                                    if (!um.getTime().equals("")) {
                                        if (um.getSchedule() != (0)) {
                                            if (!um.getSalaryDate().equals("")) {
                                                if (um.getRoles() != (0)) {
                                                    if (um.getSalaryFrom().length() >= 4 && um.getSalaryFrom().length() <= 8) {
                                                        if (um.getSalaryTo().length() >= 4 && um.getSalaryTo().length() <= 8) {
                                                            if (um.getTime().length() >= 4 && um.getTime().length() <= 5) {
                                                                if (validation.validateSalary(um.getSalaryFrom(), "4,8")) {
                                                                    if (validation.validateSalary(um.getSalaryTo(), "4,8")) {
                                                                        if (validation.SignIn(um.getTime(), "4,5")) {
                                                                            return true;
                                                                        } else {
                                                                            um.setMessage("Invalid Characters Entered In  Employee Time Field!");
                                                                            return false;
                                                                        }
                                                                    } else {
                                                                        um.setMessage("Invalid Characters Entered In Total Salary!");
                                                                        return false;
                                                                    }
                                                                } else {
                                                                    um.setMessage("Invalid Characters Entered In Fixed Salary Range Field!");
                                                                    return false;
                                                                }
                                                            } else {
                                                                um.setMessage("Invalid Time Entered in Employee Time Field!");
                                                                return false;
                                                            }
                                                        } else {
                                                            um.setMessage("Invalid Salary Entered In Total Salary Field!");
                                                            return false;
                                                        }
                                                    } else {
                                                        um.setMessage("Invalid Salary Entered In Fixed Salary Range Field!");
                                                        return false;
                                                    }
                                                } else {
                                                    um.setMessage("Select Role Field!");
                                                    return false;
                                                }
                                            } else {
                                                um.setMessage("Salary Date Field Is Empty!");
                                                return false;
                                            }
                                        } else {
                                            um.setMessage("Select Work Schedule!");
                                            return false;
                                        }
                                    } else {
                                        um.setMessage("Employee Time Field Is Empty!");
                                        return false;
                                    }
                                } else {
                                    um.setMessage("Relieved On Field Is Empty!");
                                    return false;
                                }
                            } else {
                                um.setMessage("Admitted On Field Is Empty!");
                                return false;
                            }
                        } else {
                            um.setMessage("Total Salary Field Is Empty!");
                            return false;
                        }
                    } else {
                        um.setMessage("Fixed Range Field Is Empty!");
                        return false;
                    }
                } else {
                    um.setMessage("Select Salary!");
                    return false;
                }
            } else {
                um.setMessage("Select Employee!");
                return false;
            }
        } else {
            um.setMessage("All Fields Are Empty!");
            return false;
        }
    }

    private boolean existEmployee(userModel um) {
        if (dataBase.CheckUser(um, "SELECT * FROM `employee` WHERE `companyId` ='" + um.getCompanyId() + "' AND `userId` = '" + um.getId() + "';")) {
            return true;
        } else {
            um.setMessage("Employee Already Added!");
            return false;
        }
    }

    private boolean saveEmp(userModel um) {
        String sql = "INSERT INTO `employee` VALUES (NULL,'" + um.getId() + "','" + um.getSalary() + "','" + um.getSalaryFrom() + "','" + um.getSalaryTo() + "','" + um.getSignIn() + "','" + um.getSignOut() + "','" + um.getTime() + "','" + um.getSchedule() + "','" + um.getSalaryDate() + "','" + um.getRoles() + "','" + um.getCompanyId() + "',CURRENT_TIMESTAMP);";
        System.out.println(sql);
        if (dataBase.saveDb(um, sql)) {
            return true;
        } else {
            um.setMessage("Something Went Wrong!");
            return false;
        }
    }

    public String loadAllEmployees(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.getEmployees(um);
        }
        return value;
    }

    private String getEmployees(userModel um) {
        String tr = "";
        int count = 0;
        um.setSql("SELECT * FROM `employee` WHERE `companyId` = '" + um.getCompanyId() + "';");
        System.out.println(um.getSql());
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            while (um.getResultset().next()) {
                count++;
                tr += "<tr>";
                tr += "<th>" + count + "</th>";
                tr += "<td>" + um.getResultset().getInt("userId") + "</td>";
                tr += "<td>" + um.getResultset().getFloat("salaryRange") + "</td>";
                tr += "<td>" + um.getResultset().getFloat("totalSalary") + "</td>";
                tr += "<td>" + um.getResultset().getDate("admitedOn") + "</td>";
                tr += "<td>" + um.getResultset().getDate("relievedOn") + "</td>";
                tr += "<td>" + um.getResultset().getTime("empTime").getHours() + ":00" + "</td>";
                tr += "<td>" + um.getResultset().getInt("ScheduleId") + "</td>";
                tr += "<td>" + um.getResultset().getDate("salaryDate") + "</td>";
                tr += "<td>" + um.getResultset().getInt("roleId") + "</td>";
                tr += "<td><i class='fa fa-edit'></i> |"
                        + " <i class='fa fa-trash-o'></i></td>";
                tr += "</tr>";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            dbContext.Close(dbContext.connect());
        }
        return tr;
    }

    public String AllEmp(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.getEmp(um);
        }
        return value;
    }

    private String getEmp(userModel um) {
        String option = "";
        um.setSql("SELECT users.fname,users.lname, employee.id  FROM `users` INNER JOIN  `employee`  ON employee.userId = users.id WHERE employee.companyId = '" + um.getCompanyId() + "';");
        System.out.println(um.getSql());
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));

            while (um.getResultset().next()) {
                String value = um.getResultset().getString("users.fname") + " " + um.getResultset().getString("users.lname").toUpperCase();
                option += "<option  value='";
                option += um.getResultset().getInt("employee.id");
                option += "'>";
                option += value.toUpperCase();
                option += "</option>";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return option;

    }

    public void Attendence(userModel um) {
        if (this.validAttendence(um)) {
            if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
                if (this.validSchedule(um)) {
                    if (this.saveAttendence(um)) {
                        um.setMessage("success");
                    }
                }
            }
        }
    }

    private boolean validAttendence(userModel um) {
        if (um.getId() != (0) || um.getSchedule() != (0) || !um.getSignIn().equals("") || !um.getSignOut().equals("") || !um.getSignInDelay().equals("") || !um.getSignOutDelay().equals("") || !um.getOvertime().equals("")) {
            if (um.getId() != (0)) {
                if (um.getSchedule() != (0)) {
                    if (!um.getSignIn().equals("")) {
                        if (!um.getSignOut().equals("")) {
                            if (!um.getSignInDelay().equals("")) {
                                if (!um.getSignOutDelay().equals("")) {
                                    if (!um.getOvertime().equals("")) {
                                        if (validation.validateSalary(um.getSignInDelay(), "3,8")) {
                                            if (validation.validateSalary(um.getSignOutDelay(), "3,8")) {
                                                if (validation.validateSalary(um.getOvertime(), "3,8")) {
                                                    return true;
                                                } else {
                                                    um.setMessage("Invalid Currency In Overtime Field!");
                                                    return false;
                                                }
                                            } else {
                                                um.setMessage("Invalid Currency In Sign Out Delay Field!");
                                                return false;
                                            }
                                        } else {
                                            um.setMessage("Invalid Currency In Sign In Delay Field!");
                                            return false;
                                        }
                                    } else {
                                        um.setMessage("Overtime Field Is Empty!");
                                        return false;
                                    }
                                } else {
                                    um.setMessage("Sign Out Delay Field Is Empty!");
                                    return false;
                                }
                            } else {
                                um.setMessage("Sign In Delay Field Is Empty!");
                                return false;
                            }
                        } else {
                            um.setMessage("Sign Out Field Is Empty!");
                            return false;
                        }
                    } else {
                        um.setMessage("Sign In Field Is Empty!");
                        return false;
                    }
                } else {
                    um.setMessage("Select Schedule!");
                    return false;
                }
            } else {
                um.setMessage("Select Employee Name!");
                return false;
            }
        } else {
            um.setMessage("All Fields Are Empty!");
            return false;
        }
    }

    private boolean validSchedule(userModel um) {
        String sql = "SELECT * FROM `employee` WHERE `id` = " + um.getId() + " AND `scheduleId` = " + um.getSchedule() + " ;";
        //System.out.println(sql);
        if (dataBase.CheckUser(um, sql)) {
            um.setMessage("Incorrect Work Schedule!");
            return false;
        } else {
            return true;
        }
    }

    private boolean saveAttendence(userModel um) {
        String sql = "INSERT INTO `attendence` VALUES (NULL," + um.getId() + "," + um.getSchedule() + ",'" + um.getSignIn() + "','" + um.getSignOut() + "','" + um.getSignInDelay() + "','" + um.getSignOutDelay() + "','" + um.getOvertime() + "','" + um.getCompanyId() + "',CURRENT_TIMESTAMP)";
        System.out.println(sql + " atten");
        if (dataBase.saveDb(um, sql)) {
            return true;
        } else {
            um.setMessage("Something Went Wrong!");
            return false;
        }
    }

    public String loadAllAttendence(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.getAttendence(um);
        }
        return value;
    }

    private String getAttendence(userModel um) {
        String tr = "";
        int count = 0;
        um.setSql("SELECT * FROM `attendence` WHERE `companiesId` = '" + um.getCompanyId() + "';");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            while (um.getResultset().next()) {
                count++;
                tr += "<tr>";
                tr += "<th>" + count + "</th>";
                tr += "<td>" + um.getResultset().getInt("empId") + "</td>";
                tr += "<td>" + um.getResultset().getInt("SchId") + "</td>";
                tr += "<td>" + um.getResultset().getInt("SignIn") + "</td>";
                tr += "<td>" + um.getResultset().getInt("SignOut") + "</td>";
                tr += "<td>" + um.getResultset().getInt("SigninDelay") + "</td>";
                tr += "<td>" + um.getResultset().getInt("SignoutDelay") + "</td>";
                tr += "<td>" + um.getResultset().getInt("overtime") + "</td>";
                tr += "<td><i class='fa fa-edit'></i> |"
                        + " <i class='fa fa-trash-o'></i></td>";
                tr += "</tr>";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            dbContext.Close(dbContext.connect());
        }
        return tr;
    }

    public String getAccounts(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.AllAccounts(um);
        }
        return value;
    }

    private String AllAccounts(userModel um) {
        String option = "";
        um.setSql("SELECT *  FROM `employee`  AS `e` JOIN `role` AS `r` ON e.roleId = r.id JOIN `users` AS `u` ON u.id = e.userId WHERE r.name = 'accounts' || r.name = 'admin' AND  e.companyId = " + um.getCompanyId() + ";");
        System.out.println(um.getSql());
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));

            while (um.getResultset().next()) {
                String fullName = um.getResultset().getString("u.fname") + " " + um.getResultset().getString("u.lname");
                option += "<option  value='";
                option += um.getResultset().getInt("u.id");
                option += "'>";
                option += fullName.toUpperCase();
                option += "</option>";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return option;
    }

    public String getWeek(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.AllWeekdays(um);
        }
        return value;
    }

    private String AllWeekdays(userModel um) {
        String option = "";
        um.setSql("SELECT *  FROM `employee`  AS `e` JOIN `role` AS `r` ON e.roleId = r.id JOIN `users` AS `u` ON u.id = e.userId WHERE r.name <> 'employee' AND  e.companyId = " + um.getCompanyId() + ";");

        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));

            while (um.getResultset().next()) {
                String fullName = um.getResultset().getString("u.fname") + " " + um.getResultset().getString("u.lname");
                option += "<option  value='";
                option += um.getResultset().getInt("u.id");
                option += "'>";
                option += fullName.toUpperCase();
                option += "</option>";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return option;
    }

    public String AllEmployees(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.getEmpEmployees(um);
        }
        return value;
    }

    protected String getEmpEmployees(userModel um) {
        String option = "";
        um.setSql("SELECT *  FROM `employee`  AS `e` JOIN `role` AS `r` ON e.roleId = r.id JOIN `users` AS `u` ON u.id = e.userId WHERE r.name <> 'admin' AND  e.companyId = " + um.getCompanyId() + ";");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));

            while (um.getResultset().next()) {
                String value = um.getResultset().getString("u.fname") + " " + um.getResultset().getString("u.lname").toUpperCase();
                option += "<option value='";
                option += um.getResultset().getInt("id");
                option += "'>";
                option += value.toUpperCase();
                option += "</option>";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return option;
    }

    public String SignInDelay(userModel um) throws SQLException {
        String SignInDelay = "";
        if (um.getId() != 0) {
            String Sql = "SELECT * FROM employee AS e JOIN schedule AS s ON e.scheduleId = s.id WHERE e.id = " + um.getId() + "";
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(Sql));
            while (um.getResultset().next()) {
                SignInDelay = ""
                        + "<div class=\"column-6\">\n"
                        + "                    <div class=\"form-group\">\n"
                        + "                        <label class=\"control-label\" style=\"color: #fff\">Sign In</label>\n"
                        + "                        <input type=\"text\" value=" + um.getResultset().getTime("s.signIn") + ""
                        + "                        placeholder=\"hrs:mm\""
                        + "                        name=\"txtSignIn\" id=\"txtSignIn\""
                        + "                        class=\"form-control\" disabled />\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "                <div class=\"column-6\">\n"
                        + "                    <div class=\"form-group\">\n"
                        + "                        <label class=\"control-label\" style=\"color: #fff\">Sign Out</label>\n"
                        + "                        <input type=\"text\" value= " + um.getResultset().getTime("s.signOut") + ""
                        + "                        placeholder=\"hrs:mm\" "
                        + "                        name=\"txtSignOut\" "
                        + "                        id=\"txtSignOut\" "
                        + "                        class=\"form-control\"disabled />\n"
                        + "                    </div>\n"
                        + "                </div>";

            }
        }
        return SignInDelay;
    }

    public String issue(userModel um) throws SQLException {
        String issue = "";
        float day;
        float min;
        int overtime;
        int signOutdelay;
        int max;
        float j = 0;
        float overtimeSalary = 0;
        float dayDeduction = 0;
        if (um.getId() != 0) {
            String Sql = "SELECT * FROM employee AS e JOIN salaries AS s ON e.salaryId = s.id JOIN attendence AS a ON a.empId=e.id  WHERE e.id = " + um.getId() + "";
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(Sql));
            while (um.getResultset().next()) {
                int leaves = um.getResultset().getInt("s.leavesAllowed");
                if (leaves == 1) {
                    dayDeduction = 0;
                } else if (leaves == 2) {
                    dayDeduction = 0;
                } else if (leaves == 3) {
                    dayDeduction = 0;
                } else if (leaves == 4) {
                    dayDeduction = 0;
                } else if (leaves == 5) {
                    dayDeduction = 0;
                }
                day = um.getResultset().getFloat("s.dayDeduction");
                min = um.getResultset().getFloat("s.minDeduction");
                max = um.getResultset().getInt("s.maxDeductionTime");
                signOutdelay = um.getResultset().getInt("a.signoutDelay");
                System.out.println(max + " Max");
                System.out.println(min + " Min");
                System.out.println(signOutdelay + " signOutdelay");
                if (signOutdelay >= max) {
                    int k = signOutdelay - max;
                    for (float i = 1; i <= k; i++) {
                        float g = min + min;
                        j = min + g;
                    }
                }
                overtime = um.getResultset().getInt("a.overtime");
                if (overtime == 1) {
                    overtimeSalary = 100;
                } else if (overtime == 2) {
                    overtimeSalary = 200;
                } else if (overtime == 3) {
                    overtimeSalary = 300;
                } else if (overtime == 4) {
                    overtimeSalary = 400;
                } else if (overtime == 5) {
                    overtimeSalary = 500;
                } else if (overtime == 6) {
                    overtimeSalary = 600;
                } else if (overtime == 7) {
                    overtimeSalary = 700;
                } else if (overtime == 8) {
                    overtimeSalary = 800;
                } else if (overtime == 9) {
                    overtimeSalary = 900;
                } else if (overtime == 10) {
                    overtimeSalary = 1000;
                } else {
                    overtimeSalary = 0;
                }
                float totalDec = dayDeduction + j;
                float Sa = um.getResultset().getFloat("e.totalSalary");
                float Salar = Sa + overtimeSalary;
                float SalaryTaken = Salar - totalDec;
                float balance = 0;
                if (um.getSalaryTaken() != null) {
                    if (validation.validateSalary(um.getSalaryTaken(), "3,8")) {
                        String salary = um.getSalaryTaken();
                        int sal = Integer.parseInt(salary);
                        balance = SalaryTaken - sal;
                    } else {
                        um.setMessage("Invalid Characters Entered in Salary Taken!");
                    }
                }
                issue = "<div class=\"row\">\n"
                        + "                <div class=\"column-6\">\n"
                        + "                    <div class=\"form-group\">\n"
                        + "                        <label class=\"control-label\" style=\"color: #fff\">Salary Due On</label>\n"
                        + "                         <input type=\"text\" value=" + um.getResultset().getDate("e.salaryDate") + ""
                        + "                         name=\"txtSalaryDate\" "
                        + "                         id=\"txtSalaryDate\" "
                        + "                         class=\"form-control\" disabled/>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "                <div class=\"column-6\">\n"
                        + "                    <div class=\"form-group\">\n"
                        + "                        <label class=\"control-label\" style=\"color: #fff\">Salary Taken On</label>\n"
                        + "                         <input type=\"date\" name=\"txtSalaryTakenDate\" id=\"txtSalaryTakenDate\" class=\"form-control\"/>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"column-6\">\n"
                        + "                    <div class=\"form-group\">\n"
                        + "                        <label class=\"control-label\" style=\"color: #fff\">Leaves Taken</label>\n"
                        + "                        <input type=\"text\" value=" + leaves + ""
                        + "                        name=\"txtLeaves\" "
                        + "                        id=\"txtLeaves\" "
                        + "                        class=\"form-control\" disabled />\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "                <div class=\"column-6\">\n"
                        + "                    <div class=\"form-group\">\n"
                        + "                        <label class=\"control-label\" style=\"color: #fff\">Day Deduction</label>\n"
                        + "                        <input type=\"text\" value=" + dayDeduction + " "
                        + "                        name=\"txtdayDec\" "
                        + "                        id=\"txtdayDec\" "
                        + "                        class=\"form-control\" disabled />\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "                </div>\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"column-6\">\n"
                        + "                    <div class=\"form-group\">\n"
                        + "                        <label class=\"control-label\" style=\"color: #fff\">Minute Deduction</label>\n"
                        + "                         <input type=\"text\" value=" + j + ""
                        + "                         name=\"txtminDec\" "
                        + "                         id=\"txtminDec\""
                        + "                         class=\"form-control\" disabled />\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "                <div class=\"column-6\">\n"
                        + "                    <div class=\"form-group\">\n"
                        + "                        <label class=\"control-label\" style=\"color: #fff\">OverTime</label>\n"
                        + "                         <input type=\"text\" value=" + overtime + ""
                        + "                         name=\"overtime\" "
                        + "                         id=\"overtime\""
                        + "                         class=\"form-control\" disabled  />\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "            </div>  \n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"column-6\">\n"
                        + "                    <div class=\"form-group\">\n"
                        + "                        <label class=\"control-label\" style=\"color: #fff\">Total Deduction</label>\n"
                        + "                        <input type=\"text\" value=" + totalDec + ""
                        + "                        name=\"txtTotalDec\" "
                        + "                        id=\"txtTotalDec\"  "
                        + "                        class=\"form-control\" disabled />\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "                <div class=\"column-6\">\n"
                        + "                    <div class=\"form-group\">\n"
                        + "                        <label class=\"control-label\" style=\"color: #fff\">Total Salary</label>\n"
                        + "                         <input type=\"text\" value=" + SalaryTaken + ""
                        + "                         name=\"txtTotalSalary\"   "
                        + "                         id=\"txtTotalSalary\""
                        + "                         class=\"form-control\" disabled />\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"column-6\">\n"
                        + "                    <div class=\"form-group\">\n"
                        + "                        <label class=\"control-label\" style=\"color: #fff\">Balance Salary</label>\n"
                        + "                         <input type=\"text\" value=" + balance + "  "
                        + "                         name=\"txtBalance\" "
                        + "                         id=\"txtBalance\" "
                        + "                         class=\"form-control\" disabled/>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "            </div>\n";
            }
        }
        return issue;
    }

    public String range(userModel um) throws SQLException {
        String range = "";
        um.setSql("SELECT salaryTo FROM salaries WHERE id = " + um.getId() + "");
        um.setStatement(dbContext.connect().createStatement());
        um.setResultset(um.getStatement().executeQuery(um.getSql()));
        while (um.getResultset().next()) {
            range = " <div class=\"form-group\">\n"
                    + "    <label class=\"control-label\" style=\"color: #fff\">Fixed Range</label>\n"
                    + "    <input type=\"text\" value=" + um.getResultset().getInt("salaryTo") + " "
                    + "     name=\"txtRange\" "
                    + "     id=\"txtRange\" "
                    + "     class=\"form-control\" "
                    + "     disabled/>\n"
                    + "  </div>";
        }
        return range;
    }

    public void issueSalary(userModel um) {
        if (this.validIssueSalary(um)) {
            if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
                if (this.attendenceId(um)) {
                    if (this.saveIssueSalary(um)) {
                        um.setMessage("success");
                    }
                }
            }
        }
    }

    private boolean validIssueSalary(userModel um) {
        if (um.getId() != 0) {
            if (!um.getSalaryTo().equals("")) {
                if (!um.getSalaryTaken().equals("")) {
                    if (validation.validateSalary(um.getSalaryTo(), "3,8")) {
                        return true;
                    } else {
                        um.setMessage("Invalid Characters In Salary Taken Date!");
                        return false;
                    }
                } else {
                    um.setMessage("Salary Taken Date Field Is Empty!");
                    return false;
                }
            } else {
                um.setMessage("Salary Taken Field Is Empty!");
                return false;
            }
        } else {
            um.setMessage("Select Employee Name!");
            return false;
        }
    }

    private boolean attendenceId(userModel um) {
        um.setSql("SELECT a.id FROM employee AS e JOIN attendence AS a WHERE  e.id = " + um.getId() + "");
        System.out.println(um.getSql());
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));

            while (um.getResultset().next()) {
                um.setAttendenceId(um.getResultset().getInt("a.id"));
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean saveIssueSalary(userModel um) {
        String sql = "INSERT INTO `issuesalary` VALUES (NULL," + um.getId() + "," + um.getAttendenceId() + ",'" + um.getSalaryDate() + "','" + um.getSalaryTaken() + "','" + um.getLeaves() + "','" + um.getDayDec() + "','" + um.getMinDec() + "','" + um.getOvertime() + "','" + um.getMaxDec() + "','" + um.getTotal() + "','" + um.getBalance() + "','" + um.getCompanyId() + "',CURRENT_TIMESTAMP)";
        if (dataBase.saveDb(um, sql)) {
            return true;
        } else {
            um.setMessage("Something Went Wrong!");
            return false;
        }
    }

    public String loadIssueSalary(userModel um) {
        String value = "";
        if (this.id((String) um.getRequest().getSession().getAttribute("COMPANYSESSION"), um)) {
            value = this.getIssueSalary(um);
        }
        return value;
    }

    private String getIssueSalary(userModel um) {
        String tr = "";
        int count = 0;
        um.setSql("SELECT * FROM `issuesalary` WHERE `companiesId` = '" + um.getCompanyId() + "';");
        try {
            um.setStatement(dbContext.connect().createStatement());
            um.setResultset(um.getStatement().executeQuery(um.getSql()));
            while (um.getResultset().next()) {
                count++;
                tr += "<tr>";
                tr += "<th>" + count + "</th>";
                tr += "<td>" + um.getResultset().getInt("empId") + "</td>";
                tr += "<td>" + um.getResultset().getDate("dueon") + "</td>";
                tr += "<td>" + um.getResultset().getDate("takeon") + "</td>";
                tr += "<td>" + um.getResultset().getInt("totalDec") + "</td>";
                tr += "<td>" + um.getResultset().getInt("SalaryTaken") + "</td>";
                tr += "<td>" + um.getResultset().getInt("balance") + "</td>";
                tr += "<td><i class='fa fa-edit'></i> |"
                        + " <i class='fa fa-trash-o'></i></td>";
                tr += "</tr>";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            dbContext.Close(dbContext.connect());
        }
        return tr;
    }
}
