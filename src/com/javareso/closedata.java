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

/**
 * Servlet implementation class closedata
 */
@WebServlet("/closedata")
public class closedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public closedata() {
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
		String usn=loginto1.uno;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String query="select acc_no from net_banking where username=?";
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement st=con.prepareStatement(query);
			st.setString(1,usn);
			ResultSet rs=st.executeQuery();
			String q1="delete from net_banking where username=?";
			PreparedStatement st1=con.prepareStatement(q1);
			st1.setString(1,usn);
			st1.executeUpdate();
			while(rs.next()) {
				String accp=rs.getString("acc_no");
				String q2="delete from balance where account=?";
				PreparedStatement st2=con.prepareStatement(q2);
				st2.setString(1,accp);
				st2.executeUpdate();
			}
			HttpSession session=request.getSession();
			String ss=(String)session.getAttribute("user");
			session.invalidate();
			RequestDispatcher req=request.getRequestDispatcher("front_page.html");
			req.forward(request,response);
		}catch(Exception r) {
			System.out.println("Problem Occured");
			r.printStackTrace();}
	}

}
