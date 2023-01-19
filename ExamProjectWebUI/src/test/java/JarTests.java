
import exam.project.archivators.JarArchivator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JarTests {

    @Test
    void jarTest() throws IOException {
        JarArchivator jarArchivator = new JarArchivator();
        jarArchivator.archive("input.json.jar", "C:\\Users\\User\\Documents\\Java\\ExamProjectWebUI\\examples\\input.json");
        File fileExp = new File("examples\\input.json.jar");
        assertNotNull(fileExp);
    }

    @Test
    void unjarTest() throws IOException {
        JarArchivator jarArchivator = new JarArchivator();
        jarArchivator.unarchive("C:\\Users\\User\\Documents\\Java\\ExamProjectWebUI\\examples\\input.json.jar");
        File fileExp = new File("C:\\Users\\User\\Documents\\Java\\ExamProjectWebUI\\examples\\input.JSON");
        assertNotNull(fileExp);
    }
}