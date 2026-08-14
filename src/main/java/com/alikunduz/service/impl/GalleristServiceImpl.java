package com.alikunduz.service.impl;

import com.alikunduz.dto.DtoAddress;
import com.alikunduz.dto.DtoGallerist;
import com.alikunduz.dto.DtoGalleristIU;
import com.alikunduz.exception.BaseException;
import com.alikunduz.exception.ErrorMessage;
import com.alikunduz.exception.MessageType;
import com.alikunduz.model.Address;
import com.alikunduz.model.Gallerist;
import com.alikunduz.repository.AddressRepository;
import com.alikunduz.repository.GalleristRepository;
import com.alikunduz.service.IGalleristService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristServiceImpl implements IGalleristService {

   @Autowired
   private GalleristRepository galleristRepository;

   @Autowired
   private AddressRepository addressRepository;




   private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {

       Optional<Address> optAddress = addressRepository.findById(dtoGalleristIU.getAddressId());
       if(optAddress.isEmpty()) {
           throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoGalleristIU.getAddressId().toString()));
       }

           Gallerist gallerist = new Gallerist();
           gallerist.setCreateTime(new Date());

           BeanUtils.copyProperties(dtoGalleristIU, gallerist);
           gallerist.setAddress(optAddress.get());

       return gallerist;
   }


    @Override
    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {

       DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAddress dtoAddress = new DtoAddress();

       Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));

       BeanUtils.copyProperties(savedGallerist, dtoGallerist);

       BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);
       dtoGallerist.setAddress(dtoAddress);


        return dtoGallerist;
    }
}
