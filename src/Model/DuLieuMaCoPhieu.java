package Model;

import java.util.Date;

public class DuLieuMaCoPhieu {
    private String id;
    private String idNhomNganh;
    private String ten;
    private Date ngay;
    private float diem;
    private float tyLe;
    private float khoiLuong;
    private float giaMoCua;
    private float giaDongCua;
    private float RSI;

    public DuLieuMaCoPhieu() {
        this("","","", new Date(), 0,0,0,0,0);
    }

    public DuLieuMaCoPhieu(String id, String idNhomNganh, String ten, Date ngay, float diem, float tyLe, float khoiLuong, float giaMoCua, float giaDongCua) {
        this.id = id;
        this.idNhomNganh = idNhomNganh;
        this.ten = ten;
        this.ngay = ngay;
        this.diem = diem;
        this.khoiLuong = khoiLuong;
        this.tyLe = tyLe;
        this.giaMoCua = giaMoCua;
        this.giaDongCua = giaDongCua;
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

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public float getTyLe() {
        return tyLe;
    }

    public void setTyLe(float tyLe) {
        this.tyLe = tyLe;
    }

    public float getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(float khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public float getGiaMoCua() {
        return giaMoCua;
    }

    public void setGiaMoCua(float giaMoCua) {
        this.giaMoCua = giaMoCua;
    }

    public float getGiaDongCua() {
        return giaDongCua;
    }

    public void setGiaDongCua(float giaDongCua) {
        this.giaDongCua = giaDongCua;
    }

    public float getRSI() {
        return RSI;
    }

    public void setRSI(float RSI) {
        this.RSI = RSI;
    }



    public float compare( DuLieuMaCoPhieu quaKhu) {return 1; };
}
