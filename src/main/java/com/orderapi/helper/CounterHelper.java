package com.orderapi.helper;

import com.orderapi.bo.counter.CounterCreateRequestBO;
import com.orderapi.bo.counter.CounterTypeCreateRequestBO;
import com.orderapi.bo.counter.CounterTypeUpdateRequestBO;
import com.orderapi.bo.counter.CounterUpdateRequestBO;
import com.orderapi.dto.CounterDTO;
import com.orderapi.dto.CounterTypeDTO;
import com.orderapi.rest.request.counter.CounterTypeUpdateRequest;
import com.orderapi.rest.request.counter.CounterCreateRequest;
import com.orderapi.rest.request.counter.CounterTypeCreateRequest;
import com.orderapi.rest.request.counter.CounterUpdateRequest;

public class CounterHelper {
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
        counterTypeDTO.setId(typeUpdateRequest.getId());
        return counterTypeDTO;
    }

    public static CounterDTO buildCounterDTOFromUpdateRequestBO(CounterUpdateRequestBO counterUpdateRequestBO) {
        CounterDTO counterDTO = new CounterDTO();
        counterDTO.setTypeId(counterUpdateRequestBO.getTypeId());
        counterDTO.setId(counterUpdateRequestBO.getId());
        counterDTO.setName(counterUpdateRequestBO.getName());
        counterDTO.setStoreId(counterUpdateRequestBO.getStoreId());
        return counterDTO;
    }

    public static CounterUpdateRequestBO buildUpdateRequestBOFromRequest(CounterUpdateRequest counterUpdateRequest) {
        CounterUpdateRequestBO updateRequestBO = new CounterUpdateRequestBO();
        updateRequestBO.setTypeId(counterUpdateRequest.getTypeId());
        updateRequestBO.setId(counterUpdateRequest.getId());
        updateRequestBO.setName(counterUpdateRequest.getName());
        updateRequestBO.setStoreId(counterUpdateRequest.getStoreId());
        return updateRequestBO;
    }
}
