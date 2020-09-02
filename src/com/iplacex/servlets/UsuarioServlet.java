package com.iplacex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iplacex.dao.PersonaDao;
import com.iplacex.dao.UsuarioDao;
import com.iplacex.dto.PersonaDTO;
import com.iplacex.dto.UsuarioDTO;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
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
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass"); 
        
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name", n);
        UsuarioDTO usuario = UsuarioDao.validate(n, p);

        
        if(usuario.getRutUsuario() != null ){  
        	String rut = usuario.getRutUsuario().toString();
        	PersonaDTO prsn = PersonaDao.validate(rut);
        	session.setAttribute("rut", prsn.getRut());
        	session.setAttribute("name", prsn.getNombre());
        	session.setAttribute("lstName", prsn.getApellido());
        	session.setAttribute("date", prsn.getFechaIngreso());
        	session.setAttribute("phone", prsn.getTelefono());
            RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");  
            rd.forward(request,response);  
        }  
        else{  
            out.print("<p style=\"color:red\">Disculpe usuario o clave incorrecta.</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");  
            rd.include(request,response);  
        }  

        out.close();  
	}

}
