package com.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.database.InsertPop;

/**
 * Servlet implementation class ResetAllServlet
 */
@WebServlet("/ResetAllServlet")
public class ResetAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		InsertPop ins = new InsertPop();
	    if(ins.ResetData()) {
	    	System.out.println("Reset Done");
	    	response.sendRedirect("index.jsp");
	    }
	    else {
	    	System.out.println("Reset failed");
	    }
	
	}

}
