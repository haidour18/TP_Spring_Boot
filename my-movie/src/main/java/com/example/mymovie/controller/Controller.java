package com.example.mymovie.controller;


import com.example.mymovie.model.Acteur;
import com.example.mymovie.model.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Api(value = "Controller", description = "REST Apis related to Actors and films Entity!!!!")

@RestController
public class Controller {

    String date1 = "22-06-2006";
    String date2 = "22-06-2008";


    Acteur acteur1 = new Acteur("Asmaa","Haidour", date1);
    Acteur acteur2 = new Acteur("Leila","Lagrid",date1);

    List<Acteur>acteurs=new ArrayList<Acteur>();{
        this.acteurs.add(acteur1);
        this.acteurs.add(acteur2);


    }

    Film film1=new Film("Leila","Asmaa",date1,acteur1);
    Film film2=new Film("Titanic","Asmaa",date2,acteur2);



    List<Film> films= new ArrayList<Film>();{
        this.films.add(film1);
        this.films.add(film2);
    }

    @ApiOperation(value = "Get list of Actors and films in the System ", response = Iterable.class, tags = "getActeurs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })



    @RequestMapping(value = "/getActeurs")
    public List<Acteur> getActeurs() {
        return acteurs;
    }

    @ApiOperation(value = "Get specific Acteur in the System ", response = Acteur.class, tags = "getActeur")

    @RequestMapping(value = "/getActeur/{nom}")
    public Acteur getActeur(@PathVariable(value = "nom") String nom) {
        return acteurs.stream().filter(x -> x.getNom().equalsIgnoreCase(nom)).collect(Collectors.toList()).get(0);
    }
    @ApiOperation(value = "Get list of Actors and films in the System ", response = Iterable.class, tags = "getFilms")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })


    @RequestMapping(value = "/getFilms")

    public List<Film>getFilms(){
        return films;
    }
    @ApiOperation(value = "Get specific Film in the System ", response = Film.class, tags = "getFilm")

    @RequestMapping(value = "/getFilm/{titre}")
    public Film getFilm(@PathVariable(value = "titre") String titre) {
        return films.stream().filter(x -> x.getTitre().equalsIgnoreCase(titre)).collect(Collectors.toList()).get(0);
    }
    @ApiOperation(value = "Get specific Film in the System ", response = Film.class, tags = "getFilmByDate")

    @RequestMapping(value = "/getFilmByDate/{date}")
    public Film getFilmByDate(@PathVariable(value = "date") String date) {
        return films.stream().filter(x -> x.getDate().equalsIgnoreCase(date)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get specific Film in the System ", response = Acteur.class, tags = "getActeursByFilm")

    @GetMapping("/getActeursByFilm/{titre}")
    public List<Acteur> getActeursByFilm(@PathVariable String titre) {
        List<Acteur> acteursByFilm = new ArrayList<>();
        for (Film film : films) {
            if (film.getTitre().equals(titre)) {
                acteursByFilm.add(film.getActeur());
                break;
            }
        }
        return acteursByFilm;
    }
    //@ApiOperation(value = "Delete Acteur  in the System ", response = Acteur.class, tags = "deleteActeur")





}
