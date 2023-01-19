
import exam.project.converters.CryptConverter;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionTests {

    @Test
    void Test1() throws Exception {
        CryptConverter cryptConverter = new CryptConverter();
        cryptConverter.encrypt("C:\\Users\\User\\Documents\\Java\\ExamProjectWebUI\\examples\\input.txt");
        File fileExp = new File("C:\\Users\\User\\Documents\\Java\\ExamProjectWebUI\\examples\\input_encrypted.txt");
        assertNotNull(fileExp);
    }
}