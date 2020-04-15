package com.example.demo.services.action.heroes;

import com.example.demo.common.ActionInterface;
import com.example.demo.model.Heroes;
import com.example.demo.repository.HeroesRepository;
import com.example.demo.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by aman.ullah on 4/14/2020.
 */
@Service
@Component
public class CreateHeroesActionService extends BaseService implements ActionInterface {

    private HeroesRepository heroesRepository;
    private static String CREATE_SUCCESS_MESSAGE = "Successfully Created";
    private static String UPDATE_SUCCESS_MESSAGE = "Successfully Updated";


    @Autowired
    public CreateHeroesActionService(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    @Override
    public Map executePreCondition(Map parameters) {
        return parameters;
    }

    @Override
    public Map execute(Map previousResult) {

        Heroes heroes = null;

        if (previousResult.get("id") != null) {
            long id = Long.parseLong((String) previousResult.get("id"));
            heroes = heroesRepository.findById(id);
            previousResult.put("idAvailable", "true");
        } else {
            heroes = new Heroes();
        }

        heroes.setName((String) previousResult.get("name"));

        heroesRepository.save(heroes);

        return previousResult;
    }

    @Override
    public Map executePostCondition(Map previousResult) {
        return previousResult;
    }

    @Override
    public Map buildSuccessResult(Map executeResult) {
        if (executeResult.get("idAvailable") == "true") {
            return super.setSuccess(executeResult, UPDATE_SUCCESS_MESSAGE);
        } else {
            return super.setSuccess(executeResult, CREATE_SUCCESS_MESSAGE);
        }

    }

    @Override
    public Map buildFailureResult(Map executeResult) {
        return executeResult;
    }
}
