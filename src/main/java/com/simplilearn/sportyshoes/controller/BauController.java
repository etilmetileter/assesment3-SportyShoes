package com.simplilearn.sportyshoes.controller;

import com.simplilearn.sportyshoes.model.PurchaseReport;
import com.simplilearn.sportyshoes.model.Shoe;
import com.simplilearn.sportyshoes.service.PurchaseService;
import com.simplilearn.sportyshoes.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BauController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ShoeService shoeService;

    @GetMapping("/checkPurchaseReports")
    public String checkPurchaseReports(Model model) {
        List<PurchaseReport> purchaseReportList = purchaseService.getPurchaseReports();
        model.addAttribute("reports", purchaseReportList);
        return "reports";
    }

    @PostMapping("/searchByCategory")
    public String searchByCategory(@RequestParam("filteredCategory") String category, Model model) {
        List<PurchaseReport> categorizedList;
        if (category.isBlank()) {
            categorizedList = purchaseService.getPurchaseReports();
        } else {
            categorizedList = purchaseService.getReportyByCategory(category);
        }
        model.addAttribute("reports", categorizedList);
        return "reports";
    }

    @GetMapping("/manageProducts")
    public String manageProducts(Model model) {
        Shoe shoe = new Shoe();
        model.addAttribute("shoe", shoe);
        List<Shoe> productList = shoeService.getShoes();
        model.addAttribute("products", productList);
        return "manageProducts";
    }

    @PostMapping("/addProduct")
    public String addProduct(Shoe shoe, Model model) {
        shoeService.addProduct(shoe);
        List<Shoe> productList = shoeService.getShoes();
        model.addAttribute("products", productList);
        model.addAttribute("messageSuccess", "Product Successfully added!");
        return "manageProducts";
    }

    @GetMapping("/productUpdatePage/{id}")
    public String productUpdate(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("shoe", shoeService.getShoeById(id));
        Shoe updateShoe = new Shoe();
        model.addAttribute("updateShoe", updateShoe);
        return "productUpdate";
    }

    @PostMapping("/updateProduct")
    public String productUpdate(Shoe shoe, Model model) {
        Shoe shoeFromDb = shoeService.getShoeById(shoe.getId());
        shoeFromDb.setProductname(shoe.getProductname());
        shoeFromDb.setCategory(shoe.getCategory());
        shoeFromDb.setProductprice(shoe.getProductprice());
        Shoe shoeResult = shoeService.addProduct(shoeFromDb);
        if (shoeResult != null) {
            model.addAttribute("messageSuccess", "Product Successfully updated!");

        } else {
            model.addAttribute("messageFail", "Product Adding Operation Failed!");
        }
        return "manageProducts";
    }

}
