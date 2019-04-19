package com.example.demo.mybatis.typeHandler;


import com.example.demo.mybatis.po.SexEnum;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@MappedTypes(SexEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class SexEnumTypeHandler extends EnumTypeHandler<SexEnum> {


    public SexEnumTypeHandler(Class<SexEnum> type) {
        super(type);
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        super.setParameter(ps, i, parameter, jdbcType);
        ps.setInt(i,parameter.getId());
    }

    @Override
    public SexEnum getResult(ResultSet rs, String columnName) throws SQLException {
        int id=rs.getInt(columnName);
        return SexEnum.getSexById(id);
    }

    @Override
    public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        int id=rs.getInt(columnIndex);
        return SexEnum.getSexById(id);
    }

    @Override
    public SexEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int id=cs.getInt(columnIndex);
        return SexEnum.getSexById(id);
    }
}
