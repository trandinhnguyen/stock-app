package Data;

import Model.DuLieuCongTy;
import Model.DuLieuMaCoPhieu;

import Model.LinkMaCoPhieu;

import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;


public class Data {

    private final String idDoanhThu = "ctl00_ContentPlaceHolder1_CompanyInfo_FinanceStatement1_rptNhomChiTieu_ctl00_rptData_ctl00_TrData";
    private final String idLoiNhuanSauThue = "ctl00_ContentPlaceHolder1_CompanyInfo_FinanceStatement1_rptNhomChiTieu_ctl00_rptData_ctl08_TrData";
    private final String idVonChuSoHuu = "ctl00_ContentPlaceHolder1_CompanyInfo_FinanceStatement1_rptNhomChiTieu_ctl01_rptData_ctl04_TrData";


    private final ArrayList<ArrayList<DuLieuMaCoPhieu>> duLieuMaCoPhieu20Ngay;
    private final ArrayList<LinkMaCoPhieu> linksGetData;
    private final ArrayList<DuLieuCongTy> duLieuCongTyArrayList;

    public Data() {
        this(new LinkMaCoPhieu[]{});
    }
    public Data(LinkMaCoPhieu[] linksMaCoPhieu){
        this.duLieuMaCoPhieu20Ngay = new ArrayList<ArrayList<DuLieuMaCoPhieu>>();
        this.duLieuCongTyArrayList = new ArrayList<DuLieuCongTy>();
        this.linksGetData = new ArrayList<LinkMaCoPhieu>();
        this.linksGetData.addAll(Arrays.asList(linksMaCoPhieu));


    }
    public void setMaCoPhieu(ArrayList<DuLieuMaCoPhieu> maCoPhieu) {
        this.duLieuMaCoPhieu20Ngay.add(maCoPhieu);
    }

    public void getDataCompany() throws IOException {

        for(LinkMaCoPhieu link: this.linksGetData) {
            if (link.getTen().equals("VNINDEX")) continue;

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
                    if (item.equals(this.idDoanhThu))
                        duLieuCongTy.setDoanhThuThuan(value.text().replace(",", ""));
                    if (item.equals(this.idLoiNhuanSauThue))
                        duLieuCongTy.setLoiNhuanSauThue(value.text().replace(",", ""));
                    if (item.equals(this.idVonChuSoHuu))
                        duLieuCongTy.setVoiChuSoHuu(value.text().replace(",", ""));

                    index++;
                }
            }

            for(ArrayList<DuLieuMaCoPhieu> data: this.duLieuMaCoPhieu20Ngay) {
                if (data.get(0).getTen().equals(duLieuCongTy.getTen())) {
                    duLieuCongTy.setDuLieuLichSu(data);
                    break;
                }
            }
            this.duLieuCongTyArrayList.add(duLieuCongTy);
        };


    }

    public void getData20Ngay() throws IOException, NumberFormatException {
        // date format
        DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (LinkMaCoPhieu link : this.linksGetData) {
            Document doc = Jsoup.connect(link.getLinkDataHistory()).userAgent("Mozilla/5.0").timeout(100 * 1000).get();

            Element div = doc.getElementById("ctl00_ContentPlaceHolder1_ctl03_divHO");
            Element tbody = div.getElementsByTag("tbody").first();

            ArrayList<DuLieuMaCoPhieu> dataArrayList = new ArrayList<DuLieuMaCoPhieu>();
            int count = 0;
            for (Element e : tbody.children()) {

                DuLieuMaCoPhieu data = new DuLieuMaCoPhieu();
                data.setTen(link.getTen());
                if (count < 2) {
                    ++count;
                    continue;
                }
                int index = 1;
                if (!link.getTen().equals("VNINDEX")) {
                    for (Element item : e.children()) {
                        switch (index) {
                            case 1 -> {
                                data.setNgay(LocalDate.parse(item.text(), df));
                                index++;
                            }
                            case 3 -> {
                                data.setGiaDongCua(Double.parseDouble(item.text().replace("&nbsp;", "")));
                                index++;
                            }
                            case 4 -> {
                                data.setTyLe(item.text());
                                index++;
                            }
                            case 6 -> {
                                data.setKhoiLuong(Double.parseDouble(item.text().replace("&nbsp;", "").replace(",", "")));
                                index++;
                            }
                            case 7 -> {
                                data.setGiaTri(item.text().replace("&nbsp;", ""));
                                index++;
                            }
                            case 9 -> {
                                String text_GiaTri = item.text().replace("&nbsp;", "");
                                double a_giaTri = Double.parseDouble(data.getGiaTri().replace(",", ""));
                                double b_giaTri = Double.parseDouble(text_GiaTri.replace(",", ""));
                                String result_giaTri = String.valueOf(a_giaTri + b_giaTri);
                                data.setGiaTri(result_giaTri);
                                index++;
                            }
                            case 8 -> {
                                String text = item.text().replace("&nbsp;", "");
                                double a = data.getKhoiLuong();
                                double b = Double.parseDouble(text.replace(",", ""));
                                double result = a + b;
                                data.setKhoiLuong(result);
                                index++;
                            }
                            case 10 -> {
                                data.setGiaMoCua(Double.parseDouble(item.text().replace("&nbsp;", "")));
                                index++;
                            }
                            default -> index++;
                        }
                    }
                } else {
                    for (Element item : e.children()) {
                        switch (index) {
                            case 1 -> {
                                data.setNgay(LocalDate.parse(item.text(), df));
                                index++;
                            }
                            case 2 -> {
                                data.setGiaDongCua(Double.parseDouble(item.text().replace("&nbsp;", "").replace(",", "")));
                                index++;
                            }
                            case 3 -> {
                                data.setTyLe(item.text());
                                index++;
                            }
                            case 5 -> {
                                data.setKhoiLuong(Double.parseDouble(item.text().replace("&nbsp;", "").replace(",", "")));
                                index++;
                            }
                            case 6 -> {
                                data.setGiaTri(item.text().replace("&nbsp;", ""));
                                index++;
                            }
                            case 8 -> {
                                String text_GiaTri = item.text().replace("&nbsp;", "");
                                double a_giaTri = Double.parseDouble(data.getGiaTri().replace(",", ""));
                                double b_giaTri = Double.parseDouble(text_GiaTri.replace(",", ""));
                                String result_giaTri = String.valueOf(a_giaTri + b_giaTri);
                                data.setGiaTri(result_giaTri);
                                index++;
                            }
                            case 7 -> {
                                String text = item.text().replace("&nbsp;", "");
                                double a = data.getKhoiLuong();
                                double b = Double.parseDouble(text.replace(",", ""));
                                double result = a + b;
                                data.setKhoiLuong(result);
                                index++;
                            }
                            case 9 -> {
                                data.setGiaMoCua(Double.parseDouble(item.text().replace("&nbsp;", "").replace(",", "")));
                                index++;
                            }
                            default -> index++;
                        }
                    }
                }
                dataArrayList.add(data);
            }
            this.setMaCoPhieu(dataArrayList);


        }
    }

    public ArrayList<DuLieuCongTy> getDuLieuCongTyArrayList() {
        return duLieuCongTyArrayList;
    }
    public ArrayList<ArrayList<DuLieuMaCoPhieu>> getDuLieuMaCoPhieu20Ngay() {
        return duLieuMaCoPhieu20Ngay;
    }
}
