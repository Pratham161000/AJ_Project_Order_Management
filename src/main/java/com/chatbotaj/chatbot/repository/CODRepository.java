package com.chatbotaj.chatbot.repository;

import com.chatbotaj.chatbot.models.OrderMasterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface CODRepository extends CrudRepository<OrderMasterModel, Integer> {

}
