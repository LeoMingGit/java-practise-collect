
package com.restfull.restfullapi.service.impl;

import com.restfull.restfullapi.model.Role;
import com.restfull.restfullapi.service.myinterface.IUserService;
import com.restfull.restfullapi.service.myinterface.IUserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UserService implements IUserService {


    @Override
    public List<Role> GetRoleList() {

        List<Role> lst = new ArrayList<Role>();
        for (int i = 0; i < 5; i++) {
            Role r = new Role(12345678910L, "jaackd", "NICE", 1, new Date(), 1, 1);
            lst.add(r);
        }
        return lst;
    }
}