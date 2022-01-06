/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Tien Dat
 */
public class LuotTra implements Serializable {
    private LocalDate ngaytra;
    private String mota;
    private float tienphat;
    private int tonthat;
    private LuotMuon luotMuon;
    private int ngayMuon;

    public LuotTra() {
    }

    public LuotTra(LocalDate ngaytra, String mota, float tienphat, int tonthat) {
        this.ngaytra = ngaytra;
        this.mota = mota;
        this.tienphat = tienphat;
        this.tonthat = tonthat;
    }

    public LuotTra(LocalDate ngaytra, String mota, float tienphat, int tonthat, LuotMuon luotMuon) {
        this.ngaytra = ngaytra;
        this.mota = mota;
        this.tienphat = tienphat;
        this.tonthat = tonthat;
        this.luotMuon = luotMuon;
    }

    public LuotTra(LocalDate ngaytra, String mota, float tienphat, int tonthat, LuotMuon luotMuon, int ngayMuon) {
        this.ngaytra = ngaytra;
        this.mota = mota;
        this.tienphat = tienphat;
        this.tonthat = tonthat;
        this.luotMuon = luotMuon;
        this.ngayMuon = ngayMuon;
    }

    public LuotMuon getLuotMuon() {
        return luotMuon;
    }

    public void setLuotMuon(LuotMuon luotMuon) {
        this.luotMuon = luotMuon;
    }

    public LocalDate getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(LocalDate ngaytra) {
        this.ngaytra = ngaytra;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public float getTienphat() {
        return tienphat;
    }

    public void setTienphat(float tienphat) {
        this.tienphat = tienphat;
    }

    public int getTonthat() {
        return tonthat;
    }

    public void setTonthat(int tonthat) {
        this.tonthat = tonthat;
    }

    public int getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(int ngayMuon) {
        this.ngayMuon = ngayMuon;
    }
}
