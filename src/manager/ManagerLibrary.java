package manager;

import model.Book;
import model.Card;
import model.Order;
import model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerLibrary {
    List<Book> bookList = new ArrayList<>();
    List<Student> studentList = new ArrayList<>();
    List<Card> cardList = new ArrayList<>();
    List<Order> orderList = new ArrayList<>();

    public ManagerLibrary() {
    }

    public ManagerLibrary(List<Book> bookList, List<Student> studentList, List<Card> cardList, List<Order> orderList) {
        this.bookList = bookList;
        this.studentList = studentList;
        this.cardList = cardList;
        this.orderList = orderList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Student checkIdStudent(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equals(id)) {
                return studentList.get(i);
            }
        }
        return null;
    }

    public Book checkCodeBook(String code) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getCode().equals(code)) {
                return bookList.get(i);
            }
        }
        return null;
    }
    public Order createOrder(LocalDate borrow,LocalDate deadline,Book book, Student student){
        book.setStatus(false);
        Card card=checkCard(student);
        Order order=new Order(borrow,deadline,book,student);
        orderList.add(order);
        card.getOrderList().add(order);
        return order;
    }

    public Card createCard(Student student) {
        List<Order> ordersOfStudent = new ArrayList<>();
        Card card = new Card(student.getName(), student.getID(), ordersOfStudent);
        return card;
    }

    public Order checkOrder(Book book) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getBook().equals(book))
                return orderList.get(i);
        }
        return null;
    }

    public Card checkCard(Student student) {
        for (Card card : cardList
        ) {
            if (card.getID().equals(student.getID())) {
                return card;
            }
        }
        return null;
    }

    public void giveBack(Book book, Student student) {
        book.setStatus(true);
        Order order = checkOrder(book);
        orderList.remove(order);
        Card card = checkCard(student);
        card.getOrderList().remove(order);
    }
}
