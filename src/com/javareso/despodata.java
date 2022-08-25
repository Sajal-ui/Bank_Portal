package com.javareso;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class despodata
 */
@WebServlet("/despodata")
public class despodata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public despodata() {
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
			st.setString(1,request.getParameter("acc_no"));
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				String bl=rs.getString("balance");
				int bladd=Integer.parseInt(request.getParameter("bal"));
				int h=Integer.parseInt(bl);
				int y=bladd+h;
				String azx=String.valueOf(y);
				String query1="update balance set balance=? where account=?";
				PreparedStatement st1=con.prepareStatement(query1);
				st1.setString(1,azx);
				st1.setString(2,request.getParameter("acc_no"));
				st1.executeUpdate();
				RequestDispatcher res=request.getRequestDispatcher("Deposit.jsp");
				res.forward(request,response);
			}
			
		}catch(Exception r) {
			System.out.println("Problem Occured");
			r.printStackTrace();}
	}

}
