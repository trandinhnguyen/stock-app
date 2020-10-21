package Model;

public class VNINDEX {
    private String id;
    private static final String ten = "VNINDEX";
    private float diem;
    private float tyLe;
    private float khoiLuong;

    public VNINDEX(String id, float diem, float tyLe, float khoiLuong) {
        this.id = id;
        this.diem = diem;
        this.khoiLuong = khoiLuong;
        this.tyLe = tyLe;
    }

    public float compare( VNINDEX quaKhu) {
        return 1;
    }
}
