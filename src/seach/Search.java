package seach;

import Model.DuLieuCongTy;
import Model.DuLieuMaCoPhieu;
import Model.DuLieuNhomNganh;
import Model.DuLieuSinhCau;
import java.util.ArrayList;
import java.util.Date;

public abstract class  Search<T> {
    private ArrayList<T> result;

    public Search (ArrayList<T> searchObject , String text){
        for (T str : searchObject){
            if (soSanh(str,text)){
                result.add(str);
            }
        }
    }
    public boolean soSanh(T str, String text){
        if(str.equals(text)){
            return true;
        }else return false;
    }

    public abstract boolean soSanh(DuLieuMaCoPhieu str, String text);

    public abstract boolean soSanh(DuLieuCongTy str, String text);
}





