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

import java.util.Optional;

@Controller
@RequestMapping(path = "/cancelation")
public class CancelationController {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private CODRepository codRepository;

    @PostMapping(path = "/cancel")
    public @ResponseBody String cancelOrder(@RequestParam Integer cid) {
        OrderDetailsModel orderDetailsModel = orderDetailsRepository.findBycid(cid);

        OrderDetailsModel odm = new OrderDetailsModel();
        odm.setCid(cid);
        odm.setItemId(orderDetailsModel.getItemId());
        odm.setOid(orderDetailsModel.getOid());
        odm.setPymtsts(orderDetailsModel.getPymtsts());
        odm.setQty(orderDetailsModel.getQty());
        odm.setCanceled(1);
        odm.setTotal(orderDetailsModel.getTotal());
        orderDetailsRepository.save(odm);
        return "Canceled Successfully!";

    }
}
