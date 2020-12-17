package SinhCau;

import Model.DuLieuCongTy;
import Model.DuLieuMaCoPhieu;
import Model.DuLieuSinhCau;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SinhCau {
    private final ArrayList<DuLieuSinhCau> duLieuSinhCauArrayList; // 6 cong ti thì 6 phan tu
    private final ArrayList<DuLieuCongTy> duLieuCongTyArrayList;
    private final ArrayList<DuLieuMaCoPhieu> VNINDEX;
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String sinhCauVNINDEX;


    public SinhCau(ArrayList<DuLieuCongTy> duLieuCongTyArrayList, ArrayList<DuLieuMaCoPhieu> VNINDEX) {
        this.duLieuCongTyArrayList = duLieuCongTyArrayList;
        this.VNINDEX = VNINDEX;
        this.duLieuSinhCauArrayList = new ArrayList<>();
        this.sinhCauVNINDEX = "";
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
                MA20Gia += value.getGiaDongCua()/20;
                MA20Khoiluong += value.getKhoiLuong()/20;
            }
            double tyLeKhoiLuong = duLieuNgayGanNhat.getKhoiLuong()/(MA20Khoiluong * 1.5);
            String thayDoiGia = "";
            if (duLieuNgayGanNhat.getGiaDongCua() < item.getDuLieuLichSu().get(1).getGiaDongCua()) {
                thayDoiGia += "Ngày " + duLieuNgayGanNhat.getNgay().format(dateFormat) + " cổ phiếu " + duLieuNgayGanNhat.getTen() +
                        " giao dịch với khối lượng là " + duLieuNgayGanNhat.getKhoiLuong() +
                        " cổ phiếu; trong khi giá cổ phiếu đã giảm "
                        + duLieuNgayGanNhat.getTyLe().replace("-", "") + ".";
                if (duLieuNgayGanNhat.getKhoiLuong() > tyLeKhoiLuong) {
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
                    if (duLieuNgayGanNhat.getKhoiLuong() > tyLeKhoiLuong) {
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
        double vonChuSoHuu0 = Double.parseDouble(item.getVonChuSoHuu().get(0));
        double vonChuSoHuu1 = Double.parseDouble(item.getVonChuSoHuu().get(0));
        double loiNhuan = Double.parseDouble(item.getLoiNhuanSauThue().get(0));
        double doanhThu = Double.parseDouble(item.getDoanhThuThuan().get(0));
        R = (vonChuSoHuu0/vonChuSoHuu1 -1)/100;
        ratio = EPS0 / EPS1;
        String coCauDoanhNghiep = "";
        //ROE
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
        //DAR
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
        //EPS
        if (ratio > 1.2) {
            coCauDoanhNghiep = "Công ty đang  có hoạt động kinh doanh vô cùng tốt. ban lãnh đạo đã có những" +
                            " chính sách tích cực đẩy mạnh tăng trưởng doanh thu và lợi nhuân trong một thời gian" +
                            " ngắn khi đạt lợi nhuận quý 3 "+ loiNhuan + " tỉ đồng và vốn chủ sở hữu tăng từ " +
                            vonChuSoHuu1 + " lên đến " + vonChuSoHuu0 + " tương đương " +
                            R + "%.";
        }
        if (ratio > 0.9 && ratio < 1.2) {
            coCauDoanhNghiep = "Công ty vẫn duy trì ổn hoạt động kinh doanh của mình tuy nhiên không có sự tăng" +
                            " trưởng quá rõ rệt, ban lãnh đạo đã làm tròn vai trò của mình. Doanh thu và lợi nhuận" +
                            " vẫn giữ nguyên ở mức " + doanhThu + " và " + loiNhuan + ".";
        }
        if (ratio < 0.9) {
            coCauDoanhNghiep = "Công ty đang gặp vấn đề trong hoạt động kinh doanh dẫn đến doanh thu và lợi" +
                            " nhuận đều giảm mạnh. Nhà đầu tư nên tránh xa công ty này thời điểm hiện tại và chờ đợi" +
                            " khi nào có thay đổi tích cực ở ban lãnh đạo và kết quả kinh doanh có sự phục hồi thì" +
                            " mới tham gia đầu tư.";
        }
        return coCauDoanhNghiep;
    }

    private void sinhCauVNINDEX() {
        String VNINDEX = "";
        double diemHomNay =  this.VNINDEX.get(0).getGiaDongCua();
        double diemHomQua = this.VNINDEX.get(1).getGiaDongCua();
        double khoiLuongHomNay = this.VNINDEX.get(0).getKhoiLuong();
        double MA20DIEM=0.00;
        double MA20KHOILUONG=0.00;
        for ( DuLieuMaCoPhieu value: this.VNINDEX ) {
            MA20DIEM += value.getGiaDongCua()/20;
            MA20KHOILUONG += value.getKhoiLuong()/20;
        }
        double hieuDiem = diemHomNay - diemHomQua;
        double tyLeDiem = diemHomNay/MA20DIEM;
        double tyLeKhoiLuong = khoiLuongHomNay/MA20KHOILUONG;
        if (diemHomNay < diemHomQua) {
            if ( Math.abs(hieuDiem) < 10){
                VNINDEX += "Trong phiên hôm nay thị trường đã trải qua một phiên ảm đạm khi chỉ số VNINDEX có sự sụt giảm nhẹ ~" +
                        hieuDiem + " điểm ( tương ứng với " + ""+ "%).";
                if (tyLeDiem > 1.05){
                    VNINDEX += "Thị trường mới chỉ có pha điều chỉnh nhẹ do VNINDEX đang đi đến vùng cản " +
                            "nên không tránh khỏi việc thị trường có một vài nhịp rung lắc. Nhìn chung thị trường vẫn " +
                            "đang trong xu hướng uptrend nên các nhà đâu tư vẫn nên giữ bình tĩnh, quản trị tốt " +
                            "danh mục của mình.";
                }
                if (tyLeDiem < 0.95){
                    VNINDEX += "Thị trường vẫn đang ở trong một kênh giá giảm. Tuy nhiên hôm nay thị trường" +
                            " chỉ có một pha giảm nhẹ nên vẫn chưa thể vội vàng kết luận điều gì, nhà đầu tư c" +
                            "ần phải chờ hành động giá của thị trường trong thời gian tới để đưa ra kết luận mua" +
                            " bán, k nên vội vàng trong thời điểm hiện tại.";
                }
                if (tyLeDiem > 0.95 && tyLeDiem <1.05){
                    VNINDEX += "Thị trường có thể đang trong giai đoạn tích lũy. Đây chính là thời điểm rất " +
                            "tốt để các nhà đầu tư mua gom chờ thời điểm thị trường bùng nổ.";
                }
            } else {
                VNINDEX = "Thị trường hôm nay có một pha sụt giảm vô cùng nghiêm trọng khi chỉ sổ VNINDEX sụt giảm tận " +
                        hieuDiem + " điểm (tương ứng với " + "..............." + "%). Phiên giảm điểm hôm nay" +
                        " có thể là một dấu hiệu cho thấy dòng tiền chảy vào thị trường đang giảm dần, thị trường có thể " +
                        "đang đi đến giai đoạn phân phối. Các nhà đầu tư cần hết sức chú ý đến thị trường trong thời điểm" +
                        " này, và cũng có thể cân nhắc tìm điểm đẹp để giảm bớt tỉ trọng trong danh mục của mình.";
            }
        }

        if (tyLeKhoiLuong > 1.2){
            VNINDEX = "Thanh khoản thị trường thời gian gần đây tăng đột biến chứng tỏ nhà đầu tư ngày" +
                    " càng quan tâm đến thị trường chứng khoán, dự báo tương lai sẽ có thêm nhiều dòng" +
                    " tiền đổ vào thị trường.";
        } else {
            VNINDEX = "Thanh khoản thị trường thời gian gần đây đang có xu hướng giảm rõ rệt, thị trường" +
                    " đang đi đến giai đoạn kiệt sức. Tại vùng này xu hướng rất có dấu hiệu sẽ đảo chiều nên" +
                    " các nhà đầu tư cần rất cẩn thận.";
        }

        this.sinhCauVNINDEX = VNINDEX;
    }

    public ArrayList<DuLieuSinhCau> getDuLieuSinhCauArrayList() {
        this.sinhCau();
        this.sinhCauVNINDEX();
        return duLieuSinhCauArrayList;
    }

    public String getSinhCauVNINDEX() {
        return this.sinhCauVNINDEX;
    }
}
