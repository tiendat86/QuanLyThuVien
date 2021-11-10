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
public class NVQuanLi implements Serializable {
    private String bophan;
    private NguoiDung nguoiDung;

    public NVQuanLi() {
    }

    public NVQuanLi(String bophan, NguoiDung nguoiDung) {
        this.bophan = bophan;
        this.nguoiDung = nguoiDung;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }
    
    public String getBophan() {
        return bophan;
    }

    public void setBophan(String bophan) {
        this.bophan = bophan;
    }
}
