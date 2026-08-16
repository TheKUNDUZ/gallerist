package com.alikunduz.service.impl;

import com.alikunduz.dto.CurrencyRatesResponse;
import com.alikunduz.exception.BaseException;
import com.alikunduz.exception.ErrorMessage;
import com.alikunduz.exception.MessageType;
import com.alikunduz.service.ICurrencyRatesService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyRatesServiceImpl implements ICurrencyRatesService {


    @Override
    public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate) {

        String rootUrl = "https://evds3.tcmb.gov.tr/igmevdsms-dis/";
        String series = "TP.DK.USD.A";
        String type = "json";

        String endPoint = rootUrl + "series=" + series + "&startDate=" + startDate + "&endDate=" + endDate + "&type=" + type;

        // https://evds3.tcmb.gov.tr/igmevdsms-dis/series=TP.DK.USD.A&startDate=07-08-2026&endDate=07-08-2026&type=json

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("key" , "8CyAiGVATz");

        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);



        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<CurrencyRatesResponse> response = restTemplate.exchange(endPoint, HttpMethod.GET, httpEntity,
                    new ParameterizedTypeReference<CurrencyRatesResponse>() {
            });
            if (response.getStatusCode().is2xxSuccessful()) {
             return response.getBody();
            }
        } catch (Exception e){
            throw new BaseException(new ErrorMessage(MessageType.CURRENCY_RATES_IS_OCCURED, e.getMessage()));

        }
        return null;
    }
}
