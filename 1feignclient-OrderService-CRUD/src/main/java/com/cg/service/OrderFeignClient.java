package com.cg.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import feign.Headers;

@Headers("Content-Type :application/json")
@FeignClient(name="2feignclient-ProductService-CRUD" ,url="${PRODUCT_SERVICE:http://localhost:9091}")
public interface OrderFeignClient {
      @GetMapping("/api/products")
      String productresponse();
}
