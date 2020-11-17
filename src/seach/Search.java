package seach;

import Model.DuLieuMaCoPhieu;
import Model.DuLieuNhomNganh;
import Model.DuLieuSinhCau;
import java.util.ArrayList;
import java.util.Date;

public class Search {
    private ArrayList<Integer> solution1;
    private ArrayList<Integer> solution2;
    private ArrayList<Integer> solution3;
    private Date today= new Date();



    // tim ID
    public void search(String agr, ArrayList<DuLieuMaCoPhieu> arraylist1, ArrayList<DuLieuNhomNganh> arraylist2 ){
        if ("VNINDEX".startsWith(agr)==true){
            solution3.add(1);
        }
            if (agr.length() == 1) {
                for (int i = 0; i != arraylist1.size(); i++) {
                    if (arraylist1.get(i).getId().startsWith(agr) == true && arraylist1.get(i).getNgay() == today) {
                        System.out.println(arraylist1.get(i).getId());
                        solution1.add(i);
                    }
                }

            } else if (agr.length() > 6) {
                for (int i = 0; i != arraylist1.size(); i++) {
                    if (arraylist1.get(i).getTen().startsWith(agr) == true && arraylist1.get(i).getNgay() == today) {
                        System.out.println(arraylist1.get(i).getId());
                        solution1.add(i);
                    }

                }
            } else {
                for (int i = 0; i != arraylist1.size(); i++) {
                    if ((arraylist1.get(i).getId().startsWith(agr) == true || arraylist1.get(i).getTen().startsWith(agr) == true) && arraylist1.get(i).getNgay() == today) {
                        System.out.println(arraylist1.get(i).getId());
                        solution1.add(i);
                    }
                }
            }
            // if( agr.length() == 1) {
            //     for(int i = 0; i != arraylist2.size(); i++) {
            //         if(arraylist2.get(i).getId().startsWith(agr)==true&&arraylist2.get(i).getNgay()==today) {
            //             solution2.add(i);
            //         }
            //     }

            // }else if(agr.length()>6) {
            //     for(int i = 0; i != arraylist1.size(); i++){
            //      if(arraylist2.get(i).getTen().startsWith(agr)==truearraylist2.get(i).getNgay()==today) {
            //          solution2.add(i);
            //     }
            //     }

            // }else {
            //      for(int i = 0; i != arraylist2.size(); i++){
            //          if((arraylist2.get(i).getId().startsWith(agr)==true||arraylist2.get(i).getTen().startsWith(agr)==true)&&arraylist2.get(i).getNgay()==today) {
            //          solution2.add(i);
            //          }
            //      }
            //  }

        }

    public Search() {
            ArrayList<DuLieuSinhCau> datas = new ArrayList<DuLieuSinhCau>();
            DuLieuSinhCau d = new DuLieuSinhCau("FPT", new Date(), "dfsdfsdfffffffffggggffffffffff");
            datas.add(d);
            ArrayList<DuLieuMaCoPhieu> cophieu = new ArrayList<DuLieuMaCoPhieu>();
            DuLieuMaCoPhieu a = new DuLieuMaCoPhieu("FPT","001","cong ti FPT", new Date(), (float) 12.5,(float)13.5,10000,12500,13500);
            cophieu.add(a);
            DuLieuMaCoPhieu b = new DuLieuMaCoPhieu("FPb","001","cong ti FPT", new Date(), (float) 12.5,(float)13.5,10000,12500,13500);
            cophieu.add(b);
            String keyword = "FP";
            ArrayList<DuLieuNhomNganh> nhomnganh=new ArrayList<DuLieuNhomNganh>();
            search(keyword, cophieu, nhomnganh);
        }


        public ArrayList<Integer> getSoulution1(){
            return solution1;
        }
        public ArrayList<Integer> getSoulution2(){
            return solution2;
        }

        public ArrayList<Integer> getSolution3(){
            return solution3;
        }

    }


