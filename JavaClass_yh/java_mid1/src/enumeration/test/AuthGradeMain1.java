package enumeration.test;

public class AuthGradeMain1 {
    public static void main(String[] args) {
        AuthGrade[] grade = AuthGrade.values();
        for (AuthGrade authGrade : grade) {
            System.out.println("grade = " + authGrade + ", level = " + authGrade.getLevel()
                    + ", 설명 = " + authGrade.getDescription());
        }
    }
}
