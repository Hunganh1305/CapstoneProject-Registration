/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.GroupsDAO;
import DAO.SemesterDAO;
import DAO.StudentGroupDAO;
import DAO.UserDAO;
import DTO.Groups;
import DTO.Semester;
import DTO.StudentGroup;
import DTO.Users;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Semester currSem = null;
        StudentGroupDAO sg = new StudentGroupDAO();
        
        //        pagination
        String prevAction = (String) session.getAttribute("prevGroupAction");
        if (prevAction == null) {
            session.setAttribute("prevGroupAction", action);
            prevAction = action;
        }
        session.setAttribute("currTGroupAction", action);
        String currAction = (String) session.getAttribute("currTGroupAction");
//        pagination
        switch (action) {
            case "index":
                currSem = (Semester) session.getAttribute("currentSem");
                ArrayList<StudentGroup> list = sg.readAll(currSem.getName());
                                
                //        pagination
                if (!prevAction.equals(currAction)) {
                    session.setAttribute("totalPage", null);
                    session.setAttribute("page", null);
                }
                session.setAttribute("prevGroupAction", "index");
                pagination(request, response, list);
                //        pagination 
                
                request.getRequestDispatcher("/teamList.jsp").forward(request, response);
                break;
            case "search":
                currSem = (Semester) session.getAttribute("currentSem");
                String searchText = request.getParameter("searchText");
                ArrayList<StudentGroup> list2 = null;
                if (searchText == null) {
                    list2 = sg.readAll(currSem.getName());
                } else {
                    list2 = sg.searchGroupByName(searchText, currSem.getName());
                }
                session.setAttribute("prevGroupAction", "search");
                pagination(request, response, list2);
                //        pagination
                
                request.setAttribute("searchText", searchText);
                request.getRequestDispatcher("/teamList.jsp").forward(request, response);
                break;
            case "filter":
                currSem = (Semester) session.getAttribute("currentSem");
                String filter = request.getParameter("filter");
                
                //        pagination
                String prevFilter = (String) session.getAttribute("prevGroupFilter");
                if (prevFilter == null) {
                    session.setAttribute("prevGroupFilter", filter);
                    prevFilter = filter;
                }
                session.setAttribute("currGroupFilter", filter);
                String currFilter = (String) session.getAttribute("currGroupFilter");
                
                ArrayList<StudentGroup> list3 = sg.filterByDepartment(filter, currSem.getName());
                if (!prevAction.equals(currAction) || !prevFilter.equals(currFilter)) {
                    session.setAttribute("totalPage", null);
                    session.setAttribute("page", null);
                }
                switch (currFilter) {
                    case "Cong nghe thong tin":
                        session.setAttribute("prevGroupFilter", "Cong nghe thong tin");
                        break;
                    case "Quan tri kinh doanh":
                        session.setAttribute("prevGroupFilter", "Quan tri kinh doanh");
                        break;
                    case "Ngon ngu Anh":
                        session.setAttribute("prevGroupFilter", "Ngon ngu Anh");
                        break;
                    case "Ngon ngu Nhat":
                        session.setAttribute("prevGroupFilter", "Ngon ngu Nhat");
                        break;
                    case "Ngon ngu Han Quoc":
                        session.setAttribute("prevGroupFilter", "Ngon ngu Han Quoc");
                        break;
                }
                pagination(request, response, list3);
                request.setAttribute("filter", filter);
                session.setAttribute("prevGroupFilter", "filter");
                session.setAttribute("currGroupAction", "pagefilter");
                //        pagination
                request.getRequestDispatcher("/teamList.jsp").forward(request, response);
                break;
            case "pagefilter":
                filter = (String) session.getAttribute("prevGroupFilter");
                currSem = (Semester) session.getAttribute("currentSem");
                list3 = sg.filterByDepartment(filter, currSem.getName());
                pagination(request, response, list3);                 
                session.setAttribute("prevGroupAction", "pagefilter");
                request.getRequestDispatcher("/teamList.jsp").forward(request, response);
                break;

            case "detail":
                int id = Integer.parseInt(request.getParameter("id"));

                ArrayList<StudentGroup> teamMembers = sg.viewTeamMembers(id);

                StudentGroup teamInfor = sg.viewTeamInformation(id);
                request.setAttribute("teamMembers", teamMembers);
                request.setAttribute("teamInfor", teamInfor);
                request.getRequestDispatcher("/teamDetail.jsp").forward(request, response);
                break;
            case "semester":
                String semester = request.getParameter("semester");
                SemesterDAO sem = new SemesterDAO();
                Semester currentSem = sem.read(semester);
                session.setAttribute("currentSem", currentSem);
                ArrayList<StudentGroup> list4 = sg.readAll(currentSem.getName());

                ArrayList<Semester> semList = (ArrayList<Semester>) session.getAttribute("semList");

                //        pagination
                String prevSemName = (String) session.getAttribute("prevGroupSemester");
                if (prevSemName == null) {
                    session.setAttribute("prevGroupSemester", semester);
                    prevSemName = semester;
                }
                session.setAttribute("currGroupSemester", semester);
                String currSemName = (String) session.getAttribute("currGroupSemester");
                if (!prevAction.equals(currAction) || !prevSemName.equals(currSemName)) {
                    session.setAttribute("totalPage", null);
                    session.setAttribute("page", null);
                }
                for (int i = 0; i < semList.size(); i++) {
                    if (currSemName.equals(semList.get(i).name)) {
                        session.setAttribute("prevGroupSemester", semList.get(i).name);
                    }
                }
                session.setAttribute("prevGroupAction", "semester");
                session.setAttribute("currGroupAction", "pagesemester");
                pagination(request, response, list4);
                //        pagination
                
                request.getRequestDispatcher("/teamList.jsp").forward(request, response);
                break;
            case "pagesemester":
                currSem = (Semester) session.getAttribute("currentSem");
                list4 = sg.readAll(currSem.getName());
                pagination(request, response, list4);
                session.setAttribute("prevGroupcAction", "pagesemester");
                request.getRequestDispatcher("/teamList.jsp").forward(request, response);
                break;
            case "create":
                //Hien form create de nhap du lieu (create --submit--> save)
                int Stuid = Integer.parseInt(request.getParameter("id"));
                StudentGroup depName = sg.readDepNameByUserId(Stuid);
                request.setAttribute("depName", depName);
                request.getRequestDispatcher("/createTeam.jsp").forward(request, response);
                break;
            case "save":
                //Luu toy vao db
                save(request, response);
                break;

        }
    }

    public void save(HttpServletRequest request, HttpServletResponse response) {
        GroupsDAO gr = new GroupsDAO();
        UserDAO u = new UserDAO();
        StudentGroupDAO sg = new StudentGroupDAO();
        Users user = null;
        HttpSession session = request.getSession();
        try {
            String op = request.getParameter("op");
            if (op.equals("save")) {

                String name = request.getParameter("groupName");
                int members = Integer.parseInt(request.getParameter("members"));
                int groupStatus = Integer.parseInt(request.getParameter("groupStatus"));
                Groups groups = new Groups(1, name, members, groupStatus, members);
                gr.create(groups);

//                session.getAttribute("userId");   studentID
//           group.groupId());    groupID
//             StudentGroup stugru = new StudentGroup("id", "studentID", "groupID", "leaderStatus");
//             sg.create(studentGroup);
            }
            //Quay ve view index (redirect to index view)
//            index(request, response);
            request.setAttribute("action", "index");
        } catch (Exception ex) {
            Logger.getLogger(GroupController.class.getName()).log(Level.SEVERE, null, ex);
            //Chi hien lai view create va thong bao loi
            request.setAttribute("action", "create");
            request.setAttribute("errorMessage", "Invalid data.");
        }
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
