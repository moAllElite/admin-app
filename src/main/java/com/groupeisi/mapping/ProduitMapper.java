package com.groupeisi.mapping;

import com.groupeisi.dto.ProduitDto;
import com.groupeisi.entities.Produit;
import org.mapstruct.Mapper;

@Mapper
public interface ProduitMapper {
    ProduitDto toProduitEntity(Produit produit);
    Produit fromProduitEntity(ProduitDto produitDto);
}
