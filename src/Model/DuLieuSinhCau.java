package Model;

import java.time.LocalDate;

public class DuLieuSinhCau {
    private String id;
    private LocalDate ngay;
    private String coCauDoanhNghiep;
    private String sucKhoeTaiChinh;
    private String no;
    private String khaNangTangTruong;
    private String khoiLuong;
    private String thayDoiGia;
    private String nhanDinhGia;

    public DuLieuSinhCau() {
        this("", null, "", "", "", "", "", "", "");
    }

    public DuLieuSinhCau(String id, LocalDate ngay, String coCauDoanhNghiep, String sucKhoeTaiChinh, String no, String khaNangTangTruong, String khoiLuong, String thayDoiGia, String nhanDinhGia) {
        this.id = id;
        this.ngay = ngay;
        this.coCauDoanhNghiep = coCauDoanhNghiep;
        this.sucKhoeTaiChinh = sucKhoeTaiChinh;
        this.no = no;
        this.khaNangTangTruong = khaNangTangTruong;
        this.khoiLuong = khoiLuong;
        this.thayDoiGia = thayDoiGia;
        this.nhanDinhGia = nhanDinhGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
    }

    public String getCoCauDoanhNghiep() {
        return coCauDoanhNghiep;
    }

    public void setCoCauDoanhNghiep(String coCauDoanhNghiep) {
        this.coCauDoanhNghiep = coCauDoanhNghiep;
    }

    public String getSucKhoeTaiChinh() {
        return sucKhoeTaiChinh;
    }

    public void setSucKhoeTaiChinh(String sucKhoeTaiChinh) {
        this.sucKhoeTaiChinh = sucKhoeTaiChinh;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getKhaNangTangTruong() {
        return khaNangTangTruong;
    }

    public void setKhaNangTangTruong(String khaNangTangTruong) {
        this.khaNangTangTruong = khaNangTangTruong;
    }

    public String getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(String khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public String getThayDoiGia() {
        return thayDoiGia;
    }

    public void setThayDoiGia(String thayDoiGia) {
        this.thayDoiGia = thayDoiGia;
    }

    public String getNhanDinhGia() {
        return nhanDinhGia;
    }

    public void setNhanDinhGia(String nhanDinhGia) {
        this.nhanDinhGia = nhanDinhGia;
    }

    @Override
    public String toString() {
        return this.getId() + "+" + this.getCoCauDoanhNghiep() +"+"
                + this.getThayDoiGia() + "+" + this.getNgay() + "+"
                + this.getKhaNangTangTruong() + "+" + this.getNhanDinhGia() + "+"
                + this.getNo() + "+" + this.getSucKhoeTaiChinh() + "+ "
                + this.getKhoiLuong();
    }

}
