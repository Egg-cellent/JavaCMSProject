/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taikhoan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import product.Product;
import utils.DBUtils;

/**
 *
 * @author user
 */
public class TaiKhoanDAO {

    private static final String GET_ALL_TK = "SELECT * "
            + "FROM tblTaiKhoan";
    private static final String DELETE = "DELETE "
            + "FROM tblTaiKhoan WHERE tentk= ?";
    private static final String UPDATE = "UPDATE "
            + "tblTaiKhoan SET matkhau=? WHERE tentk=?";

    public List<TaiKhoan> getListTK() throws SQLException {
        Product p = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<TaiKhoan> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL_TK);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String tentk = rs.getString("tentk");
                    String matkhau = rs.getString("matkhau");
                    boolean trangthai = rs.getBoolean("trangthai");
                    String email = rs.getString("email");
                    String nhomtk = rs.getString("nhomtk");

                    list.add(new TaiKhoan(tentk, matkhau, trangthai, email, nhomtk));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean delete(String tentk) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, tentk);
                checkDelete = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkDelete;
    }

    public boolean update(String matkhau, String tentk) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, matkhau);
                ptm.setString(2, tentk);

                checkUpdate = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkUpdate;
    }
}
