package library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import library.dto.PageParm;
import library.entity.SysUser;

public interface SysUserService extends IService<SysUser> {
    IPage<SysUser> list(PageParm parm);
    void addUser(SysUser user);
    void editUser(SysUser user);
    SysUser loadByUsername(String username);
}
