package com.temp.wedding_secretary.services;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class SendFileService {

    public void sendFile(String code, HttpServletResponse response) throws IOException {
        response.setContentType("image/*");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + code + "\"");
        ServletOutputStream outputStream = response.getOutputStream();
        String path = "./send_files/";
        File file = new File(path + code);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = IOUtils.toByteArray(fileInputStream);
        outputStream.write(bytes);

    }
}
