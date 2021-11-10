/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Tien Dat
 */
public class LuotMuon implements Serializable {
    private int id;
    private TaiLieu taiLieu;
    private TheBanDoc theBanDoc;
    private LocalDate ngaymuon, ngayphaitra;
    private String mota;

    public LuotMuon() {
    }

    public LuotMuon(TaiLieu taiLieu, TheBanDoc theBanDoc, LocalDate ngaymuon, LocalDate ngayphaitra, String mota) {
        this.taiLieu = taiLieu;
        this.theBanDoc = theBanDoc;
        this.ngaymuon = ngaymuon;
        this.ngayphaitra = ngayphaitra;
        this.mota = mota;
    }
    
    public LuotMuon(int id, TaiLieu taiLieu, TheBanDoc theBanDoc, LocalDate ngaymuon, LocalDate ngayphaitra, String mota) {
        this.id = id;
        this.taiLieu = taiLieu;
        this.theBanDoc = theBanDoc;
        this.ngaymuon = ngaymuon;
        this.ngayphaitra = ngayphaitra;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaiLieu getTaiLieu() {
        return taiLieu;
    }

    public void setTaiLieu(TaiLieu taiLieu) {
        this.taiLieu = taiLieu;
    }

    public TheBanDoc getTheBanDoc() {
        return theBanDoc;
    }

    public void setTheBanDoc(TheBanDoc theBanDoc) {
        this.theBanDoc = theBanDoc;
    }

    public LocalDate getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(LocalDate ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public LocalDate getNgayphaitra() {
        return ngayphaitra;
    }

    public void setNgayphaitra(LocalDate ngayphaitra) {
        this.ngayphaitra = ngayphaitra;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
}
