package com.example.demo.services.action.heroes;


import com.example.demo.model.Heroes;
import com.example.demo.repository.HeroesRepository;
import com.example.demo.services.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by aman.ullah on 4/14/2020.
 */
@Service
@Component
public class SelectHeroesActionService extends BaseService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HeroesRepository heroesRepository;

    public Heroes heroInfo(long id) {
        logger.error("-----------Student Selected---------");
        return heroesRepository.findById(id);
    }


}
