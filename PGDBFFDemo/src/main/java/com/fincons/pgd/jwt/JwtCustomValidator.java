package com.fincons.pgd.jwt;

import java.util.List;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JwtCustomValidator implements OAuth2TokenValidator<Jwt> {

    @Override
    public OAuth2TokenValidatorResult validate(Jwt jwt) {

        if (!"https://deleghedigitali.gov.it".equals(jwt.getIssuer().toString())) {
            return OAuth2TokenValidatorResult.failure(
                new OAuth2Error("invalid_issuer"));
        }

        List<String> samlIds = jwt.getClaim("saml_entity_ids");

        if (samlIds == null || samlIds.isEmpty()) {
            return OAuth2TokenValidatorResult.failure(
                new OAuth2Error("missing_saml_ids"));
        }

        return OAuth2TokenValidatorResult.success();
    }
}
