package library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import library.dto.ReaderParm;
import library.entity.SysReader;

public interface SysReaderService extends IService<SysReader> {
    IPage<SysReader> getList(ReaderParm parm);
    //新增读者
    void saveReader(SysReader sysReader);
    //编辑读者
    void editReader(SysReader sysReader);

    SysReader loadByUsername(String username);
}
