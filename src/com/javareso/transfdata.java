package com.javareso;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class transfdata
 */
@WebServlet("/transfdata")
public class transfdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static String accn;
    static String bln;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transfdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://127.0.0.1:3306/bank_data";
		String user="Sajal";
		String password="Sajal123#";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query="select balance from balance where account=?";
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1,request.getParameter("acc_no1"));
			accn=request.getParameter("acc_no1");
			bln=request.getParameter("bal");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				int bl=Integer.parseInt(rs.getString("balance"));
				int req=Integer.parseInt(request.getParameter("bal"));
				if(bl<req){
				RequestDispatcher res=request.getRequestDispatcher("Deposit_altr.jsp");
				res.forward(request,response);
			}
				else {
			      bl=bl-req;
			      String query1="update balance set balance=? where account=?";
			      PreparedStatement st2=con.prepareStatement(query1);
			      st2.setString(1,String.valueOf(bl));
			      st2.setString(2,request.getParameter("acc_no1"));
			      st2.executeUpdate();
			      String query2="select balance from balance where account=?";
			      PreparedStatement st1=con.prepareStatement(query2);
			      st1.setString(1,request.getParameter("acc_no2"));
			      ResultSet rs1=st1.executeQuery();
			      while(rs1.next()) {
			    	  int tt=Integer.parseInt(rs1.getString("balance"));
			    	  String re=String.valueOf(tt+req);
			    	  String query3="update balance set balance=? where account=?";
			    	  PreparedStatement st3=con.prepareStatement(query3);
			    	  st3.setString(1,re);
			    	  st3.setString(2,request.getParameter("acc_no2"));
			    	  st3.executeUpdate();
			    	  RequestDispatcher r=request.getRequestDispatcher("Pdfredirect.jsp");
			    	  r.forward(request,response);
				}
			    
			}		
		}
		}catch(Exception r) {
			System.out.println("Problem Occured");
			r.printStackTrace();}
	}
}
