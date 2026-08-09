package com.alikunduz.service.impl;

import com.alikunduz.dto.DtoAccount;
import com.alikunduz.dto.DtoAccountIU;
import com.alikunduz.model.Account;
import com.alikunduz.model.BaseEntity;
import com.alikunduz.repository.AccountRepository;
import com.alikunduz.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    private Account createAccount(DtoAccountIU dtoAccountIU) {

        Account account = new Account();
        account.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoAccountIU, account);

        return account;
    }


    @Override
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {

        DtoAccount dtoAccount = new DtoAccount();

        Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));

        BeanUtils.copyProperties(savedAccount, dtoAccount);

        return dtoAccount;
    }
}
