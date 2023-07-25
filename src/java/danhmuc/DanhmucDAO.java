/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhmuc;

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
public class DanhmucDAO {

    private static final String GET_ALL_DM = "SELECT * "
            + "FROM tblDanhMuc";
    private static final String DELETE = "DELETE "
            + "FROM tblDanhMuc WHERE madm= ?";
    private static final String UPDATE = "UPDATE "
            + "tblDanhMuc SET tendm=? WHERE madm=?";
    private static final String INSERT = "INSERT INTO "
            + "tblDanhMuc(madm, tendm, trangthai) VALUES(?,?,?)";
    private static final String CHECK_DUPLICATE = "SELECT "
            + "tensp FROM tblDanhMuc WHERE madm=?";
    
    public List<Danhmuc> getListDM() throws SQLException {
        Product p = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<Danhmuc> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL_DM);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String madm = rs.getString("madm");
                    String tendm = rs.getString("tendm");
                    boolean trangthai = rs.getBoolean("trangthai");
                    list.add(new Danhmuc(madm, tendm, trangthai));
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

    public boolean delete(String madm) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, madm);
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

    public boolean update(String tendm, String madm) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, tendm);
                ptm.setString(2, madm);
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

    public boolean insert(Danhmuc dm) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, dm.getMadm());
                ptm.setString(2, dm.getTendm());
                ptm.setBoolean(3, dm.isTrangthai());
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
    
    public boolean checkDuplicate(String madm) throws SQLException {
        boolean check=false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, madm);
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
