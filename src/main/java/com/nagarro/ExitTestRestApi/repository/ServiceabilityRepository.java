package com.nagarro.ExitTestRestApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.ExitTestRestApi.model.Serviceability;

public interface ServiceabilityRepository extends JpaRepository<Serviceability, Integer> {
	Serviceability findByCodeAndPincode(String code, String pincode);
	
	@Modifying
	@Query("DELETE FROM Serviceability s WHERE s.code = :code and s.pincode = :pincode ")
	void deleteByCodeAndPincode(@Param("code") String code, @Param("pincode") String pincode);
	
	@Query("SELECT s.pincode FROM Serviceability s WHERE s.code = :code")
	List<String> findPincodeByCode(@Param("code") String code);
	
	@Query("SELECT s.code FROM Serviceability s WHERE s.pincode = :pincode")
	List<String> findCodeByPincode(@Param("pincode") String pincode);
	
	List<Serviceability> findByCode(String code);
}
