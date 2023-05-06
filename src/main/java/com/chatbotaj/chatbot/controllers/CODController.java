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
@RequestMapping(path = "/manageCOD")
public class CODController {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private CODRepository codRepository;

    @PostMapping(path = "/updateCOD")
    public @ResponseBody String addNewUser(@RequestParam Integer cid) {
        OrderMasterModel orderMasterModel = orderMasterRepository.findBycid(cid);
        OrderDetailsModel orderDetailsModel = orderDetailsRepository.findBycid(cid);
//        Optional<OrderMasterModel> orderCOD = CODRepository.findBycid(cid);
        if(orderMasterModel != null) {
            OrderMasterModel n = orderMasterModel;
            if(n.getTmode().equals("COD")) {
                OrderDetailsModel odm = new OrderDetailsModel();
                odm.setCid(cid);
                odm.setItemId(orderDetailsModel.getItemId());
                odm.setOid(orderDetailsModel.getOid());
                odm.setPymtsts(1);
                odm.setCanceled(orderDetailsModel.getCanceled());
                odm.setQty(orderDetailsModel.getQty());
                odm.setTotal(orderDetailsModel.getTotal());
                orderDetailsRepository.save(odm);
                return "Updated";
            }
        } else {
            return "No COD Record found!";
        }

        return "Something went Wrong!";
    }
}
