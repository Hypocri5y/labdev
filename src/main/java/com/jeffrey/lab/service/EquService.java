package com.jeffrey.lab.service;

import com.jeffrey.lab.domain.Equipment;
import com.jeffrey.lab.mapper.EquipmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: lab
 * @author: Jeffrey
 * @create: 2025-04-02 15:27
 * @description:
 **/
@Service
public class EquService {

    @Resource
    private EquipmentMapper equMapper;

    public List<Equipment> select() {
        return equMapper.selectByExample(null);
    }
}
