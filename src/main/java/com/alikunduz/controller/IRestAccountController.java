package com.alikunduz.controller;

import com.alikunduz.dto.DtoAccount;
import com.alikunduz.dto.DtoAccountIU;

public interface IRestAccountController {

    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}
