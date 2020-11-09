package Model;

import java.util.Date;

public class DuLieuSinhCau {
    private String id;
    private Date ngay;
    private String cauSinhDuoc;

    public DuLieuSinhCau() {
        this("", null, "");
    }


    public DuLieuSinhCau(String id, Date ngay, String cauSinhDuoc) {
        this.id = id;
        this.ngay = ngay;
        this.cauSinhDuoc = cauSinhDuoc;
    }

    public String getId() {
        return id;
    }

    public Date getNgay() {
        return ngay;
    }

    public String getCauSinhDuoc() {
        return cauSinhDuoc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public void setCauSinhDuoc(String cauSinhDuoc) {
        this.cauSinhDuoc = cauSinhDuoc;
    }
}
