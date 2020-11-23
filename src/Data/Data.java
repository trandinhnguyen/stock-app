package Data;

import Model.DuLieuCongTy;
import Model.DuLieuMaCoPhieu;

import Model.LinkMaCoPhieu;

import Model.DuLieuNhomNganh;

import org.json.JSONArray;
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

    private final String idDoanhThu = "ctl00_ContentPlaceHolder1_CompanyInfo_FinanceStatement1_rptNhomChiTieu_ctl00_rptData_ctl00_TrData";
    private final String idLoiNhuanSauThue = "ctl00_ContentPlaceHolder1_CompanyInfo_FinanceStatement1_rptNhomChiTieu_ctl00_rptData_ctl08_TrData";
    private final String idVonChuSoHuu = "ctl00_ContentPlaceHolder1_CompanyInfo_FinanceStatement1_rptNhomChiTieu_ctl01_rptData_ctl04_TrData";


    private ArrayList<DuLieuMaCoPhieu> duLieuMaCoPhieu20Ngay;
    private ArrayList<LinkMaCoPhieu> linksGetData;
    private ArrayList<DuLieuCongTy> duLieuCongTyArrayList;

    public Data() {
        this(new LinkMaCoPhieu[]{});
    }
    public Data(LinkMaCoPhieu[] linksMaCoPhieu){
        this.duLieuMaCoPhieu20Ngay = new ArrayList<DuLieuMaCoPhieu>();
        this.duLieuCongTyArrayList = new ArrayList<DuLieuCongTy>();
        this.linksGetData = new ArrayList<LinkMaCoPhieu>();
        for (LinkMaCoPhieu item: linksMaCoPhieu) {
            this.linksGetData.add(item);
        }


    }
    public void setMaCoPhieu(DuLieuMaCoPhieu maCoPhieu) {
        this.duLieuMaCoPhieu20Ngay.add(maCoPhieu);
    }

    public void getDataCompany() throws IOException {

        for(LinkMaCoPhieu link: this.linksGetData) {
            if (link.getTen() == "VNINDEX") continue;

            Document docRequest = Jsoup.connect(link.getLinkDataIndex()).userAgent("Mozilla/5.0").timeout(100 * 1000).get();
            Document docHTML = Jsoup.connect(link.getLinkDataCompany()).userAgent("Mozilla/5.0").timeout(100 * 1000).get();

            DuLieuCongTy duLieuCongTy = new DuLieuCongTy();
            duLieuCongTy.setTen(link.getTen());

            // get Data request
            String text = docRequest.body().text();
            JSONArray arrayData = new JSONArray(text);

            for (int i = 0; i < 3; i++) {
                String EPS = arrayData.getJSONObject(i).get("EPS").toString();
                duLieuCongTy.setEPS(EPS);

                String ROE = arrayData.getJSONObject(i).get("ROE").toString();
                duLieuCongTy.setROE(ROE);

                String DAR = arrayData.getJSONObject(i).get("DAR").toString();
                duLieuCongTy.setDAR(DAR);
            }

            // get Data HTML

            String[] id = {this.idDoanhThu, this.idLoiNhuanSauThue, this.idVonChuSoHuu};

            for (String item : id) {
                Element content = docHTML.getElementById(item);
                int index = 0;
                for (Element value : content.children()) {
                    if (index == 0) {
                        index++;
                        continue;
                    }

                    if (index == 5) break;
                    if (item == this.idDoanhThu)
                        duLieuCongTy.setDoanhThuThuan(value.text().replace(",", ""));
                    if (item == this.idLoiNhuanSauThue)
                        duLieuCongTy.setLoiNhuanSauThue(value.text().replace(",", ""));
                    if (item == this.idVonChuSoHuu)
                        duLieuCongTy.setVoiChuSoHuu(value.text().replace(",", ""));

                    index++;
                }
            }

        }

    }

    public void getData20Ngay() throws IOException, NumberFormatException {
        // date format
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        for (LinkMaCoPhieu link : this.linksGetData) {
            Document doc = Jsoup.connect(link.getLinkDataHistory()).userAgent("Mozilla/5.0").timeout(100 * 1000).get();

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
                        case 7:
                            data.setGiaTri(item.text().replace("&nbsp;", ""));
                            index++;
                            break;
                        case 9:
                            String text_GiaTri = item.text().replace("&nbsp;", "");
                            float a_giaTri = Float.parseFloat(data.getKhoiLuong().replace(",", ""));
                            float b_giaTrib = Float.parseFloat(text_GiaTri.replace(",", ""));
                            String result_giaTri = String.valueOf(a_giaTri + b_giaTrib);
                            data.setGiaTri(result_giaTri);
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
    public ArrayList<DuLieuNhomNganh> getDuLieuMaNhomnganh20Ngay(){
        return null;
    }
}
