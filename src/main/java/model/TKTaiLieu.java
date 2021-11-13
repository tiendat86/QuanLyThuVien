package model;

import java.io.Serializable;

public class TKTaiLieu implements Serializable {
    private TaiLieu taiLieu;
    private int soluong;

    public TKTaiLieu() {
    }

    public TKTaiLieu(TaiLieu taiLieu, int soluong) {
        this.taiLieu = taiLieu;
        this.soluong = soluong;
    }

    public TaiLieu getTaiLieu() {
        return taiLieu;
    }

    public void setTaiLieu(TaiLieu taiLieu) {
        this.taiLieu = taiLieu;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
