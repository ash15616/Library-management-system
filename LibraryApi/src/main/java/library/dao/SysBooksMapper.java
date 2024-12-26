package library.dao;

import com.baomidou.mybatisplus.core.dao.Basedao;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import library.dto.BookVo;
import library.dto.ExceptionParm;
import library.entity.SysBooks;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysBooksdao extends Basedao<SysBooks> {
    IPage<SysBooks> getList(Page<SysBooks> page,@Param("parm") ExceptionParm.ListParm parm);
    int subBook(@Param("bookId") Long bookId);
    int addBook(@Param("bookId") Long bookId);
    List<BookVo> getHotBook();
}
