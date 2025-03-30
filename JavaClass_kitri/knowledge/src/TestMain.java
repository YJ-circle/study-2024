import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class TestMain {
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InterruptedException{
//		WatchService watchService = FileSystems.getDefault().newWatchService();
//		Path path = Paths.get("\\\\Desktop-uj7gie3\\공유폴더\\과제\\함예정\\20240924");
//		path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
//		
//		while(true) {
//			WatchKey key = watchService.take();
//			System.out.println("변경발생:" + path.getFileName());
//			key.pollEvents();
//			key.reset();
//		}
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.getClass();
		
		
		
		
		
	}
	
	//파일 모니터링
	//암호화
	public static String encrypt(String text) throws NoSuchAlgorithmException {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(text.getBytes(StandardCharsets.UTF_8));
		 	 byte[] encoding = Base64.getEncoder().encode(md.digest());
		 	 ByteArrayOutputStream bt = new ByteArrayOutputStream();

			String salt="";
			try {
				SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
				byte[] bytes = new byte[16];
				random.nextBytes(bytes);
				salt = new String(Base64.getEncoder().encode(bytes));
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return salt;
		}
}
