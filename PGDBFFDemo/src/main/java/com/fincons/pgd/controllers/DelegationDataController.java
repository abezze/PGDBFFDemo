package com.fincons.pgd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fincons.pgd.bffservices.DelegationData;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/pgd/delegation-data")
public class DelegationDataController {
	
	private final DelegationData delegationData;
	
	@GetMapping("/getDelegationData")
	public ResponseEntity<Object> getDelegationData(@AuthenticationPrincipal Jwt jwt, @RequestParam (required = true) String userIdPNR) {
		 
			log.debug("getDelegationData userIdPNR= {}", userIdPNR);
			Object r = new Object();
			HttpStatus status = HttpStatus.OK;
			try {
				r= delegationData.getDelegationData(userIdPNR);
			} catch (Exception e) {
				log.debug("getDelegationData exc {}", e.getMessage());
				r=e.getMessage();
				status = HttpStatus.BAD_REQUEST;
			}
			log.debug("getDelegationData Ended  {}", r.toString());
			return ResponseEntity.status(status).body(r);
	}
	

}
