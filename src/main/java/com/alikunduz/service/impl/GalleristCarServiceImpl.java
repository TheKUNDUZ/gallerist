package com.alikunduz.service.impl;

import com.alikunduz.dto.*;
import com.alikunduz.exception.BaseException;
import com.alikunduz.exception.ErrorMessage;
import com.alikunduz.exception.MessageType;
import com.alikunduz.model.Car;
import com.alikunduz.model.Gallerist;
import com.alikunduz.model.GalleristCar;
import com.alikunduz.repository.CarRepository;
import com.alikunduz.repository.GalleristCarRepository;
import com.alikunduz.repository.GalleristRepository;
import com.alikunduz.service.IGalleristCarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristCarServiceImpl implements IGalleristCarService {


    @Autowired
    private GalleristCarRepository galleristCarRepository;

    @Autowired
    private GalleristRepository galleristRepository;

    @Autowired
    private CarRepository carRepository;


    private GalleristCar createGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {


       Optional<Gallerist> optGallerist = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());
       if (optGallerist.isEmpty()){
           throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoGalleristCarIU.getGalleristId().toString()));
           }

        Optional<Car> optCar = carRepository.findById(dtoGalleristCarIU.getCarId());
        if (optCar.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoGalleristCarIU.getCarId().toString()));
        }

        GalleristCar galleristCar = new GalleristCar();
        galleristCar.setCreateTime(new Date());

        galleristCar.setGallerist(optGallerist.get());
        galleristCar.setCar(optCar.get());


        return galleristCar;
    }



    @Override
    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU galleristCarIU) {

        DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoCar dtoCar = new DtoCar();
        DtoAddress dtoAddress = new DtoAddress(); //Gallerist entity sinde address alanı var

        GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(galleristCarIU));

        BeanUtils.copyProperties(savedGalleristCar,dtoGalleristCar);  // id ve creat time alanları kopyalandı
        BeanUtils.copyProperties(savedGalleristCar.getGallerist(),dtoGallerist);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(),dtoAddress);


        BeanUtils.copyProperties(savedGalleristCar.getCar(),dtoCar);

        dtoGallerist.setAddress(dtoAddress);

        dtoGalleristCar.setGallerist(dtoGallerist);
        dtoGalleristCar.setCar(dtoCar);


        return dtoGalleristCar;
    }
}


