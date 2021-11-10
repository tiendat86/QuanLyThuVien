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
public class LuotTra implements Serializable {
    private Date ngaytra;
    private String mota;
    private float tienphat;
    private int tonthat;
    private LuotMuon luotMuon;

    public LuotTra() {
    }

    public LuotTra(Date ngaytra, String mota, float tienphat, int tonthat) {
        this.ngaytra = ngaytra;
        this.mota = mota;
        this.tienphat = tienphat;
        this.tonthat = tonthat;
    }

    public LuotTra(Date ngaytra, String mota, float tienphat, int tonthat, LuotMuon luotMuon) {
        this.ngaytra = ngaytra;
        this.mota = mota;
        this.tienphat = tienphat;
        this.tonthat = tonthat;
        this.luotMuon = luotMuon;
    }

    public LuotMuon getLuotMuon() {
        return luotMuon;
    }

    public void setLuotMuon(LuotMuon luotMuon) {
        this.luotMuon = luotMuon;
    }

    public Date getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(Date ngaytra) {
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
    
    
}
