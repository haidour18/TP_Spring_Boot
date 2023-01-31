package com.example.myfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Service
public class FilmController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getActeurs}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod_acteurs")
    public String getActeurs()
    {

        String response = restTemplate.exchange("http://acteurs-service/getActeurs",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();

        System.out.println("Response Body " + response);

    }
@SuppressWarnings("unused")
    public String  fallbackMethod_acteurs(){

        return "Fallback response:: No acteurs  available temporarily";
    }
    @RequestMapping(value = "/getFilms}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethodFilms")
    public String getFilms()
    {

        String response = restTemplate.exchange("http://acteurs-service/getFilms",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();

        System.out.println("Response Body " + response);

    }
    @SuppressWarnings("unused")

    public String  fallbackMethodFilms(){

        return "Fallback response:: No acteurs  available temporarily";
    }


    @RequestMapping(value = "/getActeur/nom}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod_nom")
    public String getActeur(@PathVariable String nom)
    {

        String response = restTemplate.exchange("http://acteurs-service/getActeur/nom",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {},nom).getBody();

        System.out.println("Response Body " + response);

    }
    @SuppressWarnings("unused")

    public String  fallbackMethod_nom(String nom){

        return "Fallback response:: No acteurs  available temporarily";
    }

    @RequestMapping(value = "/getFilm/titre}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod_titre")
    public String getFilm(@PathVariable String titre)
    {

        String response = restTemplate.exchange("http://acteurs-service/getFilm/titre",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {},titre).getBody();

        System.out.println("Response Body " + response);

    }
    @SuppressWarnings("unused")

    public String  fallbackMethod_titre(String titre){

        return "Fallback response:: No acteurs  available temporarily";
    }

    @RequestMapping(value = "getFilmByDate/{date}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod_date")
    public String getFilmByDate(@PathVariable String date)
    {

        String response = restTemplate.exchange("http://acteurs-service/getFilmByDate/date",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {},date).getBody();

        System.out.println("Response Body " + response);

    }
    @SuppressWarnings("unused")

    public String  fallbackMethod_date(String date){

        return "Fallback response:: No acteurs  available temporarily";
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}