package com.chatbotaj.chatbot.repository;

import com.chatbotaj.chatbot.models.OrderDetailsModel;
import com.chatbotaj.chatbot.models.OrderMasterModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderDetailsRepository extends CrudRepository<OrderDetailsModel, Integer> {

    OrderDetailsModel findBycid(@Param("cid") Integer cid);
}
