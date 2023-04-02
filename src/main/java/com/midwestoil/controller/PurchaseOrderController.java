package com.midwestoil.controller;

import com.midwestoil.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoice/purchase")
public class PurchaseOrderController {

    @GetMapping("/create")
    public String createUser() {


        return "invoice/purchase/create";
    }
}
