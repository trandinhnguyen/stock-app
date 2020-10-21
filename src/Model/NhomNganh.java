package Model;

public class NhomNganh {
    private String id;
    private String ten;
    private float diem;
    private float tyLe;
    private float khoiLuong;

    public NhomNganh(String id, String ten, float diem, float tyLe, float khoiLuong) {
        this.id = id;
        this.ten = ten;
        this.diem = diem;
        this.khoiLuong = khoiLuong;
        this.tyLe = tyLe;
    }

    public float compare( NhomNganh quaKhu) {
        return 1;
    }
}
