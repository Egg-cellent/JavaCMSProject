/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhmuc;

/**
 *
 * @author user
 */
public class Danhmuc {
    private String madm;
    private String tendm;
    private boolean trangthai;

    public Danhmuc() {
    }

    public Danhmuc(String madm, String tendm, boolean trangthai) {
        this.madm = madm;
        this.tendm = tendm;
        this.trangthai = trangthai;
    }

    public String getMadm() {
        return madm;
    }

    public void setMadm(String madm) {
        this.madm = madm;
    }

    public String getTendm() {
        return tendm;
    }

    public void setTendm(String tendm) {
        this.tendm = tendm;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }
    
}
