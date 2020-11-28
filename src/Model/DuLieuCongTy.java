package Model;

import java.util.ArrayList;

public class DuLieuCongTy extends ArrayList<DuLieuCongTy> {
    private String ten;
    private ArrayList<String> EPS;
    private ArrayList<String> ROE;
    private ArrayList<String> DAR;
    private ArrayList<String> doanhThuThuan;
    private ArrayList<String> loiNhuanSauThue;
    private ArrayList<String> vonChuSoHuu;

    public DuLieuCongTy() {
        this.ten = "";
        this.EPS = new ArrayList<String>();
        this.ROE = new ArrayList<String>();
        this.DAR = new ArrayList<String>();
        this.doanhThuThuan = new ArrayList<String>();
        this.loiNhuanSauThue = new ArrayList<String>();
        this.vonChuSoHuu = new ArrayList<String>();
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

    public ArrayList<String> getVoiChuSoHuu() {
        return vonChuSoHuu;
    }

    public void setVoiChuSoHuu(String vonChuSoHuu) {
        this.vonChuSoHuu.add(vonChuSoHuu);
    }

    public String getEPS(int i) { return ""; }
    }


