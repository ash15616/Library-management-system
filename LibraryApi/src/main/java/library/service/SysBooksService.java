package library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import library.dto.BookVo;
import library.dto.ExceptionParm;
import library.entity.SysBooks;

import java.util.List;

public interface SysBooksService extends IService<SysBooks> {
    IPage<SysBooks> getList(ExceptionParm.ListParm parm);
    //减库存
    int subBook(Long bookId);
    //加库存
    int addBook(Long bookId);
     List<BookVo> getHotBook();
}
