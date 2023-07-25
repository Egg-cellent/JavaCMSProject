/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhomtaikhoan;

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
public class NhomTKDAO {
    private static final String GET_ALL_NTK = "SELECT * "
            + "FROM tblNhomTaiKhoan";
    private static final String DELETE = "DELETE "
            + "FROM tblNhomTaiKhoan WHERE nhomtk= ?";
    private static final String UPDATE = "UPDATE "
            + "tblNhomTaiKhoan SET mota=? WHERE nhomtk=?";
    private static final String INSERT = "INSERT INTO "
            + "tblNhomTaiKhoan(nhomtk, mota, trangthai) VALUES(?,?,?)";
    private static final String CHECK_DUPLICATE = "SELECT "
            + "mota FROM tblNhomTaiKhoan WHERE nhomtk=?";
    
    public List<NhomTaiKhoan> getListNTK() throws SQLException {
        Product p = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<NhomTaiKhoan> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL_NTK);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String nhomtk = rs.getString("nhomtk");
                    String mota = rs.getString("mota");
                    boolean trangthai = rs.getBoolean("trangthai");
                    
                    list.add(new NhomTaiKhoan(nhomtk, mota, trangthai));
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

    public boolean delete(String nhomtk) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, nhomtk);
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

    public boolean update(String tendm, String nhomtk) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, tendm);
                ptm.setString(2, nhomtk);
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

    public boolean insert(NhomTaiKhoan ntk) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, ntk.getNhomtk());
                ptm.setString(2, ntk.getMota());
                ptm.setBoolean(3, ntk.isTrangthai());
                check = ptm.executeUpdate() > 0 ? true : false;
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
        return check;
    }
    
    public boolean checkDuplicate(String nhomtk) throws SQLException {
        boolean check=false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, nhomtk);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check=true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return check;
    }
}
