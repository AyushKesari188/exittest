package com.nagarro.ExitTestRestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ExitTestRestApi.model.Products;
import com.nagarro.ExitTestRestApi.model.Serviceability;
import com.nagarro.ExitTestRestApi.repository.ServiceabilityRepository;

@RestController
@CrossOrigin
public class ServiceabilityController {

	@Autowired
	ServiceabilityRepository serviceabilityRepository;

	@PostMapping(path = "/serviceability", consumes = { "application/json" })
	public ResponseEntity<Object> addServiceability(@RequestBody Serviceability serviceability) {
		if (serviceabilityRepository.findByCodeAndPincode(serviceability.getCode(),
				serviceability.getPincode()) != null) {
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		try {
			serviceabilityRepository.save(serviceability);
		} catch (Exception e) {
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		return ResponseEntity.ok().body("{\"message\":\"success\"}");
	}

	@GetMapping("/serviceability/code")
	public ResponseEntity<List<String>> getPincodeByCode(@RequestParam("code") String code) {
		List<String> pincodes = serviceabilityRepository.findPincodeByCode(code);
		return ResponseEntity.ok().body(pincodes);
	}

	@GetMapping("/serviceability/pincode")
	public ResponseEntity<List<String>> getCodeByPincode(@RequestParam("pincode") String pincode) {
		List<String> codes = serviceabilityRepository.findCodeByPincode(pincode);
		return ResponseEntity.ok().body(codes);
	}

	@GetMapping("/serviceability/code/pincode")
	public ResponseEntity<Object> getByCodeAndPincode(@RequestParam("code") String code,
			@RequestParam("pincode") String pincode) {
		Serviceability serviceability = null;
		try {
			serviceability = serviceabilityRepository.findByCodeAndPincode(code, pincode);
		} catch (Exception e) {
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		if (serviceability == null) {
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		} else {
			return ResponseEntity.ok().body("{\"message\":\"success\"}");
		}
	}

	@DeleteMapping("/serviceability")
	public ResponseEntity<Object> deleteServiceability(@RequestParam("code") String code,
			@RequestParam("pincode") String pincode) {
		Serviceability serviceability = serviceabilityRepository.findByCodeAndPincode(code, pincode);
		if (serviceability == null) {
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		try {
			serviceabilityRepository.delete(serviceability);
		} catch (Exception e) {
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		return ResponseEntity.ok().body("{\"message\":\"success\"}");
	}

	@DeleteMapping("/serviceability/code/{code}")
	public ResponseEntity<Object> deleteServiceabilityByCode(@PathVariable("code") String code) {
		try {
			List<Serviceability> serviceability = serviceabilityRepository.findByCode(code);
			if(serviceability.size() !=0) {
				for (Serviceability s : serviceability) {
					serviceabilityRepository.delete(s);
				}
			}
			
		} catch (Exception e) {
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		return ResponseEntity.ok().body("{\"message\":\"success\"}");
	}
}
