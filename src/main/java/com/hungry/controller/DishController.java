package com.hungry.controller;

import com.hungry.pojo.PageInfo;
import com.hungry.pojo.Result;
import com.hungry.pojo.entity.Dish;
import com.hungry.service.impl.DishServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
@RequiredArgsConstructor
@Slf4j
public class DishController {
    private final DishServiceImpl dishService;
    @GetMapping("/page")
    public Result<PageInfo<Dish>> page(@RequestParam int pageNum, @RequestParam int pageSize) {
        return Result.success(dishService.MyPageList(pageNum,pageSize));
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public Result<String> editDish(@RequestBody Dish dish,@PathVariable Integer id){
        log.info("{}",dish);
        log.info("{}",id);
        return dishService.editDish(dish,id);
    }

    @PutMapping("/add")
    @PreAuthorize("hasAuthority('admin')")
    public Result<String> addDish(@RequestBody Dish dish){
        return dishService.addDish(dish);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public Result<String> deleteDish(@PathVariable Integer id){
        return dishService.deleteDish(id);
    }

    @PostMapping("/{status}/{id}")@PreAuthorize("hasAuthority('admin')")
    public Result<String> editStatus(@PathVariable int status,
                                     @PathVariable Integer id){
        return dishService.editStatus(status,id);
    }

    @GetMapping("/select/{id}")
    public Result<Dish> queryDishById(@PathVariable Integer id){
        return dishService.queryDishById(id);
    }
}
