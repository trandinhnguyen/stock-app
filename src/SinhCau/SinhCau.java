package SinhCau;

import Model.DuLieuCongTy;
import Model.DuLieuMaCoPhieu;
import Model.DuLieuSinhCau;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SinhCau {
    private ArrayList<DuLieuSinhCau> duLieuSinhCauArrayList;
    private  ArrayList<DuLieuCongTy> duLieuCongTyArrayList;
    private ArrayList<ArrayList<DuLieuMaCoPhieu>> duLieuMaCoPhieuArrayList;
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public SinhCau(ArrayList<DuLieuCongTy> duLieuCongTyArrayList, ArrayList<ArrayList<DuLieuMaCoPhieu>> duLieuMaCoPhieuArrayList) {
        this.duLieuCongTyArrayList = duLieuCongTyArrayList;
        this.duLieuMaCoPhieuArrayList = duLieuMaCoPhieuArrayList;

        this.duLieuSinhCauArrayList = new ArrayList<>();


    }


    private void thayDoiGia() {

        for(ArrayList<DuLieuMaCoPhieu> item: duLieuMaCoPhieuArrayList) {
            double MA20Gia = 0.00;
            double MA20Khoiluong = 0.00;
            DuLieuMaCoPhieu duLieuNgayGanNhat = item.get(0);
            DuLieuSinhCau duLieuSinhCau = new DuLieuSinhCau();

            duLieuSinhCau.setId(duLieuNgayGanNhat.getTen());
            duLieuSinhCau.setNgay(duLieuNgayGanNhat.getNgay());
            for(DuLieuMaCoPhieu value: item) {
                MA20Gia += value.getGiaDongCua();
                MA20Khoiluong += value.getKhoiLuong() * 1.5;
            }
            if(item.get(0).getGiaDongCua() < item.get(1).getGiaDongCua()) {
                String thayDoiGia = "Ngày " + duLieuNgayGanNhat.getNgay().format(dateFormat) + " cổ phiếu " + duLieuNgayGanNhat.getTen() +
                        " giao dịch với khối lượng là " + duLieuNgayGanNhat.getKhoiLuong() +
                        " cổ phiếu; trong khi giá cổ phiếu đã giảm "
                        + duLieuNgayGanNhat.getTyLe().replace("-", "") + ".";
                if(item.get(0).getKhoiLuong() > MA20Khoiluong){
                    thayDoiGia += "Trong phiên hôm nay ghi nhận sự đột biến về thanh khoản.";
                }
                if(item.get(0).getGiaDongCua() > MA20Gia){
                    thayDoiGia += "Tuy nhiên giá vẫn đang trong xu hướng tăng. Nhận định đây có thể là nhịp điều chỉnh nhẹ của" +
                            " cổ phiếu. Nhà đầu tư có thể cân nhắc giải ngân ở vùng này.";
                } else{
                    thayDoiGia += "Phiên giảm giá hôm nay đã xác nhận xu hướng giảm của mã cổ phiếu" +
                            ". Các nhà đầu tư không nên mở mua mới tại thời điểm này; và nếu đang nắm giữ nên cân nhắc cắt lỗ.";
                }

                duLieuSinhCau.setThayDoiGia(thayDoiGia);
            }
            if(item.get(0).getGiaDongCua() >= item.get(1).getGiaDongCua()){
                String thayDoiGia = "Ngày "+ duLieuNgayGanNhat.getNgay().toString() + " cổ phiếu " + duLieuNgayGanNhat.getTen() + " giao"
                        + " dịch với khối lượng là " + duLieuNgayGanNhat.getKhoiLuong() + " cổ phiếu; trong khi giá cổ phiếu đã tăng "
                        + duLieuNgayGanNhat.getTyLe().replace("-", "");
                if(item.get(0).getKhoiLuong() > MA20Khoiluong) {
                    thayDoiGia += "Trong phiên hôm nay ghi nhận sự đột biến về thanh khoản.";
                }
                if(item.get(0).getGiaDongCua() > MA20Gia) {
                    thayDoiGia += "Phiên tăng giá hôm nay đã xác nhận xu hướng tăng của mã " + duLieuNgayGanNhat.getTen() +
                            ". Tuy nhiên thời điểm này giá đã tăng khá cao khỏi điểm mua. " +
                            "Nhà đầu tư cần cẩn trọng khi quyết định giải ngân, tránh FOMO.";
                } else {
                    thayDoiGia += "Dù đã trải qua một phiên tăng điểm hưng phấn nhưng giá hiện tại vẫn đang trong xu hướng giảm, đây " +
                            "có thể chỉ là một đợt phục hồi nhẹ của mã " + duLieuNgayGanNhat.getTen() + ". Nhà đầu tư cần bỏ tư duy" +
                            " bắt đáy, không nên tham lam mà phải chờ có dấu hiệu đảo chiều thực sự mới quyết định giải ngân.";
                }
                duLieuSinhCau.setThayDoiGia(thayDoiGia);
            }

            this.duLieuSinhCauArrayList.add(duLieuSinhCau);
        }
    }

    private void coCauDoanhNghiep() {
        for(ArrayList<DuLieuCongTy> item: duLieuCongTyArrayList) {
            DuLieuCongTy duLieuNamGanNhat = item.get(0);
            double ratio = 0.00;
            double EPS1 = Double.parseDouble(item.get(0).getEPS());
            double EPS2 = Double.parseDouble(item.get(1).getEPS());
            double R = EPS1/EPS2;
        }
    }

    public ArrayList<DuLieuSinhCau> getDuLieuSinhCauArrayList() {
        this.thayDoiGia();
        this.coCauDoanhNghiep();
        return duLieuSinhCauArrayList;
    }
}
