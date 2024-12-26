package library.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import library.exception_advice.BusinessException;
import library.dto.ReaderParm;
import library.entity.SysReader;
import library.mapper.SysReaderMapper;
import library.service.SysReaderService;
import library.entity.ReaderRole;
import library.service.ReaderRoleService;
import library.service.SysRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysReaderServiceImpl extends ServiceImpl<SysReaderMapper, SysReader> implements SysReaderService {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private ReaderRoleService readerRoleService;

    @Override
    public IPage<SysReader> getList(ReaderParm parm) {
        //构造查询条件
        QueryWrapper<SysReader> query = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(parm.getIdCard())) {
            query.lambda().like(SysReader::getIdCard, parm.getIdCard());
        }
        if (StringUtils.isNotEmpty(parm.getLearnNum())) {
            query.lambda().like(SysReader::getLearnNum, parm.getLearnNum());
        }
        if (StringUtils.isNotEmpty(parm.getPhone())) {
            query.lambda().like(SysReader::getPhone, parm.getPhone());
        }
        if (StringUtils.isNotEmpty(parm.getUsername())) {
            query.lambda().like(SysReader::getUsername, parm.getUsername());
        }
        //构造分页对象
        IPage<SysReader> page = new Page<>();
        page.setCurrent(parm.getCurrentPage());
        page.setSize(parm.getPageSize());
        return this.baseMapper.selectPage(page, query);
    }

    @Override
    @Transactional
    public void saveReader(SysReader sysReader) {
        QueryWrapper<SysReader.SysRole> query = new QueryWrapper<>();
        query.lambda().eq(SysReader.SysRole::getRoleType, "2");
        SysReader.SysRole one = sysRoleService.getOne(query);
        if (one == null) {
            throw new BusinessException(500, "请先新建读者角色，再建读者!");
        }
        //新增读者
        this.baseMapper.insert(sysReader);
        //设置读者角色
        ReaderRole readerRole = new ReaderRole();
        readerRole.setReaderId(sysReader.getReaderId());
        readerRole.setRoleId(one.getRoleId());
        readerRoleService.save(readerRole);
    }

    @Override
    @Transactional
    public void editReader(SysReader sysReader) {
         //编辑读者
        this.baseMapper.updateById(sysReader);

        QueryWrapper<SysReader.SysRole> query = new QueryWrapper<>();
        query.lambda().eq(SysReader.SysRole::getRoleType, "2");
        SysReader.SysRole one = sysRoleService.getOne(query);

        //设置读者，先删除，再设置
        QueryWrapper<ReaderRole> readerRole = new QueryWrapper<>();
        readerRole.lambda().eq(ReaderRole::getReaderId, sysReader.getReaderId());
        //先删除
        readerRoleService.remove(readerRole);
        //设置读者角色
        ReaderRole saveReaderRole = new ReaderRole();
        saveReaderRole.setReaderId(sysReader.getReaderId());
        saveReaderRole.setRoleId(one.getRoleId());
        readerRoleService.save(saveReaderRole);
    }

    @Override
    public SysReader loadByUsername(String username) {
        QueryWrapper<SysReader> query = new QueryWrapper<>();
        query.lambda().eq(SysReader::getUsername,username);
        return this.baseMapper.selectOne(query);
    }
}
