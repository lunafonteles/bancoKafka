package com.letscode.banco.client;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetCpfValidator {
    public ValidatorInfo execute() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<ValidatorInfo> validatorInfoResponseEntity =
                restTemplate.exchange("http://localhost:9080/cpf/add", HttpMethod.GET,
                        entity, ValidatorInfo.class);

        if (validatorInfoResponseEntity.getStatusCode().isError()){
            return null;
        }
        return validatorInfoResponseEntity.getBody();
    }
}
