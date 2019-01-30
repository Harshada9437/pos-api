package com.orderapi.requesthandler;

import com.orderapi.bo.counter.CounterCreateRequestBO;
import com.orderapi.bo.counter.CounterTypeCreateRequestBO;
import com.orderapi.bo.counter.CounterTypeUpdateRequestBO;
import com.orderapi.bo.counter.CounterUpdateRequestBO;
import com.orderapi.dao.CounterDAO;
import com.orderapi.dto.CounterDTO;
import com.orderapi.dto.CounterTypeDTO;
import com.orderapi.helper.CounterHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CounterRequestHandler {
    @Autowired
    CounterDAO counterDAO;

    public void createCounterType(CounterTypeCreateRequestBO typeCreateRequestBO) {
        counterDAO.createCounterType(CounterHelper.buildCounterTypeDTOFromCreateRequest(typeCreateRequestBO));
    }

    public void createCounter(CounterCreateRequestBO counterCreateRequestBO) {
        counterDAO.createCounter(CounterHelper.buildCounterDTOFromCreateRequest(counterCreateRequestBO));
    }

    public List<CounterTypeDTO> getCounterType() {
        return counterDAO.getCounterType();
    }

    public void updateCounterType(CounterTypeUpdateRequestBO typeUpdateRequestBO) {
        counterDAO.updateCounterType(CounterHelper.buildTypeUpdateDTOFromRequestBO(typeUpdateRequestBO));
    }

    public List<CounterDTO> getCounterList() {
        return counterDAO.getCounterList();
    }

    public void updateCounter(CounterUpdateRequestBO counterUpdateRequestBO) {
        counterDAO.updateCounter(CounterHelper.buildCounterDTOFromUpdateRequestBO(counterUpdateRequestBO));
    }
}
