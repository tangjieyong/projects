package keyon.tang.dao.inteceptor;
import keyon.tang.bean.AdBase;
import keyon.tang.bean.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/5/5 14:39
 * @Version 1.0
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare" ,args={Connection.class})})
public class PageInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
//        拦截到RoutingStatementHandler对象
       StatementHandler statementHandler= (StatementHandler) invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        if(mappedStatement.getId().endsWith("ByPage")){
//            获得原生的sql语句
//            sql语句，预编译参数类型存放在mappedStatement内，但在代码执行的过程中，把这两个属性赋值给RoutingStatementHandler
//            的BoundSql中，因此可以使用statementHandler.getBoundSql().getSql(); statementHandler.getBoundSql().getParameterObject();

//            sql= select * from ad where title  like '%${adCustom.title}%'
            String sql = statementHandler.getBoundSql().getSql();
//            对原生的sql语句进行修改
            String countSql="select count(*) from("+sql+")a";
//            预编译修改后的sql语句
            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement preparedStatement = connection.prepareStatement(countSql);
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
//           为修改后的sql语句自定义参数赋值
            parameterHandler.setParameters(preparedStatement);
//             执行修改后的sql语句
            ResultSet resultSet = preparedStatement.executeQuery();
             AdBase adBase = (AdBase) statementHandler.getBoundSql().getParameterObject();
//              将执行结果赋值给sql的parameterType
            Page page = adBase.getPage();
             while (resultSet.next()){
                 page.setTotalCapacity(resultSet.getInt(1));
             }
//             最终的语句
//             select * from ad where title  like '%${adCustom.title}%' limit 0, 1
             String finalSql=sql +" limit "+(page.getCurrentPage()-1)*page.getDbCurrentCapacity()+" ,"+page.getDbCurrentCapacity();
//             用最终的语句替换掉原生的语句
              metaObject.setValue("delegate.boundSql.sql",finalSql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
