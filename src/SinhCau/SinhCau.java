package SinhCau;

import Model.DuLieuCongTy;
import Model.DuLieuMaCoPhieu;
import Model.DuLieuSinhCau;

import java.util.ArrayList;

public class SinhCau {
    private ArrayList<DuLieuSinhCau> duLieuSinhCauArrayList;
    private  ArrayList<DuLieuCongTy> duLieuCongTyArrayList;
    private ArrayList<ArrayList<DuLieuMaCoPhieu>> duLieuMaCoPhieuArrayList;
    private  DuLieuSinhCau duLieuSinhCau;

    public SinhCau(ArrayList<DuLieuCongTy> duLieuCongTyArrayList, ArrayList<ArrayList<DuLieuMaCoPhieu>> duLieuMaCoPhieuArrayList) {
        this.duLieuCongTyArrayList = duLieuCongTyArrayList;
        this.duLieuMaCoPhieuArrayList = duLieuMaCoPhieuArrayList;

        this.duLieuSinhCau = new DuLieuSinhCau();

        this.thayDoiGia();
    }


    private void thayDoiGia() {

        for(ArrayList<DuLieuMaCoPhieu> item: duLieuMaCoPhieuArrayList) {
            double MA20Gia = 0.00;
            double MA20Khoiluong = 0.00;
            DuLieuMaCoPhieu duLieuNgayGanNhat = item.get(0);
            for(DuLieuMaCoPhieu value: item) {
                MA20Gia += value.getGiaDongCua();
                MA20Khoiluong += value.getKhoiLuong() * 1.5;
            }
            if(item.get(0).getGiaDongCua() < item.get(1).getGiaDongCua()) {
                String thayDoiGia = "Ngày " + duLieuNgayGanNhat.getNgay().toString() + " cổ phiếu " + duLieuNgayGanNhat.getTen() + " giao dịch với khối lượng là "
                                    + duLieuNgayGanNhat.getKhoiLuong() + " cổ phiếu; trong khi giá cổ phiếu đã giảm " + duLieuNgayGanNhat.getTyLe().replace("-", "") + ".";
                if(item.get(0).getKhoiLuong() > MA20Khoiluong){
                    thayDoiGia += "Trong phiên hôm nay ghi nhận sự đột biến về thanh khoản.";
                }
                if(item.get(0).getGiaDongCua() > MA20Gia){
                    thayDoiGia += "Tuy nhiên giá vẫn đang trong xu hướng tăng. Nhận định đây có thể là nhịp điều chỉnh nhẹ của cổ phiếu" +
                            ". Nhà đầu tư có thể cân nhắc giải ngân ở vùng này.";
                } else{
                    thayDoiGia += "Phiên giảm giá hôm nay đã xác nhận xu hướng giảm của mã cổ phiếu" +
                            ". Các nhà đầu tư không nên mở mua mới tại thời điểm này; và nếu đang nắm giữ nên cân nhắc cắt lỗ.";
                }

                this.duLieuSinhCau.setThayDoiGia(thayDoiGia);
            }
            if(item.get(0).getGiaDongCua() >= item.get(1).getGiaDongCua()){
                String thayDoiGia = "Ngày"+ duLieuNgayGanNhat.getNgay().toString() + " cổ phiếu " + duLieuNgayGanNhat.getTen() + " giao dịch với khối lượng là "
                        + duLieuNgayGanNhat.getKhoiLuong() + " cổ phiếu; trong khi giá cổ phiếu đã tăng " + duLieuNgayGanNhat.getTyLe().replace("-", "");
                this.duLieuSinhCau.setThayDoiGia(thayDoiGia);
            }
        }
    }

    public DuLieuSinhCau getDuLieuSinhCau() {
        return duLieuSinhCau;
    }

}
