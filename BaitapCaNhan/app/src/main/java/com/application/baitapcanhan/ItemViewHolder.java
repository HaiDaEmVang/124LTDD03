package com.application.baitapcanhan;

public class ItemViewHolder {
    private String ten;
    private String mota;
    private String hinhAnh;

    public ItemViewHolder(String ten, String mota, String hinhAnh) {
        this.ten = ten;
        this.mota = mota;
        this.hinhAnh = hinhAnh;
    }

    public ItemViewHolder() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
