package com.alikunduz.service;

import com.alikunduz.dto.DtoAccount;
import com.alikunduz.dto.DtoAccountIU;
import com.alikunduz.dto.DtoAddress;
import com.alikunduz.dto.DtoAddressIU;

public interface IAccountService {

    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
