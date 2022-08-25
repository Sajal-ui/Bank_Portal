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
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class loginto1
 */
@WebServlet("/loginto1")
public class loginto1 extends HttpServlet {
	protected static String uno;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginto1() {
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
			String query="select psw from net_banking where username=?";
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1,request.getParameter("usn"));
			String psswd=request.getParameter("psw");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				String check=rs.getString("psw");
				if(check.equalsIgnoreCase(psswd)) {
					RequestDispatcher req=request.getRequestDispatcher("front_page.html");
					req.forward(request,response);
					HttpSession session=request.getSession();
					session.setAttribute("user",request.getParameter("usn"));
					uno=request.getParameter("usn");
				}
				else {
					RequestDispatcher req=request.getRequestDispatcher("Balance2.jsp");
					req.forward(request,response);
				}
			}
			
		}catch(Exception r) {
			System.out.println("Problem Occured");
			r.printStackTrace();}
	}
}
