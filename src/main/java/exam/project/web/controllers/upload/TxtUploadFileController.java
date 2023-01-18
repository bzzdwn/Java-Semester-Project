package exam.project.web.controllers.upload;

// Importing required classes
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

import exam.project.archivators.ZipArchivator;
import exam.project.converters.CryptConverter;
import exam.project.converters.builder.IReadWriter;
import exam.project.converters.builder.JsonConverter;
import exam.project.converters.builder.TxtConverter;
import exam.project.converters.builder.XMLConverter;
import exam.project.expressions.ExpressionsList;
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
public class TxtUploadFileController {

    @GetMapping("read/txt/upload") public String upload()
    {
        return "fileform";
    }

    @RequestMapping(value = "read/txt/uploadfile",
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
            IReadWriter reader;
            TxtConverter txtConverter = new TxtConverter();
            Pattern pattern = Pattern.compile("(\\w+)$");
            Matcher matcher = pattern.matcher(filePath);
            String input_extension = "";
            while (matcher.find())
                input_extension = matcher.group();
            if (input_extension.equals("txt")){
                reader = new TxtConverter();
            } else if (input_extension.equals("json")){
                reader = new JsonConverter();
            } else {
                reader = new XMLConverter();
            }
            ExpressionsList expressionsList = new ExpressionsList();
            reader.Read(filePath, expressionsList);
            pattern = Pattern.compile("([\\w:\\\\]+)[\\\\](\\w+)[.]([a-z]+)$");
            matcher = pattern.matcher(filePath);
            String newFile = "", newFile2 = "";
            while (matcher.find()) {
                newFile = matcher.group(1) + "\\" + matcher.group(2) + ".txt";
                newFile2 = matcher.group(2) + ".txt";
            }
            txtConverter.Write(newFile, expressionsList);

            FileDownloadController.setPath(newFile2);
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/download.do";
    }


}
