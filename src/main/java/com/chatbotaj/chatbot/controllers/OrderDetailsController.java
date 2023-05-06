package com.chatbotaj.chatbot.controllers;

import com.chatbotaj.chatbot.models.OrderDetailsModel;
import com.chatbotaj.chatbot.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/addOrderDetails")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addOrderDetails(@RequestParam Integer cid, @RequestParam Integer oid, @RequestParam Integer canceled, @RequestParam Integer itemid, @RequestParam Integer qty, @RequestParam Double total, @RequestParam Integer pymtsts) {
        OrderDetailsModel n = new OrderDetailsModel();
        n.setCid(cid);
        n.setCanceled(canceled);
        n.setOid(oid);
        n.setItemId(itemid);
        n.setQty(qty);
        n.setTotal(total);
        n.setPymtsts(pymtsts);
        orderDetailsRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<OrderDetailsModel> getAllUsers() {
        return orderDetailsRepository.findAll();
    }
}
