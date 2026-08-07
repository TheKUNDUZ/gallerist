package com.alikunduz.service;

import com.alikunduz.dto.DtoAddress;
import com.alikunduz.dto.DtoAddressIU;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU  dtoAddressIU);
}
