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
public class TheBanDoc implements Serializable {
    private String mathe, loaithe;
    private BanDoc banDoc;

    public TheBanDoc() {
    }

    public TheBanDoc(String mathe, String loaithe) {
        this.mathe = mathe;
        this.loaithe = loaithe;
    }

    public TheBanDoc(String mathe, String loaithe, BanDoc banDoc) {
        this.mathe = mathe;
        this.loaithe = loaithe;
        this.banDoc = banDoc;
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }


    public String getMathe() {
        return mathe;
    }

    public void setMathe(String mathe) {
        this.mathe = mathe;
    }

    public String getLoaithe() {
        return loaithe;
    }

    public void setLoaithe(String loaithe) {
        this.loaithe = loaithe;
    }
    
}
