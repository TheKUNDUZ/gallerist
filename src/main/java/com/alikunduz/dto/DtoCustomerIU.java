package com.alikunduz.dto;

import com.alikunduz.model.Account;
import com.alikunduz.model.Address;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DtoCustomerIU {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String tckn;

    @NotNull
    private Date birthDate;

    @NotNull
    private Long addressID;

    @NotNull
    private Long accountId;
}
