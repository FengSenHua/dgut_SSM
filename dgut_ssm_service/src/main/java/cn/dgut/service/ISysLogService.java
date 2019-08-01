package cn.dgut.service;

import cn.dgut.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    void saveSysLog(SysLog sysLog);

    List<SysLog> findAll();
}
