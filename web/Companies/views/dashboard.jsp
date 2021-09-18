<%@page import="persistence.dbContext"%>
<%@page import="com.sun.xml.ws.util.xml.CDATA"%>
<%@page import="model.userModel"%>
<%@page import="controller.companyController"%>
<%@page import="essentials.companyEssentials"%>
<%@page  import="java.util.*" %>
<%@page import="java.util.function.ToDoubleFunction"%>
<%@ page import="java.util.*,java.sql.*"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@page import="com.google.gson.Gson" %>
<%@page  import="com.google.gson.JsonObject" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../isAuthentic.jsp" %>
<%@include file="../../config.jsp" %>
<%      Gson gsonObj = new Gson();
    String dataPoints = "";
    Map<Object, Object> map = new HashMap<Object, Object>();
    List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
    try {
        um.setSql(""
                + "SELECT (SELECT count(*) from users)AS USERCOUNT,"
                + "(SELECT count(*) from employee WHERE roleId = 7)AS EMPCOUNT,"
                + "(SELECT count(*) from employee WHERE roleId = 6)AS ACCOUNT,"
                + "(SELECT count(*) from employee WHERE roleId = 3)AS ADMINCOUNT,"
                + "(SELECT count(*) from employee WHERE roleId = 5)AS ADMINISTRATIIONCOUNT,"
                + "(SELECT count(*) from role)AS ROLCOUNT,"
                + "(SELECT count(*) from weekdays)AS WEEKCOUNT,"
                + "(SELECT count(*) from schedule)AS SCHCOUNT,"
                + "(SELECT count(*) from salaries)AS SALARYCOUNT,"
                + "(SELECT count(*) from issuesalary)AS ISSUECOUNT"
                + "");
        um.setStatement(dbContext.connect().createStatement());
        um.setResultset(um.getStatement().executeQuery(um.getSql()));
        String xVal, yVal,Val3,Val4,Val5,Val6,Val7,Val8,Val9,Val10;
            while (um.getResultset().next()) {
            yVal = um.getResultset().getString("USERCOUNT");
            xVal = um.getResultset().getString("EMPCOUNT");
            Val3 = um.getResultset().getString("ACCOUNT");
            Val4 = um.getResultset().getString("ADMINCOUNT");
            Val5 = um.getResultset().getString("ADMINISTRATIIONCOUNT");
            Val6 = um.getResultset().getString("ROLCOUNT");
            Val7 = um.getResultset().getString("WEEKCOUNT");
            Val8 = um.getResultset().getString("SCHCOUNT");
            Val9 = um.getResultset().getString("SALARYCOUNT");
            Val10 = um.getResultset().getString("ISSUECOUNT");
            
            map = new HashMap<Object, Object>();
            map.put("label","user");
            map.put("y",Double.parseDouble(yVal));
            list.add(map);
            
            map = new HashMap<Object, Object>();
            map.put("label","employee");
            map.put("y",Double.parseDouble(xVal));
            list.add(map);
            
            map = new HashMap<Object, Object>();
            map.put("label","accounts");
            map.put("y",Double.parseDouble(Val3));
            list.add(map);
            
            map = new HashMap<Object, Object>();
            map.put("label","admin");
            map.put("y",Double.parseDouble(Val4));
            list.add(map);
            
            map = new HashMap<Object, Object>();
            map.put("label","administration");
            map.put("y",Double.parseDouble(Val5));
            list.add(map);
            
            map = new HashMap<Object, Object>();
            map.put("label","role");
            map.put("y",Double.parseDouble(Val6));
            list.add(map);
            
            map = new HashMap<Object, Object>();
            map.put("label","week");
            map.put("y",Double.parseDouble(Val7));
            list.add(map);
            
            map = new HashMap<Object, Object>();
            map.put("label","schedule");
            map.put("y",Double.parseDouble(Val8));
            list.add(map);
            
            map = new HashMap<Object, Object>();
            map.put("label","salary");
            map.put("y",Double.parseDouble(Val9));
            list.add(map);
            
            map = new HashMap<Object, Object>();
            map.put("label","issue");
            map.put("y",Double.parseDouble(Val10));
            list.add(map);
            dataPoints = gsonObj.toJson(list);
        }
        dbContext.connect().close();
    } catch (SQLException e) {
        out.println(e.getMessage());
        //out.println("<div class='alert alert-danger' style='margin:1%;'>Could not connect to the database. Please check if you have mySQL Connector installed on the machine - if not, try installing the same. Please refer to Instruction.txt</div>");
        dataPoints = null;
    }%>
<%=companyEssentials.getPage("Dashboard", "Company", um)%>
<script type="text/javascript">
    window.onload = function() {

        var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light2",
            animationEnabled: true,
            axisX: {
               title: "All"
           },
           axisY: {
               title: "Numbers"
           },
            data: [{
                    type: "column", //change type to bar, line, area, pie, etc
                    indexLabelFontSize: 35,
                    indexLabel: "{y}", //Shows y value on all Data Points
                    indexLabelFontColor: "#f5f5f5",
                    indexLabelPlacement: "inside",
                    dataPoints: <%out.print(dataPoints);%>
                }]
        });
        chart.render();

    }
</script>
    <div id="chartContainer" style="height: 370px; width: 100%;">
        
    </div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<%=companyEssentials.footer()%>