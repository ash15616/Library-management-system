package library.model;



import java.util.Date;
import java.util.List;

public class BorrowParm {
    private Long borrowId;
    //借书人id
    private Long readerId;
    //图书id
    private List<Long> bookIds;
    //还书时间
    private Date returnTime;

    public BorrowParm() {
    }

    public BorrowParm(Long borrowId, Long readerId, List<Long> bookIds, Date returnTime) {
        this.borrowId = borrowId;
        this.readerId = readerId;
        this.bookIds = bookIds;
        this.returnTime = returnTime;
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public List<Long> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Long> bookIds) {
        this.bookIds = bookIds;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    @Override
    public String toString() {
        return "BorrowParm{" +
                "borrowId=" + borrowId +
                ", readerId=" + readerId +
                ", bookIds=" + bookIds +
                ", returnTime=" + returnTime +
                '}';
    }
}