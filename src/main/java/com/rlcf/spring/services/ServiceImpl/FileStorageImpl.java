package com.rlcf.spring.services.ServiceImpl;


import com.rlcf.spring.models.FileExploi;
import com.rlcf.spring.repository.FileRepository;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

import com.rlcf.spring.services.FileStorageService;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;

import javax.servlet.http.HttpServletResponse;

@Service
@Transactional
public class FileStorageImpl implements FileStorageService {
    private enum ResourceType {
        FILE_SYSTEM,
        CLASSPATH
    }
    @Autowired
    private FileRepository fileRepository;

    @Value("${upload.file.path}")
    private String path;


    @Override
    public Long storeFile(MultipartFile file) throws IOException {
            java.io.File file1 = new java.io.File(path+ file.getOriginalFilename());
            file1.createNewFile();
            FileOutputStream output = new FileOutputStream(file1);
            output.write(file.getBytes());
            output.close();
            FileExploi fileExploi =new FileExploi();
            fileExploi.setPath(file1.getPath());
            fileExploi.setName(file.getOriginalFilename());
            fileRepository.save(fileExploi);
            return fileExploi.getId();
    }
    public Resource getFileSystem(Long id, HttpServletResponse response) {
        Optional<FileExploi> file1 = fileRepository.findById(id);
        String fileName = file1.get().getName();
        return getResource(fileName, response, ResourceType.FILE_SYSTEM);
    }

    private Resource getResource(String filename, HttpServletResponse response, ResourceType resourceType) {
        response.setContentType("text/html");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);
        response.setHeader("filename", filename);

        Resource resource = null;
        switch (resourceType) {
            case FILE_SYSTEM:
                resource = new FileSystemResource(path + filename);
                break;
        }
        return resource;
    }

}



