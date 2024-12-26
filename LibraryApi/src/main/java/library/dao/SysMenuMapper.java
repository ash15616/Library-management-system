package library.dao;

import com.baomidou.mybatisplus.core.dao.Basedao;
import library.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenudao extends Basedao<SysMenu> {
    //根据用户id查询权限
    List<SysMenu> getMenuByUserId(@Param("userId") Long userId);
    //根据读者id查询权限
    List<SysMenu> getReaderMenuByUserId(@Param("readerId") Long readerId);
    //根据角色id查询权限
    List<SysMenu> getMenuByRoleId(@Param("roleId") Long roleId);
}
