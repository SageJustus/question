package com.sage.local

import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply

class JpaFilter : Filter<ILoggingEvent>() {
    override fun decide(event: ILoggingEvent): FilterReply {
        val result = event.message.startsWith("Start")
        println(event.message)
        println(result)
        return if (result) FilterReply.DENY else FilterReply.NEUTRAL
    }
}