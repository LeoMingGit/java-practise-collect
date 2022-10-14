package com.fs.tulingsql.mapper;

import com.fs.tulingsql.dto.AuthorBookDto;
import com.fs.tulingsql.entity.Author;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【author】的数据库操作Mapper
* @createDate 2022-10-13 13:21:51
* @Entity com.fs.tulingsql.entity.Author
*/
public interface AuthorMapper extends BaseMapper<Author> {

   List<AuthorBookDto> selectAuthor();
}




