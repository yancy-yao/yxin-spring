package com.yancy.spring.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by yancy on 2017/11/21.
 */
public abstract class JdbcTemplate {

    public final Object execute(String sql){
        Connection con = null;
        Statement stmt = null;
        try{
            con = getConnection();
            stmt = con.createStatement();
            Object retValue = executeWithStatement(stmt, sql);
            return retValue;
        } catch (SQLException e){
//            DataAceessException ex = translateSQLException(e);
//            throw ex;
            return null;
        }
        finally {
            closeStatement(stmt);
            releaseConnection(con);
        }
    }

    protected abstract Object executeWithStatement(Statement stmt, String sql);

    protected abstract Connection getConnection();
    protected abstract void closeStatement(Statement stmt);
    protected abstract void releaseConnection(Connection con);
}
