package com.alikunduz.controller;

import com.alikunduz.dto.DtoCustomer;
import com.alikunduz.dto.DtoCustomerIU;

public interface  IRestCustomerController {

   public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}
