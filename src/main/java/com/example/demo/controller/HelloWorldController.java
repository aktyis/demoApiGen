package com.example.demo.controller;

import com.example.demo.model.Heroes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")
public class HelloWorldController {
    /*List<Heroes> heroes = new ArrayList<>();
    Gson gsonBuilder = new GsonBuilder().create();
    String jsonFromJavaArrayList = "";

    @RequestMapping("/hello")
    String hello() {
        String data = "Hello World";
        return data;
    }

    @RequestMapping("/heroes2")
    public String getHeroes() {
        heroes.clear();

        heroes.add(new Heroes(1, "ami"));
        heroes.add(new Heroes(2, "tumi"));
        heroes.add(new Heroes(3, "she"));
  *//*      heroes.add(new Heroes(4, "amra"));
        heroes.add(new Heroes(5, "tomra"));
        heroes.add(new Heroes(6, "tahara"));
        heroes.add(new Heroes(7, "elakabashi"));
        heroes.add(new Heroes(8, "mohollbashi"));
        heroes.add(new Heroes(9, "jellabashi"));
        heroes.add(new Heroes(10, "deshbashi"));*//*

//        String jsonHeroes = new Gson().toJson(heroes);
        jsonFromJavaArrayList = gsonBuilder.toJson(heroes);
        System.out.println(jsonFromJavaArrayList);
        return jsonFromJavaArrayList;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    String getHero(@PathVariable int id) {
        System.out.println("id: " + id);
        jsonFromJavaArrayList = gsonBuilder.toJson(heroes.get(id - 1));
        System.out.println(jsonFromJavaArrayList);
//        heroes.clear();
        return jsonFromJavaArrayList;
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    Heroes addHero(@RequestBody Heroes heroes1) { // @RequestBody Student student
//        String hero = (String) parameters.get("hero");             // RequestParam Map<String, Object> parameters
        System.out.println(heroes1);
        int id = heroes1.getId() + heroes.size() + 1;
        heroes.add(new Heroes(id, heroes1.getName()));

        jsonFromJavaArrayList = gsonBuilder.toJson(heroes);
        System.out.println(jsonFromJavaArrayList);
        return heroes1;
    }*/

}

