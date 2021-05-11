package com.feng.service;

import com.feng.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    List<Brand> findAll();
    Brand findById(Integer id);
    void add(Brand brand);
    void update(Brand brand);
    void delete(Integer id);
    List<Brand> findList(Brand brand);
    PageInfo<Brand> findPage(Brand brand, int page, int size);
}
