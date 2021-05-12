package cn.smbms.mapper.role;

import java.sql.Connection;
import java.util.List;
import cn.smbms.pojo.Role;

public interface RoleDao {
	
	public List<Role> getRoleList()throws Exception;

}
