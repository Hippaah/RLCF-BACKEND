package com.rlcf.spring.security.services.ServiceImpl;


import com.rlcf.spring.models.FileExploi;
import com.rlcf.spring.repository.FileRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

import com.rlcf.spring.security.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class FileStorageImpl implements FileStorageService {
    @Autowired
    private FileRepository fileRepository;

    @Value("${upload.file.path}")
    private String path;


//    public Long store(MultipartFile file) throws IOException {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        FileExploi File = new FileExploi(fileName, file.getContentType(), file.getBytes());
//         FileExploi file1=fileRepository.save(File);
//         return  file1.getId();
//    }

    @Override
    public Long storeFile(MultipartFile file) throws IOException {
            java.io.File file1 = new java.io.File(path+ file.getOriginalFilename());
            file1.createNewFile();
            FileOutputStream output = new FileOutputStream(file1);
            output.write(file.getBytes());
            output.close();
            FileExploi fileExploi =new FileExploi();
            fileExploi.setPath(file1.getPath());
            fileRepository.save(fileExploi);
            return fileExploi.getId();
    }

    @Override
    public FileExploi getFile(String id) {
        return null;
    }

    @Override
    public Stream<FileExploi> getAllFiles() {
        return null;
    }


//    public FileExploi getFile(String id) {
//        return fileRepository.findById(id).get();
//    }
//
//    public Stream<FileExploi> getAllFiles() {
//        return fileRepository.findAll().stream();
//    }
}
