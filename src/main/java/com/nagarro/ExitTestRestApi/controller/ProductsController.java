package com.nagarro.ExitTestRestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.ExitTestRestApi.model.Products;
import com.nagarro.ExitTestRestApi.repository.ProductsRepository;

@RestController
@CrossOrigin
public class ProductsController {
	
	@Autowired
	ProductsRepository productsRepository;
	
	@PostMapping(path = "/products")
	public ResponseEntity<Object> addProducts(@RequestParam("image") MultipartFile image,
            @RequestParam("name") String name,
            @RequestParam("brand") String brand,
            @RequestParam("description") String description,
            @RequestParam("code") String code,
            @RequestParam("price") double price) {
		 try {
	            Products product = new Products();
	            product.setName(name);
	            product.setBrand(brand);
	            product.setDescription(description);
	            product.setCode(code);
	            product.setPrice(price);
	            product.setImage(image.getBytes()); // Convert MultipartFile to byte array
	            productsRepository.save(product);
	            return ResponseEntity.ok().body("{\"message\":\"success\"}");
	        } catch (Exception e) {
	        	return ResponseEntity.ok().body("{\"message\":\"error\"}");
	        }
	}
	
	@GetMapping("products")
	public ResponseEntity<List<Products>> getAllProducts() {
	    List<Products> products = productsRepository.findAll();
	    return ResponseEntity.ok().body(products);
	}
	
	@GetMapping("/products/name")
	public ResponseEntity<List<Products>> getProductsByNameLike(@RequestParam("name") String name) {
	  List<Products> products = productsRepository.findByNameLike(name);
	  return ResponseEntity.ok().body(products);
	}
	
	@GetMapping("/products/code")
	public ResponseEntity<List<Products>> getProductsByCodeLike(@RequestParam("code") String code) {
	  List<Products> products = productsRepository.findByCodeLike(code);
	  return ResponseEntity.ok().body(products);
	}
	@GetMapping("/products/brand")
	public ResponseEntity<List<Products>> getProductsByBrandLike(@RequestParam("brand") String brand) {
	  List<Products> products = productsRepository.findByBrandLike(brand);
	  return ResponseEntity.ok().body(products);
	}
	
	@GetMapping("/products/getallcode")
	public ResponseEntity<List<String>> getAllCode() {
	  List<String> codes = productsRepository.findAllCode();
	  return ResponseEntity.ok().body(codes);
	}
	
    @DeleteMapping("/products/{code}")
    public ResponseEntity<Object> deleteProductByCode(@PathVariable("code") String code) {
        try {
            Products product = productsRepository.findByCode(code);
            if (product != null) {
                // Delete the product
                productsRepository.delete(product);
                return ResponseEntity.ok().body("{\"message\":\"success\"}");
            } else {
                return ResponseEntity.ok().body("{\"message\":\"error\"}");
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body("{\"message\":\"error\"}");
        }
    }
    @GetMapping("/products/{code}")
    public ResponseEntity<Products> getProductByCode(@PathVariable("code") String code) {
    	Products product = productsRepository.findByCode(code);
        return ResponseEntity.ok().body(product);
    }
}
