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
public class NhaCungCap implements Serializable {
    private String mancc, ten, diachi, sdt;

    public NhaCungCap() {
    }

    public NhaCungCap(String mancc, String ten, String diachi, String sdt) {
        this.mancc = mancc;
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String mancc) {
        this.mancc = mancc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
