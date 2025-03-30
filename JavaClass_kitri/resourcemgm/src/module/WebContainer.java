package module;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WebContainer {
	public void read(String path) throws IOException {
		// 1. context root path 정확한지 검사
		String[] ele = path.split("/");
		
		String contentRoot = ele[0];
		String filename = ele[1];
		
		if(invaildCrp(contentRoot)) {
			System.out.println("CRP 오류");
			return;
		}
		String fileFolder = getFolder(ele[1]);
		if(fileFolder == null) {
			fileFolder = StorageAccessGuide.SERVICE_STORAGE;
			filename += ".java";
		}
		
		File file = new File(fileFolder + filename);
		
		if(invaildFile(file)) {
			System.out.println("존재하지 않는 파일입니다.");
			return;
		}
		
		//출력
		BufferedReader br = new BufferedReader(new FileReader(file));
		while(br.readLine() != null) {
			System.out.println(br.readLine());
		}

	}

	private boolean invaildFile(File file) {
		return !file.isFile();
	}

	private boolean invaildCrp(String contentRoot) {
		return !contentRoot.equals(StorageAccessGuide.CONTEXT_ROOT_PATH);
	}
	
	private String getFolder(String file) {
		if(file.contains("html")) {
			return StorageAccessGuide.HTML_STORAGE;
		}
		
		if(file.contains("jsp")){
			return StorageAccessGuide.JSP_STORAGE;
		}
		
		return null;
	}
}
