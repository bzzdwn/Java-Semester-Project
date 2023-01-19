package com.converters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CryptConverter {
    static final byte[] KEYVALUE = "12345SEMENCHENKO12345".getBytes();
    static final int BUFFERLEN = 1024;

    public CryptConverter() { }

    public void encrypt(String file_name) throws Exception {
        FileInputStream in = new FileInputStream(file_name);
        String tmp = file_name;
        //tmp = file_name.toLowerCase();
        Pattern pattern = Pattern.compile("([\\w:\\\\]+)[\\\\](\\w+)[.]([a-z]+)$");
        Matcher matcher = pattern.matcher(tmp);
        String newFile = "";
        while (matcher.find())
            newFile = matcher.group(1) + "\\" + matcher.group(2) + "_encrypted." + matcher.group(3);
        File file = new File(newFile);
        if (!file.exists())
            file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);
        int c, pos, keylen;
        pos = 0;
        keylen = KEYVALUE.length;
        byte buffer[] = new byte[BUFFERLEN];
        while ((c = in.read(buffer)) != -1) {
            for (int i = 0; i < c; i++) {
                buffer[i] ^= KEYVALUE[pos];
                out.write(buffer[i]);
                pos++;
                if (pos == keylen)
                    pos = 0;
            }
        }
        in.close();
        out.close();
    }

    public void decrypt(String file_name) throws Exception {
        FileInputStream in = new FileInputStream(file_name);
        String tmp = file_name;
        Pattern pattern = Pattern.compile("([\\w:\\\\]+)[\\\\](\\w+)[.]([a-z]+)$");
        Matcher matcher = pattern.matcher(tmp);
        String newFile = "";
        while (matcher.find())
            newFile = matcher.group(1) + "\\" + matcher.group(2) + "_decrypted." + matcher.group(3);
        File file = new File(newFile);
        if (!file.exists())
            file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);
        int c, pos, keylen;
        pos = 0;
        keylen = KEYVALUE.length;
        byte buffer[] = new byte[BUFFERLEN];
        while ((c = in.read(buffer)) != -1) {
            for (int i = 0; i < c; i++) {
                buffer[i] ^= KEYVALUE[pos];
                out.write(buffer[i]);
                pos++;
                if (pos == keylen)
                    pos = 0;
            }
        }
        in.close();
        out.close();
    }
};