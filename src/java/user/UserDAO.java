/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author user
 */
public class UserDAO {
    
    private static final String LOGIN = "SELECT "
            + "tblTaiKhoan.trangthai, tblTaiKhoan.email, tblTaiKhoan.nhomtk "
            + "FROM tblTaiKhoan right join tblNhomTaiKhoan on tblTaiKhoan.nhomtk=tblNhomTaiKhoan.nhomtk WHERE tentk=? AND matkhau=?";
    private static final String SEARCH = "SELECT userID, fullName, roleID FROM tblUsers WHERE fullName like ?";
    private static final String DELETE = "DELETE tblUsers WHERE UserID=?";
    private static final String UPDATE = "UPDATE tblUsers SET fullName=?, roleID=? WHERE userID=?";
    private static final String CHECK_DUPLICATE = "SELECT fullName FROM tblUsers WHERE userID=?";
    private static final String INSERT = "INSERT INTO tblUsers(userID, fullName, roleID, password) VALUES(?,?,?,?)";
    
    public UserDTO checkLogin(String tentk, String matkhau) throws SQLException {
        UserDTO loginUser = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, tentk);
                ptm.setString(2, matkhau);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    boolean trangthai=Boolean.parseBoolean(rs.getString("trangthai"));
                    String email = rs.getString("email");
                    String nhomtk = rs.getString("nhomtk");
                    loginUser = new UserDTO(tentk, matkhau, trangthai, email, nhomtk);
                }
            }
        } catch (Exception e) {
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
        return loginUser;
    }
}
