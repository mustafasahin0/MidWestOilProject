package com.midwestoil.entity;

import com.midwestoil.enums.CompanyType;
import com.midwestoil.enums.State;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class Company extends BaseEntity{

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private State state;
    private String zipCode;
    private CompanyType companyType;

    public Company(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, Long id1, String name, String phone, String email, String address, State state, String zipCode, CompanyType companyType) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.id = id1;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.state = state;
        this.zipCode = zipCode;
        this.companyType = companyType;
    }
}
