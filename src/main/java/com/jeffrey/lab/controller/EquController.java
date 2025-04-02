package com.jeffrey.lab.controller;

import com.jeffrey.lab.domain.Equipment;
import com.jeffrey.lab.service.EquService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: lab
 * @author: Jeffrey
 * @create: 2025-04-02 15:26
 * @description:
 **/
@RestController
public class EquController {

    @Resource
    private EquService equService;
    @GetMapping("/equ/list")
    public List<Equipment> getEquList() {
        List<Equipment> list = equService.select();
        return list;
    }
}
