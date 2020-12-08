//package Search;
//
//import Model.*;
//import SinhCau.SinhCau;
//
//import java.util.ArrayList;
//
//public class ListCauTraLoi {
//    private ArrayList<DuLieuCongTy> searchDuLieuCongTy;
//    private ArrayList<DuLieuMaCoPhieu> searchDuLieuMaCoPhieu;
//    private ArrayList<DuLieuNhomNganh> searchDuLieuNhomNganh;
//    private ArrayList<DuLieuSinhCau> searchDuLieuSinhCau;
//    private ArrayList<LinkMaCoPhieu> searchLinkMaCoPhieu;
//    private ArrayList<Answer> danhSachHienThi;
//    private ArrayList<SinhCau> searchSinhcau;
//
//    public void setSearchDuLieuCongTy(ArrayList<DuLieuCongTy> searchDuLieuCongTy){
//        this.searchDuLieuCongTy = searchDuLieuCongTy ;
//    }
//
//    public void setSearchDuLieuMaCoPhieu(ArrayList<DuLieuMaCoPhieu> searchDuLieuMaCoPhieu) {
//        this.searchDuLieuMaCoPhieu = searchDuLieuMaCoPhieu;
//    }
//
//    public void setSearchDuLieuNhomNganh(ArrayList<DuLieuNhomNganh> searchDuLieuNhomNganh) {
//        this.searchDuLieuNhomNganh = searchDuLieuNhomNganh;
//    }
//
//    public void setSearchDuLieuSinhCau(ArrayList<DuLieuSinhCau> searchDuLieuSinhCau) {
//        this.searchDuLieuSinhCau = searchDuLieuSinhCau;
//    }
//
//    public void setSearchLinkMaCoPhieu(ArrayList<LinkMaCoPhieu> searchLinkMaCoPhieu) {
//        this.searchLinkMaCoPhieu = searchLinkMaCoPhieu;
//    }
//
//    public void setDanhSachHienThi(String text){
//        Search resultDuLieuCongTy = new Search<DuLieuCongTy>( this.searchDuLieuCongTy,  text);
//        Search resultDuLieuMaCoPhieu = new Search<DuLieuMaCoPhieu>(this.searchDuLieuMaCoPhieu, text);
//        Search resultDuLieuNhomNganh = new Search<DuLieuNhomNganh>(this.searchDuLieuNhomNganh, text);
//        Search resultDuLieuSinhCau = new Search<DuLieuSinhCau>(this.searchDuLieuSinhCau, text);
//        Search resultLinkMaCoPhieu = new Search<LinkMaCoPhieu>(this.searchLinkMaCoPhieu,text);
//        Search resultSinhcau = new Search<SinhCau>(this.searchSinhcau, text);
//
//        this.danhSachHienThi.addAll(resultDuLieuCongTy.getCauTraLoi());
//        this.danhSachHienThi.addAll(resultDuLieuMaCoPhieu.getCauTraLoi());
//        this.danhSachHienThi.addAll(resultDuLieuNhomNganh.getCauTraLoi());
//        this.danhSachHienThi.addAll(resultDuLieuSinhCau.getCauTraLoi());
//        this.danhSachHienThi.addAll(resultLinkMaCoPhieu.getCauTraLoi());
//        java.util.Collections.sort(this.danhSachHienThi ,  new Answer() );
//    }
//
//    public ArrayList<Answer> getDanhSachHienThi(){
//        return danhSachHienThi;
//    }
//
//}
