package com.pdk.blog.app.ServiceImplementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pdk.blog.app.Service.FileService;

@Service
public class FileServiceImplementation implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        String name = file.getOriginalFilename();

        String randomId = UUID.randomUUID().toString();

        String fileName = randomId.concat(name.substring(name.lastIndexOf(".")));

        String filePath = path + File.separator + fileName;

        File f = new File(filePath);

        if (f.exists()) {
            f.mkdirs();
        }

        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;
    }

    // @Override
    // public InputStream getResourse(String path, String fileName) throws
    // FileNotFoundException {
    // String fullPath = path + File.separator + fileName;
    // InputStream is = new FileInputStream(fullPath);
    // return is;
    // }

    @Override
    public InputStream getResourse(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        InputStream is = new FileInputStream(fullPath);
        return is;
    }

}
