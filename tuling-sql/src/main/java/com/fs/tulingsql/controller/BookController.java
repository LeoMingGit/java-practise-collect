package com.fs.tulingsql.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "BookController",description = "Book接口")
@RequestMapping("/ Book")
public class BookController {

}
