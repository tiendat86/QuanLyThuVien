package model;

public class TKNhaCungCap {
    private NhaCungCap nhaCungCap;
    private int soluongnhap;

    public TKNhaCungCap(NhaCungCap nhaCungCap, int soluongnhap) {
        this.nhaCungCap = nhaCungCap;
        this.soluongnhap = soluongnhap;
    }

    public TKNhaCungCap() {
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public int getSoluongnhap() {
        return soluongnhap;
    }

    public void setSoluongnhap(int soluongnhap) {
        this.soluongnhap = soluongnhap;
    }
}
