/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taikhoan;

/**
 *
 * @author user
 */
public class TaiKhoan {
    private String tentk;
    private String matkhau;
    private boolean trangthai;
    private String email;
    private String nhomtk;

    public TaiKhoan() {
    }

    public TaiKhoan(String tentk, String matkhau, boolean trangthai, String email, String nhomtk) {
        this.tentk = tentk;
        this.matkhau = matkhau;
        this.trangthai = trangthai;
        this.email = email;
        this.nhomtk = nhomtk;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNhomtk() {
        return nhomtk;
    }

    public void setNhomtk(String nhomtk) {
        this.nhomtk = nhomtk;
    }
    
}
