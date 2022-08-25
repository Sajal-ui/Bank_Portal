package com.javareso;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insertinto
 */
@WebServlet("/insertinto")
public class insertinto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertinto() {
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
			String query="insert into net_banking(username,acc_no,psw)values(?,?,?)";
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1,request.getParameter("usn"));
			st.setString(2,request.getParameter("account"));
			st.setString(3,request.getParameter("psw"));
			st.executeUpdate();
			String query2="insert into balance(account,balance)values(?,0)";
			PreparedStatement st1=con.prepareStatement(query2);
			st1.setString(1,request.getParameter("account"));
			st1.executeUpdate();
			RequestDispatcher req=request.getRequestDispatcher("/aftersubmit.jsp");
			req.forward(request,response);
		}catch(Exception r) {
			System.out.println("Problem Occured");
			r.printStackTrace();}
		
	}

}
