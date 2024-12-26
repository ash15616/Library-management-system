package library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("borrow_book")
public class BorrowBook {
    @TableId(type = IdType.AUTO)
    private Long borrowId;
    //图书id
    private Long bookId;
    //借书人id
    private Long readerId;
    //借书时间
    private Date borrowTime;
    //还书时间
    private Date returnTime;
    //0: 待审核 1： 已审核  2：拒绝
    private String applyStatus;
    //0：审核中 1:在借中  2：已还   3：拒绝
    private String borrowStatus;
    //1: 正常还书 2：异常还书
    private String returnStatus;
    //异常还书备注
    private String excepionText;
    //审核拒绝备注
    private String applyText;

    public BorrowBook() {
    }

    @Override
    public String toString() {
        return "BorrowBook{" +
                "borrowId=" + borrowId +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", borrowTime=" + borrowTime +
                ", returnTime=" + returnTime +
                ", applyStatus='" + applyStatus + '\'' +
                ", borrowStatus='" + borrowStatus + '\'' +
                ", returnStatus='" + returnStatus + '\'' +
                ", excepionText='" + excepionText + '\'' +
                ", applyText='" + applyText + '\'' +
                '}';
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
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

    public String getExcepionText() {
        return excepionText;
    }

    public void setExcepionText(String excepionText) {
        this.excepionText = excepionText;
    }

    public String getApplyText() {
        return applyText;
    }

    public void setApplyText(String applyText) {
        this.applyText = applyText;
    }

    public BorrowBook(Long borrowId, Long bookId, Long readerId, Date borrowTime, Date returnTime, String applyStatus, String borrowStatus, String returnStatus, String excepionText, String applyText) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.readerId = readerId;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
        this.applyStatus = applyStatus;
        this.borrowStatus = borrowStatus;
        this.returnStatus = returnStatus;
        this.excepionText = excepionText;
        this.applyText = applyText;
    }
}
