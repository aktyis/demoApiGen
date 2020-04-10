package com.example.demo.controller;

import com.example.demo.model.Heroes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

    Gson gsonBuilder = new GsonBuilder().create();

    @RequestMapping("/hello")
    String hello() {
        String data = "Hello World";
        return data;
    }

    @RequestMapping("/heroes2")
    public String getCities() {

        List<Heroes> heroes = new ArrayList<>();

        heroes.add(new Heroes(1, "ami"));
        heroes.add(new Heroes(2, "tumi"));
        heroes.add(new Heroes(3, "she"));
        heroes.add(new Heroes(4, "amra"));
        heroes.add(new Heroes(5, "tomra"));
        heroes.add(new Heroes(6, "tahara"));
        heroes.add(new Heroes(7, "elakabashi"));
        heroes.add(new Heroes(8, "mohollbashi"));
        heroes.add(new Heroes(9, "jellabashi"));
        heroes.add(new Heroes(10, "deshbashi"));

//        String jsonHeroes = new Gson().toJson(heroes);
        String jsonFromJavaArrayList = gsonBuilder.toJson(heroes);
        System.out.println(jsonFromJavaArrayList);

        return jsonFromJavaArrayList;
    }

}

