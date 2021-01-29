package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.ShoeProduct;
import com.cottonfactory.products.services.ShoeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products/shoe")
@Api(tags = {"shoes"})
public class ShoeController {

    @Autowired
    private ShoeService shoeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addShoeProduct(@RequestBody ShoeProduct shoeProduct){
        shoeService.addShoeProduct(shoeProduct);
    }

    @GetMapping
    public List<ShoeProduct> getAllShoes(){
        return shoeService.getAllShoes();
    }

    @GetMapping("/{id}")
    public ShoeProduct getShoeById(@PathVariable Long id){
        return shoeService.getShoeById(id);
    }

    @PutMapping("/{id}")
    public void updateShoeProduct(@PathVariable Long id, @RequestBody ShoeProduct shoeProduct){
        shoeProduct.setId(id);
        shoeService.updateShoeProduct(shoeProduct);
    }

    @PatchMapping("/{id}")
    public void patchShoeProduct(@PathVariable Long id, @RequestBody ShoeProduct shoeProduct){
        shoeProduct.setId(id);
        shoeService.updateShoeProduct(shoeProduct);
    }
}
