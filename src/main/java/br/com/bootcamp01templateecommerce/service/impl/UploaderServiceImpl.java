package br.com.bootcamp01templateecommerce.service.impl;

import br.com.bootcamp01templateecommerce.service.UploaderService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Primary
public class UploaderServiceImpl implements UploaderService {

    @Override
    public Set<String> submit(List<MultipartFile> imagens) {
        return imagens.stream()
                .map(imagem -> "http://bucket.io/"
                        + imagem.getOriginalFilename())
                .collect(Collectors.toSet());
    }
}
