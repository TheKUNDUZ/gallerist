package com.alikunduz.dto;

import com.alikunduz.model.Car;
import com.alikunduz.model.Gallerist;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGalleristCarIU {

    @NotNull
    private Long galleristId;

    @NotNull
    private Long carId;
}
