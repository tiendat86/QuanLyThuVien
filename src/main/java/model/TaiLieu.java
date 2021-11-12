/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Tien Dat
 */
public class TaiLieu implements Serializable {
    private String matl, ten, tacgia, nxb;
    private int soluong;
    private float gia;
    private String anh;

    public TaiLieu() {
    }

    public TaiLieu(String matl, String ten, float gia, String tacgia, String nxb, int soluong) {
        this.matl = matl;
        this.ten = ten;
        this.gia = gia;
        this.tacgia = tacgia;
        this.nxb = nxb;
        this.soluong = soluong;
    }

    public TaiLieu(String matl, String ten, float gia, String tacgia, String nxb, int soluong, String anh) {
        this.matl = matl;
        this.ten = ten;
        this.tacgia = tacgia;
        this.nxb = nxb;
        this.soluong = soluong;
        this.gia = gia;
        this.anh = anh;
    }

    public TaiLieu(String string, String string0, float aFloat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getMatl() {
        return matl;
    }

    public void setMatl(String matl) {
        this.matl = matl;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    
    
}
