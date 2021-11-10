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
public class PhieuTra implements Serializable {
    private int id;
    private List<LuotTra> dsLuotTra;
    private float tongtienphat;
    private NVThuVien nguoiin;

    public PhieuTra() {
    }

    public PhieuTra(List<LuotTra> dsLuotTra, float tongtienphat, NVThuVien nguoiin) {
        this.dsLuotTra = dsLuotTra;
        this.tongtienphat = tongtienphat;
        this.nguoiin = nguoiin;
    }

    public PhieuTra(int id, List<LuotTra> dsLuotTra, float tongtienphat, NVThuVien nguoiin) {
        this.id = id;
        this.dsLuotTra = dsLuotTra;
        this.tongtienphat = tongtienphat;
        this.nguoiin = nguoiin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<LuotTra> getDsLuotTra() {
        return dsLuotTra;
    }

    public void setDsLuotTra(List<LuotTra> dsLuotTra) {
        this.dsLuotTra = dsLuotTra;
    }

    public float getTongtienphat() {
        return tongtienphat;
    }

    public void setTongtienphat(float tongtienphat) {
        this.tongtienphat = tongtienphat;
    }

    public NVThuVien getNguoiin() {
        return nguoiin;
    }

    public void setNguoiin(NVThuVien nguoiin) {
        this.nguoiin = nguoiin;
    }
    
    
}
