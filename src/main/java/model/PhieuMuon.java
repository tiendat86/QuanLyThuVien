/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tien Dat
 */
public class PhieuMuon implements Serializable {
    private int id;
    private List<LuotMuon> listLuotMuon;
    private LocalDate ngayin;
    private NVThuVien nguoiin;

    public PhieuMuon() {
    }

    public PhieuMuon(List<LuotMuon> listLuotMuon, LocalDate ngayin, NVThuVien nguoiin) {
        this.listLuotMuon = listLuotMuon;
        this.ngayin = ngayin;
        this.nguoiin = nguoiin;
    }

    public PhieuMuon(int id, List<LuotMuon> listLuotMuon, LocalDate ngayin, NVThuVien nguoiin) {
        this.id = id;
        this.listLuotMuon = listLuotMuon;
        this.ngayin = ngayin;
        this.nguoiin = nguoiin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<LuotMuon> getListLuotMuon() {
        return listLuotMuon;
    }

    public void setListLuotMuon(List<LuotMuon> listLuotMuon) {
        this.listLuotMuon = listLuotMuon;
    }

    public LocalDate getNgayin() {
        return ngayin;
    }

    public void setNgayin(LocalDate ngayin) {
        this.ngayin = ngayin;
    }

    public NVThuVien getNguoiin() {
        return nguoiin;
    }

    public void setNguoiin(NVThuVien nguoiin) {
        this.nguoiin = nguoiin;
    }

}
