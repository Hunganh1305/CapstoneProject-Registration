/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ProjectDAO;
import DTO.Project;
import DTO.Semester;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author phamquang
 */
@WebServlet(name = "ProjectLecturerController", urlPatterns = {"/projectlecturer"})
public class ProjectLecturerController extends HttpServlet {

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
        String action = request.getAttribute("action").toString();
        Semester currSem = null;
        HttpSession session = request.getSession();
        String prevAction = (String) session.getAttribute("prevProjectAction");
        if (prevAction == null) {
            session.setAttribute("prevProjectAction", action);
            prevAction = action;

        }
        session.setAttribute("currProjectAction", action);
        String currAction = (String) session.getAttribute("currProjectAction");
        switch (action) {
            case "lecView":
                currSem = (Semester) session.getAttribute("currentSem");
                ProjectDAO proDao = new ProjectDAO();
                List<Project> proList = proDao.readAllProject(currSem.getSemesterId());

                //        pagination
                if (!prevAction.equals(currAction)) {
                    session.setAttribute("totalPage", null);
                    session.setAttribute("page", null);
                }
                session.setAttribute("prevProjectAction", "lecView");
                pagination(request, response, proList);
                //        pagination 

                request.getRequestDispatcher("/projectListLecturer.jsp").forward(request, response);
                break;
            case "search":
                currSem = (Semester) session.getAttribute("currentSem");
                proDao = new ProjectDAO();
                String searchText = request.getParameter("searchText");
                List<Project> proList1 = null;

                //        pagination
                String prevSearch = (String) session.getAttribute("prevProjectSearch");
                if (prevSearch == null) {
                    session.setAttribute("prevProjectSearch", searchText);
                    prevSearch = searchText;
                }
                session.setAttribute("currProjectSearch", searchText);
                String currSearch = (String) session.getAttribute("currProjectSearch");

                if (searchText == null) {
                    proList1 = proDao.readAllProject(currSem.getSemesterId());
                } else {
                    proList1 = proDao.searchByName(searchText, currSem.getSemesterId());
                }
                if (!prevAction.equals(currAction)) {
                    session.setAttribute("totalPage", null);
                    session.setAttribute("page", null);
                }
                session.setAttribute("prevProjectAction", "search");
                pagination(request, response, proList1);
                session.setAttribute("searchText", searchText);
                session.setAttribute("currProjectAction", "pagesearch");
                //        pagination

                request.getRequestDispatcher("/projectListLecturer.jsp").forward(request, response);
                break;
            case "pagesearch":
                searchText = (String) session.getAttribute("searchText");
                proDao = new ProjectDAO();
                currSem = (Semester) session.getAttribute("currentSem");
                if (searchText == null) {
                    proList1 = proDao.readAllProject(currSem.getSemesterId());
                } else {
                    proList1 = proDao.searchByName(searchText, currSem.getSemesterId());
                }
                pagination(request, response, proList1);
                session.setAttribute("prevProjectAction", "pagesearch");

                request.getRequestDispatcher("/projectListLecturer.jsp").forward(request, response);

                break;
        }

    }

    private void pagination(HttpServletRequest request, HttpServletResponse response, List<Project> list) {
        int pageSize = 5;//Kich thuoc trang                        
        //Xac dinh so thu tu cua trang hien tai

        HttpSession session = request.getSession();
        session.setAttribute("totalPage", null);
        Integer page = (Integer) session.getAttribute("page");
        if (page == null) {
            page = 1;
        }

        //Xac dinh tong so trang
        Integer totalPage = (Integer) session.getAttribute("totalPage");
        if (totalPage == null) {
            int count = list.size();//Dem so luong records
            totalPage = (int) Math.ceil((double) count / pageSize);//Tinh tong so trang
        }

        String op = request.getParameter("op");
        if (op == null) {
            op = "FirstPage";
        }
        switch (op) {
            case "FirstPage":
                page = 1;
                break;
            case "PreviousPage":
                if (page > 1) {
                    page--;
                }
                break;
            case "NextPage":
                if (page < totalPage) {
                    page++;
                }
                break;
            case "LastPage":
                page = totalPage;
                break;
            case "GotoPage":
                page = Integer.parseInt(request.getParameter("gotoPage"));
                if (page <= 0) {
                    page = 1;
                } else if (page > totalPage) {
                    page = totalPage;
                }
                break;
        }

        //Lay trang du lieu duoc yeu cau
        List slist;
        int n1 = (page - 1) * pageSize;
        int n2 = n1 + pageSize - 1;
        try {
            slist = list.subList(n1, n2 + 1);
        } catch (Exception e) {
            slist = list.subList(n1, list.size());
        }//Doc mot trang

        //Luu thong tin vao session va request
        session.setAttribute("page", page);
        session.setAttribute("totalPage", totalPage);
        request.setAttribute("proList", slist);
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
