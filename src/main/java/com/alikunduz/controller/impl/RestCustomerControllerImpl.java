package com.alikunduz.controller.impl;

import com.alikunduz.controller.IRestCustomerController;
import com.alikunduz.controller.RestBaseController;
import com.alikunduz.controller.RootEntity;
import com.alikunduz.dto.DtoCustomer;
import com.alikunduz.dto.DtoCustomerIU;
import com.alikunduz.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/customer")
public class RestCustomerControllerImpl extends RestBaseController implements IRestCustomerController {


    @Autowired
    private ICustomerService customerService;


    @PostMapping("/save")
    @Override
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {

        return ok(customerService.saveCustomer(dtoCustomerIU));
    }
}
