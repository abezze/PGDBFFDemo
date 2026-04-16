package com.fincons.pgd.bffservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fincons.pgd.dto.outputs.DelegaDTO;
import com.fincons.pgd.dto.outputs.DelegationDataDTO;
import com.fincons.pgd.dto.outputs.UtenteDTO;
import com.fincons.pgd.feignclients.DelegaClient;
import com.fincons.pgd.feignclients.UtenteClient;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DelegationData {
	
	private final DelegaClient delegaClient;
	private final UtenteClient utenteClient;
	
	public DelegationDataDTO getDelegationData(String userId) {
		
		UtenteDTO utente = utenteClient.getUtente(userId);
		
		
		List<DelegaDTO> deleghe = delegaClient.getDeleghe();
			
		return new DelegationDataDTO(utente, deleghe);
			
			
		
	}
	
	
}
