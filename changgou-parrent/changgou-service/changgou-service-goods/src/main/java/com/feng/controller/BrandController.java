package com.feng.controller;

import com.feng.goods.pojo.Brand;
import com.feng.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/findAll")
    public Result<List<Brand>> findAll(){
        List<Brand> brands = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK, "查询品牌成功", brands);
    }

    @GetMapping("/findById/{id}")
    public Result<Brand> findById(@PathVariable("id") Integer id){
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK, "查询品牌成功", brand);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "增加品牌成功");
    }

    @PutMapping("/update/{id}")
    public Result update(@RequestBody Brand brand, @PathVariable("id")Integer id){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true,StatusCode.OK, "修改品牌成功");
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        brandService.delete(id);
        return new Result(true, StatusCode.OK, "删除品牌成功");
    }

    @PostMapping("/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        List<Brand> brands = brandService.findList(brand);
        return new Result<List<Brand>>(true, StatusCode.OK, "条件查询", brands);

    }

    //条件+分页查询
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody Brand brand, @PathVariable  int page, @PathVariable  int size){
        //分页查询
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }
}

