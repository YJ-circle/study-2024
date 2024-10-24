package studyfrontpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Run {
	public static void main(String[] args) {
		
		//출력할 리스트를 만듭니다.
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>(List.of("a", "b"));
		
		//리스트를 출력합니다.
		listPrint(list1);	
		listPrint(list2);
		
		listPrint2(list1);
		listPrint2(list2);
		
		listPrintException(list1);
		listPrintException(list2);
		
	
		
		System.out.println("===리스트 출력===");
		if(list1.size() != 0) {
			for (String string : list1) {
				System.out.println(string);
			}
		} else {
			System.out.println("빈 리스트 입니다.");
		}
		System.out.println("=== 출력 종료 ===");
		System.out.println();
		System.out.println("===리스트 출력===");
		if(list2.size() != 0) {
			for (String string : list2) {
				System.out.println(string);
			}
		} else {
			System.out.println("빈 리스트 입니다.");
		}
		System.out.println("=== 출력 종료 ===");
		System.out.println();
		
		
		System.out.println(printMsg(list1).orElse("빈리스트 입니다\n"));
		System.out.println(printMsg(list2).orElse("빈리스트 입니다\n"));
	}
	
	

	
	private static void listPrint(List<String> list) {;
		System.out.println("===리스트 출력===");
		if(emptyValue(list)) {
			System.out.println("빈 리스트 입니다.");
			return;
		}
		
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("=== 출력 종료 ===");
		System.out.println();
		
	}
	
	private static void listPrint2(List<String> list) {;
	System.out.println("===리스트 출력===");
	if(hasValue(list)) {
		for (String string : list) {
			System.out.println(string);
		}
	} else {
		System.out.println("빈 리스트 입니다.");
	}
	System.out.println("=== 출력 종료 ===");
	System.out.println();
	
	}
	
	private static void listPrintException(List<String> list) {
		System.out.println("===리스트 출력===");
		try {
			if(emptyValue(list)) {
				System.out.println("빈 리스트 입니다.");
				throw new RuntimeException("빈 리스트 예외");
			}
			
			for (String string : list) {
				System.out.println(string);
			}
		} catch (RuntimeException e) {
			System.out.println("\n예외발생\n");
		} finally {
			System.out.println("=== 출력 종료 ===");
			System.out.println();
		}
		
		
	}
	
	private static Optional<String> printMsg(List<String> list) {
		String string = null;
		
		//리스트에 값이 있으면 StringBulider에 값 추가
		if(!list.isEmpty()) {
			StringBuilder str = new StringBuilder();
			
			str.append("===리스트 출력===\n");
			for (String s : list) {
				str.append(s+"\n");
			}
			str.append("===출력 종료===\n");
			string = str.toString();
		}
		
		return Optional.ofNullable(string);
		
	}
	
	//size 0 이면 true
	private static boolean emptyValue(List<String> list) {
		return list.size() == 0;
	}
	
	//size 0 이면 false
	private static boolean hasValue(List<String> list) {
		return list.size() != 0;
	}

}
