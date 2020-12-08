package Model;

import java.time.LocalDate;

public class DuLieuSinhCau {
    private String id;
    private LocalDate ngay;
    private String coCauDoanhNghiep;
    private String thayDoiGia;

    public DuLieuSinhCau() {
        this("", null, "", "", "", "", "", "", "");
    }

    public DuLieuSinhCau(String id, LocalDate ngay, String coCauDoanhNghiep, String sucKhoeTaiChinh, String no, String khaNangTangTruong, String khoiLuong, String thayDoiGia, String nhanDinhGia) {
        this.id = id;
        this.ngay = ngay;
        this.coCauDoanhNghiep = coCauDoanhNghiep;


        this.thayDoiGia = thayDoiGia;

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


    public String getThayDoiGia() {
        return thayDoiGia;
    }

    public void setThayDoiGia(String thayDoiGia) {
        this.thayDoiGia = thayDoiGia;
    }

    @Override
    public String toString() {
        return this.getId() + "+" + this.getCoCauDoanhNghiep() +"+"
                + this.getThayDoiGia() + "+" + this.getNgay();
    }

}
