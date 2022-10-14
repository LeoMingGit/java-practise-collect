package com.fs.tulingsql.controller;

import com.fs.tulingsql.dto.AuthorBookDto;
import com.fs.tulingsql.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "AuthorController",description = "Author接口")
@RequestMapping("/Author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    /**
     *
     *
     * @return
     */
    @ApiOperation("selectAuthor")
    @RequestMapping(value = "/selectAuthor", method = RequestMethod.GET)
    @ResponseBody
    public List<AuthorBookDto> selectAuthor(){

        return  authorService.selectAuthor();
    }

}
