package com.alikunduz.controller;

import com.alikunduz.dto.DtoAddress;
import com.alikunduz.dto.DtoAddressIU;

public interface IRestAddressController {

    public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);
}
