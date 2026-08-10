package com.alikunduz.dto;

import com.alikunduz.model.Account;
import com.alikunduz.model.Address;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DtoCustomer extends DtoBase {


    private String firstName;

    private String lastName;

    private String tckn;

    private Date birthDate;

    private DtoAddress address;

    private DtoAccount account;
}
