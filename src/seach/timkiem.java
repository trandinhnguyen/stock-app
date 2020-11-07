package seach;

import Model.DuLieuSinhCau;

import java.util.ArrayList;
import java.util.Date;

public class timkiem {
    public static int timkiemdl(String agr1[],String agr2[],int i,int n){
        if(i==n&&agr1[i]==agr2[i]){
            return 1;
        } else if(agr1[i]==agr2[i]){
            return timkiem1(agr1[],agr2[],i+1,n);
        }else {
            return 0;}
    }



    public timkiem() {
        ArrayList<DuLieuSinhCau> datas = new ArrayList<DuLieuSinhCau>();

        DuLieuSinhCau d = new DuLieuSinhCau("FPT", new Date(), "dfsdfsdfffffffffggggffffffffff");
        datas.add(d);
    }
}
