package library.dao;

import com.baomidou.mybatisplus.core.dao.Basedao;
import library.dto.CategoryVo;
import library.entity.SysCategory;

import java.util.List;

public interface SysCategorydao extends Basedao<SysCategory> {
    List<CategoryVo> getCategoryVo();
}
