package com.alikunduz.service;

import com.alikunduz.dto.DtoCar;
import com.alikunduz.dto.DtoCarIU;

public interface ICarService {

    public DtoCar saveCar(DtoCarIU dtoCarIU);
}
