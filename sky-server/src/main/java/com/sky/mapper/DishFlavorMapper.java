package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入菜品数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id删除菜品
     * @param id
     */
    void deleteBatch(Long id);

    /**
     * 根据菜品ids集合批量删除口味
     * @param ids
     */
    void deleteBatchs(List<Long> ids);
}
