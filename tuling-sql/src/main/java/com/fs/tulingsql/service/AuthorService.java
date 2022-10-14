package com.fs.tulingsql.service;

import com.fs.tulingsql.dto.AuthorBookDto;
import com.fs.tulingsql.entity.Author;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【author】的数据库操作Service
* @createDate 2022-10-13 13:21:51
*/
public interface AuthorService extends IService<Author> {

    List<AuthorBookDto> selectAuthor();
}
