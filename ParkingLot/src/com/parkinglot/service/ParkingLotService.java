package com.parkinglot.service;

import com.parkinglot.entity.Gate;
import com.parkinglot.entity.ParkingFloor;

import java.util.List;

public class ParkingLotService {
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private EntryGateService entryGateService;
    private ExitGateService exitGateService;
}