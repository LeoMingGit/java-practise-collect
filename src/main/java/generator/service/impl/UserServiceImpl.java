package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.User;
import generator.service.UserService;
import generator.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-09-24 14:48:06
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




