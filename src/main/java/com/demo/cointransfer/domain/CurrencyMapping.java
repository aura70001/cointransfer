package com.demo.cointransfer.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency_mapping")
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyMapping {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "code_zh")
    private String codeZh;
}
