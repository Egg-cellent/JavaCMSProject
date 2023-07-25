/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author user
 */
public class ProductDAO {

    private static final String GET_ALL = "SELECT "
            + "tblSanPham.masp,tblSanPham.tensp,tblSanPham.mota,tblSanPham.soluong,tblSanPham.dongia,tblSanPham.hinhanh,tblDanhMuc.trangthai,tblDanhMuc.madm "
            + "FROM tblSanPham right join tblDanhMuc on tblSanPham.madm=tblDanhMuc.madm";
    private static final String GET_PRODUCT = "SELECT "
            + "tblSanPham.masp,tblSanPham.tensp,tblSanPham.mota,tblSanPham.soluong,tblSanPham.dongia,tblSanPham.hinhanh,tblDanhMuc.trangthai,tblDanhMuc.madm "
            + "FROM tblSanPham right join tblDanhMuc on tblSanPham.madm=tblDanhMuc.madm where tblSanPham.tensp like ?";
    private static final String GET_PRODUCT_DM = "SELECT "
            + "tblSanPham.masp,tblSanPham.tensp,tblSanPham.mota,tblSanPham.soluong,tblSanPham.dongia,tblSanPham.hinhanh,tblDanhMuc.trangthai,tblDanhMuc.madm "
            + "FROM tblSanPham right join tblDanhMuc on tblSanPham.madm=tblDanhMuc.madm where tblDanhMuc.madm = ?";
    private static final String DELETE = "DELETE "
            + "FROM tblSanPham WHERE masp= ?";
    private static final String UPDATE = "UPDATE "
            + "tblSanPham SET tensp=? , mota=? , soluong=? , dongia=? , hinhanh=? WHERE masp=?";
    private static final String INSERT = "INSERT INTO "
            + "tblSanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm) VALUES(?,?,?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE = "SELECT "
            + "tensp FROM tblSanPham WHERE masp=?";

    public List<Product> getListProduct() throws SQLException {
        List listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String masp = rs.getString("masp");
                    String tensp = rs.getString("tensp");
                    String mota = rs.getString("mota");
                    int soluong = Integer.parseInt(rs.getString("soluong"));
                    float dongia = Float.parseFloat(rs.getString("dongia"));
                    String hinhanh = rs.getString("hinhanh");
                    boolean trangthai = rs.getBoolean("trangthai");
                    String madm = rs.getString("madm");
                    listProduct.add(new Product(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm));
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
        return listProduct;
    }

    public List<Product> getProduct(String tenspSearch) throws SQLException {
        Product p = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<Product> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PRODUCT);
                ptm.setString(1, "%" + tenspSearch + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String masp = rs.getString("masp");
                    String tensp = rs.getString("tensp");
                    String mota = rs.getString("mota");
                    int soluong = Integer.parseInt(rs.getString("soluong"));
                    float dongia = Float.parseFloat(rs.getString("dongia"));
                    String hinhanh = rs.getString("hinhanh");
                    boolean trangthai = rs.getBoolean("trangthai");
                    String madm = rs.getString("madm");

                    p = new Product(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm);
                    list.add(p);
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

    public List<Product> getProductDM(String madmSearch) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<Product> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PRODUCT_DM);
                ptm.setString(1, madmSearch);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String masp = rs.getString("masp");
                    String tensp = rs.getString("tensp");
                    String mota = rs.getString("mota");
                    int soluong = Integer.parseInt(rs.getString("soluong"));
                    float dongia = Float.parseFloat(rs.getString("dongia"));
                    String hinhanh = rs.getString("hinhanh");
                    boolean trangthai = rs.getBoolean("trangthai");
                    String madm = rs.getString("madm");

                    list.add(new Product(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm));
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

    public boolean delete(String masp) throws SQLException {
        boolean checkDelete = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, masp);
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

    public boolean update(Product sp) throws SQLException {
        boolean checkUpdate = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, sp.getTensp());
                ptm.setString(2, sp.getMota());
                ptm.setInt(3, sp.getSoluong());
                ptm.setFloat(4, sp.getDongia());
                ptm.setString(5, sp.getHinhanh());
                ptm.setString(6, sp.getMasp());

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

    public boolean insert(Product sp) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, sp.getMasp());
                ptm.setString(2, sp.getTensp());
                ptm.setString(3, sp.getMota());
                ptm.setInt(4, sp.getSoluong());
                ptm.setFloat(5, sp.getDongia());
                ptm.setString(6, sp.getHinhanh());
                ptm.setBoolean(7, sp.isTrangthai());
                ptm.setString(8, sp.getMadm());

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

    public boolean checkDuplicate(String masp) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, masp);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

}
