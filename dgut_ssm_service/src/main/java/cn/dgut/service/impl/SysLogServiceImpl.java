package cn.dgut.service.impl;

import cn.dgut.dao.ISysLogDao;
import cn.dgut.domain.SysLog;
import cn.dgut.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sysLogService")
@Transactional
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void saveSysLog(SysLog sysLog) {
        sysLogDao.saveSysLog(sysLog);
    }

    @Override
    public List<SysLog> findAll() {

        return sysLogDao.findAll();
    }
}
