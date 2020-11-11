package seach;
import java.text.SimpleDateFormat;
import java.util.Date;
import Model.DuLieuMaCoPhieu;
import Model.DuLieuNhomNganh;
import Model.DuLieuSinhCau;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class awser {
    private int[] solution1;
    private String answer;
    private ArrayList<DuLieuMaCoPhieu>  cophieu;
    private ArrayList<DuLieuNhomNganh> nhomnganh;

    public int[] getSolution() {
        Search search = new Search();
        this.solution1 = search.getSoulution1();
        return solution1;
    }

    public void setAnswer(){
        for (int i = 0; i < solution1.length; i++){
            answer = cophieu.get(solution1[i]).getId() + "\t" + cophieu.get(solution1[i]).getTen() + "\t" + cophieu.get(solution[i]).getNgay();
            answer += "\n";
            // Du lieu sinh cau cua rieng doi tuong
        }
        // for (int i = 0; i < solution.length; i++){
        //     answer = nhomnganh.get(solution[i]).getid() + "\t" + nhomnganh.get(solution[i]).getTen() + "\t" +nhomnganh.get(solution[i]).getNgay();
        //     answer += "\n";
        //     // Du lieu sinh cau cua rieng doi tuong
        // }
        //du lieu sinh cau cua nhieu doi tuong
    }

    public String getAnswer(){
        return answer;
    }
}