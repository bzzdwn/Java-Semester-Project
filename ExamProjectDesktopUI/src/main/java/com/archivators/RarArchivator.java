package com.archivators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class RarArchivator implements IArchive{

    @Override
    public void archive(String archive_name, String file_name) throws IOException {
        archive_name = archive_name.concat(".rar");
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(archive_name));
        ZipEntry zipEntry = new ZipEntry(file_name);
        zipOutputStream.putNextEntry(zipEntry);
        FileInputStream fileInputStream = new FileInputStream(file_name);
        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        zipOutputStream.write(buffer);
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        fileInputStream.close();
    }

    @Override
    public void unarchive(String archive_name) throws IOException {
        //archive_name = archive_name.concat(".rar");
        String filepath = "";
        Pattern pattern = Pattern.compile("([\\w:\\\\]+[\\\\])([\\w.]+)$");
        Matcher matcher = pattern.matcher(archive_name);
        while (matcher.find())
            filepath = matcher.group(1);
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archive_name));
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry())!=null) {
            String name = zipEntry.getName();
            File file = new File(name);
            if (!file.exists())
                file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(zipInputStream.readAllBytes());
            fileOutputStream.flush();
            zipInputStream.closeEntry();
            fileOutputStream.close();
        }
    }
    @Override
    public String getExtension(){
        return "rar";
    }
}
