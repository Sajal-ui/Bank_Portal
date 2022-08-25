package com.javareso;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import javax.sql.DataSource;
/**
 * Servlet implementation class Pdfgen
 */
@WebServlet("/Pdfgen")
public class Pdfgen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pdfgen() {
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
	   	Connection con=null;
	   	PreparedStatement ps=null;
	   	ResultSet rs=null;
	   	String url="jdbc:mysql://127.0.0.1:3306/bank_data";
		String user="Sajal";
		String password="Sajal123#";
	   	try {
	   		Class.forName("com.mysql.cj.jdbc.Driver");
	   		Document doc=new Document(PageSize.A4);
	   		response.setContentType("application/pdf");
	   		PdfWriter.getInstance(doc,response.getOutputStream());
	   		con=DriverManager.getConnection(url, user, password);
	   		String query="select balance from balance where account=?";
            ps=con.prepareStatement(query);
            String axc=transfdata.accn;
            String vv=transfdata.bln;
            ps.setString(1,axc);
            rs=ps.executeQuery();
            doc.open();
            Image img=Image.getInstance("G:\\My Personal Favourite\\Bank_Portal\\WebContent\\14e34811526e6b0fcb35950689b6f78b.jpg");
            img.scaleToFit(90,90);
            img.setAlignment(Image.MIDDLE);
            doc.add(img);
            doc.add(new Paragraph("-----------------------------------------------------Transaction Receipt------------------------------------------------\n\n"));
            while(rs.next()) {
              doc.add(new Paragraph("Account1----->  "+axc+"\n\n"));
              doc.add(new Paragraph("Balance------->  "+rs.getString("balance")+"\n\n"));
              doc.add(new Paragraph("Transfered Amount--------->  "+vv));
            } 
            doc.close();
            con.close();
	   	}catch(Exception r) {
	   		r.printStackTrace();
	   	}
	}		
}
