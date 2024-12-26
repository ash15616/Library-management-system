package library.model;

public class ReaderParm {
    private Long currentPage;
    private Long pageSize;
    private String username;
    private String idCard;
    private String phone;
    private String learnNum;

    @Override
    public String toString() {
        return "ReaderParm{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", username='" + username + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", learnNum='" + learnNum + '\'' +
                '}';
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLearnNum() {
        return learnNum;
    }

    public void setLearnNum(String learnNum) {
        this.learnNum = learnNum;
    }

    public ReaderParm(Long currentPage, Long pageSize, String username, String idCard, String phone, String learnNum) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.username = username;
        this.idCard = idCard;
        this.phone = phone;
        this.learnNum = learnNum;
    }

    public ReaderParm() {
    }
}
