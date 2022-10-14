package com.fs.tulingsql.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fs.tulingsql.dto.AuthorBookDto;
import com.fs.tulingsql.entity.Author;
import com.fs.tulingsql.service.AuthorService;
import com.fs.tulingsql.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【author】的数据库操作Service实现
* @createDate 2022-10-13 13:21:51
*/
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author>
    implements AuthorService{

    @Autowired
    AuthorMapper authorMapper;

    @Override
    public List<AuthorBookDto> selectAuthor(){

        return  authorMapper.selectAuthor();

    }

}




