import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class STUDYTEST {
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("\\\\Desktop-uj7gie3\\공유폴더\\과제\\함예정\\20240924");
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        while(true) {
            System.out.println("while");
            WatchKey key = watchService.take();
            System.out.println("key = " + key);
            Path p = (Path)key.pollEvents().get(0).context();
            System.out.println("key.pollEvents = " + p.getFileName());
            key.reset();
            key.reset();
        }
    }
}
