package com.demo.cointransfer.api;

import com.demo.cointransfer.dto.coindeskapi.CoindeskApiOutputDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CoindeskApi {
    @GET
    Call<CoindeskApiOutputDto> fetchCoinInfo (@Url String url);
}
