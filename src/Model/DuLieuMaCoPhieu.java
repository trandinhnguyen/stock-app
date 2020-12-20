package Model;

import java.time.LocalDate;

public class DuLieuMaCoPhieu {
    private String ten;
    private LocalDate ngay;
    private String tyLe;
    private double khoiLuong;
    private String giaTri;
    private double giaMoCua;
    private double giaDongCua;
    private String RSI;

    public DuLieuMaCoPhieu() {
        this("", null, "", 0.00, 0.00, 0.00, "");
    }

    public DuLieuMaCoPhieu(String ten, LocalDate ngay, String tyLe, double khoiLuong, double giaMoCua, double giaDongCua, String giaTri) {
        this.ten = ten;
        this.ngay = ngay;
        this.khoiLuong = khoiLuong;
        this.tyLe = tyLe;
        this.giaMoCua = giaMoCua;
        this.giaDongCua = giaDongCua;
        this.giaTri = giaTri;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
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

    public String getGiaTri() {
        return this.giaTri;
    }

}
