/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.UserDAO;
import DTO.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HLong
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String email=request.getParameter("txtemail");
            String password=request.getParameter("txtpassword");
            String save=request.getParameter("savelogin");
            Users user=null;
            try {
                if(email==null || email.equals("") || password==null || password.equals("")){
                    Cookie[] c=request.getCookies();
                    String token="";
                    if(c!=null){
                        for (Cookie cookie : c) {
                            if(cookie.getName().equals("selector")){
                                token=cookie.getValue();
                            }
                        }
                    }
                    if(!token.equals("")){
                        response.sendRedirect("profile.jsp");
                    }
                    else
                        request.setAttribute("WARNING", "You must login to use cookie");
                        request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
                user=UserDAO.read(email,password);
                if(user!=null){
                    //student
                    if(user.getRoleId()==1){
                        //chuyen sang trang cho student
                        HttpSession session=request.getSession(true);
                        if(session!=null){
                            session.setAttribute("name", user.getName());
                            session.setAttribute("email", user.getEmail());
                            //create a cookie and attach it to the response obj
                            if(save!=null){
                                String token="ABC123";
                                UserDAO.updateUserToken(token, email);
                                Cookie cookie=new Cookie("selector", token);
                                cookie.setMaxAge(60*30);
                                response.addCookie(cookie);
                            }
                            response.sendRedirect("profile.jsp");
                        }
                    }
                    else if(user.getRoleId()==2){
                        //chuyen sang trang cho lecture
                        HttpSession session=request.getSession(true);
                        if(session!=null){
                            session.setAttribute("name", user.getName());
                            session.setAttribute("email", user.getEmail());
                            //create cookie and attach it to response object
                            if(save!=null){
                                String token="XYZ456";  
                                UserDAO.updateUserToken(token, email);
                                Cookie cookie=new Cookie("selector", token);
                                cookie.setMaxAge(60*30);
                                response.addCookie(cookie);
                            }
                            response.sendRedirect("index.html");
                        }
                    }
                    else if(user.getRoleId()==3){
                        //chuyen sang trang cho lecture
                        HttpSession session=request.getSession(true);
                        if(session!=null){
                            session.setAttribute("name", user.getName());
                            session.setAttribute("email", user.getEmail());
                            //create cookie and attach it to response object
                            if(save!=null){
                                String token="CDE789";  
                                UserDAO.updateUserToken(token, email);
                                Cookie cookie=new Cookie("selector", token);
                                cookie.setMaxAge(60*30);
                                response.addCookie(cookie);
                            }
                            response.sendRedirect("index.html");
                        }
                    }
                }
                else{
                    request.setAttribute("WARNING", "Invalid email or password");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
