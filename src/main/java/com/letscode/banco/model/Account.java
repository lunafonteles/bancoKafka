package com.letscode.banco.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letscode.banco.request.AccountRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Account")
    @Entity
    @NoArgsConstructor
    @Data
    @EntityListeners(AuditingEntityListener.class)
    public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "number")
        private Integer number;

        @Column(name = "agency")
        private Integer agency;

        @Column(name = "create_date")
        @CreatedDate
        private LocalDateTime createDate;

        @Column(name = "update_date")
        @LastModifiedDate
        private LocalDateTime updateDate;

        @Column(name = "balance")
        private BigDecimal balance;

        @Column(name = "account_type")
        @Enumerated(EnumType.STRING)
        private AccountType accountType;

        @ManyToOne()
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private User user;

        @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
        @JsonIgnore
        private List<Transaction> transactions;

}
