package exam.project.web.controllers.upload;

// Importing required classes
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

import exam.project.archivators.JarArchivator;
import exam.project.archivators.RarArchivator;
import exam.project.archivators.ZipArchivator;
import exam.project.web.controllers.FileDownloadController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

// Annotation
@Controller
// Class
public class ArchiveJarUploadFileController {

    @GetMapping("archive/archive/jar/upload") public String upload()
    {
        return "fileform";
    }

    @RequestMapping(value = "archive/archive/jar/uploadfile",
            method = RequestMethod.POST)
    public String
    fileUpload(@RequestParam("thisfile")
               CommonsMultipartFile file, HttpSession s,
               Model mod)
    {

        byte[] data = file.getBytes();

        String filePath
                = s.getServletContext().getRealPath("/")
                + "downloads"
                + File.separator
                + file.getOriginalFilename();
        try {

            FileOutputStream fileout
                    = new FileOutputStream(filePath);
            fileout.write(data);

            fileout.close();
            JarArchivator jarArchivator = new JarArchivator();
            try {
                jarArchivator.archive(filePath, filePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String filename = "";
            Pattern pattern = Pattern.compile("([\\w+.]+\\w+)$");
            Matcher matcher = pattern.matcher(filePath);
            while (matcher.find())
                filename = matcher.group(1);
            FileDownloadController.setPath(filename + ".jar");
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/download.do";
    }


}
