package com.alikunduz.controller.impl;

import com.alikunduz.controller.IRestGalleristCarController;
import com.alikunduz.controller.RestBaseController;
import com.alikunduz.controller.RootEntity;
import com.alikunduz.dto.DtoGalleristCar;
import com.alikunduz.dto.DtoGalleristCarIU;
import com.alikunduz.service.IGalleristCarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/gallerist-car")
public class RestGalleristCarControllerImpl extends RestBaseController implements IRestGalleristCarController {


    @Autowired
    private IGalleristCarService galleristCarService;



    @PostMapping("/save")
    @Override
    public RootEntity<DtoGalleristCar> saveGalleristCar(@Valid @RequestBody DtoGalleristCarIU dtoGalleristCarIU) {

        return ok(galleristCarService.saveGalleristCar(dtoGalleristCarIU));
    }
}
