package library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 用学号登录
 */
@TableName("sys_reader")
public class SysReader {
    @TableId(type = IdType.AUTO)
    private Long readerId;
    private String learnNum; // 姓名
    private String username;  // 学号
    private String idCard;
    private String sex;
    private String phone;
    private String password;
    private String type;
    private String checkStatus;
    private String userStatus;
    private String className;

    @Override
    public String toString() {
        return "SysReader{" +
                "readerId=" + readerId +
                ", learnNum='" + learnNum + '\'' +
                ", username='" + username + '\'' +
                ", idCard='" + idCard + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public String getLearnNum() {
        return learnNum;
    }

    public void setLearnNum(String learnNum) {
        this.learnNum = learnNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public SysReader() {
    }

    public SysReader(Long readerId, String learnNum, String username, String idCard, String sex, String phone, String password, String type, String checkStatus, String userStatus, String className) {
        this.readerId = readerId;
        this.learnNum = learnNum;
        this.username = username;
        this.idCard = idCard;
        this.sex = sex;
        this.phone = phone;
        this.password = password;
        this.type = type;
        this.checkStatus = checkStatus;
        this.userStatus = userStatus;
        this.className = className;
    }

    public static class AssignParm {
        private Long userId;
        private Long roleId;

        @Override
        public String toString() {
            return "AssignParm{" +
                    "userId=" + userId +
                    ", roleId=" + roleId +
                    '}';
        }

        public AssignParm() {
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }

        public AssignParm(Long userId, Long roleId) {
            this.userId = userId;
            this.roleId = roleId;
        }
    }

    public static class AssignVo {
        //当前用户拥有的菜单
        private List<SysMenu> menuList = new ArrayList<>();
        //被分配的角色拥有的菜单id
        private Object[] checkList;

        public AssignVo(List<SysMenu> menuList, Object[] checkList) {
            this.menuList = menuList;
            this.checkList = checkList;
        }

        @Override
        public String toString() {
            return "AssignVo{" +
                    "menuList=" + menuList +
                    ", checkList=" + Arrays.toString(checkList) +
                    '}';
        }

        public List<SysMenu> getMenuList() {
            return menuList;
        }

        public void setMenuList(List<SysMenu> menuList) {
            this.menuList = menuList;
        }

        public Object[] getCheckList() {
            return checkList;
        }

        public void setCheckList(Object[] checkList) {
            this.checkList = checkList;
        }

        public AssignVo() {
        }
    }

    public static class RoleParm {
        private Long currentPage;
        private Long pageSize;
        private String roleName;

        @Override
        public String toString() {
            return "RoleParm{" +
                    "currentPage=" + currentPage +
                    ", pageSize=" + pageSize +
                    ", roleName='" + roleName + '\'' +
                    '}';
        }

        public Long getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Long currentPage) {
            this.currentPage = currentPage;
        }

        public Long getPageSize() {
            return pageSize;
        }

        public void setPageSize(Long pageSize) {
            this.pageSize = pageSize;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public RoleParm() {
        }

        public RoleParm(Long currentPage, Long pageSize, String roleName) {
            this.currentPage = currentPage;
            this.pageSize = pageSize;
            this.roleName = roleName;
        }
    }

    public static class SaveAssign {
        private Long roleId;
        private List<Long> list;

        @Override
        public String toString() {
            return "SaveAssign{" +
                    "roleId=" + roleId +
                    ", list=" + list +
                    '}';
        }

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }

        public List<Long> getList() {
            return list;
        }

        public void setList(List<Long> list) {
            this.list = list;
        }

        public SaveAssign(Long roleId, List<Long> list) {
            this.roleId = roleId;
            this.list = list;
        }

        public SaveAssign() {
        }
    }

    @TableName("sys_role")
    public static class SysRole {
        @TableId(type = IdType.AUTO)
        private Long roleId;
        private String roleName;
        private String roleType;
        private String remark;
        private Date createTime;
        private Date updateTime;

        @Override
        public String toString() {
            return "SysRole{" +
                    "roleId=" + roleId +
                    ", roleName='" + roleName + '\'' +
                    ", roleType='" + roleType + '\'' +
                    ", remark='" + remark + '\'' +
                    ", createTime=" + createTime +
                    ", updateTime=" + updateTime +
                    '}';
        }

        public Long getRoleId() {
            return roleId;
        }

        public void setRoleId(Long roleId) {
            this.roleId = roleId;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleType() {
            return roleType;
        }

        public void setRoleType(String roleType) {
            this.roleType = roleType;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        public SysRole(Long roleId, String roleName, String roleType, String remark, Date createTime, Date updateTime) {
            this.roleId = roleId;
            this.roleName = roleName;
            this.roleType = roleType;
            this.remark = remark;
            this.createTime = createTime;
            this.updateTime = updateTime;
        }

        public SysRole() {
        }
    }
}
