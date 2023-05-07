package com.mybatisplus.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatisplus.mybatisplus.model.TblBook;
import com.mybatisplus.mybatisplus.service.TblBookService;
import com.mybatisplus.mybatisplus.mapper.TblBookMapper;
import org.springframework.stereotype.Service;

/**
* @author 李响
* @description 针对表【tbl_book】的数据库操作Service实现
* @createDate 2023-05-07 15:51:53
*/
@Service
public class TblBookServiceImpl extends ServiceImpl<TblBookMapper, TblBook>
    implements TblBookService{

}




