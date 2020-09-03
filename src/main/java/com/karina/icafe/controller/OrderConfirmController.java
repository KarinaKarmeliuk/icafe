package com.karina.icafe.controller;

import com.karina.icafe.service.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@SessionScope
public class OrderConfirmController implements Serializable {

    @Autowired
    private Connector connector;


}
