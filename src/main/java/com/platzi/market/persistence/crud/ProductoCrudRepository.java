package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<ProductoEntity, Integer>{
    List<ProductoEntity> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<ProductoEntity>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
