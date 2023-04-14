package com.sage.demo2

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @PostMapping("/list")
    @Operation(summary = "use id find models")
    fun hello(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "id list",
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                array = ArraySchema(schema = Schema(type = "integer", format = "int64", example = "1"))
            )]
        ) @org.springframework.web.bind.annotation.RequestBody ids: List<Long>
    ): String {
        return "hello"
    }

}
