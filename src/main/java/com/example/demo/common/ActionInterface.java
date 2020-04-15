package com.example.demo.common;

import java.util.Map;

/**
 * Created by aman.ullah on 4/14/2020.
 */
public interface ActionInterface {
    Map executePreCondition(Map parameters);
    Map execute(Map previousResult);
    Map executePostCondition(Map previousResult);
    Map buildSuccessResult(Map executeResult);
    Map buildFailureResult(Map executeResult);
}
