package com.northstar.crm;

import com.northstar.crm.repository.CustomerRepository;

public class FailureExperiment {

    public static void main(String[] args) {
        new CustomerRepository().findById("CUS-1001");
    }
}