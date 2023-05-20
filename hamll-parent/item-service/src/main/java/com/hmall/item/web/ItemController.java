package com.hmall.item.web;

import com.hmall.common.dto.PageDTO;
import com.hmall.item.pojo.Item;
import com.hmall.item.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@RequestMapping("item")
public class ItemController {


    @Autowired
    private IItemService itemService;


    @GetMapping("list")
    public PageDTO<Item> list(@RequestParam("page") Integer page, @RequestParam("size") Integer pageSize) {
        return itemService.page(page, pageSize);
    }


    @GetMapping("list/{id}")
    public Item getById(@PathVariable("id") Long id) {
        return itemService.getById(id);
    }

    @PostMapping
    public void save(Item item) {
        item.setCreateTime(new Date());
        item.setUpdateTime(new Date());
        itemService.save(item);
    }

    @PutMapping("/status/{id}/{status}")
    public void putStatus(@PathVariable("id") Long id, @PathVariable("status") Integer status) {
        Item item = new Item();
        item.setId(id);
        item.setStatus(status);
        itemService.updateById(item);
    }

    @PutMapping()
    public void update(Item item) {
        item.setUpdateTime(new Date());
        itemService.updateById(item);
    }


}
