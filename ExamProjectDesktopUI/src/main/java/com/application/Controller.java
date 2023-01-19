package com.application;

import com.archivators.IArchive;
import com.archivators.JarArchivator;
import com.archivators.RarArchivator;
import com.converters.CryptConverter;
import com.converters.builder.IReadWriter;
import com.converters.builder.JsonConverter;
import com.converters.builder.TxtConverter;
import com.converters.builder.XMLConverter;
import com.expressions.ExpressionsList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.archivators.ZipArchivator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller {
    private boolean chooseFile;
    private File selectedFile;
    @FXML
    private Label fileLabel;
    @FXML
    private Label resultLabel;
    @FXML
    private Button chooseButton;

    @FXML
    void actionButton() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose file");
        selectedFile = fileChooser.showOpenDialog(new Stage());
        fileLabel.setText("File: " + selectedFile.getName());
        chooseFile = true;
    }
    @FXML
    void actionJSON(){
        if (!chooseFile) {
            fileLabel.setText("Choose file!");
            return;
        }
        try {
            IReadWriter reader = null;
            JsonConverter jsonConverter = new JsonConverter();
            Pattern pattern = Pattern.compile("(\\w+)$");
            Matcher matcher = pattern.matcher(selectedFile.getPath());
            String input_extension = "";
            while (matcher.find())
                input_extension = matcher.group();
            if (input_extension.equals("txt")){
                reader = new TxtConverter();
                resultLabel.setText("Result: File converted into JSON.");
            } else if (input_extension.equals("json")){
                reader = new JsonConverter();
                resultLabel.setText("Result: File converted into JSON.");
            } else if (input_extension.equals("xml")) {
                reader = new XMLConverter();
                resultLabel.setText("Result: File converted into JSON.");
            } else {
                resultLabel.setText("File: Chosen file has incorrect extension!");
            }
            ExpressionsList expressionsList = new ExpressionsList();
            reader.Read(selectedFile.getPath(), expressionsList);
            pattern = Pattern.compile("([\\w:\\\\]+)[\\\\](\\w+)[.]([a-z]+)$");
            matcher = pattern.matcher(selectedFile.getPath());
            String newFile = "";
            while (matcher.find()) {
                newFile = matcher.group() + ".json";
            }
            jsonConverter.Write(newFile, expressionsList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void actionTXT(){
        if (!chooseFile) {
            fileLabel.setText("Choose file!");
            return;
        }
        try {
            IReadWriter reader = null;
            TxtConverter txtConverter = new TxtConverter();
            Pattern pattern = Pattern.compile("(\\w+)$");
            Matcher matcher = pattern.matcher(selectedFile.getPath());
            String input_extension = "";
            while (matcher.find())
                input_extension = matcher.group();
            if (input_extension.equals("txt")){
                reader = new TxtConverter();
                resultLabel.setText("Result: File converted into TXT.");
            } else if (input_extension.equals("json")){
                reader = new JsonConverter();
                resultLabel.setText("Result: File converted into TXT.");
            } else if (input_extension.equals("xml")) {
                reader = new XMLConverter();
                resultLabel.setText("Result: File converted into TXT.");
            } else {
                resultLabel.setText("File: Chosen file has incorrect extension!");
            }
            ExpressionsList expressionsList = new ExpressionsList();
            reader.Read(selectedFile.getPath(), expressionsList);
            pattern = Pattern.compile("([\\w:\\\\]+)[\\\\](\\w+)[.]([a-z]+)$");
            matcher = pattern.matcher(selectedFile.getPath());
            String newFile = "";
            while (matcher.find()) {
                newFile = matcher.group() + ".txt";
            }
            txtConverter.Write(newFile, expressionsList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void actionRar(){
        if (!chooseFile) {
            fileLabel.setText("Choose file!");
            return;
        }
        try {
            RarArchivator rarArchivator = new RarArchivator();
            try {
                rarArchivator.archive(selectedFile.getPath(), selectedFile.getPath());
                resultLabel.setText("Result: Rar archived Successfully!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void actionJar(){
        if (!chooseFile) {
            fileLabel.setText("Choose file!");
            return;
        }
        try {
            JarArchivator jarArchivator = new JarArchivator();
            try {
                jarArchivator.archive(selectedFile.getPath(), selectedFile.getPath());
                resultLabel.setText("Result: Jar archived Successfully!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void actionXML(){
        if (!chooseFile) {
            fileLabel.setText("Choose file!");
            return;
        }
        try {
            IReadWriter reader = null;
            XMLConverter xmlConverter = new XMLConverter();
            Pattern pattern = Pattern.compile("(\\w+)$");
            Matcher matcher = pattern.matcher(selectedFile.getPath());
            String input_extension = "";
            while (matcher.find())
                input_extension = matcher.group();
            if (input_extension.equals("txt")){
                reader = new TxtConverter();
                resultLabel.setText("Result: File converted into XML.");
            } else if (input_extension.equals("json")){
                reader = new JsonConverter();
                resultLabel.setText("Result: File converted into XML.");
            } else if (input_extension.equals("xml")) {
                reader = new XMLConverter();
                resultLabel.setText("Result: File converted into XML.");
            } else {
                resultLabel.setText("File: Chosen file has incorrect extension!");
            }
            ExpressionsList expressionsList = new ExpressionsList();
            reader.Read(selectedFile.getPath(), expressionsList);
            pattern = Pattern.compile("([\\w:\\\\]+)[\\\\](\\w+)[.]([a-z]+)$");
            matcher = pattern.matcher(selectedFile.getPath());
            String newFile = "";
            while (matcher.find()) {
                newFile = matcher.group() + ".xml";
            }
            xmlConverter.Write(newFile, expressionsList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void actionDecrypt(ActionEvent event) {
        if (!chooseFile) {
            fileLabel.setText("Choose file!");
            return;
        }
        CryptConverter cryptConverter = new CryptConverter();
        try {
            cryptConverter.decrypt(selectedFile.getPath());
            resultLabel.setText("Result: Decrypted Successfully!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void actionEncrypt() {
        if (!chooseFile) {
            fileLabel.setText("Choose file!");
            return;
        }
        CryptConverter cryptConverter = new CryptConverter();
        try {
            cryptConverter.encrypt(selectedFile.getPath());
            resultLabel.setText("Result: Encrypted Successfully!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void actionUnarchive() throws IOException {
        if (!chooseFile) {
            fileLabel.setText("Choose file!");
            return;
        }
        IArchive iArchive;
        Pattern pattern = Pattern.compile("(\\w+)$");
        Matcher matcher = pattern.matcher(selectedFile.getPath());
        String input_extension = "";
        while (matcher.find())
            input_extension = matcher.group();
        if (input_extension.equals("zip")){
            iArchive = new ZipArchivator();
        } else if (input_extension.equals("rar")){
            iArchive = new RarArchivator();
        } else {
            iArchive = new JarArchivator();
        }
        iArchive.unarchive(selectedFile.getPath());
        resultLabel.setText("Result: Unarchived Successfully!");
    }

    @FXML
    void actionZip() {
        if (!chooseFile) {
            fileLabel.setText("Choose file!");
            return;
        }
        try {
            ZipArchivator zipArchivator = new ZipArchivator();
            try {
                zipArchivator.archive(selectedFile.getPath(), selectedFile.getPath());
                resultLabel.setText("Result: Zip archived Successfully!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void actionChooseEntered(){
        chooseButton.setStyle("-fx-background-color: #2997e5");
    }
}