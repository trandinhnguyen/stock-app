package seach;

import Model.DuLieuCongTy;
import Model.DuLieuMaCoPhieu;

import java.util.ArrayList;

public abstract class SearchDuLieuCongTy extends Search {
    public SearchDuLieuCongTy(ArrayList searchObject, String text) {
        super(searchObject, text);
    }

    @Override
    public boolean soSanh(DuLieuCongTy str, String text) {
        return false;
    }
}
