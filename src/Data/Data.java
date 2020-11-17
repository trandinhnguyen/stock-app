package Data;

import Model.DuLieuMaCoPhieu;
import Model.LinkMaCoPhieu;
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
    private ArrayList<LinkMaCoPhieu> linksGetData;

    public Data() {
        this(new LinkMaCoPhieu[]{});
    }
    public Data(LinkMaCoPhieu[] linksMaCoPhieu){
        this.duLieuMaCoPhieu20Ngay = new ArrayList<DuLieuMaCoPhieu>();
        this.linksGetData = new ArrayList<LinkMaCoPhieu>();
        for (LinkMaCoPhieu item: linksMaCoPhieu) {
            this.linksGetData.add(item);
        }


    }
    public void setMaCoPhieu(DuLieuMaCoPhieu maCoPhieu) {
        this.duLieuMaCoPhieu20Ngay.add(maCoPhieu);
    }





    public void getData() throws IOException, NumberFormatException {
        // date format
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        for (LinkMaCoPhieu link : this.linksGetData) {
            Document doc = Jsoup.connect(link.getLink()).get();

            Element div = doc.getElementById("ctl00_ContentPlaceHolder1_ctl03_divHO");
            Element tbody = div.getElementsByTag("tbody").first();

            int count = 0;
            for (Element e : tbody.children()) {
                DuLieuMaCoPhieu data = new DuLieuMaCoPhieu();
                data.setTen(link.getTen());
                if (count < 2) {
                    ++count;
                    continue;
                }
                int index = 1;
                for (Element item : e.children()) {
                    switch (index) {
                        case 1:
                            try {
                                data.setNgay(df.parse(item.text()));
                            } catch (ParseException parseException) {
                                parseException.printStackTrace();
                            }
                            index++;
                            break;
                        case 3:
                            data.setGiaDongCua(item.text());
                            index++;
                            break;
                        case 4:
                            data.setTyLe(item.text());
                            index++;
                            break;
                        case 6:
                            data.setKhoiLuong(item.text().replace("&nbsp;", ""));
                            index++;
                            break;
                        case 8:
                            String text = item.text().replace("&nbsp;", "");
                            float a = Float.parseFloat(data.getKhoiLuong().replace(",", ""));
                            float b = Float.parseFloat(text.replace(",", ""));
                            String result = String.valueOf(a + b);
                            data.setKhoiLuong(result);
                            index++;
                            break;
                        case 10:
                            data.setGiaMoCua(item.text().replace("&nbsp;", ""));
                            index++;
                            break;
                        default:
                            index++;
                            break;
                    }
                }
                this.setMaCoPhieu(data);
            }


        }
    }
    public ArrayList<DuLieuMaCoPhieu> getDuLieuMaCoPhieu20Ngay() {
        return duLieuMaCoPhieu20Ngay;
    }
}
