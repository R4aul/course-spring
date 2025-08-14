package com.platzi.market.persistence;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.PurchaseRepository;
import com.platzi.market.persistence.crud.CompraCrudRepository;
import com.platzi.market.persistence.entity.CompraEntity;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    private final CompraCrudRepository compraCrudRepository;
    private final PurchaseMapper purchaseMapper;

    public CompraRepository(CompraCrudRepository compraCrudRepository, PurchaseMapper purchaseMapper) {
        this.compraCrudRepository = compraCrudRepository;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public List<Purchase> getAll() {
        List<CompraEntity> purchases = (List<CompraEntity>) this.compraCrudRepository.findAll();
        return this.purchaseMapper.toPurchases(purchases);
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return this.compraCrudRepository.findByIdCliente(clientId)
                .map(compraEntities -> this.purchaseMapper.toPurchases(compraEntities));
    }

    @Override
    public Purchase save(Purchase purchase) {
        CompraEntity compra = this.purchaseMapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return this.purchaseMapper.toPurchase(this.compraCrudRepository.save(compra));
    }
}
