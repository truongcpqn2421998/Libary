package model;

import java.time.LocalDate;

public class Order {
    private LocalDate borrowDate;
    private LocalDate deadLine;
    private Book book;
    private Student student;

    public Order() {
    }
    public Order(LocalDate borrowDate, LocalDate deadLine, Book book, Student student) {
        this.borrowDate = borrowDate;
        this.deadLine = deadLine;
        this.book = book;
        this.student = student;
        book.setStatus(false);
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Order{" +
                "borrowDate=" + borrowDate +
                ", deadLine=" + deadLine +
                ", book=" + book +
                ", student=" + student +
                '}';
    }
}
