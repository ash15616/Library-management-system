package library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import library.entity.RoleMenu;

import java.util.List;

public interface RoleMenuService extends IService<RoleMenu> {
    //保存角色的权限
    void assignSave(Long roleId,List<Long> menuList);
}
