package com.simplilearn.sportyshoes.repo;

import com.simplilearn.sportyshoes.model.PurchaseReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<PurchaseReport, Integer> {

    public List<PurchaseReport> findByCategory(String category);

}
