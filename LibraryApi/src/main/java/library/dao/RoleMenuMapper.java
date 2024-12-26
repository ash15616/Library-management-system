package library.dao;

import com.baomidou.mybatisplus.core.dao.Basedao;
import library.entity.RoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenudao extends Basedao<RoleMenu> {
    //保存角色的权限
    void assignSave(@Param("roleId") Long roleId, @Param("menuList")List<Long> menuList);
}
