package cn.dgut.dao;

import cn.dgut.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void saveSysLog(SysLog sysLog);

    @Select("select * from syslog")
    List<SysLog> findAll();
}
