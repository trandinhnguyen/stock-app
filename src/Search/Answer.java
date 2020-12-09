package Search;

import java.util.Comparator;

public class Answer<T> implements Comparator<Answer> {
    private String cauHienThi;

    private int viTri;
    private int chiSoUuTien;

    public Answer(String cauHienThi, int kieuDuLieu , int chiSoUuTien){
        this.cauHienThi = cauHienThi;

        this.viTri = viTri;
        this.chiSoUuTien = chiSoUuTien;
    }

    public Answer() {

    }


    public int getChiSoUuTien() {
        return chiSoUuTien;
    }

    public int getViTri() {
        return viTri;
    }


    public String getCauHienThi() {
        return cauHienThi;
    }

    @Override
    public int compare(Answer o1, Answer o2) {
        return o1.getChiSoUuTien() - o2.getChiSoUuTien();
    }
}
