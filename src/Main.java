import Data.Data;
import Model.LinkMaCoPhieu;
import UI.RenderUI;

import java.io.IOException;
import java.util.ArrayList;

class Main {
    public static void main(String args[]) throws IOException {
        new RenderUI();
        LinkMaCoPhieu[] links = {
                new LinkMaCoPhieu("FPT", "https://s.cafef.vn/Lich-su-giao-dich-FPT-1.chn"),
                new LinkMaCoPhieu("HPG", "https://s.cafef.vn/Lich-su-giao-dich-HPG-1.chn"),
                new LinkMaCoPhieu("VIC", "https://s.cafef.vn/Lich-su-giao-dich-VIC-1.chn"),
                new LinkMaCoPhieu("VHM", "https://s.cafef.vn/Lich-su-giao-dich-VHM-1.chn"),
                new LinkMaCoPhieu("PNJ", "https://s.cafef.vn/Lich-su-giao-dich-PNJ-1.chn"),
                new LinkMaCoPhieu("GEX", "https://s.cafef.vn/Lich-su-giao-dich-GEX-1.chn"),
        };
        Data data = new Data(links);
        data.getData();
        System.out.println(data.getDuLieuMaCoPhieu20Ngay().size());
    }

}
