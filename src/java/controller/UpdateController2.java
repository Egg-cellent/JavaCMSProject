/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import danhmuc.DanhmucDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import product.Product;
import product.ProductDAO;

/**
 *
 * @author user
 */
public class UpdateController2 extends HttpServlet {

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
            boolean checkUpdate = false;
            String type = request.getParameter("type");
            String masp = request.getParameter("masp");
            String tensp = request.getParameter("tensp");
            String mota = request.getParameter("mota");
            int soluong = Integer.parseInt(request.getParameter("soluong"));
            float dongia = Float.parseFloat(request.getParameter("dongia"));
            String hinhanh = request.getParameter("hinhanh");
            Boolean trangthai = Boolean.parseBoolean(request.getParameter("trangthai"));
            String madm = request.getParameter("madm");

            ProductDAO daoSp = new ProductDAO();
            Product sp = new Product(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm);

            if (type.equals("sanpham")) {
                checkUpdate = daoSp.update(new Product(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm));
                if (checkUpdate) {
                    url = "MainController?action=Get San Pham";
                }
            }

        } catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
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
