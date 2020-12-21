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
            double kL = duLieuNgayGanNhat.getKhoiLuong()/1000000;
            if (duLieuNgayGanNhat.getGiaDongCua() < item.getDuLieuLichSu().get(1).getGiaDongCua()) {
                thayDoiGia += "Ngày " + duLieuNgayGanNhat.getNgay().format(dateFormat) + " cổ phiếu " + duLieuNgayGanNhat.getTen() +
                        " giao dịch với khối lượng là " + (double)Math.round(kL*1000)/1000 +
                        " triệu cổ phiếu; trong khi giá cổ phiếu đã giảm "
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
                thayDoiGia += "Ngày " + duLieuNgayGanNhat.getNgay().format(dateFormat) + " cổ phiếu " + duLieuNgayGanNhat.getTen() + " giao"
                            + " dịch với khối lượng là " + (double)Math.round(kL*1000)/1000 + " triệu cổ phiếu; trong khi giá cổ phiếu đã tăng "
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
        double vonChuSoHuu1 = Double.parseDouble(item.getVonChuSoHuu().get(1));
        double loiNhuan = Double.parseDouble(item.getLoiNhuanSauThue().get(0));
        double doanhThu = Double.parseDouble(item.getDoanhThuThuan().get(0));
        R = (vonChuSoHuu0/vonChuSoHuu1)/100;
        ratio = EPS0 / EPS1;
        String coCauDoanhNghiep = "";
        double vCSH0 = vonChuSoHuu0/100000000;
        double vCSH1 = vonChuSoHuu1/100000000;
        double lN = loiNhuan/100000000;
        double dT = doanhThu/100000000;
        //ROE
        if (ROE0 > 25) {
            coCauDoanhNghiep += "Công ty đang có tình hình tài chính cực tốt với mức sinh lời trên tài sản (ROE) đạt top đầu " +
                            "các công ty trên thị trường: " + ROE0 + "%/năm.";
        }
        if (ROE0 > 10 && ROE0 < 25) {
            coCauDoanhNghiep += "Công ty có tình hình tài chính ổn với mức sinh lời trên tài sản (ROE) đạt mức " + ROE0 +
                            "%/năm.";
        }
        if (ROE0 < 10) {
            coCauDoanhNghiep += "Công ty đang gặp vấn đề về tài chính cũng như hoạt động kinh doanh của công ty đang vận hành " +
                            "có vấn đề khi mà khả năng sinh lời trên tài sản của công ty đang ở mức đáng báo động, chỉ " + ROE0 +
                            "%/năm.";
        }
        //DAR
        if (DAR0 > 70) {
            coCauDoanhNghiep += " Công ty có một cấu trúc nợ khá lớn lên đến " + DAR0 + "% tài sản công ty. Điều này cản trở" +
                            "công ty phát triển do phải gánh trên vai một khoản nợ khổng lồ.";
        }
        if (DAR0 < 70 && DAR0 > 30) {
            coCauDoanhNghiep += " Công ty đang cân bằng được giữa tài sản và các khoản vay khi tỷ lệ nợ chỉ có " + DAR0 +
                            "% tài sản của công ty. Cơ cấu tài sản cho thấy công ty đang có tham vọng phát triển trong tương lai, do đó trong " +
                            "cấu trúc tài chính của công ty mới tồn tại một món nợ để công ty tái đầu tư và mở rộng thị phần. Đây là một " +
                            "công ty thích hợp với những nhà đầu tư có tính cách mạo hiểm.";
        }
        if (DAR0 < 30) {
            coCauDoanhNghiep += " Đây là công ty có sức khoẻ về tài chính khá tốt khi có tỷ lệ nợ vô cùng thấp: " + DAR0 +
                            "% tài sản công ty. Tuy nhiên cơ cấu tài sản hiện tại của công ty cho thấy công ty không có" +
                            " tham vọng phát triển hoặc khó có tiềm năng mở rộng phát triển. Đây là một công ty phù hợp" +
                            " với những nhà đầu tư ưa cảm giác an toàn và muốn được chia cổ phiếu thường xuyên.";
        }
        //EPS
        if (ratio > 1.2) {
            coCauDoanhNghiep += " Công ty đang  có hoạt động kinh doanh vô cùng tốt. ban lãnh đạo đã có những" +
                            " chính sách tích cực đẩy mạnh tăng trưởng doanh thu và lợi nhuân trong một thời gian" +
                            " ngắn khi đạt lợi nhuận quý 3 là "+ (double)Math.round(lN*10)/10 + " trăm triệu đồng ";
            if (vonChuSoHuu0 > vonChuSoHuu1) {
                coCauDoanhNghiep += "và vốn chủ sở hữu tăng từ " + (double)Math.round(vCSH1*10)/10 + " lên đến " +
                                    (double)Math.round(vCSH0*10)/10 + " trăm triệu đồng tương đương " +
                                    (double)Math.round(R*10000)/10000 + "%.";
            } else {
                coCauDoanhNghiep += ". Tuy nhiên nhiều khi do dịch bệnh nên công ty phải cắt giảm nhân công để đỡ " +
                                    "chi phí, mô hình kinh doanh bị thu hẹp nên vốn chủ sở hữu từ " +
                                    (double)Math.round(vCSH1*10)/10 + " xuống " + (double)Math.round(vCSH0*10)/10
                                    + " trăm triệu đồng tương đương " + (double)Math.round(R*10000)/10000 + "%." +
                                    " Nhưng công ty vẫn tăng lợi nhuận như trên.";
            }
        }
        if (ratio > 0.9 && ratio < 1.2) {
            coCauDoanhNghiep += " Công ty vẫn duy trì ổn hoạt động kinh doanh của mình tuy nhiên không có sự tăng" +
                            " trưởng quá rõ rệt, ban lãnh đạo đã làm tròn vai trò của mình. Doanh thu và lợi nhuận" +
                            " vẫn giữ nguyên ở mức " + (double)Math.round(dT*10)/10 + " trăm triệu đồng" +
                            " và " + (double)Math.round(lN*10)/10 + " trăm triệu đồng.";
        }
        if (ratio < 0.9) {
            coCauDoanhNghiep += " Công ty đang gặp vấn đề trong hoạt động kinh doanh dẫn đến doanh thu và lợi" +
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
                        Math.abs(hieuDiem) + " điểm.";
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
                VNINDEX += "Thị trường hôm nay có một pha sụt giảm vô cùng nghiêm trọng khi chỉ sổ VNINDEX sụt giảm tận " +
                        this.VNINDEX.get(0).getTyLe() + " điểm. Phiên giảm điểm hôm nay" +
                        " có thể là một dấu hiệu cho thấy dòng tiền chảy vào thị trường đang giảm dần, thị trường có thể " +
                        "đang đi đến giai đoạn phân phối. Các nhà đầu tư cần hết sức chú ý đến thị trường trong thời điểm" +
                        " này, và cũng có thể cân nhắc tìm điểm đẹp để giảm bớt tỉ trọng trong danh mục của mình.";
            }
        } else {
            if (Math.abs(hieuDiem) < 10 ){
                VNINDEX += "Thị trường hôm nay đã có phiên tăng " + (double)Math.round(Math.abs(hieuDiem)*100)/100 + " điểm. ";
                if (tyLeDiem > 1.05) {
                    VNINDEX += "Thị trường vẫn đang trong một kênh giá tăng. Phiên tăng điểm hôm nay cho thấy sự" +
                            " hưng phấn của dòng tiền mới đổ thêm vào thị trường. Tuy nhiên nhà đầu tư k nên quá" +
                            " hưng phấn do phiên tăng điểm hôm nay lực mua không mạnh, cần kiên nhẫn chờ hành" +
                            " động giá của những phiên sau để có quyết định đúng đắn nhất.";
                }
                if (tyLeDiem < 0.95) {
                    VNINDEX += "Thị trường đang trong một kênh giá giảm . Phiên tăng điểm hôm nay có thể chỉ" +
                            " là một chút điều chỉnh lên của thị trường. Các nhà đầu tư không nên FOMO," +
                            " đánh ngược lại xu hướng. Cần những chỉ báo và dấu hiệu đảo chiều rõ ràng" +
                            " mới cân nhắc giải ngân.";
                }
                if (tyLeDiem > 0.95 && tyLeDiem < 1.05) {
                    VNINDEX += "Thị trường có thể đang trong giai đoạn tích lũy. Đây chính là thời điểm rất tốt" +
                            " để các nhà đầu tư mua gom chờ thời điểm thị trường bùng nổ.";
                }
            } else {
                VNINDEX += "Thị trường hôm nay là một dấu hiệu vô cùng tích cực khi chỉ số VNINDEX tăng" +
                        " mạnh: "+ this.VNINDEX.get(0).getTyLe() + " điểm. Điều này chứng tỏ phe bò " +
                        "đang chiến thắng hoàn toàn phe gấu và chứng khoán đang là một kênh đầu tư rất thu" +
                        " hút dòng tiền. Hiện tại do dịch COVID nên các kênh trú ẩn thông thường như tiền " +
                        "tệ vàng hay bất động sản đã không còn hấp dẫn các nhà đầu tư nữa nên dòng tiền dần" +
                        " chuyển sang kênh chứng khoán. Hơn nữa pha tăng điểm hôm nay cho ta thấy một lực " +
                        "mua rất mạnh của thị trường, có thể trong tương lại thị dư địa tăng của toàn thị " +
                        "trường vẫn còn rất tích cực.";
            }
        }

        if (tyLeKhoiLuong > 1.2){
            if (diemHomNay > MA20DIEM){
                VNINDEX += "Thanh khoản thị trường thời gian gần đây tăng đột biến chứng tỏ nhà đầu tư ngày càng" +
                        " quan tâm đến thị trường chứng khoán, dự báo tương lai sẽ có thêm nhiều dòng tiền đổ vào" +
                        " thị trường. Trong giai đoạn thị trường tăng trưởng như hiện tại, nhà đầu tư có thể cân " +
                        "nhắc sử dụng thêm đòn bẩy tài chính để gia tăng lợi nhuận của mình. Tuy nhiên, nhà đầu tư" +
                        " chỉ nên sử dụng đòn bẩy tài chính khi đã có kiến thức thật tốt về quản trị danh mục vì dù" +
                        " sao đây cũng là con dao hai lưỡi.";
            } else {
                VNINDEX += "Thanh khoản của thị trường tăng chứng tỏ nhà đầu tư đang ngày càng quan tâm đến thị " +
                        "trường. Thị trường vẫn đang là sự giằng có quyết liệt giữa gấu và bò nên để đảm bảo an " +
                        "toàn cho tài khoản của mình nhà đầu tư nên kiên nhẫn chờ hành động giá trong thời gian sắp tới.";
            }
        } else {
            if (diemHomNay > MA20DIEM) {
                VNINDEX += "Thị trường vẫn đang trong kênh giá tăng tuy nhiên thanh khoản của thị trường gần đây đang" +
                        " có dấu hiệu giảm và không mấy tích cực lắm. Thanh khoản giảm chứng tỏ nhà đầu tư đã ít quan" +
                        " tâm đến thị trường hoặc phe bò sau một giai đoạn đẩy thị trường lên quá hưng phấn nên lực " +
                        "cầu đã yếu dần. Có thể trong thời gian tới thị trường sẽ có một nhịp điều chỉnh lại để tăng" +
                        " tiếp hoặc nếu tiêu cực hơn thì đây có thể chính là đỉnh của thị trường và xu hướng chính sẽ" +
                        " đảo chiều giảm.";
            } else {
                VNINDEX += "Thanh khoản thị trường thời gian gần đây đang có xu hướng giảm rõ rệt, thị trường đang đi" +
                        " đến giai đoạn kiệt sức. Tại vùng này xu hướng rất có dấu hiệu sẽ đảo chiều nên các nhà đầu" +
                        " tư cần rất cẩn thận. Nếu như trong danh mục của nhà đầu tư đã có mã lỗ trên 5% thì cân nhắc" +
                        " cắt lỗ do với tình hiện tại thị trường khó có thể phục hồi sớm được.";
            }
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
