package com.letscode.banco.response;

import com.letscode.banco.model.User;

import java.time.LocalDateTime;

public class UserResponse {
    private Integer id;
    private String name;
    private String cpf;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.createDate = user.getCreateDate();
        this.updateDate = user.getUpdateDate();
    }
}
