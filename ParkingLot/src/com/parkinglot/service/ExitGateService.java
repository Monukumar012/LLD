package com.parkinglot.service;

import com.parkinglot.strategy.calculatefair.CalculateFairStrategy;

public class ExitGateService {
    private CalculateFairStrategy calculateFairStrategy;
    private PaymentService paymentService;
}