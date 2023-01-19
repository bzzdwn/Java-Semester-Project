
import exam.project.archivators.ZipArchivator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ZipTests {

    @Test
    void zipTest() throws IOException {
        ZipArchivator zipArchivator = new ZipArchivator();
        zipArchivator.archive("input.txt.zip", "C:\\Users\\User\\Documents\\Java\\ExamProjectWebUI\\examples\\input.txt");
        File fileExp = new File("examples\\input.txt.zip");
        assertNotNull(fileExp);
    }

    @Test
    void unzipTest() throws IOException {
        ZipArchivator zipArchivator = new ZipArchivator();
        zipArchivator.unarchive("C:\\Users\\User\\Documents\\Java\\ExamProjectWebUI\\examples\\input.txt.zip");
        File fileExp = new File("examples\\input.txt");
        assertNotNull(fileExp);
    }
}