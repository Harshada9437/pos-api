package com.orderapi.api;

import com.orderapi.bo.ItemCategoryCreateRequestBO;
import com.orderapi.constants.ItemConstants;
import com.orderapi.constants.MESSAGETYPE;
import com.orderapi.dto.CounterTypeDTO;
import com.orderapi.dto.ItemCategoryDTO;
import com.orderapi.helper.ItemHelper;
import com.orderapi.requesthandler.ItemRequestHandler;
import com.orderapi.rest.request.ItemCategoryCreateRequest;
import com.orderapi.rest.response.CounterTypeListResponse;
import com.orderapi.rest.response.ItemCategoryResponseListResponse;
import com.orderapi.rest.response.MessageResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api("Food item operations")
@RequestMapping(ItemConstants.item)
@Controller
public class ItemController {
    @Autowired
    private ItemRequestHandler itemRequestHandler;
    @Autowired
    private MessageResponse messageResponse;

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @ApiOperation(value = "Item category creation process",
            response = ItemController.class)
    @RequestMapping(value = ItemConstants.item_category_create, method = RequestMethod.POST)
    public
    @ResponseBody
    MessageResponse createItemCategory(@RequestHeader("Auth") String auth, @Valid @RequestBody ItemCategoryCreateRequest itemCategoryCreateRequest, BindingResult result) {
        if (result.hasErrors()) {
            messageResponse.setMessage(result.getFieldError().getDefaultMessage());
            messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
            return messageResponse;
        } else {
            try {
                // if(auth != null && new UserRequestValidation().isRequestValid(auth)) {
                ItemCategoryCreateRequestBO itemCategoryCreateRequestBO = ItemHelper.buildCategoryCreateRequestBOFromRequest(itemCategoryCreateRequest);
                itemRequestHandler.createItemCategory(itemCategoryCreateRequestBO);
                messageResponse.setMessage("New counter type has been created.");
                messageResponse.setMessageType(MESSAGETYPE.SUCCESS.name());
                return messageResponse;
            /*    }else{
                    messageResponse.setMessageType("UNAUTHORIZED");
                    messageResponse.setMessage("UNAUTHORIZED ACCESS");
                    return messageResponse;
                }*/
            } catch (Exception e) {
                e.printStackTrace();
                messageResponse.setMessage(e.getMessage());
                messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
                return messageResponse;
            }
        }
    }

    @ApiOperation(value = "Item category listing",
            response = ItemController.class)
    @RequestMapping(value = ItemConstants.get_item_category_list, method = RequestMethod.GET)
    public
    @ResponseBody
    Object getItemCategoryList() {
        try {
            ItemCategoryResponseListResponse listResponse = new ItemCategoryResponseListResponse();
            List<ItemCategoryDTO> itemCategoryList = itemRequestHandler.getItemCategoryList();
            if (itemCategoryList.size() > 0) {
                listResponse.setItemCategoryList(itemCategoryList);
                listResponse.setMessageType(MESSAGETYPE.SUCCESS.name());
                return listResponse;
            } else {
                messageResponse.setMessage("Failed to get the list of categories.");
                messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
                return messageResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
            messageResponse.setMessage(e.getMessage());
            messageResponse.setMessageType(MESSAGETYPE.FAILURE.name());
            return messageResponse;
        }
    }
}
