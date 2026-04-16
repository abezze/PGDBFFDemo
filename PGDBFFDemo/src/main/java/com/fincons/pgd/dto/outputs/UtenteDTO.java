package com.fincons.pgd.dto.outputs;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtenteDTO {
    private Long id;
    private String idPNR;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String residenza;
    private String luogoDiNascita;
    private String codiceFiscale;
    private String indirizzoEmail;
    private Boolean flagEmailCertificata;
    private Boolean flagAccettazionePolicy;
    //private Set<AssociativaUtenteProfiloDTO> profili;
    private List<DelegaDTO> delegheConcesse;

}
