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


    private final ArrayList<LinkMaCoPhieu> linksGetData;
    private final ArrayList<DuLieuCongTy> duLieuCongTyArrayList;
    private ArrayList<DuLieuMaCoPhieu> VNINDEX;


    public Data(LinkMaCoPhieu[] linksMaCoPhieu) {
        this.duLieuCongTyArrayList = new ArrayList<DuLieuCongTy>();
        this.linksGetData = new ArrayList<LinkMaCoPhieu>();
        this.linksGetData.addAll(Arrays.asList(linksMaCoPhieu));
        this.VNINDEX = new ArrayList<>();


    }

    private DuLieuCongTy getDataCompany(LinkMaCoPhieu link) throws IOException {
        System.out.println(link.getTen());
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

        String idDoanhThu = "ctl00_ContentPlaceHolder1_CompanyInfo_FinanceStatement1_rptNhomChiTieu_ctl00_rptData_ctl00_TrData";
        String idLoiNhuanSauThue = "ctl00_ContentPlaceHolder1_CompanyInfo_FinanceStatement1_rptNhomChiTieu_ctl00_rptData_ctl08_TrData";
        String idVonChuSoHuu = "ctl00_ContentPlaceHolder1_CompanyInfo_FinanceStatement1_rptNhomChiTieu_ctl01_rptData_ctl04_TrData";
        String[] id = {idDoanhThu, idLoiNhuanSauThue, idVonChuSoHuu};

        for (String item : id) {
            Element content = docHTML.getElementById(item);
            // i dont know why it  is  wrong ?????????
            while (content == null) {
                System.out.println("die :" + link.getTen());
                docHTML = Jsoup.connect(link.getLinkDataCompany()).userAgent("Mozilla/5.0").timeout(100 * 1000).get();

                content = docHTML.getElementById(item);
            }
            int index = 0;
            for (Element value : content.children()) {
                if (index == 0) {
                    index++;
                    continue;
                }

                if (index == 5) break;
                if (item.equals(idDoanhThu))
                    duLieuCongTy.setDoanhThuThuan(value.text().replace(",", ""));
                if (item.equals(idLoiNhuanSauThue))
                    duLieuCongTy.setLoiNhuanSauThue(value.text().replace(",", ""));
                if (item.equals(idVonChuSoHuu))
                    duLieuCongTy.setVonChuSoHuu(value.text().replace(",", ""));

                index++;
            }
        }

        return duLieuCongTy;
    }

    ;

    // lấy dữ liệu mã cổ phiếu và dữ liệu công ty
    public void getData() throws IOException, NumberFormatException {
        // date format
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // lấy dữ liệu mã cổ phiếu
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

            if (link.getTen().equals("VNINDEX")) {
                this.VNINDEX = dataArrayList;
                continue;
            }


            // lấy dữ liệu công ty
            DuLieuCongTy duLieuCongTy = this.getDataCompany(link);
            duLieuCongTy.setDuLieuLichSu(dataArrayList);

            this.duLieuCongTyArrayList.add(duLieuCongTy);

        }
    }

    public ArrayList<DuLieuMaCoPhieu> getVNINDEX() {
        return VNINDEX;
    }

    public ArrayList<DuLieuCongTy> getDuLieuCongTyArrayList() {
        return duLieuCongTyArrayList;
    }
}
