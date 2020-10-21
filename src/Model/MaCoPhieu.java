package Model;

public class MaCoPhieu {
    private String id;
    private String idNhomNganh;
    private String ten;
    private float diem;
    private float tyLe;
    private float khoiLuong;
    private float giaMoCua;
    private float giaDongCua;
    private float RSI;

    public MaCoPhieu(String id, String idNhomNganh, String ten, float diem, float tyLe, float khoiLuong, float giaMoCua, float giaDongCua) {
        this.id = id;
        this.idNhomNganh = idNhomNganh;
        this.ten = ten;
        this.diem = diem;
        this.khoiLuong = khoiLuong;
        this.tyLe = tyLe;
        this.giaMoCua = giaMoCua;
        this.giaDongCua = giaDongCua;
    }

    public float compare( MaCoPhieu quaKhu) {
        return 1;
    }
}
