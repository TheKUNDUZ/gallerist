package com.alikunduz.service;

import com.alikunduz.dto.DtoGalleristCar;
import com.alikunduz.dto.DtoGalleristCarIU;
import com.alikunduz.model.GalleristCar;

public interface IGalleristCarService {

    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU galleristCarIU);
}
