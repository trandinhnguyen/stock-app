import Constants.LinkData;
import Data.Data;
import Model.LinkMaCoPhieu;
import SinhCau.SinhCau;
import UI.LoadingUI;
import UI.RenderUI;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        // Khởi tạo các đối tượng ban đầu
        RenderUI UI = new RenderUI();
        LoadingUI loading = new LoadingUI();
        LinkMaCoPhieu[] LINKS = LinkData.linkMaCoPhieus;
        Data data = new Data(LINKS);

        // set loadding
        loading.setVisible(true);
        // lay dữ liệu từ trên web
        data.getData();

        // Bắt đầu sinh câu từ dữ liệu
        SinhCau sinhCau = new SinhCau(data.getDuLieuCongTyArrayList(), data.getVNINDEX());

        // truyền dữ liệu vào UI để hiển thi
        UI.setDuLieuSinhCauArrayList(sinhCau.getDuLieuSinhCauArrayList());
        // set loading visiable = false để xóa frame loading
        loading.setVisible(false);

        // hiển thị UI
        UI.setVisible(true);
    }

}
