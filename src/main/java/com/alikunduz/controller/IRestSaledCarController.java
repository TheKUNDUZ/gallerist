package com.alikunduz.controller;

import com.alikunduz.dto.DtoSaledCar;
import com.alikunduz.dto.DtoSaledCarIU;

public interface IRestSaledCarController {

    public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);

}
