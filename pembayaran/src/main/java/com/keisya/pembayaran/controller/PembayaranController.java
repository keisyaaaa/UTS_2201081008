/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.keisya.pembayaran.controller;

import com.keisya.pembayaran.entity.Pembayaran;
import com.keisya.pembayaran.service.PembayaranService;
import com.keisya.pembayaran.vo.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("api/v1/pembayaran")
public class PembayaranController {
    @Autowired
    private PembayaranService pembayaranService;
    
   @GetMapping
    public List<Pembayaran> getAll() {
        return pembayaranService.getAll();
    }
    
    @GetMapping(path = "{id}")
    public Pembayaran getPembayaran(@PathVariable("id") Long id){
        return pembayaranService.getPembayaran(id);
    }

    @PostMapping
    public void insertPembayaran(@RequestBody Pembayaran pembayaran) {
        pembayaranService.insert(pembayaran);
    } 
     @GetMapping(path = "/order/produk/{id}")
    public List<ResponseTemplate>getPembayaranWithOrderkById(@PathVariable("id") Long id) {
        return pembayaranService.getPembayaranWithOrderkById(id);
    }
}