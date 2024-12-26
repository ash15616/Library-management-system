package library.dao;

import com.baomidou.mybatisplus.core.dao.Basedao;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import library.dto.ExceptionParm;
import library.dto.LookBorrow;
import library.dto.LookParm;
import library.dto.ReturnBook;

import library.entity.BorrowBook;
import org.apache.ibatis.annotations.Param;

public interface BorrowBookdao extends Basedao<BorrowBook> {
    IPage<ReturnBook> getBorrowList(Page<ReturnBook> page, @Param("parm") ExceptionParm.ListParm parm);
    //管理员借阅查看列表
    IPage<LookBorrow> getLookBorrowList(Page<LookBorrow> page, @Param("parm") LookParm parm);
    //读者借阅查看列表
    IPage<LookBorrow> getReaderLookBorrowList(Page<LookBorrow> page, @Param("parm") LookParm parm);
}
