<%@ page import ="java.sql.*" %>
<%
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
            "hackathon", "hackathon");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from members where uname='" + userid + "' and pass='" + pwd + "'");
   
  
    if (rs.next()) {
       /* session.setAttribute("userid", userid);
       // out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");    
      
        response.sendRedirect("success");
  */ ResultSet rs1;
    rs1 = st.executeQuery("select account from members where uname='" + userid + "' and pass='" + pwd + "'");
          rs1.next();
    String a=rs1.getString(1);
     if(a.equals("Personal"))
                 {
           response.sendRedirect("success");
     }
    else
               {
        response.sendRedirect("company");
    }
    }
    else 
    {
          response.sendRedirect("index");
    }                 
%>