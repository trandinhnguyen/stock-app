package seach;

import Model.DuLieuMaCoPhieu;
import Model.DuLieuNhomNganh;
import Model.DuLieuSinhCau;

import java.util.ArrayList;
import java.util.Date;

public class Search {

    private ArrayList<DuLieuMaCoPhieu>  cophieu;
    private ArrayList<DuLieuNhomNganh> nhomnganh;
    private String agr1, agr2, id;
//    private ArrayList<DuLieuMaCoPhieu> ID1, name1;
//    private ArrayList<DuLieuNhomNganh> ID2, name2;
    private int[] solution;


    // agr1 : key word      arg2: ID or neme    i = 0
    public int search1(String agr1[], String agr2[], int i, int n) {
        if (i == n && agr1[i] == agr2[i]) {
            return 1;
        } else if (agr1[i] == agr2[i]) {
            return search1(agr1, agr2, i +1, n);
        } else {
            return 0;
        }
    }
    ///  tim ID
    public void search2(String agr1[],ArrayList<DuLieuMaCoPhieu> arraylist1, ArrayList<DuLieuNhomNganh> arraylist2 ){
        int count = 0;
        if (agr1.length == 1) {
            for(int i = 0; i != arraylist1.size(); i++) {
                String tmp =  arraylist1.get(i).getId();
                if(search1(agr1, tmp, 0, agr1.length) == 1) {
                    System.out.println(arraylist1.get(i));
                    count++;
                    setSolution(count, i);
                }
            }

        }else if(agr1.length>4) {
            for(int i = 0; i != arraylist2.size(); i++){
                String tmp =  arraylist1.get(i).getTen();
                if(search1(agr1, tmp, 0, agr1.length)==1) {
                    System.out.println(arraylist2.get(i));
                }
            }

        }else {
            for(int i = 0; i != arraylist1.size(); i++){
                String tmp1 = arraylist1.get(i).getId();
                String tmp2 = arraylist1.get(i).getTen();
                if(search1(agr1, tmp1,0,agr1.length)==1||search1(agr1,tmp2,0,agr1.length)==1) {
                    System.out.println(arraylist1.get(i));
                }
            }
        }
    }

    public Search() {
        ArrayList<DuLieuSinhCau> datas = new ArrayList<DuLieuSinhCau>();

        DuLieuSinhCau d = new DuLieuSinhCau("FPT", new Date(), "dfsdfsdfffffffffggggffffffffff");
        datas.add(d);

        ArrayList<String> ID1 = new ArrayList<String>();
        ArrayList<String> name1 = new ArrayList<String>();
//        ID2 = new ArrayList<DuLieuNhomNganh>();
//        name2 = new ArrayList<DuLieuNhomNganh>();
//        solution = new int[1];

//        ID1.add("FPT");
//        ID1.add("FPP");
//        ID1.add("FPS");
//        ID1.add("FPG");
//        name1.add("hjagsdjh");
//        name1.add("hjagssdfh");
//        name1.add("hjaaerwh");
//        name1.add("hjagsghjcxh");

        String[] keyword = {"FP"};

//        search2(keyword, ID1, name1);
    }

    public void setSolution(int j, int chiso) {
        this.solution=  new int[j];
        this.solution[j - 1] = chiso;
    }

    public int[] getSoulution(){
        return solution;
    }

    public static void main(String[] args){
        new Search();
    }

}

