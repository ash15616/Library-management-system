package library.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import library.annotation.Auth;
import library.dto.ExceptionParm;
import library.utils.ResultUtils;
import library.utils.ResultVo;
import library.dto.BookVo;
import library.entity.SysBooks;
import library.service.SysBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class SysBooksController {
    @Autowired
    private SysBooksService sysBooksService;

    //新增
    @Auth
    @PostMapping
    public ResultVo add(@RequestBody SysBooks books){
        boolean save = sysBooksService.save(books);
        if(save){
            return ResultUtils.success("新增成功");
        }
        return ResultUtils.error("新增失败");
    }

    //编辑
    @Auth
    @PutMapping
    public ResultVo edit(@RequestBody SysBooks books){
        boolean save = sysBooksService.updateById(books);
        if(save){
            return ResultUtils.success("编辑成功");
        }
        return ResultUtils.error("编辑失败");
    }

    //删除
    @Auth
    @DeleteMapping("/{bookId}")
    public ResultVo delete(@PathVariable("bookId") Long bookId){
        boolean remove = sysBooksService.removeById(bookId);
         if(remove){
            return ResultUtils.success("删除成功");
        }
        return ResultUtils.error("删除失败");
    }

    //列表
    @Auth
    @GetMapping("/list")
    public ResultVo getList(ExceptionParm.ListParm parm){
        IPage<SysBooks> list = sysBooksService.getList(parm);
        return ResultUtils.success("查询成功",list);
    }

     //列表
    @Auth
    @GetMapping("/getHotBook")
    public ResultVo getHotBook(){
        List<BookVo> hotBook = sysBooksService.getHotBook();
        return ResultUtils.success("查询成功",hotBook);
    }
}
