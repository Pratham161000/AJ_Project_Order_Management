package com.chatbotaj.chatbot.controllers;

import com.chatbotaj.chatbot.models.OrderDetailsModel;
import com.chatbotaj.chatbot.models.OrderMasterModel;
import com.chatbotaj.chatbot.repository.CODRepository;
import com.chatbotaj.chatbot.repository.OrderDetailsRepository;
import com.chatbotaj.chatbot.repository.OrderMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping(path = "/delivery")
public class DeliveryController {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private CODRepository codRepository;

    @PostMapping(path = "/delivered")
    public @ResponseBody String deliveryStatus(@RequestParam Integer cid) {
        OrderMasterModel orderMasterModel = orderMasterRepository.findBycid(cid);

        OrderMasterModel omm = new OrderMasterModel();
        omm.setCid(cid);
        omm.setOid(orderMasterModel.getOid());
        omm.setDatetime(LocalDateTime.now());
        omm.setDelivered(1);
        omm.setShpadd(orderMasterModel.getShpadd());
        omm.setTmode(orderMasterModel.getTmode());
        omm.setTransaction(orderMasterModel.getTransaction());
        omm.setTransactionId(orderMasterModel.getTransactionId());
        orderMasterRepository.save(omm);
        return "Order Delivered Successfully!";
    }
}
