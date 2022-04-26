package com.letscode.banco.jms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.letscode.banco.model.Account;
import lombok.extern.slf4j.Slf4j;
import java.util.Objects;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j
public class AccountSerializer implements Serializer<Account> {
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public byte[] serialize(String s, Account account) {
        try {
            if(Objects.nonNull(account)){
                return mapper.writeValueAsBytes(account);
            }
        } catch (
                JsonProcessingException e) {
            log.error("Json processing error serializer", e);
            throw new RuntimeException(e);
        }
        return null;
    }
}

