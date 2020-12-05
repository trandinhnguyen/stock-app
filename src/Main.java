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
        LinkMaCoPhieu[] links = LinkData.linkMaCoPhieus;
        Data data = new Data(links);

        // set loadding
        loading.setVisible(true);
        // lay dữ liệu từ trên web
        data.getData20Ngay();
        data.getDataCompany();

        // Bắt đầu sinh câu từ dữ liệu
        SinhCau sinhCau = new SinhCau(data.getDuLieuCongTyArrayList());

        // truyền dữ liệu vào UI để hiển thi
        UI.setDuLieuSinhCauArrayList(sinhCau.getDuLieuSinhCauArrayList());
        // set loading visiable = false để xóa frame loading
        loading.setVisible(false);

        // hiển thị UI
        UI.setVisible(true);
    }

}
