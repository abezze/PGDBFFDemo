package com.fincons.pgd.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.fincons.pgd.dto.outputs.DelegaDTO;

@FeignClient(name = "delega-service", url = "http://localhost:9070")
public interface DelegaClient {
	
	@GetMapping("/pgd/delega/get-delegation-data")
    List<DelegaDTO> getDeleghe();

}
