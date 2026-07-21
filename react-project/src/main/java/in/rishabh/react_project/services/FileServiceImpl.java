package in.rishabh.react_project.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadFile(String path, MultipartFile multipartFile) throws IOException {
        String filename = multipartFile.getOriginalFilename();
        String filepath = path + File.pathSeparator + filename;

        File f = new File(path);

        if(!f.exists()) {
            f.mkdir();
        }

        Files.copy(multipartFile.getInputStream(), Paths.get(filepath));

        return filename;
    }

    @Override
    public InputStream getResourceFile(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        return new FileInputStream(fullPath);
    }

}
