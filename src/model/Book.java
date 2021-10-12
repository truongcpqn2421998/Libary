package model;

public class Book {
    private String title;
    private String category;
    private String code;
    private boolean status=true;

    public Book() {
    }
    public Book(String title, String category, String code) {
        this.title = title;
        this.category = category;
        this.code = code;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
