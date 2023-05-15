package com.sage

import com.sage.mapper.CategoryMapper
import com.sage.mapper.SourceItemMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringbootMybatisApplicationTests() {

    @Autowired
    private lateinit var sourceItemMapper: SourceItemMapper

    @Autowired
    private lateinit var categoryMapper: CategoryMapper

    @Test
    fun hello() {
        val dto = sourceItemMapper.getUpsertRequestById(listOf(116391252727042048))
        println(dto)
    }

    @Test
    fun hello2(){
        val s = categoryMapper.getOne()
    }

}
