package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询对应套餐id
     * @param dishId
     * @return
     */
    List<Long> getSetMealIdsByDishId(List<Long> dishId);
}
