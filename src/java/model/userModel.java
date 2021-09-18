package model;

public class userModel extends essentialModel {

    private int SigInDelay;
    private int schedule = 0;
    private int id = 0;
    private int CompanyId = 0;
    private String message;
    private String Username;
    private String Password;
    private String Remember;
    private String Sname;
    private String Phone;
    private String Qualification;
    private String FatherName;
    private String MotherName;
    private String Email;
    private int Gender;
    private String Address;
    private String Dob;
    private String Role;
    private String Company;
    private int Status;
    private String Name;
    private String Enquiry;
    private String Fname;
    private String Lname;
    private String Moblie;
    private String SalaryFrom;
    private String SalaryTo;
    private String Ta;
    private String Da;
    private String Pf;
    private String Other;
    private String DayDec;
    private String MinDec;
    private String MaxDec;
    private String Leaves;
    private String Week;
    private String SchFrom;
    private String SchTo;
    private String signIn;
    private String signOut;
    private String signInDelay;
    private String signOutDelay;
    private int Create = 0;
    private int Salary = 0;
    private String Time;
    private int roles = 0;
    private String salaryDate;
    private String Overtime;
    private String SalaryTaken;
    private String Total;
    private String Balance;
    private int attendenceId;

    public int getAttendenceId() {
        return attendenceId;
    }

    public void setAttendenceId(int attendenceId) {
        this.attendenceId = attendenceId;
    }
    
    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String Balance) {
        this.Balance = Balance;
    }
    
    public String getSalaryTaken() {
        return SalaryTaken;
    }

    public void setSalaryTaken(String SalaryTaken) {
        this.SalaryTaken = SalaryTaken;
    }

    public String getSignInDelay() {
        return signInDelay;
    }

    public void setSignInDelay(String signInDelay) {
        this.signInDelay = signInDelay;
    }

    public String getSignOutDelay() {
        return signOutDelay;
    }

    public void setSignOutDelay(String signOutDelay) {
        this.signOutDelay = signOutDelay;
    }

    public String getOvertime() {
        return Overtime;
    }

    public void setOvertime(String Overtime) {
        this.Overtime = Overtime;
    }

    public String getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(String salaryDate) {
        this.salaryDate = salaryDate;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getWeek() {
        return Week;
    }

    public void setWeek(String Week) {
        this.Week = Week;
    }

    public String getSchFrom() {
        return SchFrom;
    }

    public void setSchFrom(String SchFrom) {
        this.SchFrom = SchFrom;
    }

    public String getSchTo() {
        return SchTo;
    }

    public void setSchTo(String SchTo) {
        this.SchTo = SchTo;
    }

    public String getSignIn() {
        return signIn;
    }

    public void setSignIn(String signIn) {
        this.signIn = signIn;
    }

    public String getSignOut() {
        return signOut;
    }

    public void setSignOut(String signOut) {
        this.signOut = signOut;
    }

    public int getCreate() {
        return Create;
    }

    public void setCreate(int Create) {
        this.Create = Create;
    }

    public String getSalaryFrom() {
        return SalaryFrom;
    }

    public void setSalaryFrom(String SalaryFrom) {
        this.SalaryFrom = SalaryFrom;
    }

    public String getSalaryTo() {
        return SalaryTo;
    }

    public void setSalaryTo(String SalaryTo) {
        this.SalaryTo = SalaryTo;
    }

    public String getTa() {
        return Ta;
    }

    public void setTa(String Ta) {
        this.Ta = Ta;
    }

    public String getDa() {
        return Da;
    }

    public void setDa(String Da) {
        this.Da = Da;
    }

    public String getPf() {
        return Pf;
    }

    public void setPf(String Pf) {
        this.Pf = Pf;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String Other) {
        this.Other = Other;
    }

    public String getDayDec() {
        return DayDec;
    }

    public void setDayDec(String DayDec) {
        this.DayDec = DayDec;
    }

    public String getMinDec() {
        return MinDec;
    }

    public void setMinDec(String MinDec) {
        this.MinDec = MinDec;
    }

    public String getMaxDec() {
        return MaxDec;
    }

    public void setMaxDec(String MaxDec) {
        this.MaxDec = MaxDec;
    }

    public String getLeaves() {
        return Leaves;
    }

    public void setLeaves(String Leaves) {
        this.Leaves = Leaves;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public userModel() {
        this.message = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemember() {
        return Remember;
    }

    public void setRemember(String Remember) {
        this.Remember = Remember;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String Sname) {
        this.Sname = Sname;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String Qualification) {
        this.Qualification = Qualification;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String FatherName) {
        this.FatherName = FatherName;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String MotherName) {
        this.MotherName = MotherName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEnquiry() {
        return Enquiry;
    }

    public void setEnquiry(String Enquiry) {
        this.Enquiry = Enquiry;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getMoblie() {
        return Moblie;
    }

    public void setMoblie(String Moblie) {
        this.Moblie = Moblie;
    }

    public int getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(int CompanyId) {
        this.CompanyId = CompanyId;
    }

    public String getWeekdays() {
        return Week;
    }

    public void setWeekdays(String Week) {
        this.Week = Week;
    }

    public int getSigInDelay() {
        return SigInDelay;
    }

    public void setSigInDelay(int SigInDelay) {
        this.SigInDelay = SigInDelay;
    }

}
