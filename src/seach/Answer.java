package seach;
import java.text.SimpleDateFormat;
import java.util.Date;

import Data.Data;
import Model.DuLieuMaCoPhieu;
import Model.DuLieuNhomNganh;
import Model.DuLieuSinhCau;
import java.util.ArrayList;
import org.w3c.dom.ls.LSOutput;

public class Answer {
    private ArrayList<String> answercophieu;
    private ArrayList<String> answernhomnganh;
    private String   answervnindex="VNINDEX";
    public void setAnswerCophieu(ArrayList<DuLieuMaCoPhieu> arraylist1){
        ArrayList<String> answercophieu = new ArrayList<String>();
        for (int i = 0; i < arraylist1.size(); i++){
            String a = arraylist1.get(i).getId() + "\t" + arraylist1.get(i).getTen() + "\t" ;
            answercophieu.add(a);
        }
    }
    // public void setAnswerNhomnganh(ArrayList<DuLieuNhomNganh> arraylist2){
    //     ArrayList<String> answernhomnganh = new ArrayList<String>();
    //     for (int i = 0; i < arraylist2.size(); i++){
    //         String b = arraylist2.get(i).getId() + "\t" + arraylist2.get(i).getTen();
    //         answernhomnganh.add(b);
    //     }
    // }

    public ArrayList<String> getAnswerCoPhieu(){
        return answercophieu;
    }
    public ArrayList<String> getAnswerNhomNganh(){
        return answernhomnganh;
    }
    public String getAnswerVnindex(){
        return answervnindex;
    }

    public String getSearch(String keyword) {
        Search search = new Search();
        Data datacophieu = new Data();

        ArrayList<DuLieuMaCoPhieu> cophieu = new ArrayList<DuLieuMaCoPhieu>();
        DuLieuMaCoPhieu a = new DuLieuMaCoPhieu("FPT","001","cong ti FPT", new Date(), (float) 12.5,(float)13.5,10000,12500,13500);
        cophieu.add(a);
        DuLieuMaCoPhieu b = new DuLieuMaCoPhieu("FPb","001","cong ti FPT", new Date(), (float) 12.5,(float)13.5,10000,12500,13500);
        cophieu.add(b);
        datacophieu.getDuLieuMaCoPhieu20Ngay().add(a);
        datacophieu.getDuLieuMaCoPhieu20Ngay().add(b);

        Answer answer = new Answer();
        search.search(keyword, datacophieu.getDuLieuMaCoPhieu20Ngay(), datacophieu.getDuLieuMaNhomnganh20Ngay());
        String tmp = "";

        if (search.getSolution3() != null) {
            tmp += getAnswerVnindex();
            tmp += "\n";
        }

        for (int i = 0; i != search.getSoulution1().size(); i++) {
            tmp += answer.getAnswerCoPhieu().get(search.getSoulution1().get(i));
            tmp += "\n";

            // sinh cau

            tmp += "\n";
        }

        for (int i = 0; i != search.getSoulution2().size(); i++) {
            tmp += answer.getAnswerCoPhieu().get(search.getSoulution2().get(i));
            tmp += "\n";

            //Sinh cau

            tmp += "n";
        }

        return tmp;

    }
}