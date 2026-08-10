package com.alikunduz.service;

import com.alikunduz.dto.DtoCustomer;
import com.alikunduz.dto.DtoCustomerIU;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
