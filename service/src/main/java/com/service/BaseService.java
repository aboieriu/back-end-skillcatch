package com.service;


import com.exception.NoLoggedUser;
import com.exception.UploadException;
import com.security.AuthenticationContext;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import view.UserView;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Optional;

/**
 * Created by icringanu on 11.03.2016.
 */
public class BaseService {

    public Long getLoggedUserId() throws Exception{
        Optional<Long> loggedUserId = AuthenticationContext.getLoggedInUserId();
        if (!loggedUserId.isPresent()) {
            throw new NoLoggedUser();
        }
        return loggedUserId.get();
    }

    public void processUpload(@RequestParam("uploadedFile") MultipartFile uploadedFileRef, byte[] buffer, File outputFile) throws UploadException, FileNotFoundException {
        try {
            InputStream reader ;
            FileOutputStream writer;
            // Create the input stream to uploaded file to read data from it.
            reader = uploadedFileRef.getInputStream();
            // Create writer for 'outputFile' to write data read from
            // 'uploadedFileRef'
            writer = new FileOutputStream(outputFile);
            // Iteratively read data from 'uploadedFileRef' and write to
            // 'outputFile';
            while (reader.read(buffer) != -1) {
                    writer.write(buffer);
                }
            writer.close();
            reader.close();
        } catch (IOException  e) {
            throw new UploadException("Incompatible file or to big File!");
        }

    }


}
