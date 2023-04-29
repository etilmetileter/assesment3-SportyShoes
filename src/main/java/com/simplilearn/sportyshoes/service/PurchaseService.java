package com.simplilearn.sportyshoes.service;

import com.simplilearn.sportyshoes.model.PurchaseReport;
import com.simplilearn.sportyshoes.repo.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<PurchaseReport> getPurchaseReports() {
        return purchaseRepository.findAll();
    }

    public List<PurchaseReport> getReportyByCategory(String category) {
        return purchaseRepository.findByCategory(category);
    }

}
