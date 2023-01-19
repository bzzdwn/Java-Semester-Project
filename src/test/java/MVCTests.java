import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import exam.project.web.config.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes= SpringConfig.class)
public class MVCTests {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testMainPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("main"));
    }
    @Test
    public void testReadPage() throws Exception {
        mockMvc.perform(get("/read"))
                .andExpect(status().isOk())
                .andExpect(view().name("read"));
    }
    @Test
    public void testArchivePage() throws Exception {
        mockMvc.perform(get("/archive"))
                .andExpect(status().isOk())
                .andExpect(view().name("archive"));
    }
    @Test
    public void testZipPage() throws Exception {
        mockMvc.perform(get("/archive/archive/zip/upload"))
                .andExpect(status().isOk())
                .andExpect(view().name("fileform"));
    }
    @Test
    public void testRarPage() throws Exception {
        mockMvc.perform(get("/archive/archive/rar/upload"))
                .andExpect(status().isOk())
                .andExpect(view().name("fileform"));
    }
    @Test
    public void testJarPage() throws Exception {
        mockMvc.perform(get("/archive/archive/jar/upload"))
                .andExpect(status().isOk())
                .andExpect(view().name("fileform"));
    }
    @Test
    public void testCryptPage() throws Exception {
        mockMvc.perform(get("/crypt"))
                .andExpect(status().isOk())
                .andExpect(view().name("crypt"));
    }
    @Test
    public void testEncryptPage() throws Exception {
        mockMvc.perform(get("/crypt/encrypt/upload"))
                .andExpect(status().isOk())
                .andExpect(view().name("fileform"));
    }
    @Test
    public void testDecryptPage() throws Exception {
        mockMvc.perform(get("/crypt/decrypt/upload"))
                .andExpect(status().isOk())
                .andExpect(view().name("fileform"));
    }
    @Test
    public void testTxtPage() throws Exception {
        mockMvc.perform(get("/read/txt/upload"))
                .andExpect(status().isOk())
                .andExpect(view().name("fileform"));
    }
    @Test
    public void testJsonPage() throws Exception {
        mockMvc.perform(get("/read/json/upload"))
                .andExpect(status().isOk())
                .andExpect(view().name("fileform"));
    }
    @Test
    public void testXmlPage() throws Exception {
        mockMvc.perform(get("/read/xml/upload"))
                .andExpect(status().isOk())
                .andExpect(view().name("fileform"));
    }
}