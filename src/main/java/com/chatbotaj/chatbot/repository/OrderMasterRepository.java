package com.chatbotaj.chatbot.repository;

import com.chatbotaj.chatbot.models.OrderMasterModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderMasterRepository extends CrudRepository<OrderMasterModel, Integer> {
    OrderMasterModel findBycid(@Param("cid") Integer cid);
}
