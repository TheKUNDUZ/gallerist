package com.alikunduz.controller;

import com.alikunduz.dto.DtoGallerist;
import com.alikunduz.dto.DtoGalleristIU;

public interface IRestGalleristController {

    public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);
}
