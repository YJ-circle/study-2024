package nested.test.ex1;

public class LibraryMain {
    public static void main(String[] args) {
        Library liberary = new Library(4); // 최대 4권의 도서를 저장할 수 있는 도서관
        liberary.addBook("책1", "저자1");
        liberary.addBook("책2", "저자2");
        liberary.addBook("책3", "저자3");
        liberary.addBook("책4", "저자4");
        liberary.addBook("책5", "저자5"); //Print ERROR Msg
        liberary.showBooks(); // 도서관 모든 도서 출력

    }
}
