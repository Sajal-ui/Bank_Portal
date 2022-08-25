<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCKTYPE html>
<html>
    <head>
        <title>Confirmation</title>
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
                vertical-align: middle;
                margin-top:1px;
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
  height: 60%;
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
                height:361px;
                margin-left: 207px;
                position: absolute;
                margin-top: -418px;
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
                margin-left: -5px;
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
                margin-left: 547px;
                position:absolute;
                margin-top: -16px;
                background-color: black;
            }
            input[type=text], input[type=password],input[type=number] {
  width: 50%;
  padding: 10px;
  margin: 1px 0 22px 0;
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
        </style>    
    </head>
    <body style="background-color: gray">
       <%String val1=request.getParameter("usn");
         String val2=request.getParameter("account");
         String val3=request.getParameter("psw");%>
        <div class="myDiv1">
            <div class="myDiv2">
                 <img src="G:\My Personal Favourite\Bank_Portal\WebContent\14e34811526e6b0fcb35950689b6f78b.jpg" alt="Bank Image" height="200px" width="400px" style="position:relative;margin-top:0px">
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
                <li><h3><a href="redirect.jsp">Close Account</a></h3></li>
            </ul>
            <div class="myDiv4">
            <h2 style="color:white">Your Account has been Registered Successfully and Here are your Login Credentials </h2><br><br>
            <p style="color:white">UserName:    <%= val1 %></p><br><br>
            <p style="color:white">Account:     <%= val2 %></p><br><br>
            <p style="color:white">Password:    <%= val3 %></p><br><br>
            </div>
            <div class="myDiv6">
                <h2 style="font-family: Times New Roman;position: relative;color: white;margin-top: 0px">References</h2>
                <p style="position:relative;margin-top: -1.5px"><a href="https://www.investopedia.com/articles/general/071213/retail-banking-vs-commercial-banking.asp">Reference 1</a></p> 
                <p style="position: relative;margin-top: -0.75px"><a href="https://www.ilearnlot.com/corporate-banking-meaning-characteristics-importance-and-advantages/61014/">Reference 2</a></p>
                <p style="position: relative;margin-top: 0px"><a href="https://www.finweb.com/banking-credit/the-8-defining-features-of-corporate-bank-operations.html">Reference 3</a></p>
            </div>
            <div class="myDiv7">
                <h2 style="position: relative;margin-left: 10px;font-family: serif;color: white">Contact US</h2>
                <h4 style="position: relative;margin-left: 10px;font-family: cursive;color: white;">0012-7999-5674</h4>
                <h4 style="position: relative;margin-left: 10px;font-family: cursive;color: white;">0012-7999-5675</h4>
                <h4 style="position: relative;margin-left: 10px;font-family: cursive;color:white">0012-8000-4532</h4>
                <h4 style="position:relative;margin-left: 300px;margin-top: -135px; font-family: cursive;color: white">banking_sii123@gmail.com</h4>
                <h4 style="position: relative;margin-left: 300px;margin-top: 0px;font-family: cursive;color: white">corporate_sector112@gmail.com</h4>
            </div>