package com.rlcf.spring.controllers;

import com.rlcf.spring.services.FileStorageService;
import com.rlcf.spring.models.FileExploi;
import com.rlcf.spring.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")

public class FileController {
    @Autowired
    private FileStorageService storageService;
    @Autowired
    private FileRepository fileRepository;

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

    @GetMapping(value = "/files/system/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Resource getFileFromFileSystem(@PathVariable Long id, HttpServletResponse response) {
        return storageService.getFileSystem(id, response);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<ByteArrayResource> getFile(@PathVariable Long id) throws IOException {

        Optional<FileExploi> file1 = fileRepository.findById(id);
        String name = file1.get().getName();
        System.err.println(fileRepository.findById(id).isPresent());
        if (fileRepository.findById(id).isPresent()) {
            String path1 = file1.get().getPath();
            System.err.println(path1.isEmpty());
            File file2Upload = new File(path1);
            HttpHeaders headers = new HttpHeaders();

            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            // InputStreamResource resource = new InputStreamResource(new FileInputStream(file2Upload));
            Path path = Paths.get(file2Upload.getAbsolutePath());
            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file2Upload.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);


        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



//    @GetMapping("/files/{id}")
//    public ResponseEntity<byte[]> getFile(@PathVariable("id") long id) {
//
//        FileExploi file1 = storageService.getFile(id);
//       return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" )
//          +file.getName() + "\"")
//         .body(file1.getData());
// }


//    @GetMapping("/files/{id}")
//    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
//        FileExploi file = storageService.getFile(id);
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
//                .body(file.getData());
//    }


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


}