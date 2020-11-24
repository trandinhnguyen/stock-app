import Constants.LinkData;
import Data.Data;
import Model.LinkMaCoPhieu;
import UI.LoadingUI;
import UI.RenderUI;

import java.io.IOException;

class Main {
    public static void main(String args[]) throws IOException {
        RenderUI UI = new RenderUI();
        LoadingUI loading = new LoadingUI(UI);
        LinkMaCoPhieu[] links = LinkData.linkMaCoPhieus;
        Data data = new Data(links);

        UI.setVisible(true);

        loading.setVisible(true);
        data.getDataCompany();
        data.getData20Ngay();
        loading.setVisible(false);
        System.out.println(data.getDuLieuMaCoPhieu20Ngay().size());
    }

}
