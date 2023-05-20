package com.hmall.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmall.common.dto.PageDTO;
import com.hmall.item.mapper.ItemMapper;
import com.hmall.item.pojo.Item;
import com.hmall.item.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService extends ServiceImpl<ItemMapper, Item> implements IItemService {
    @Autowired
    private ItemMapper itemMapper;


    @Override
    public PageDTO<Item> page(Integer page, Integer pageSize) {
        Page<Item> itemPage = new Page<>(page, pageSize);
        PageDTO<Item> itemPageDTO = new PageDTO<>();
        Page<Item> pageInfo = itemMapper.selectPage(itemPage, null);
        itemPageDTO.setList(pageInfo.getRecords());
        itemPageDTO.setTotal(pageInfo.getTotal());
        return itemPageDTO;
    }
}
