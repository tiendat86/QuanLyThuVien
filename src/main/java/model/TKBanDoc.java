package model;

import java.io.Serializable;

public class TKBanDoc implements Serializable {
    private TheBanDoc theBanDoc;
    private int soluong;

    public TKBanDoc() {
    }

    public TKBanDoc(TheBanDoc theBanDoc, int soluong) {
        this.theBanDoc = theBanDoc;
        this.soluong = soluong;
    }

    public TheBanDoc getTheBanDoc() {
        return theBanDoc;
    }

    public void setTheBanDoc(TheBanDoc theBanDoc) {
        this.theBanDoc = theBanDoc;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
