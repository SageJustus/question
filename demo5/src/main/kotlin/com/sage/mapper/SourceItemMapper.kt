package com.sage.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.sage.entity.SourceUpsertItemRequest
import org.apache.ibatis.annotations.Mapper

@Mapper
interface SourceItemMapper : BaseMapper<SourceItemEntity> {


    fun getUpsertRequestById(ids: List<Long>): List<SourceUpsertItemRequest>

}
