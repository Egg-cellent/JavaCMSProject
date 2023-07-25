/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class MainController extends HttpServlet {
    private final static String ERROR="error.jsp";
    private final static String LOGIN="Login";
    private final static String LOGIN_CONTROLLER="LoginController";
    private final static String SEARCH="Search";
    private final static String SEARCH_CONTROLLER="SearchController";
    private final static String SEARCH_SL="Search So Luong";
    private final static String SEARCH_CONTROLLER_SL="SearchControllerSL";
    private final static String SEARCHDM="SearchDM";
    private final static String SEARCH_CONTROLLERDM="SearchControllerDM";
    private final static String LOGOUT="Logout";
    private final static String LOGOUT_CONTROLLER="LogoutController";
    private final static String DELETE="Delete";
    private final static String DELETE_CONTROLLER="DeleteController";
    private final static String DELETE_TK="Delete Tai Khoan";
    private final static String DELETE_CONTROLLER_TK="DeleteControllerTK";
    private final static String UPDATE="Update";
    private final static String UPDATE_CONTROLLER="UpdateController";
    private final static String UPDATE2="Update San Pham";
    private final static String UPDATE_CONTROLLER2="UpdateController2";
    private final static String UPDATE3="Update Tai Khoan";
    private final static String UPDATE_CONTROLLER3="UpdateController3";
    private final static String CREATE="Create";
    private final static String CREATE_CONTROLLER="CreateController";
    private final static String CREATE2="Create San Pham";
    private final static String CREATE_CONTROLLER2="CreateController2";
    private final static String GET_ALL="Get all";
    private final static String GET_ALL_CONTROLLER="GetAllController";
    private final static String GET_ALL2="Get San Pham";
    private final static String GET_ALL_CONTROLLER2="GetAllController2";
    private final static String GET_DM="Get Danh Muc";
    private final static String GET_DM_CONTROLLER="GetDMController";
    private final static String GET_NTK="Get Nhom Tai Khoan";
    private final static String GET_NTK_CONTROLLER="GetNhomTK";
    private final static String GET_TK="Get Tai Khoan";
    private final static String GET_TK_CONTROLLER="GetTaiKhoan";
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
        String url=ERROR;
        try {
            String action=request.getParameter("action");
            if(action==null){
                url=GET_ALL_CONTROLLER;
            }else if(LOGIN.equals(action)){
                url=LOGIN_CONTROLLER;
            }else if(SEARCH.equals(action)){
                url=SEARCH_CONTROLLER;
            }else if(SEARCH_SL.equals(action)){
                url=SEARCH_CONTROLLER_SL;
            }else if(SEARCHDM.equals(action)){
                url=SEARCH_CONTROLLERDM;
            }else if(LOGOUT.equals(action)){
                url=LOGOUT_CONTROLLER;
            }else if(DELETE.equals(action)){
                url=DELETE_CONTROLLER;
            }else if(DELETE_TK.equals(action)){
                url=DELETE_CONTROLLER_TK;
            }else if(UPDATE.equals(action)){
                url=UPDATE_CONTROLLER;
            }else if(UPDATE2.equals(action)){
                url=UPDATE_CONTROLLER2;
            }else if(UPDATE3.equals(action)){
                url=UPDATE_CONTROLLER3;
            }else if(CREATE.equals(action)){
                url=CREATE_CONTROLLER;
            }else if(CREATE2.equals(action)){
                url=CREATE_CONTROLLER2;
            }else if(GET_ALL.equals(action)){
                url=GET_ALL_CONTROLLER;
            }else if(GET_ALL2.equals(action)){
                url=GET_ALL_CONTROLLER2;
            }else if(GET_DM.equals(action)){
                url=GET_DM_CONTROLLER;
            }else if(GET_NTK.equals(action)){
                url=GET_NTK_CONTROLLER;
            }else if(GET_TK.equals(action)){
                url=GET_TK_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController:" + e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
