<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="javax.servlet.http.*" %>
<% String s=(String)session.getAttribute("user");
if(s==null){
	RequestDispatcher req=request.getRequestDispatcher("Login_man.jsp");
	req.forward(request,response);
}
%>
<!DOCKTYPE html>
<html>
    <head>
        <title>Balance-Login(Correct)</title>
        <style>
            .myDiv1{ 
                display: grid;
                width:1400;
                height: 1000;
            }
            .myDiv2{
                width: 997px;
                height: 200px;
                position: absolute;
                transform: translate(20%,0%);
                background-color: black;
                display: inline-flex;
                vertical-align: middle
            }
            .myDiv3{
                width: 1600;
                height: 40;
                position: relative;
                display: inline-grid;
                margin-left: 43px;
                margin-top: 40px;
            }
            ul {
         list-style-type: none;
         margin-top: -4px;
  margin-left: -7px;
  padding: 0px;
  width: 15%;
  background-color: whitesmoke;
  position: relative;
  height: 81.8%;
                border: 2px solid gray;
  overflow: auto;
  text-align: center;
}

li a {
  display: block;
  color: #000;
  padding: 10px 16px;
  text-decoration: none;
  height: 27px;
}
li {
  text-align: center;
}

li:last-child {
    border-bottom: none;
}
li a.active {
  background-color: #4CAF50;
  color: white;
}

li a:hover:not(.active) {
  color: Blue;
     height: 30px;
}
            .myDiv4{
                width:949px;
                height:578px;
                margin-left: 207px;
                position: absolute;
                margin-top: -636px;
                margin-bottom: 60px;
                border: 20px solid black;
                background-color: black;
            }
            .myDiv5{
                width:509px;
                height: 358px;
                margin-left: 648px;
                position: absolute;
                display: inline-grid;
                margin-top: 204px;
                margin-bottom: 60px;
                border: 20px solid black;
                background-color: black;
            }
            .myDiv6{
                width:509px;
                height: 165px;
                margin-left: -5.5px;
                position: absolute;
                display: inline-grid;
                margin-top: -16px;
                margin-bottom: 60px;
                border: 20px solid black;
                background-color: black;
            }
            .myDiv7{
                width:650px;
                height:205.2px;
                margin-left: 546px;
                position:absolute;
                margin-top: -16px;
                background-color: black;
            }
            input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 3px 0 22px 0;
  display: inline-blocks;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}
        </style>    
    </head>
    <body style="background-color: gray">
        <%
                  String url="jdbc:mysql://127.0.0.1:3306/bank_data";
		          String user="Sajal";
		          String password="Sajal123#";
		          String balance=null;
		          try {
			           Class.forName("com.mysql.cj.jdbc.Driver");
			           String query="select acc_no from net_banking where username=?";
			           Connection con=DriverManager.getConnection(url, user, password);
			           PreparedStatement st=con.prepareStatement(query);
			           st.setString(1,s);
			           ResultSet rs=st.executeQuery();
			           while(rs.next()){
			        	   String accno=rs.getString("acc_no");
			        	   String query2="select balance from balance where account=?";
			        	   PreparedStatement stmn=con.prepareStatement(query2);
			        	   stmn.setString(1,accno);
			        	   ResultSet rsr=stmn.executeQuery();
			        	   while(rsr.next()){
			        		   balance=rsr.getString("balance");
			        	   }
			           }
		          }catch(Exception d){
		        	  d.printStackTrace();
		          }
			%>
			<%
			    String val1=request.getParameter("usn");
			    %>
        <div class="myDiv1">
            <div class="myDiv2">
                 <img src="G:\My Personal Favourite\Bank_Portal\WebContent\14e34811526e6b0fcb35950689b6f78b.jpg" alt="Bank Image" height="200px" width="400px" style="position:relative">
                <div class="myDiv3">
                  <h1 style="color:white;position: relative">Cooperative Bank</h1>
                    <h5 style="color: white;position: relative;margin-top: -17px">(Nanital Road,Kichha,Udham Singh Nagar,Uttarakhand)</h5>
                    <h4 style="color: white;font-family:Lucida Handwriting;position: absolute;margin-top: 30px;margin-bottom: 0px;margin-left: 480px">"Aapka Bhala,Sabki Bhalai"</h4>
                </div>    
            </div>
            <ul>
                <li><h3><a href="front_page.html">Home</a></h3></li>
                <li><h3><a href="NewAccount.jsp">New Account</a></h3></li>
                <li><h3><a href="Balance1.jsp">Balance</a></h3></li>
                <li><h3><a href="Deposit.jsp">Deposit</a></h3></li>
                <li><h3><a href="Transfer.jsp">Transfer</a></h3></li>
                <li><h3><a href="CloseAccount.jsp">Close Account</a></h3></li>
                <li><h3><a href="redirect.jsp">Logout</a></h3></li>
            </ul>
              <div class="myDiv4">
                <h4 style="color:white;font-size:30">The details you are looking for</h4><br><br>
                <p style="color:white;font-size:30">UserName:   <%= s%></p><br><br>
                <p style="color:white;font-size:30">Balance:    <%= balance%></p><br><br>
                <hr>
              </div>
            <div class="myDiv6">
                <h2 style="font-family: Times New Roman;position: relative;color: white;margin-top: 0px">References</h2>
                <p style="position:relative;margin-top: -1.5px"><a href="https://www.investopedia.com/articles/general/071213/retail-banking-vs-commercial-banking.asp">Reference 1</a></p> 
                <p style="position: relative;margin-top: -0.75px"><a href="https://www.ilearnlot.com/corporate-banking-meaning-characteristics-importance-and-advantages/61014/">Reference 2</a></p>
                <p style="position: relative;margin-top: 0px"><a href="https://www.finweb.com/banking-credit/the-8-defining-features-of-corporate-bank-operations.html">Reference 3</a></p>
            </div>
            <div class="myDiv7">
                <h2 style="position: relative;margin-left: 10px;font-family: serif;color: white">Contact US</h2>
                <h4 style="position:relative;margin-left: 10px;font-family: cursive;color: white;">0012-7999-5674</h4>
                <h4 style="position: relative;margin-left: 10px;font-family: cursive;color: white;">0012-7999-5675</h4>
                <h4 style="position: relative;margin-left: 10px;font-family: cursive;color:white">0012-8000-4532</h4>
                <h4 style="position:relative;margin-left: 300px;margin-top: -135px; font-family: cursive;color: white">banking_sii123@gmail.com</h4>
                <h4 style="position: relative;margin-left: 300px;margin-top: 0px;font-family: cursive;color: white">corporate_sector112@gmail.com</h4>
            </div>
        </div>
    </body>
</html>