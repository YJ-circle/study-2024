package optional;

import java.util.Optional;

public class RunMain {
	public static void main(String[] args) {
		String[] str = new String[10];
		str[0] = "test1";
		str[1] = "test2";
		str[2] = "test3";
		
		Optional<String> checknull1 = Optional.ofNullable(str[0]);
		Optional<String> checknull2 = Optional.ofNullable(str[3]);
		System.out.println("checknull1 = " + checknull1);
		System.out.println("checknull2 = " + checknull2);
		checknull1 = Optional.ofNullable(str[1]);
		System.out.println("checknull1 = " + checknull1);
		
		System.out.println(checknull2.orElse("값이 없습니다."));
		
		
	}

}
