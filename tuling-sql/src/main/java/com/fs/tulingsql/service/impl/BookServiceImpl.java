package com.fs.tulingsql.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fs.tulingsql.entity.Book;
import com.fs.tulingsql.service.BookService;
import com.fs.tulingsql.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【book】的数据库操作Service实现
* @createDate 2022-10-13 13:21:29
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




