/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import danhmuc.DanhmucDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import product.ProductDAO;
import user.UserDTO;

/**
 *
 * @author user
 */
public class DeleteController extends HttpServlet {

    private static final String ERROR = "admin.jsp";

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
        String url = ERROR;
        try {
            boolean result = false;
            String madm = request.getParameter("madm");
            String masp = request.getParameter("masp");
            String type = request.getParameter("type");

            DanhmucDAO daoDm = new DanhmucDAO();
            ProductDAO daoSp = new ProductDAO();

            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            String tentk = user.getTentk();

            if (type.equals("danhmuc")) {
                if (tentk.contains("admin")) {
                    result = daoDm.delete(madm);
                    if (result) {
                        url = "MainController?action=Get Danh Muc";
                    }
                }else request.setAttribute("recode", "TENTK NOT CONTAIN ADMIN");

            }
            if (type.equals("sanpham")) {
                if (tentk.contains("admin")) {
                    result = daoSp.delete(masp);
                    if (result) {
                        url = "MainController?action=Get San Pham";
                    }
                }else request.setAttribute("recode", "TENTK NOT CONTAIN ADMIN");

            }

        } catch (Exception e) {
            log("Error at DeleteController: " + e.toString());
        } finally {
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
