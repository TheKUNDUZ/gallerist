package com.alikunduz.service.impl;

import com.alikunduz.dto.DtoAddress;
import com.alikunduz.dto.DtoAddressIU;
import com.alikunduz.model.Address;
import com.alikunduz.repository.AddressRepository;
import com.alikunduz.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;


    private Address createAddress(DtoAddressIU dtoAddressIU) {
        Address address = new Address();
        address.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoAddressIU, address);
        return address;
    }


    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        DtoAddress dtoAddress = new DtoAddress();
        Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));

        BeanUtils.copyProperties(savedAddress, dtoAddress);
        return dtoAddress;
    }
}
