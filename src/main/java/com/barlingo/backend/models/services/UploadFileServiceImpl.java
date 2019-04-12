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
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UploadFileServiceImpl implements IUploadFileService {

  @Value("${folder.uploads}")
  private String UPLOADS_FOLDER;

  @Override
  public Resource load(String filename) throws MalformedURLException {
    Path pathFoto = getPath(filename);
    log.info("pathFoto: " + pathFoto);

    Resource recurso = new UrlResource(pathFoto.toUri());

    if (!recurso.exists() || !recurso.isReadable()) {
      throw new RuntimeException("Error: no se puede cargar la imagen: " + pathFoto.toString());
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
    return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(Paths.get(UPLOADS_FOLDER).toFile());

  }

  @Override
  public void init() throws IOException {
    try {
      if (!Paths.get(UPLOADS_FOLDER).toFile().exists()) {
        Files.createDirectory(Paths.get(UPLOADS_FOLDER));
      }
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}
