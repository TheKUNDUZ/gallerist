package com.alikunduz.dto;

import com.alikunduz.model.Address;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGalleristIU {


    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Long addressId;
}
