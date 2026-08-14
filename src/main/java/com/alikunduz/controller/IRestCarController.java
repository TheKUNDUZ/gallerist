package com.alikunduz.controller;

import com.alikunduz.dto.DtoCar;
import com.alikunduz.dto.DtoCarIU;

public interface IRestCarController {

    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);
}
