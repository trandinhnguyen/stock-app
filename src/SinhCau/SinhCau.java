package SinhCau;

import Model.DuLieuCongTy;
import Model.DuLieuMaCoPhieu;
import Model.DuLieuSinhCau;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SinhCau {
    private ArrayList<DuLieuSinhCau> duLieuSinhCauArrayList; // 6 cong ti thì 6 phan tu
    private ArrayList<DuLieuCongTy> duLieuCongTyArrayList;
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public SinhCau(ArrayList<DuLieuCongTy> duLieuCongTyArrayList) {
        this.duLieuCongTyArrayList = duLieuCongTyArrayList;
        this.duLieuSinhCauArrayList = new ArrayList<>();

        System.out.println(duLieuCongTyArrayList.get(0).getTen());

    }


    private void sinhCau() {
        for (DuLieuCongTy item : this.duLieuCongTyArrayList) {
            DuLieuSinhCau duLieuSinhCau = new DuLieuSinhCau();

            double MA20Gia = 0.00;
            double MA20Khoiluong = 0.00;
            DuLieuMaCoPhieu duLieuNgayGanNhat = item.getDuLieuLichSu().get(0);

            duLieuSinhCau.setId(duLieuNgayGanNhat.getTen());
            duLieuSinhCau.setNgay(duLieuNgayGanNhat.getNgay());
            for (DuLieuMaCoPhieu value : item.getDuLieuLichSu()) {
                MA20Gia += value.getGiaDongCua();
                MA20Khoiluong += value.getKhoiLuong() * 1.5;
            }

            String thayDoiGia = "";
            if (duLieuNgayGanNhat.getGiaDongCua() < item.getDuLieuLichSu().get(1).getGiaDongCua()) {
                thayDoiGia += "Ngày " + duLieuNgayGanNhat.getNgay().format(dateFormat) + " cổ phiếu " + duLieuNgayGanNhat.getTen() +
                        " giao dịch với khối lượng là " + duLieuNgayGanNhat.getKhoiLuong() +
                        " cổ phiếu; trong khi giá cổ phiếu đã giảm "
                        + duLieuNgayGanNhat.getTyLe().replace("-", "") + ".";
                if (duLieuNgayGanNhat.getKhoiLuong() > MA20Khoiluong) {
                    thayDoiGia += "Trong phiên hôm nay ghi nhận sự đột biến về thanh khoản.";
                }
                if (duLieuNgayGanNhat.getGiaDongCua() > MA20Gia) {
                    thayDoiGia += "Tuy nhiên giá vẫn đang trong xu hướng tăng. Nhận định đây có thể là nhịp điều chỉnh nhẹ của" +
                            " cổ phiếu. Nhà đầu tư có thể cân nhắc giải ngân ở vùng này.";
                } else {
                    thayDoiGia += "Phiên giảm giá hôm nay đã xác nhận xu hướng giảm của mã cổ phiếu" +
                            ". Các nhà đầu tư không nên mở mua mới tại thời điểm này; và nếu đang nắm giữ nên cân nhắc cắt lỗ.";
                }

            }
            else{
                thayDoiGia += "Ngày " + duLieuNgayGanNhat.getNgay().toString() + " cổ phiếu " + duLieuNgayGanNhat.getTen() + " giao"
                            + " dịch với khối lượng là " + duLieuNgayGanNhat.getKhoiLuong() + " cổ phiếu; trong khi giá cổ phiếu đã tăng "
                            + duLieuNgayGanNhat.getTyLe().replace("-", "");
                    if (duLieuNgayGanNhat.getKhoiLuong() > MA20Khoiluong) {
                        thayDoiGia += "Trong phiên hôm nay ghi nhận sự đột biến về thanh khoản.";
                    }
                    if (duLieuNgayGanNhat.getGiaDongCua() > MA20Gia) {
                        thayDoiGia += "Phiên tăng giá hôm nay đã xác nhận xu hướng tăng của mã " + duLieuNgayGanNhat.getTen() +
                                ". Tuy nhiên thời điểm này giá đã tăng khá cao khỏi điểm mua. " +
                                "Nhà đầu tư cần cẩn trọng khi quyết định giải ngân, tránh FOMO.";
                    } else {
                        thayDoiGia += "Dù đã trải qua một phiên tăng điểm hưng phấn nhưng giá hiện tại vẫn đang trong xu hướng giảm, đây " +
                                "có thể chỉ là một đợt phục hồi nhẹ của mã " + duLieuNgayGanNhat.getTen() + ". Nhà đầu tư cần bỏ tư duy" +
                                " bắt đáy, không nên tham lam mà phải chờ có dấu hiệu đảo chiều thực sự mới quyết định giải ngân.";
                    }

                }

                String coCauDoanhNghiep = this.coCauDoanhNghiep(item);

                duLieuSinhCau.setThayDoiGia(thayDoiGia);
                duLieuSinhCau.setCoCauDoanhNghiep(coCauDoanhNghiep);
                this.duLieuSinhCauArrayList.add(duLieuSinhCau);
        }
    }

        private String coCauDoanhNghiep(DuLieuCongTy item) {
                double ratio = 0.00;
                double R = 0.00;
                double EPS0 = Double.parseDouble(item.getEPS().get(0));
                double EPS1 = Double.parseDouble(item.getEPS().get(1));
                double DAR0 = Double.parseDouble(item.getDAR().get(0));
                double ROE0 = Double.parseDouble(item.getROE().get(0));
                ratio = EPS0 / EPS1;
                String coCauDoanhNghiep = "";
                if (ROE0 > 25) {
                    coCauDoanhNghiep = "Công ty đang có tình hình tài chính cực tốt với mức sinh lời trên tài sản (ROE) đạt top đầu " +
                            "các công ty trên thị trường: " + ROE0 + "%/năm.";

                }
                if (ROE0 > 10 && ROE0 < 25) {
                    coCauDoanhNghiep = "Công ty có tình hình tài chính ổn với mức sinh lời trên tài sản (ROE) đạt mức " + ROE0 +
                            "%/ năm.";

                }
                if (ROE0 < 10) {
                    coCauDoanhNghiep = "Công ty đang gặp vấn đề về tài chính cũng như hoạt động kinh doanh của công ty đang vận hành " +
                            "có vấn đề khi mà khả năng sinh lời trên tài sản của công ty đang ở mức đáng báo động, chỉ " + ROE0 +
                            "%/ năm.";

                }
                if (DAR0 > 70) {
                    coCauDoanhNghiep = "Công ty có một cấu trúc nợ khá lớn lên đến " + DAR0 + "% tài sản công ty. Điều này cản trở" +
                            "công ty phát triển do phải gánh trên vai một khoản nợ khổng lồ.";

                }
                if (DAR0 < 70 && DAR0 > 30) {
                    coCauDoanhNghiep = "Công ty đang cân bằng được giữa tài sản và các khoản vay khi tỷ lệ nợ chỉ có " + DAR0 +
                            "% tài sản của công ty. Cơ cấu tài sản cho thấy công ty đang có tham vọng phát triển trong tương lai, do đó trong " +
                            "cấu trúc tài chính của công ty mới tồn tại một món nợ để công ty tái đầu tư và mở rộng thị phần. Đây là một " +
                            "công ty thích hợp với những nhà đầu tư có tính cách mạo hiểm.";

                }
                if (DAR0 < 30) {
                    coCauDoanhNghiep = "Đây là công ty có sức khoẻ về tài chính khá tốt khi có tỷ lệ nợ vô cùng thấp: " + DAR0 +
                            "% tài sản công ty. Tuy nhiên cơ cấu tài sản hiện tại của công ty cho thấy công ty không có tham vọng phát triển" +
                            " hoặc khó có tiềm năng mở rộng phát triển. Đây là một công ty phù hợp với những nhà đầu tư ưa cảm giác an toàn" +
                            " và muốn được chia cổ phiếu thường xuyên.";
                }

            return coCauDoanhNghiep;
    }

    public ArrayList<DuLieuSinhCau> getDuLieuSinhCauArrayList() {
        this.sinhCau();
        return duLieuSinhCauArrayList;
    }
}
