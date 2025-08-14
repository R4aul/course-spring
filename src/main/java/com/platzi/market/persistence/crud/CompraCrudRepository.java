package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.CompraEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<CompraEntity, Integer> {
    Optional<List<CompraEntity>> findByIdCliente(String idCliente);
}
