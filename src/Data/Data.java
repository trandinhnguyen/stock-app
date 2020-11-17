package Data;

import Model.DuLieuMaCoPhieu;
import Model.DuLieuNhomNganh;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

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





    public void getData() throws IOException, NumberFormatException {
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
            for (Element item : e.children()) {
                for (int i = 0; i < 11; i++) {
                    if (i == 1) {
                        try {
                            data.setNgay(df.parse(item.text()));
                        } catch (ParseException parseException) {
                            parseException.printStackTrace();
                        }
                    }
                    if (i == 3) {
                        try {
                            data.setGiaDongCua(Float.parseFloat(item.text()));
                        } catch (NumberFormatException numberFormatException) {
                            numberFormatException.printStackTrace();
                        }
                    }
                    float a = 0;
                    if (i == 6) {
                        try {
                            a = Float.parseFloat(item.text());
                        } catch (NumberFormatException numberFormatException) {
                            numberFormatException.printStackTrace();
                        }
                    }
                    float b = 0;
                    if (i == 8) {
                        try {
                            b = Float.parseFloat(item.text());
                        } catch (NumberFormatException numberFormatException) {
                            numberFormatException.printStackTrace();
                        }
                    }
                    data.setKhoiLuong(a + b);
                    if (i == 10) {
                        try {
                            data.setGiaMoCua(Float.parseFloat(item.text()));
                        } catch (NumberFormatException numberFormatException) {
                            numberFormatException.printStackTrace();
                        }
                    }
                    // TODO
                    // Viet tiep cac du lieu khac vao
                }
            }

        }

        this.setMaCoPhieu(data);
        // test
        System.out.println(data.getNgay());
        System.out.println(data.getGiaDongCua());
        System.out.println(data.getGiaMoCua());
        System.out.println(data.getKhoiLuong());
    }

    public ArrayList<DuLieuMaCoPhieu> getDuLieuMaCoPhieu20Ngay() {
        return duLieuMaCoPhieu20Ngay;
    }
    public ArrayList<DuLieuNhomNganh> getDuLieuMaNhomnganh20Ngay(){
        return null;
    }
}
