package com.alikunduz.controller;

import com.alikunduz.dto.DtoGalleristCar;
import com.alikunduz.dto.DtoGalleristCarIU;
import com.alikunduz.model.BaseEntity;

public interface IRestGalleristCarController {

    public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
