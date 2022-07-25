package com.rlcf.spring.security.services;

import com.rlcf.spring.models.FileExploi;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileStorageService {
//    public Long store(MultipartFile file) throws IOException;
    public Long storeFile(MultipartFile file) throws IOException;

    public FileExploi getFile(String id);

    public Stream<FileExploi> getAllFiles();
}
