package MyStudyOptional;

import java.lang.reflect.Constructor;
import java.util.Optional;

public class OptionalTestMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        //class 정보 가져오기
        Class<?> person = Class.forName("util.MyLogger");
        System.out.println("person.getClass() = " + person.getClass().getDeclaredMethods());


        //방법1: Null > 예외 던지기
        try{
//            Person person1 = findById(1L).orElseThrow(RuntimeException::new);
            Person person2 = findById(1L).orElseThrow(() -> new RuntimeException("Empty"));
            System.out.println(person2.getId());
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        }
        
        // 방법2: Null > 기본값
        // 무조건 검증하기 때문에 객체가 생성된다. 무.조.건
//        Person person3 = findById(1L).orElse(new Person(0L, "UNKNOWN_PERSON"));
        Person person3 = findById(1L).orElse(Person.getEmptyMember());
        System.out.println("person3 = " + person3.getId() + ", " + person3.getName());

        //값이 없을 때만 생성함. 람다로 인자를 받음
        Person person4 = findById(2L).orElseGet(() -> new Person(0L, "UNKNOWN_PERSON"));
        System.out.println("person4 = " + person4.getId() + ", " + person4.getName());




    }
    static Optional<Person> findById(Long id){
        if(id.equals(2L)){
            return Optional.of(new Person(2L, "exist"));
        }
        return Optional.empty();
    }
    static class Person{
        private static final Person EMPTY_MEMBER = new Person(0L, "NO_MEMBER");
        Long id;
        String name;

        public Person(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public static Person getEmptyMember(){
            return EMPTY_MEMBER;
        }
    }
}
