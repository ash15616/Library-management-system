package library.model;


public class LookParm {
    private Long userId;
    //当前页
    private Long currentPage;
    //每页条数
    private Long pageSize;
    //学号
    private String username;
    //姓名
    private String learnNum;
    private String bookName;
     //0: 待审核 1： 已审核  2：拒绝
    private String applyStatus;
    //1:在借中  2：已还   3：拒绝
    private String borrowStatus;
    //1: 正常还书 2：异常还书
    private String returnStatus;
    // 1:到期 0：未到期
    private String timeStatus;

    public LookParm() {
    }

    @Override
    public String toString() {
        return "LookParm{" +
                "userId=" + userId +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", username='" + username + '\'' +
                ", learnNum='" + learnNum + '\'' +
                ", bookName='" + bookName + '\'' +
                ", applyStatus='" + applyStatus + '\'' +
                ", borrowStatus='" + borrowStatus + '\'' +
                ", returnStatus='" + returnStatus + '\'' +
                ", timeStatus='" + timeStatus + '\'' +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getLearnNum() {
        return learnNum;
    }

    public void setLearnNum(String learnNum) {
        this.learnNum = learnNum;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(String borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getTimeStatus() {
        return timeStatus;
    }

    public void setTimeStatus(String timeStatus) {
        this.timeStatus = timeStatus;
    }

    public LookParm(Long userId, Long currentPage, Long pageSize, String username, String learnNum, String bookName, String applyStatus, String borrowStatus, String returnStatus, String timeStatus) {
        this.userId = userId;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.username = username;
        this.learnNum = learnNum;
        this.bookName = bookName;
        this.applyStatus = applyStatus;
        this.borrowStatus = borrowStatus;
        this.returnStatus = returnStatus;
        this.timeStatus = timeStatus;
    }
}