package Model;

public class LinkMaCoPhieu {
    private String ten;
    private String link;

    public LinkMaCoPhieu() {
        this("", "");
    }

    public LinkMaCoPhieu(String ten, String link) {
        this.ten = ten;
        this.link = link;
    }

    public String getTen() {
        return ten;
    }

    public String getLink() {
        return link;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setLink(String link) {
        this.link = link;
    }
}