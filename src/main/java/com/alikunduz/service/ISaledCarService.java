package com.alikunduz.service;

import com.alikunduz.dto.DtoSaledCar;
import com.alikunduz.dto.DtoSaledCarIU;

public interface ISaledCarService {

    public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);

}
