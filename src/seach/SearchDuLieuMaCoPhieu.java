package seach;

import Model.DuLieuCongTy;
import Model.DuLieuMaCoPhieu;

import java.util.ArrayList;

public abstract class SearchDuLieuMaCoPhieu extends Search {

    public SearchDuLieuMaCoPhieu(ArrayList searchObject, String text) {
        super(searchObject, text);
    }

    @Override
    public boolean soSanh(DuLieuMaCoPhieu str, String text) {
        if(str.getGiaTri().contains(text) || str.getIdNhomNganh().contains(text) || str.getId().contains(text) || str.getDiem().contains(text) || str.getRSI().contains(text) || str.getTen().contains(text) || str.getTyLe().contains(text)){
            return true;
        }else return false;
    }
}
