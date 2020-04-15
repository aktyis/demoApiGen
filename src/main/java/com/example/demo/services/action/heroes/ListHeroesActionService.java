package com.example.demo.services.action.heroes;



import com.example.demo.common.ActionInterface;
import com.example.demo.services.BaseService;
import groovy.sql.GroovyRowResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by aman.ullah on 4/14/2020.
 */
@Service
@Component
public class ListHeroesActionService extends BaseService implements ActionInterface {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private static String SUCCESS_MESSAGE = "Successfully Displayed";

    @Override
    public Map executePreCondition(Map parameters) {
        return parameters;
    }

    @Override
    public Map execute(Map previousResult) {
        try {
            String preparedQuery = executeWithParams();
            List<GroovyRowResult> queryList = executeSelectSql(preparedQuery);
            previousResult.put("queryList", queryList);
            previousResult.put("aman", "aman");
            return previousResult;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Map executePostCondition(Map previousResult) {
        return previousResult;
    }

    @Override
    public Map buildSuccessResult(Map executeResult) {
        return super.setSuccess(executeResult, SUCCESS_MESSAGE);

    }

    @Override
    public Map buildFailureResult(Map executeResult) {
        return executeResult;
    }

    private String executeWithParams() {
//        String sqlString = "SELECT id, studentId, studentName, courseId FROM StudentInfo ";
        String sqlString = "SELECT * \n" +
                "  FROM heroes";

        return sqlString;
    }
}
