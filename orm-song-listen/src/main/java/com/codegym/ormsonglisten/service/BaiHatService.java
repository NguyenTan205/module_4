package com.codegym.ormsonglisten.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codegym.ormsonglisten.model.BaiHat;
import com.codegym.ormsonglisten.repository.BaiHatRepository;

import java.util.List;

@Service
public class BaiHatService {
    @Autowired
    private BaiHatRepository baiHatRepository;

    public List<BaiHat> findAll() {
        return baiHatRepository.findAll();
    }

    public void save(BaiHat baihat) {
        baiHatRepository.save(baihat);
    }

    public BaiHat findById(Long id) {
        return baiHatRepository.findById(id);
    }

    public void delete(Long id) {
        baiHatRepository.delete(id);
    }
}