package co.edu.unipamplona.ciadti.rap.services.config.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

@Service
public class FtpService {
    @Autowired
    private Map<String, FTPClient> ftpClients;

    @Value("${defaultFTP}")
    private String defaultFTP;

    public void uploadFile(FileInputStream fileInputStream, String remotePath) throws Exception {
        FTPClient ftpClient = ftpClients.get(this.getNameFTP());
        try {
            boolean uploadFile =  ftpClient.storeFile(remotePath, fileInputStream);
            System.out.printf("[uploadFile][%d] Is success to upload file : %s -> %b", System.currentTimeMillis(), remotePath, uploadFile);
            if ( uploadFile == false ) {
                throw new Exception("Error al subir el fichero");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }finally {
            fileInputStream.close();
        }
    }

    public byte[]  downloadFile(String path) throws Exception {
        FTPClient ftpClient = ftpClients.get(this.getNameFTP());
        byte[] fileBytes = null;
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try {
            inputStream = ftpClient.retrieveFileStream(path);
            outputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            boolean success = ftpClient.completePendingCommand();
            if (success) {
                fileBytes = outputStream.toByteArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }finally {
            if (inputStream != null) {inputStream.close();}
            if (outputStream != null) {outputStream.close();}
        }
        return fileBytes ;
    }

    private String getNameFTP(){
        if (FtpContext.getFTP() != null){
            return FtpContext.getFTP();
        }
        return defaultFTP;
    }
}
