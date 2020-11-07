package Data;

import Model.DuLieuMaCoPhieu;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

// test JSoup
public class Data {

    private ArrayList<DuLieuMaCoPhieu> duLieuMaCoPhieu20Ngay;

    public Data() {
        this(new String[]{});
    }
    public Data(String[] linksMaCoPhieu){
        this.duLieuMaCoPhieu20Ngay = new ArrayList<DuLieuMaCoPhieu>();

    }
    public void setMaCoPhieu(DuLieuMaCoPhieu maCoPhieu) {
        this.duLieuMaCoPhieu20Ngay.add(maCoPhieu);
    }


    public void getData() throws IOException {
        // date format
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Document doc = Jsoup.connect("https://s.cafef.vn/Lich-su-giao-dich-FPT-1.chn").get();

        Element div = doc.getElementById("ctl00_ContentPlaceHolder1_ctl03_divHO");
        Element tbody = div.getElementsByTag("tbody").first();

        DuLieuMaCoPhieu data = new DuLieuMaCoPhieu();
        int count = 0;
        for(Element e: tbody.children()) {
            if (count < 2) {
                ++count;
                continue;
            }
            e.children().forEach((item) ->{
//                if (item.hasClass("Item_DateItem")) {
//                    try {
//                        data.setNgay(df.parse(item.text()));
//                    } catch (ParseException parseException) {
//                        parseException.printStackTrace();
//                    }
                        System.out.println(item.text());;
                }
                // TODO
                // Viet tiep cac du lieu khac vao
            );

        }

//        this.setMaCoPhieu(data);
//        // test
//        System.out.println(data.getNgay());

    }

    public ArrayList<DuLieuMaCoPhieu> getDuLieuMaCoPhieu20Ngay() {
        return duLieuMaCoPhieu20Ngay;
    }
}
