package com.example.demo.controller;

import com.example.demo.common.BaseController;
import com.example.demo.model.Heroes;
import com.example.demo.services.action.heroes.CreateHeroesActionService;
import com.example.demo.services.action.heroes.DeleteHeroesActionService;
import com.example.demo.services.action.heroes.ListHeroesActionService;
import com.example.demo.services.action.heroes.SelectHeroesActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class HeroesController extends BaseController {

    private CreateHeroesActionService createHeroesActionService;
    private ListHeroesActionService listHeroesActionService;
    private SelectHeroesActionService selectHeroesActionService;
    private DeleteHeroesActionService deleteHeroesActionService;

    @Autowired
    public HeroesController(
            CreateHeroesActionService createHeroesActionService
            , ListHeroesActionService listHeroesActionService
            , SelectHeroesActionService selectHeroesActionService
            , DeleteHeroesActionService deleteHeroesActionService) {
        this.createHeroesActionService = createHeroesActionService;
        this.listHeroesActionService = listHeroesActionService;
        this.selectHeroesActionService = selectHeroesActionService;
        this.deleteHeroesActionService = deleteHeroesActionService;
    }


    @GetMapping(value = "/api/heroes2", produces = "application/json")
    @ResponseBody
    public String getHeroes() throws Exception {
        Map parameters = new HashMap();
        parameters.put("", "");
        return renderOutput(listHeroesActionService, parameters);
    }

    @RequestMapping(path = "/api/{id}", method = RequestMethod.GET)
    Heroes getHeroById(@PathVariable long id) {
        System.out.println("id: " + id);
        Heroes heroes = selectHeroesActionService.heroInfo(id);

        return heroes;
    }

    @RequestMapping(path = "/api/save", method = RequestMethod.POST)
    String addHero(@RequestBody Heroes heroes1) {
        Map parameters = new HashMap();
        if (heroes1.getId() != null) {
            parameters.put("id", heroes1.getId());
        }
        parameters.put("name", heroes1.getName());

        return renderOutput(createHeroesActionService, parameters);
    }

    @RequestMapping(path = "/api/delete/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    void deleteHeroById(@PathVariable long id) {
        deleteHeroesActionService.heroDelete(id);
    }


}
