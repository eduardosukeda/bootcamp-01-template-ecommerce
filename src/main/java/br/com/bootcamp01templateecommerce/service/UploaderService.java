package br.com.bootcamp01templateecommerce.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface UploaderService {

    Set<String> submit(List<MultipartFile> imagens);
}
