import Constants.LinkData;
import Data.Data;
import Model.DuLieuCongTy;
import Model.LinkMaCoPhieu;
import SinhCau.SinhCau;
import UI.LoadingUI;
import UI.RenderUI;

import java.io.IOException;

class Main {
    public static void main(String args[]) throws IOException {
        LoadingUI loading = new LoadingUI();
        LinkMaCoPhieu[] links = LinkData.linkMaCoPhieus;
        Data data = new Data(links);

        loading.setVisible(true);
        data.getDataCompany();
        data.getData20Ngay();

        SinhCau sinhCau = new SinhCau(data.getDuLieuCongTyArrayList(), data.getDuLieuMaCoPhieu20Ngay());
        RenderUI UI = new RenderUI();
        UI.setDuLieuSinhCauArrayList(sinhCau.getDuLieuSinhCauArrayList());
        loading.setVisible(false);
        UI.setVisible(true);
    }

}
