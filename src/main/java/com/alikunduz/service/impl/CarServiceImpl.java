package com.alikunduz.service.impl;

import com.alikunduz.dto.DtoCar;
import com.alikunduz.dto.DtoCarIU;
import com.alikunduz.model.Car;
import com.alikunduz.repository.CarRepository;
import com.alikunduz.service.ICarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarRepository carRepository;

    private Car createCar(DtoCarIU dtoCarIU) {

        Car car = new Car();

        car.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoCarIU, car);

        return car;
    }


    @Override
    public DtoCar saveCar(DtoCarIU dtoCarIU) {

        DtoCar dtoCar = new DtoCar();

        Car savedCar = carRepository.save(createCar(dtoCarIU));

        BeanUtils.copyProperties(savedCar, dtoCar);

        return dtoCar;
    }


}
