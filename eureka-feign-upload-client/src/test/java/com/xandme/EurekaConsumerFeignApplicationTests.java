package com.xandme;

import com.xandme.client.UploadClient;
import lombok.SneakyThrows;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaConsumerFeignApplicationTests {
    private final static Logger LOGGER = Logger.getLogger(EurekaConsumerFeignApplicationTests.class);

    @Autowired
    private UploadClient uploadClient;

    @Test
    @SneakyThrows
    public void contextLoads() {
        File file = new File("upload.txt");
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",
                MediaType.TEXT_PLAIN_VALUE, true, file.getName());
        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = fileItem.getOutputStream()) {
            IOUtils.copy(inputStream, outputStream);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }
        MultipartFile multi = new CommonsMultipartFile(fileItem);

        LOGGER.info(uploadClient.handleFileUpload(multi));
    }

}
