package com.orderapi.spring.helper;

import com.orderapi.spring.bo.counter.CounterCreateRequestBO;
import com.orderapi.spring.bo.counter.CounterTypeCreateRequestBO;
import com.orderapi.spring.bo.counter.CounterTypeUpdateRequestBO;
import com.orderapi.spring.dto.CounterDTO;
import com.orderapi.spring.dto.CounterTypeDTO;
import com.orderapi.spring.rest.request.CounterTypeUpdateRequest;
import com.orderapi.spring.rest.request.counter.CounterCreateRequest;
import com.orderapi.spring.rest.request.counter.CounterTypeCreateRequest;

public class ConterHelper {
    public static CounterTypeCreateRequestBO buildTypeCreateRequestBOFromRequest(CounterTypeCreateRequest typeCreateRequest) {
        CounterTypeCreateRequestBO counterTypeCreateRequestBO = new CounterTypeCreateRequestBO();
        counterTypeCreateRequestBO.setTypeName(typeCreateRequest.getTypeName());
        return counterTypeCreateRequestBO;
    }

    public static CounterTypeDTO buildCounterTypeDTOFromCreateRequest(CounterTypeCreateRequestBO typeCreateRequestBO) {
        CounterTypeDTO counterTypeDTO = new CounterTypeDTO();
        counterTypeDTO.setName(typeCreateRequestBO.getTypeName());
        return counterTypeDTO;
    }

    public static CounterDTO buildCounterDTOFromCreateRequest(CounterCreateRequestBO counterCreateRequestBO) {
        CounterDTO counterDTO = new CounterDTO();
        counterDTO.setName(counterCreateRequestBO.getName());
        counterDTO.setStoreId(counterCreateRequestBO.getStoreId());
        counterDTO.setTypeId(counterCreateRequestBO.getTypeId());
        return counterDTO;
    }

    public static CounterCreateRequestBO buildCreateRequestBOFromRequest(CounterCreateRequest counterCreateRequest) {
        CounterCreateRequestBO createRequestBO = new CounterCreateRequestBO();
        createRequestBO.setName(counterCreateRequest.getName());
        createRequestBO.setStoreId(counterCreateRequest.getStoreId());
        createRequestBO.setTypeId(counterCreateRequest.getTypeId());
        return createRequestBO;
    }

    public static CounterTypeUpdateRequestBO buildTypeUpdateRequestBOFromRequest(CounterTypeUpdateRequest typeUpdateRequest) {
        CounterTypeUpdateRequestBO counterTypeUpdateRequestBO = new CounterTypeUpdateRequestBO();
        counterTypeUpdateRequestBO.setName(typeUpdateRequest.getName());
        counterTypeUpdateRequestBO.setId(typeUpdateRequest.getId());
        return counterTypeUpdateRequestBO;
    }
    public static CounterTypeDTO buildTypeUpdateDTOFromRequestBO(CounterTypeUpdateRequestBO typeUpdateRequest) {
        CounterTypeDTO counterTypeDTO = new CounterTypeDTO();
        counterTypeDTO.setName(typeUpdateRequest.getName());
        counterTypeDTO.setName(typeUpdateRequest.getName());
        return counterTypeDTO;
    }
}
