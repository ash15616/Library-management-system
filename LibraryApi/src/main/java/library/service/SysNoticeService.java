package library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import library.dto.NoticeParm;
import library.entity.SysNotice;

public interface SysNoticeService extends IService<SysNotice> {
    IPage<SysNotice> getList(NoticeParm parm);
}
