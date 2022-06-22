/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.StudentGroupDAO;
import DTO.StudentGroup;
import java.io.IOException;
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
 * @author SE161740 Pham Nguyen Hung Anh
 */
@WebServlet(name = "GroupController", urlPatterns = {"/group"})
public class GroupController extends HttpServlet {

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
        HttpSession session = request.getSession();
        StudentGroupDAO sg = new StudentGroupDAO();

        switch (action) {
            case "index":                              
                ArrayList<StudentGroup> list = sg.readAll();
//                request.setAttribute("list",list );
                pagination(request, response, list);
                request.getRequestDispatcher("/teamList.jsp").forward(request, response);
                break;
            case "search":
                String searchText = request.getParameter("searchText");
                if(searchText==null){
                    response.sendRedirect("/teamList.jsp");
                }
                ArrayList<StudentGroup> list2= sg.searchGroupByName(searchText);
                request.setAttribute("list", list2);
                request.setAttribute("searchText", searchText);
                request.getRequestDispatcher("/teamList.jsp").forward(request, response);
                break;
             case "filter":
                String filter = request.getParameter("filter");

                ArrayList<StudentGroup> list3 = sg.filterByDepartment(filter);
                if (filter.equals("Quan tri kinh doanh")) {
                    paginationQTKD(request, response, list3);
                } else if (filter.equals("Cong nghe thong tin")) {
                    paginationCNTT(request, response, list3);
                } else if (filter.equals("Ngon ngu Anh")) {
                    paginationNNA(request, response, list3);
                } else if (filter.equals("Ngon ngu Han Quoc")) {
                    paginationNNH(request, response, list3);
                } else if (filter.equals("Ngon ngu Nhat")) {
                    paginationNNN(request, response, list3);
                }
                request.setAttribute("filter", filter);
                session.setAttribute("pageFilter", filter);
                request.getRequestDispatcher("/teamList.jsp").forward(request, response);
                break;
            case "filter1":
                String pagefilter = (String) session.getAttribute("pageFilter");

                list3 = sg.filterByDepartment(pagefilter);
                if (pagefilter.equals("Quan tri kinh doanh")) {
                    paginationQTKD(request, response, list3);
                } else if (pagefilter.equals("Cong nghe thong tin")) {
                    paginationCNTT(request, response, list3);
                } else if (pagefilter.equals("Ngon ngu Anh")) {
                    paginationNNA(request, response, list3);
                } else if (pagefilter.equals("Ngon ngu Han Quoc")) {
                    paginationNNH(request, response, list3);
                } else if (pagefilter.equals("Ngon ngu Nhat")) {
                    paginationNNN(request, response, list3);
                }

                request.setAttribute("filter", pagefilter);
                request.getRequestDispatcher("/teamList.jsp").forward(request, response);
                break;
            case "create":
                //Hien form create de nhap du lieu (create --submit--> save)
                create(request, response);
                break;
            
        }
    }
    public void create(HttpServletRequest request, HttpServletResponse response) {
    }
    
     private void pagination(HttpServletRequest request, HttpServletResponse response, ArrayList<StudentGroup> list) {
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
            totalPage = (int) Math.ceil((double) count / pageSize );//Tinh tong so trang
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
        request.setAttribute("list", slist);
    }
     
     private void paginationQTKD(HttpServletRequest request, HttpServletResponse response, ArrayList<StudentGroup> list) {
        int pageSize = 5;//Kich thuoc trang                        
        //Xac dinh so thu tu cua trang hien tai
        HttpSession session = request.getSession();
        session.setAttribute("totalPageQTKD", null);
        Integer page = (Integer) session.getAttribute("pageQTKD");
        if (page == null) {
            page = 1;
        }

        //Xac dinh tong so trang
        Integer totalPage = (Integer) session.getAttribute("totalPageQTKD");
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
        session.setAttribute("pageQTKD", page);
        session.setAttribute("totalPageQTKD", totalPage);
        request.setAttribute("list", slist);
    }

    private void paginationCNTT(HttpServletRequest request, HttpServletResponse response, ArrayList<StudentGroup> list) {
        int pageSize = 5;//Kich thuoc trang                        
        //Xac dinh so thu tu cua trang hien tai
        HttpSession session = request.getSession();
        session.setAttribute("totalPageCNTT", null);
        Integer page = (Integer) session.getAttribute("pageCNTT");
        if (page == null) {
            page = 1;
        }

        //Xac dinh tong so trang
        Integer totalPage = (Integer) session.getAttribute("totalPageCNTT");
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
        session.setAttribute("pageCNTT", page);
        session.setAttribute("totalPageCNTT", totalPage);
        request.setAttribute("list", slist);
    }

    private void paginationNNA(HttpServletRequest request, HttpServletResponse response, ArrayList<StudentGroup> list) {
        int pageSize = 5;//Kich thuoc trang                        
        //Xac dinh so thu tu cua trang hien tai
        HttpSession session = request.getSession();
        session.setAttribute("totalPageNNA", null);
        Integer page = (Integer) session.getAttribute("pageNNA");
        if (page == null) {
            page = 1;
        }

        //Xac dinh tong so trang
        Integer totalPage = (Integer) session.getAttribute("totalPageNNA");
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
        session.setAttribute("pageNNA", page);
        session.setAttribute("totalPageNNA", totalPage);
        request.setAttribute("list", slist);
    }

    private void paginationNNH(HttpServletRequest request, HttpServletResponse response, ArrayList<StudentGroup> list) {
        int pageSize = 5;//Kich thuoc trang                        
        //Xac dinh so thu tu cua trang hien tai
        HttpSession session = request.getSession();
        session.setAttribute("totalPageNNH", null);
        Integer page = (Integer) session.getAttribute("pageNNH");
        if (page == null) {
            page = 1;
        }

        //Xac dinh tong so trang
        Integer totalPage = (Integer) session.getAttribute("totalPageNNH");
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
        session.setAttribute("pageNNH", page);
        session.setAttribute("totalPageNNH", totalPage);
        request.setAttribute("list", slist);
    }

    private void paginationNNN(HttpServletRequest request, HttpServletResponse response, ArrayList<StudentGroup> list) {
        int pageSize = 5;//Kich thuoc trang                        
        //Xac dinh so thu tu cua trang hien tai
        HttpSession session = request.getSession();
        session.setAttribute("totalPageNNN", null);
        Integer page = (Integer) session.getAttribute("pageNNN");
        if (page == null) {
            page = 1;
        }

        //Xac dinh tong so trang
        Integer totalPage = (Integer) session.getAttribute("totalPageNNN");
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
        session.setAttribute("pageNNN", page);
        session.setAttribute("totalPageNNN", totalPage);
        request.setAttribute("list", slist);
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
