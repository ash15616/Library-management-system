package library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import library.entity.ReaderRole;
import library.mapper.ReaderRoleMapper;
import library.service.ReaderRoleService;
import org.springframework.stereotype.Service;

@Service
public class ReaderRoleServiceImpl extends ServiceImpl<ReaderRoleMapper, ReaderRole> implements ReaderRoleService {
}
