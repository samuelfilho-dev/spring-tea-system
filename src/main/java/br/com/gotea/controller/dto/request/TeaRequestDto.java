package br.com.gotea.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeaRequestDto {

    private String name;

    private String description;

    private String category;

    private String originCountry;

    private LocalTime infusionTime;

    private Integer waterTemperature;

    private Integer caffeineContent;

    private BigInteger price;

    private String tasteRating;

    private String imageUrl;
}
