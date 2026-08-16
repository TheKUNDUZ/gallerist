package com.alikunduz.service.impl;

import com.alikunduz.dto.DtoAccount;
import com.alikunduz.dto.DtoAddress;
import com.alikunduz.dto.DtoCustomer;
import com.alikunduz.dto.DtoCustomerIU;
import com.alikunduz.exception.BaseException;
import com.alikunduz.exception.ErrorMessage;
import com.alikunduz.exception.MessageType;
import com.alikunduz.model.Account;
import com.alikunduz.model.Address;
import com.alikunduz.model.Customer;
import com.alikunduz.repository.AccountRepository;
import com.alikunduz.repository.AddressRepository;
import com.alikunduz.repository.CustomerRepository;
import com.alikunduz.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {




    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;





    private Customer createCustomer(DtoCustomerIU dtoCustomerIU){

        Customer customer = new Customer();
        customer.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoCustomerIU, customer);

        Optional<Address> optAddress = addressRepository.findById(dtoCustomerIU.getAddressID());
        if (optAddress.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoCustomerIU.getAddressID().toString()));
        }
        customer.setAddress(optAddress.get());

        Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
        if (optAccount.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoCustomerIU.getAccountId().toString()));
        }
        customer.setAccount(optAccount.get());

        return customer;
    }


    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {

        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        DtoAccount dtoAccount = new DtoAccount();

        Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));

        BeanUtils.copyProperties(savedCustomer,dtoCustomer);
        BeanUtils.copyProperties(savedCustomer.getAddress(),dtoAddress);
        BeanUtils.copyProperties(savedCustomer.getAccount(),dtoAccount);


        dtoCustomer.setAddress(dtoAddress);
        dtoCustomer.setAccount(dtoAccount);

        return dtoCustomer;
    }
}
