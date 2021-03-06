package com.barlingo.backend.models.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import com.barlingo.backend.utilities.RestError;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UploadFileServiceImpl implements IUploadFileService {

  @Value("${folder.uploads}")
  private String uploadsFolder;

  @Override
  public Resource load(String filename) {
    Path pathFoto = getPath(filename);
    log.info("pathFoto: " + pathFoto);

    Resource recurso = null;
    try {
      recurso = new UrlResource(pathFoto.toUri());

      Assert.isTrue(recurso.exists() && recurso.isReadable(),
          RestError.SIGNED_ESTABLISHMENT_ERROR_LOADING_IMAGE);

    } catch (MalformedURLException e) {
      Assert.isTrue(false, RestError.SIGNED_ESTABLISHMENT_ERROR_LOADING_IMAGE);
    }
    return recurso;
  }

  @Override
  public String copy(MultipartFile file) throws IOException {
    String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
    Path rootPath = getPath(uniqueFilename);

    log.info("rootPath: " + rootPath);

    Files.copy(file.getInputStream(), rootPath);

    return uniqueFilename;
  }

  @Override
  public boolean delete(String filename) {
    Path rootPath = getPath(filename);
    File archivo = rootPath.toFile();
    Boolean result = false;

    if (archivo.exists() && archivo.canRead()) {
      if (archivo.delete()) {
        result = true;
      }
    }
    return result;
  }

  public Path getPath(String filename) {
    return Paths.get(this.uploadsFolder).resolve(filename).toAbsolutePath();
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(Paths.get(this.uploadsFolder).toFile());

  }

  @Override
  public void init() throws IOException {
    try {
      if (!Paths.get(this.uploadsFolder).toFile().exists()) {
        Files.createDirectory(Paths.get(this.uploadsFolder));
      }
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}
