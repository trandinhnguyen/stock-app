package seach;

import Model.DuLieuMaCoPhieu;
import Model.DuLieuNhomNganh;
import Model.DuLieuSinhCau;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Action {
    private int[] solution;
    private String answer;
    private ArrayList<DuLieuMaCoPhieu>  cophieu;
    private ArrayList<DuLieuNhomNganh> nhomnganh;

    public int[] getSolution() {
        Search search = new Search();
        this.solution = search.getSoulution();
        return solution;
    }

//    chuyen date sang string
//    import java.text.SimpleDateFormat;
//    import java.util.Date;
//
//
//    public class DateDemo {
//        public static void main(String[] args) {
//            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//            Date date = new Date();
//            String dateFormat = formatter.format(date);
//            System.out.println("Ngày đã được định dạng : "+dateFormat);
//
//        }
//    }

    public void setAnswer(){
        for (int i = 0; i < solution.length; i++){
            answer = cophieu.get(solution[i]).getId() + "\t" + cophieu.get(solution[i]).getTen() + "\t" + cophieu.get(solution[i]).getNgay();
            answer += "\n";
            // Du lieu sinh cau cua rieng doi tuong
        }
        for (int i = 0; i < solution.length; i++){
            answer = nhomnganh.get(solution[i]).getid() + "\t" + nhomnganh.get(solution[i]).getTen() + "\t" +nhomnganh.get(solution[i]).getNgay();
            answer += "\n";
            // Du lieu sinh cau cua rieng doi tuong
        }
        //du lieu sinh cau cua nhieu doi tuong
    }

    public String getAnswer(){
        return answer;
    }
}