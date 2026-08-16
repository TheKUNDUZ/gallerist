package com.alikunduz.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CurrencyRatesResponse {

    private Integer totalCount;

    private List<CurrencyRatesItems> items;


//    {
//        "totalCount": 1,
//            "items": [
//        {
//            "Tarih": "07-08-2026",
//                "TP_DK_USD_A": "47.50550000",
//                "UNIXTIME": {
//            "$numberLong": "1786050000"
//        }
//        }
//    ]
//    }


}
