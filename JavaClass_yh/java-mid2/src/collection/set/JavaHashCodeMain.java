package collection.set;

import collection.set.member.Member;

public class JavaHashCodeMain {
    public static void main(String[] args) {
        //Objct의 기본 HashCode는 객체의 참조값 기본 생성
        
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println("obj2.hashCode() = " + obj2.hashCode());
        System.out.println("obj1.hashCode() = " + obj1.hashCode());
        
        //Java의 toString 메소드는 hashcode값을 16진수로 바꾸어줍니다.
        System.out.println(Integer.toHexString(obj1.hashCode()));

        Integer i = 10;
        String strA = "A";
        String strAB = "AB";
        System.out.println("10.hashCode() = " + i.hashCode());
        System.out.println("a.hasCode() = " + strA.hashCode());
        System.out.println("ab.hasCode() = " + strAB.hashCode());

        //hashCode는 마이너스 값이 들어올 수도 있다.
        System.out.println("-1.hashCode() = " + Integer.valueOf(-1).hashCode());

        // 둘은 같을까?

        Member member1 = new Member("idA");
        Member member2 = new Member("idA");

        
        //equals, hashCode를 오버라이딩 하지 않은 경우와 한 경우 비교
        System.out.println("member1 == member2 = " + (member1 == member2));
        System.out.println("member1 == member2 = " + (member1.equals(member2)));
        System.out.println("member1.hashCode() = " + member1.hashCode());
        System.out.println("member2.hashCode() = " + member2.hashCode()); // 오버라이딩 안하면 해시코드가 다르게 나온다.
        
    }
}
