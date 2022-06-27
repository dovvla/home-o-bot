package com.robot.homeobot.controller;

import com.robot.homeobot.dtos.ChangeRealEstateOwnersDTO;
import com.robot.homeobot.dtos.DeviceConfigDTO;
import com.robot.homeobot.exception.MyException;
import com.robot.homeobot.model.Device;
import com.robot.homeobot.model.RealEstate;
import com.robot.homeobot.services.realestate.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/devices", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/update-config")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Device>> updateAllDevicesConfig(@RequestBody List<DeviceConfigDTO> dtos) {
        List<Device> allDevices = deviceService.updateAllDevicesConfig(dtos);

        return new ResponseEntity<>(allDevices, HttpStatus.OK);
    }

}