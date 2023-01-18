package exam.project.cli;

import exam.project.archivators.IArchive;
import exam.project.archivators.JarArchivator;
import exam.project.archivators.RarArchivator;
import exam.project.archivators.ZipArchivator;
import exam.project.converters.*;
import exam.project.converters.builder.IReadWriter;
import exam.project.converters.builder.JsonConverter;
import exam.project.converters.builder.TxtConverter;
import exam.project.converters.builder.XMLConverter;
import exam.project.expressions.ExpressionsList;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleLineInterface {
    private IArchive iArchive;
    private IReadWriter iReadWriter;
    public ConsoleLineInterface(){
        boolean     isTrue = true;
        int         option = 0;
        int         option2 = 0;
        String      file_name = "";
        String      archive_name = "";
        System.out.println("Welcome to the Console Line Interface!");
        while (isTrue) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chose option to do (enter the number):\n" +
                    "1. Read arithmetic expression.\n" +
                    "2. Archive/Unarchive file.\n" +
                    "3. Encrypt/Decrypt file.\n" +
                    "4. Exit.");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Input file name:");
                    file_name = scanner.nextLine();
                    file_name = scanner.nextLine();
                    String tmp;
                    tmp = file_name.toLowerCase();
                    Pattern pattern = Pattern.compile("([a-z]+)$");
                    Matcher matcher = pattern.matcher(tmp);
                    if (matcher.find()) {
                        if (matcher.group().equals("txt")) {
                            iReadWriter = new TxtConverter();
                        } else if (matcher.group().equals("json")) {
                            iReadWriter = new JsonConverter();
                        } else if (matcher.group().equals("xml")) {
                            iReadWriter = new XMLConverter();
                        }
                        ExpressionsList expressionsList = new ExpressionsList();
                        try {
                            iReadWriter.Read(file_name, expressionsList);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (XMLStreamException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Operations were calculated!\nInput file to out result:");
                        file_name = scanner.nextLine();
                        tmp = file_name.toLowerCase();
                        if (matcher.group().equals("txt")){
                            iReadWriter = new TxtConverter();
                        } else if (matcher.group().equals("json")){
                            iReadWriter = new JsonConverter();
                        } else if (matcher.group().equals("xml")){
                            iReadWriter = new XMLConverter();
                        }
                        try {
                            iReadWriter.Write(file_name, expressionsList);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (XMLStreamException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("File with this name doesn't exists!");
                    }
                    break;
                case 2:
                    System.out.println("Choose archive extension:\n" +
                            "1. ZIP.\n" +
                            "2. RAR.\n" +
                            "3. JAR.");
                    option2 = scanner.nextInt();
                    if (option2 == 1) {
                        iArchive = new ZipArchivator();
                    } else if (option2 == 2) {
                        iArchive = new RarArchivator();
                    }
                    else if (option2 == 3) {
                        iArchive = new JarArchivator();
                    } else {
                        System.out.println("Wrong value!");
                        break;
                    }
                    System.out.println("Choose option:\n" +
                            "1. Archive file.\n" +
                            "2. Unarchive file.");
                    option2 = scanner.nextInt();
                    if (option2 == 1){
                        System.out.println("Write file name:");
                        file_name = scanner.nextLine();
                        file_name = scanner.nextLine();
                        System.out.println("Write archive name:");
                        archive_name = scanner.nextLine();
                        try {
                            iArchive.archive(archive_name, file_name);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Archived successfully!");
                    } else if (option2 == 2){
                        System.out.println("Write archive name:");
                        archive_name = scanner.nextLine();
                        archive_name = scanner.nextLine();
                        try {
                            iArchive.unarchive(archive_name);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Unarchived successfully!");
                    } else {
                        System.out.println("Wrong value!");
                        break;
                    }
                    break;
                case 3:
                    CryptConverter cryptConverter = new CryptConverter();
                    System.out.println("Choose option:\n" +
                            "1. Encrypt.\n" +
                            "2. Decrypt.");
                    option2 = scanner.nextInt();
                    System.out.println("Input file name:");
                    file_name = scanner.nextLine();
                    file_name = scanner.nextLine();
                    if (option2 == 1){
                        try {
                            cryptConverter.encrypt(file_name);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (option2 == 2){
                        try {
                            cryptConverter.decrypt(file_name);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 4:
                    isTrue = false;
                    break;
                default:
                    System.out.println("Wrong value!");
                    break;
            }
        }
    }
}
