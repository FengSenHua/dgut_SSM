package cn.dgut.dao;

import cn.dgut.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    //根据id查询会员
    @Select("select * from member where id=#{id}")
    public Member findById(String id);
}
