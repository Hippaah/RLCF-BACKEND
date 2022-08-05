package com.rlcf.spring.services;

import com.rlcf.spring.models.FileExploi;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;


public interface FileStorageService {

    public Long storeFile(MultipartFile file) throws IOException;


    public Resource getFileSystem(Long id, HttpServletResponse response);

}
