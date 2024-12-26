package library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import library.entity.UserRole;
import library.mapper.UserRoleMapper;
import library.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
