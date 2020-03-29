package com.services;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.database.InsertPop;
import com.dao.model.Message;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		InsertPop ins = new InsertPop();
		String currentuser = (String) session.getAttribute("username");
		String newmsg ;
		newmsg = (String)request.getParameter("newmessage");
		String newmsgold = newmsg;
		System.out.println("old new msg: "+newmsgold);
		System.out.println(" new msg: "+newmsg);
		
		if(newmsg!=null && newmsgold!=newmsg) 
		{
	System.out.println("in IF");
		ins.Insert(newmsg, currentuser);
		ArrayList<Message> result = ins.getData();
		System.out.println(result.size());
		request.setAttribute("result", result);
		 RequestDispatcher rd = request.getRequestDispatcher("Chatroom.jsp");
		 rd.forward(request, response);  
		}
		else {
			ins.Insert(newmsg, currentuser);
			System.out.println("in else");
			ArrayList<Message> result = ins.getData();
			System.out.println(result.size());
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("Chatroom.jsp");
			 rd.forward(request, response); 
			
		}
		}

}
