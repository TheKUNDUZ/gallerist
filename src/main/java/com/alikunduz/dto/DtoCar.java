package com.alikunduz.dto;

import com.alikunduz.enums.CarStatusType;
import com.alikunduz.enums.CurrencyType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DtoCar extends DtoBase {


    private String plaka;


    private String brand;


    private String model;


    private int productionYear;


    private BigDecimal price;


    private CurrencyType currencyType;


    private BigDecimal damagePrice;


    private CarStatusType carStatusType;
}
