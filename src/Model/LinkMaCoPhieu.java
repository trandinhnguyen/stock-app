package Model;

public class LinkMaCoPhieu {
    private String ten;
    private String linkDataHistory;
    private String linkDataCompany;
    private String linkDataIndex;

    public LinkMaCoPhieu() {
        this("", "", "", "");
    }

    public LinkMaCoPhieu(String ten, String linkDataHistory, String linkDataCompany, String linkDataIndex) {
        this.ten = ten;
        this.linkDataHistory = linkDataHistory;
        this.linkDataCompany = linkDataCompany;
        this.linkDataIndex = linkDataIndex;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLinkDataHistory() {
        return linkDataHistory;
    }

    public void setLinkDataHistory(String linkDataHistory) {
        this.linkDataHistory = linkDataHistory;
    }

    public String getLinkDataCompany() {
        return linkDataCompany;
    }

    public void setLinkDataCompany(String linkDataCompany) {
        this.linkDataCompany = linkDataCompany;
    }

    public String getLinkDataIndex() {
        return linkDataIndex;
    }

    public void setLinkDataIndex(String linkDataIndex) {
        this.linkDataIndex = linkDataIndex;
    }
}