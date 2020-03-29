package com.services;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.dao.database.Authenticate;
import com.dao.database.InsertPop;
import com.dao.model.Message;

/**
 * Servlet implementation class AuthenticateServlet
 */
@WebServlet("/AuthenticateServlet")
public class AuthenticateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Username :"+username);
		System.out.println("Password :"+password);
		
		HttpSession session = request.getSession();
		Authenticate authenticate = new Authenticate();
		if(authenticate.Auth(username, password)) {
			session.setAttribute("username",username );
			InsertPop ins = new InsertPop();
			ArrayList<Message> result = ins.getData();
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("AddServlet");
			rd.forward(request, response);

		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

}
