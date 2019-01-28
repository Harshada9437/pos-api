package com.orderapi.spring.requesthandler;

import com.orderapi.spring.bo.counter.CounterCreateRequestBO;
import com.orderapi.spring.bo.counter.CounterTypeCreateRequestBO;
import com.orderapi.spring.bo.counter.CounterTypeUpdateRequestBO;
import com.orderapi.spring.dao.CounterDAO;
import com.orderapi.spring.dto.CounterTypeDTO;
import com.orderapi.spring.helper.ConterHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CounterRequestHandler {
    @Autowired
    CounterDAO counterDAO;
    public int createCounterType(CounterTypeCreateRequestBO typeCreateRequestBO) {
        return counterDAO.createCounterType(ConterHelper.buildCounterTypeDTOFromCreateRequest(typeCreateRequestBO));
    }

    public int createCounter(CounterCreateRequestBO counterCreateRequestBO) {
        return counterDAO.createCounter(ConterHelper.buildCounterDTOFromCreateRequest(counterCreateRequestBO));
    }

    public List<CounterTypeDTO> getCounterType() {
        return counterDAO.getCounterType();
    }

    public boolean updateCounterType(CounterTypeUpdateRequestBO typeUpdateRequestBO) {
        counterDAO.updateCounterType(typeUpdateRequestBO);
        return true;
    }
}
