/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Tien Dat
 */
public class HoaDon implements Serializable {
    private int id;
    private double tongtien;
    private int tongsoluong;
    private List<LuotNhap> dsluotnhap;
    private NVThuVien nguoiin;

    public HoaDon() {
    }

    public HoaDon(int id, double tongtien, int tongsoluong, List<LuotNhap> dsluotnhap, NVThuVien nguoiin) {
        this.id = id;
        this.tongtien = tongtien;
        this.tongsoluong = tongsoluong;
        this.dsluotnhap = dsluotnhap;
        this.nguoiin = nguoiin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public int getTongsoluong() {
        return tongsoluong;
    }

    public void setTongsoluong(int tongsoluong) {
        this.tongsoluong = tongsoluong;
    }

    public List<LuotNhap> getDsluotnhap() {
        return dsluotnhap;
    }

    public void setDsluotnhap(List<LuotNhap> dsluotnhap) {
        this.dsluotnhap = dsluotnhap;
    }

    public NVThuVien getNguoiin() {
        return nguoiin;
    }

    public void setNguoiin(NVThuVien nguoiin) {
        this.nguoiin = nguoiin;
    }
    
}
