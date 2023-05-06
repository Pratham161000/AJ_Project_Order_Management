package com.chatbotaj.chatbot.controllers;

import com.chatbotaj.chatbot.models.OrderMasterModel;
import com.chatbotaj.chatbot.repository.OrderMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Random;

@Controller
@RequestMapping(path = "/addOrdersMaster")
public class OrderMasterController {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewOrder(@RequestParam Integer oid, @RequestParam Integer cid, @RequestParam Integer delivered, @RequestParam String shpadd, @RequestParam String tmode) {

        Random rand = new Random();
        String transection = "";
        String transection_id = "";

        if(tmode.equals("COD")) {
            transection = "NONE";
            transection_id = "NONE";
        } else {
            transection = "Done";
            transection_id = String.valueOf(rand.nextInt(1000000000));
        }

        OrderMasterModel n = new OrderMasterModel();
        n.setOid(oid);
        n.setCid(cid);
        n.setDatetime(LocalDateTime.now());
        n.setDelivered(delivered);
        n.setShpadd(shpadd);
        n.setTmode(tmode);
        n.setTransaction(transection);
        n.setTransactionId(transection_id);
        orderMasterRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<OrderMasterModel> getAllUsers() {
        return orderMasterRepository.findAll();
    }
}
