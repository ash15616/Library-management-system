package library.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import library.utils.MakeTree;
import library.entity.SysMenu;
import library.entity.SysReader;
import library.service.SysMenuService;
import library.mapper.SysRoleMapper;
import library.service.SysRoleService;
import library.entity.SysUser;
import library.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysReader.SysRole> implements SysRoleService {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;
    @Override
    public IPage<SysReader.SysRole> list(SysReader.RoleParm parm) {
        //构造分页对象
        IPage<SysReader.SysRole> page = new Page<>();
        page.setSize(parm.getPageSize());
        page.setCurrent(parm.getCurrentPage());
        //查询条件
        QueryWrapper<SysReader.SysRole> query = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(parm.getRoleName())){
            query.lambda().like(SysReader.SysRole::getRoleName,parm.getRoleName());
        }
        return this.baseMapper.selectPage(page,query);
    }

    @Override
    public SysReader.AssignVo getAssignShow(SysReader.AssignParm parm) {
        //查询当前用户的信息
        SysUser user = sysUserService.getById(parm.getUserId());
        //菜单数据
        List<SysMenu> list = null;
        if(user.getIsAdmin().equals("1")){ //如果是超级管理员，拥有所有的权限
            QueryWrapper<SysMenu> query = new QueryWrapper<>();
            query.lambda().orderByAsc(SysMenu::getOrderNum);
            list = sysMenuService.list(query);
        }else{
            list = sysMenuService.getMenuByUserId(user.getUserId());
        }
        //组装树
        List<SysMenu> menuList = MakeTree.makeMenuTree(list, 0L);
        //查询角色原来的菜单
        List<SysMenu> roleList = sysMenuService.getMenuByRoleId(parm.getRoleId());
        List<Long> ids = new ArrayList<>();
        Optional.ofNullable(roleList).orElse(new ArrayList<>()).stream().filter(item -> item != null).forEach(item ->{
            ids.add(item.getMenuId());
        });
        //组装数据
        SysReader.AssignVo vo = new SysReader.AssignVo();
        vo.setMenuList(menuList);
        vo.setCheckList(ids.toArray());
        return vo;
    }
}
