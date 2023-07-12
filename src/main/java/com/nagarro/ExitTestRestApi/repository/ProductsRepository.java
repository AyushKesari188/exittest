package com.nagarro.ExitTestRestApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.ExitTestRestApi.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

	@Query("SELECT p FROM Products p WHERE p.name LIKE %:name%")
	List<Products> findByNameLike(@Param("name") String name);
	
	@Query("SELECT p FROM Products p WHERE p.code LIKE %:code%")
	List<Products> findByCodeLike(@Param("code") String code);
	
	@Query("SELECT p FROM Products p WHERE p.brand LIKE %:brand%")
	List<Products> findByBrandLike(@Param("brand") String brand);
	
	Products findByCode(String code);
	
	@Query("SELECT code FROM Products")
	List<String> findAllCode();

}
