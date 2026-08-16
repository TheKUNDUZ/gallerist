package com.alikunduz.controller.impl;

import com.alikunduz.controller.IRestCurrencyRatesController;
import com.alikunduz.controller.RestBaseController;
import com.alikunduz.controller.RootEntity;
import com.alikunduz.dto.CurrencyRatesResponse;
import com.alikunduz.service.ICurrencyRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/currency-rates")
public class RestCurrencyRatesControllerImpl extends RestBaseController implements IRestCurrencyRatesController {

    @Autowired
    private ICurrencyRatesService currencyRatesService;

    @GetMapping("/")
    @Override
    public RootEntity<CurrencyRatesResponse> getCurrencyRates(
            @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {

        return ok(currencyRatesService.getCurrencyRates(startDate, endDate));
    }
}
