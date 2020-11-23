import Data.Data;
import Model.LinkMaCoPhieu;
import UI.LoadingUI;
import UI.RenderUI;

import java.io.IOException;
import java.util.ArrayList;

class Main {
    public static void main(String args[]) throws IOException {
        RenderUI UI = new RenderUI();
        LoadingUI loading = new LoadingUI(UI);
        LinkMaCoPhieu[] links = {
                new LinkMaCoPhieu(
                        "FPT",
                        "https://s.cafef.vn/Lich-su-giao-dich-FPT-1.chn",
                        "https://s.cafef.vn/hose/FPT-cong-ty-co-phan-fpt.chn",
                        "https://e.cafef.vn/fi.ashx?symbol=FPT"
                ),
                new LinkMaCoPhieu(
                        "HPG",
                        "https://s.cafef.vn/Lich-su-giao-dich-HPG-1.chn",
                        "https://s.cafef.vn/hose/HPG-cong-ty-co-phan-tap-doan-hoa-phat.chn",
                        "https://e.cafef.vn/fi.ashx?symbol=HPG"
                        ),
                new LinkMaCoPhieu(
                        "VIC",
                        "https://s.cafef.vn/Lich-su-giao-dich-VIC-1.chn",
                        "https://s.cafef.vn/hose/VIC-tap-doan-vingroup-cong-ty-co-phan.chn",
                        "https://e.cafef.vn/fi.ashx?symbol=VIC"),
                new LinkMaCoPhieu(
                        "VHM",
                        "https://s.cafef.vn/Lich-su-giao-dich-VHM-1.chn",
                        "https://s.cafef.vn/hose/VHM-cong-ty-co-phan-vinhomes.chn",
                        "https://e.cafef.vn/fi.ashx?symbol=VHM"),
                new LinkMaCoPhieu(
                        "PNJ",
                        "https://s.cafef.vn/Lich-su-giao-dich-PNJ-1.chn",
                        "https://s.cafef.vn/hose/PNJ-cong-ty-co-phan-vang-bac-da-quy-phu-nhuan.chn",
                        "https://e.cafef.vn/fi.ashx?symbol=PNJ"),
                new LinkMaCoPhieu(
                        "GEX",
                        "https://s.cafef.vn/Lich-su-giao-dich-GEX-1.chn",
                        "https://s.cafef.vn/hose/GEX-tong-cong-ty-co-phan-thiet-bi-dien-viet-nam.chn",
                        "https://e.cafef.vn/fi.ashx?symbol=GEX"),
                new LinkMaCoPhieu(
                        "VNINDEX",
                        "https://s.cafef.vn/Lich-su-giao-dich-VNINDEX-1.chn",
                        "",
                        ""
                )
        };
        Data data = new Data(links);

        UI.setVisible(true);

        // loading.setVisible(true);
        data.getDataCompany();
        data.getData20Ngay();
        // loading.setVisible(false);
        System.out.println(data.getDuLieuMaCoPhieu20Ngay().size());
    }

}
