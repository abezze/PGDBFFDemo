package com.fincons.pgd.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fincons.pgd.dto.outputs.UtenteDTO;

@FeignClient(name = "utente-service", url = "http://localhost:9070")
public interface UtenteClient {
	
	@GetMapping("/pgd/utente/findByIdPNR")
    UtenteDTO getUtente(@RequestParam("userIdPNR") String userIdPNR);

}
