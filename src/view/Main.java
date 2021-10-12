package view;

import manager.ManagerLibrary;
import model.Book;
import model.Card;
import model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static ManagerLibrary library=new ManagerLibrary();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        while(choice!=0){
            System.out.println("------MENU------");
            System.out.println("1.Add a new Student ");
            System.out.println("2.Remove a student ");
            System.out.println("3.Add a new Book ");
            System.out.println("4.Remove a book ");
            System.out.println("5.Create a order");
            System.out.println("6.Create a Card");
            System.out.println("7.Give book back");
            System.out.println("8.check a card");
            System.out.println("0.Exit");
            System.out.println("Enter choice");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    addNewBook();
                    break;
                case 4:
                    removeBook();
                    break;
                case 5:
                    createOrder();
                    break;
                case 6:
                    createCard();
                    break;
                case 7:
                    giveBookBack();
                    break;
                case 8:
                    checkCard();
                    break;
            }
        }
    }
    //Thêm sinh viên
    public static void addStudent(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a name");
        String name =scanner.nextLine();
        System.out.println("Enter student's age");
        String age =scanner.nextLine();
        System.out.println("Enter student's ID:");
        String id =scanner.nextLine();
        library.getStudentList().add(new Student(name,age,id));
    }
    //Xóa sinh viên
    public static void removeStudent(){
        Student student=checkIdOfStudent();
        library.getStudentList().remove(student);
    }
    //tìm kiếm sinh viên theo số ID
    private static Student checkIdOfStudent() {
        Scanner scanner=new Scanner(System.in);
        Student student=null;
        do{
            System.out.println("Enter student's ID:");
            String id=scanner.nextLine();
            student= library.checkIdStudent(id);
            if(student==null){
                System.out.println("id is not exist");
            }
        }while(student==null);
        return student;
    }
    //tạo sách mới
    public static void addNewBook(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter book's title");
        String title=scanner.nextLine();
        System.out.println("Enter book's category");
        String category=scanner.nextLine();
        System.out.println("Enter book's code");
        String code=scanner.nextLine();
        library.getBookList().add(new Book(title,category,code));
    }
    //xóa sách
    public static void removeBook(){
        Book deleteBook=checkCodeOfBook();
        library.getBookList().remove(deleteBook);
    }

    //Tìm kiếm sách theo code
    private static Book checkCodeOfBook() {
        Scanner scanner=new Scanner(System.in);
        Book book=null;
        do{
            System.out.println("Enter Code");
            String code=scanner.nextLine();
            book=library.checkCodeBook(code);
            if(book==null){
                System.out.println("Code is not exist");
            }
        }while (book==null);
        return book;
    }
    //tạo 1 ngày
    public static LocalDate createDay(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Day:");
        int day=scanner.nextInt();
        System.out.println("Enter Month:");
        int month=scanner.nextInt();
        System.out.println("Enter Year:");
        int year=scanner.nextInt();
        return LocalDate.of(year,month,day);
    }
    //tạo 1 order mới
    public static void createOrder(){
        Student student= checkIdOfStudent();
        if(library.checkCard(student)!=null){
            Book book=checkCodeOfBook();
            if(book.isStatus()){
                System.out.println("Enter borrow day:");
                LocalDate borrow=createDay();
                System.out.println("Enter deadline day:");
                LocalDate deadline=createDay();
                library.createOrder(borrow,deadline,book,student);
            }else {
                System.out.println("Book was borrow ");
            }
        }else {
            System.out.println("You must create card first");
        }
    }

    //tạo card mới
    public static void createCard(){
        Student student=checkIdOfStudent();
        Card card=library.createCard(student);
        library.getCardList().add(card);
    }

    //trả lại sách
    public static void giveBookBack(){
        System.out.println("Enter Book's Code you want to give back:");
        Book book=checkCodeOfBook();
        System.out.println("Enter Student want give back book");
        Student student=checkIdOfStudent();
        library.giveBack(book,student);
    }

    //kiểm tra card
    public static void checkCard(){
        System.out.println("Enter student's id want to check:");
        Student student=checkIdOfStudent();
        System.out.println(library.checkCard(student).toString());
    }
}
