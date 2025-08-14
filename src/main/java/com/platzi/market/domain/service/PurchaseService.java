package com.platzi.market.domain.service;

import com.platzi.market.domain.Purchase;
import com.platzi.market.persistence.CompraRepository;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    private final CompraRepository compraRepository;

    public PurchaseService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public List<Purchase> getAll(){
        return this.compraRepository.getAll();
    }

    public Optional<List<Purchase>> getByIdClient(String clientId){
        return this.compraRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase){
        return this.compraRepository.save(purchase);
    }
}
