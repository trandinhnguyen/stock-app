import Constants.LinkData;
import Data.Data;
import Model.LinkMaCoPhieu;
import SinhCau.SinhCau;
import UI.LoadingUI;
import UI.RenderUI;

import java.io.IOException;

class Main {
    public static void main(String args[]) throws IOException {
        RenderUI UI = new RenderUI();
        LoadingUI loading = new LoadingUI(UI);
        LinkMaCoPhieu[] links = LinkData.linkMaCoPhieus;
        Data data = new Data(links);

        // UI.setVisible(true);

        data.getDataCompany();
        data.getData20Ngay();

        SinhCau sinhCau = new SinhCau(data.getDuLieuCongTyArrayList(), data.getDuLieuMaCoPhieu20Ngay());

        System.out.println(sinhCau.getDuLieuSinhCau().getThayDoiGia());
        System.out.println(123);

    }

}
