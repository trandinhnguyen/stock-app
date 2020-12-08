package Search;

import Model.*;

import java.util.ArrayList;

public class ListCauTraLoi {
    private ArrayList<DuLieuCongTy> searchDuLieuCongTy;
    private ArrayList<DuLieuMaCoPhieu> searchDuLieuMaCoPhieu;
    private ArrayList<DuLieuNhomNganh> searchDuLieuNhomNganh;
    private ArrayList<DuLieuSinhCau> searchDuLieuSinhCau;
    private ArrayList<LinkMaCoPhieu> searchLinkMaCoPhieu;
    private ArrayList<Answer> danhSachHienThi;

    public void setSearchDuLieuCongTy(ArrayList<DuLieuCongTy> searchDuLieuCongTy){
        this.searchDuLieuCongTy = searchDuLieuCongTy ;
    }

    public void setSearchDuLieuMaCoPhieu(ArrayList<DuLieuMaCoPhieu> searchDuLieuMaCoPhieu) {
        this.searchDuLieuMaCoPhieu = searchDuLieuMaCoPhieu;
    }

    public void setSearchDuLieuNhomNganh(ArrayList<DuLieuNhomNganh> searchDuLieuNhomNganh) {
        this.searchDuLieuNhomNganh = searchDuLieuNhomNganh;
    }

    public void setSearchDuLieuSinhCau(ArrayList<DuLieuSinhCau> searchDuLieuSinhCau) {
        this.searchDuLieuSinhCau = searchDuLieuSinhCau;
    }

    public void setSearchLinkMaCoPhieu(ArrayList<LinkMaCoPhieu> searchLinkMaCoPhieu) {
        this.searchLinkMaCoPhieu = searchLinkMaCoPhieu;
    }

    public void setDanhSachHienThi(String text){
        Search resultDuLieuCongTy = new Search<DuLieuCongTy>( this.searchDuLieuCongTy, 1 , text);
        Search resultDuLieuMaCoPhieu = new Search<DuLieuMaCoPhieu>(this.searchDuLieuMaCoPhieu, 2 ,text);
        Search resultDuLieuNhomNganh = new Search<DuLieuNhomNganh>(this.searchDuLieuNhomNganh, 3,text);
        Search resultDuLieuSinhCau = new Search<DuLieuSinhCau>(this.searchDuLieuSinhCau, 4,text);
        Search resultLinkMaCoPhieu = new Search<LinkMaCoPhieu>(this.searchLinkMaCoPhieu,5 ,text);

        this.danhSachHienThi.addAll(resultDuLieuCongTy.getCauTraLoi());
        this.danhSachHienThi.addAll(resultDuLieuMaCoPhieu.getCauTraLoi());
        this.danhSachHienThi.addAll(resultDuLieuNhomNganh.getCauTraLoi());
        this.danhSachHienThi.addAll(resultDuLieuSinhCau.getCauTraLoi());
        this.danhSachHienThi.addAll(resultLinkMaCoPhieu.getCauTraLoi());
        java.util.Collections.sort(this.danhSachHienThi ,  new Answer() );
    }

    public ArrayList<Answer> getDanhSachHienThi(){
        return danhSachHienThi;
    }
}
