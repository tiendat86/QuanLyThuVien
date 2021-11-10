/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Tien Dat
 */
public class LuotNhap implements Serializable {
    private NhaCungCap ncc;
    private TaiLieu tailieu;
    private int soluong;
    private float gia;
    private Date ngaynhap;
    private int id;

    public LuotNhap() {
    }

    public LuotNhap(NhaCungCap ncc, TaiLieu tailieu, int soluong, float gia, Date ngaynhap) {
        this.ncc = ncc;
        this.tailieu = tailieu;
        this.soluong = soluong;
        this.gia = gia;
        this.ngaynhap = ngaynhap;
    }

    public LuotNhap(NhaCungCap ncc, TaiLieu tailieu, int soluong, float gia, Date ngaynhap, int id) {
        this.ncc = ncc;
        this.tailieu = tailieu;
        this.soluong = soluong;
        this.gia = gia;
        this.ngaynhap = ngaynhap;
        this.id = id;
    }

    public NhaCungCap getNcc() {
        return ncc;
    }

    public void setNcc(NhaCungCap ncc) {
        this.ncc = ncc;
    }

    public TaiLieu getTailieu() {
        return tailieu;
    }

    public void setTailieu(TaiLieu tailieu) {
        this.tailieu = tailieu;
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

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
