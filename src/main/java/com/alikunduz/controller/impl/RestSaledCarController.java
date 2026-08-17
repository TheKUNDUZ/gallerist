package com.alikunduz.controller.impl;

import com.alikunduz.controller.IRestSaledCarController;
import com.alikunduz.controller.RestBaseController;
import com.alikunduz.controller.RootEntity;
import com.alikunduz.dto.DtoSaledCar;
import com.alikunduz.dto.DtoSaledCarIU;
import com.alikunduz.service.ISaledCarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/saled-car")
public class RestSaledCarController extends RestBaseController implements IRestSaledCarController {

   @Autowired
   private ISaledCarService saledCarService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU dtoSaledCarIU) {
        return ok(saledCarService.buyCar(dtoSaledCarIU));
    }
}
