package com.demo.cointransfer.config;

import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    public static Retrofit getInstance() {
        return new Retrofit.Builder()
                .baseUrl("https://placeholder/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
