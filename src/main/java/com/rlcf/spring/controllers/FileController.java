package com.rlcf.spring.controllers;

import com.rlcf.spring.Old.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")

public class FileController {
    @Autowired
    private FileStorageService storageService;

//    @PostMapping("/upload")
//    public ResponseEntity<Long> uploadFile(MultipartFile file) throws IOException {
//        String message = "";
//        try {
//            storageService.store(file);
//            message = "Uploaded the file successfully: " + file.getOriginalFilename();
//            return ResponseEntity.status(HttpStatus.OK).body(storageService.store(file));
//        } catch (Exception e) {
//            message = e.getMessage();
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(storageService.store(file));
//        }
//    }

    @PostMapping("/uploads")
    public Long uploadsFile(@RequestBody MultipartFile file) throws IOException {
          return storageService.storeFile(file);
    }
//    @GetMapping("/files")
//    public ResponseEntity<List<ResponseFile>> getListFiles() {
//        List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
//            String fileDownloadUri = ServletUriComponentsBuilder
//                    .fromCurrentContextPath()
//                    .path("/files/")
//                    .path(dbFile.getId())
//                    .toUriString();
//
//            return new ResponseFile(
//                    dbFile.getName(),
//                    fileDownloadUri,
//                    dbFile.getType(),
//                    dbFile.getData().length);
//        }).collect(Collectors.toList());
//
//        return ResponseEntity.status(HttpStatus.OK).body(files);
//    }

//    @GetMapping("/files/{id}")
//    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
//        FileExploi file = storageService.getFile(id);
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
//                .body(file.getData());
//    }
}
