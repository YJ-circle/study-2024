package nested.test.ex1;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books =  new ArrayList<>();
    private int limit;


    Library(int size) {
        limit = size;
    }
    public void addBook(String bookName, String bookAuthor) {
        if(books.size() < limit){
            System.out.println("books.size() = " + books.size());
            books.add(new Book(bookName, bookAuthor));    
        } else {
            System.out.println("도서관 저장 공간이 부족합니다");
        }
        
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println("도서 제목: " + book.title + ", 저자: "+ book.author);
        }
    }

    private static class Book {
        String title;
        String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }
}
