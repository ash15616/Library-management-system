package library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import library.dto.CategoryEcharts;
import library.dto.ListCateParm;
import library.entity.SysCategory;


public interface SysCategoryService extends IService<SysCategory> {
    IPage<SysCategory> getList(ListCateParm parm);
    CategoryEcharts getCategoryVo();
}
