package vo;

public class BookVO {
    private int bookNum;        // autoIncrement 책번호
    private String bookTitle;   // 책제목
    private String bookPub;     // 출판사
    private int bookPrice;      // 책 가격
    private String pubYear;     // 출판년도
////////////////////////////////////////////////////////////
    // 생성자
    public BookVO(int bookNum, String bookTitle, String bookPub, int bookPrice, String pubYear) {
        this.bookNum = bookNum;
        this.bookTitle = bookTitle;
        this.bookPub = bookPub;
        this.bookPrice = bookPrice;
        this.pubYear = pubYear;
    }
     
    public BookVO(String bookTitle, String bookPub, int bookPrice, String pubYear) {
        this.bookTitle = bookTitle;
        this.bookPub = bookPub;
        this.bookPrice = bookPrice;
        this.pubYear = pubYear;
    }
     
    public BookVO(){
    }
////////////////////////////////////////////////////////////    
    // 접근자&설정자 (getter&setter)
    public int getBookNum() {
        return bookNum;
    }
    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getBookPub() {
        return bookPub;
    }
    public void setBookPub(String bookPub) {
        this.bookPub = bookPub;
    }
    public int getBookPrice() {
        return bookPrice;
    }
    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }
    public String getPubYear() {
        return pubYear;
    }
    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }
//////////////////////////////////////////////////////////////////  
    @Override
    public String toString() {
        return "BookVO [bookNum=" + bookNum + ", bookTitle=" + bookTitle + ", bookPub=" + bookPub + ", bookPrice="
                + bookPrice + ", pubYear=" + pubYear + "]";
    }   	
}
