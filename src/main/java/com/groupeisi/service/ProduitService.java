package com.groupeisi.service;

import com.groupeisi.dto.ProduitDto;
import com.groupeisi.mapping.ProduitMapper;
import com.groupeisi.repositories.IProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RequiredArgsConstructor
@Service
public class ProduitService {
    private  IProduitRepository produitRepository;
    private  ProduitMapper produitMapper;
    MessageSource  messageSource;
    @Transactional(readOnly = true)
    public ProduitDto getProduitDto(){
        return (ProduitDto) StreamSupport.stream(produitRepository.findAll()
                .spliterator(),false)
                .map(produitMapper::toProduitEntity)
                .collect(Collectors.toList()
                );
    }
}
