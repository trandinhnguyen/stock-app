package Model;

import java.util.Date;

public class DuLieuMaCoPhieu {
    private String id;
    private String idNhomNganh;
    private String ten;
    private Date ngay;
    private String diem;
    private String tyLe;
    private double khoiLuong;
    private String giaTri;
    private double giaMoCua;
    private double giaDongCua;
    private String RSI;

    public DuLieuMaCoPhieu() {
        this("","","", new Date(), "", "", 0.00, 0.00, 0.00, "");
    }

    public DuLieuMaCoPhieu(String id, String idNhomNganh, String ten, Date ngay, String diem, String tyLe, double khoiLuong, double giaMoCua, double giaDongCua, String giaTri) {
        this.id = id;
        this.idNhomNganh = idNhomNganh;
        this.ten = ten;
        this.ngay = ngay;
        this.diem = diem;
        this.khoiLuong = khoiLuong;
        this.tyLe = tyLe;
        this.giaMoCua = giaMoCua;
        this.giaDongCua = giaDongCua;
        this.giaTri = giaTri;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdNhomNganh() {
        return idNhomNganh;
    }

    public void setIdNhomNganh(String idNhomNganh) {
        this.idNhomNganh = idNhomNganh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }

    public String getTyLe() {
        return tyLe;
    }

    public void setTyLe(String tyLe) {
        this.tyLe = tyLe;
    }

    public double getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(double khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public double getGiaMoCua() {
        return giaMoCua;
    }

    public void setGiaMoCua(double giaMoCua) {
        this.giaMoCua = giaMoCua;
    }

    public double getGiaDongCua() {
        return giaDongCua;
    }

    public void setGiaDongCua(double giaDongCua) {
        this.giaDongCua = giaDongCua;
    }

    public String getRSI() {
        return RSI;
    }

    public void setRSI(String RSI) {
        this.RSI = RSI;
    }

    public void setGiaTri(String giaTri) {
        this.giaTri = giaTri;
    }

    public String getGiaTri() {return this.giaTri;}


    public String compare( DuLieuMaCoPhieu quaKhu) {return ""; };
}
