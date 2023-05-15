package com.sage.mapper

import com.sage.entity.CategoryDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface CategoryMapper {

    fun getOne(): CategoryDto

}
