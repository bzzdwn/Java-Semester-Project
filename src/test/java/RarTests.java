
import exam.project.archivators.RarArchivator;
import exam.project.archivators.ZipArchivator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RarTests {

    @Test
    void rarTest() throws IOException {
        RarArchivator rarArchivator = new RarArchivator();
        rarArchivator.archive("input.txt.rar", "input.txt");
        File fileExp = new File("examples\\input.txt.rar");
        assertNotNull(fileExp);
    }

    @Test
    void unrarTest() throws IOException {
        RarArchivator rarArchivator = new RarArchivator();
        rarArchivator.unarchive("C:\\Users\\User\\Documents\\Java\\ExamProjectWebUI\\examples\\input.txt.rar");
        File fileExp = new File("examples\\input.txt");
        assertNotNull(fileExp);
    }
}