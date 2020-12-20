package Model;

import java.util.ArrayList;

public class DuLieuCongTy {
    private String ten;
    private final ArrayList<String> EPS;
    private final ArrayList<String> ROE;
    private final ArrayList<String> DAR;
    private final ArrayList<String> doanhThuThuan;
    private final ArrayList<String> loiNhuanSauThue;
    private final ArrayList<String> vonChuSoHuu;

    private ArrayList<DuLieuMaCoPhieu> duLieuLichSu;

    public DuLieuCongTy() {
        this.ten = "";
        this.EPS = new ArrayList<String>();
        this.ROE = new ArrayList<String>();
        this.DAR = new ArrayList<String>();
        this.doanhThuThuan = new ArrayList<String>();
        this.loiNhuanSauThue = new ArrayList<String>();
        this.vonChuSoHuu = new ArrayList<String>();
        this.duLieuLichSu = new ArrayList<>();
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public ArrayList<String> getEPS() { return EPS; }

    public void setEPS(String EPS) {
        this.EPS.add(EPS);
    }

    public ArrayList<String> getROE() { return ROE; }

    public void setROE(String ROE) {
        this.ROE.add(ROE);
    }

    public ArrayList<String> getDAR() {
        return DAR;
    }

    public void setDAR(String DAR) {
        this.DAR.add(DAR);
    }

    public ArrayList<String> getDoanhThuThuan() {
        return doanhThuThuan;
    }

    public void setDoanhThuThuan(String doanhThuThuan) {
        this.doanhThuThuan.add(doanhThuThuan);
    }

    public ArrayList<String> getLoiNhuanSauThue() {
        return loiNhuanSauThue;
    }

    public void setLoiNhuanSauThue(String loiNhuanSauThue) {
        this.loiNhuanSauThue.add(loiNhuanSauThue);
    }


    public void setVonChuSoHuu(String vonChuSoHuu) {
        this.vonChuSoHuu.add(vonChuSoHuu);
    }

    public void setDuLieuLichSu(ArrayList<DuLieuMaCoPhieu> duLieuLichSu) {
        this.duLieuLichSu = duLieuLichSu;
    }

    public ArrayList<String> getVonChuSoHuu() {
        return vonChuSoHuu;
    }

    public ArrayList<DuLieuMaCoPhieu> getDuLieuLichSu() {
        return duLieuLichSu;
    }
}


