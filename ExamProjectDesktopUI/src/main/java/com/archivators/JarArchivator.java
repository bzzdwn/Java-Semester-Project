package com.archivators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JarArchivator implements IArchive {

    @Override
    public void archive(String archive_name, String file_name) throws IOException {
        archive_name = archive_name.concat(".jar");
        JarOutputStream jarOutputStream = new JarOutputStream(new FileOutputStream(archive_name));
        JarEntry jarEntry = new JarEntry(file_name);
        jarOutputStream.putNextEntry(jarEntry);
        FileInputStream fileInputStream = new FileInputStream(file_name);
        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        jarOutputStream.write(buffer);
        jarOutputStream.closeEntry();
        jarOutputStream.close();
        fileInputStream.close();
    }

    @Override
    public void unarchive(String archive_name) throws IOException {
        //archive_name = archive_name.concat(".jar");
        String filepath = "";
        Pattern pattern = Pattern.compile("([\\w:\\\\]+[\\\\])([\\w.]+)$");
        Matcher matcher = pattern.matcher(archive_name);
        while (matcher.find())
            filepath = matcher.group(1);
        JarInputStream jarInputStream = new JarInputStream(new FileInputStream(archive_name));
        JarEntry jarEntry;
        while ((jarEntry = jarInputStream.getNextJarEntry()) != null) {
            String name = jarEntry.getName();
            File file = new File(name);
            if (!file.exists())
                file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(jarInputStream.readAllBytes());
            fileOutputStream.flush();
            jarInputStream.closeEntry();
            fileOutputStream.close();
        }
    }
    @Override
    public String getExtension(){
        return "jar";
    }
}