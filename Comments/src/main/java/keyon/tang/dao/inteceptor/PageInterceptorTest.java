package keyon.tang.dao.inteceptor;

import java.sql.Connection;

import keyon.tang.bean.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;



/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/4/21 22:10
 * @Version 1.0
 */

/**
 * 使用mybatis拦截器在StatementHandler接口实现类执行prepare方法之前动态获取sql
 * 在原先Sql的基础上重新组合Sql
 * 替换掉原先的sql返回继续执行
 */
@Intercepts({@Signature(type = StatementHandler.class,method ="prepare", args={Connection.class})})
public class PageInterceptorTest implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        /**
         * 此时拦截到的是StatementHandler接口实现类RoutingStatementHandler
         * 拦截到这个实现类时它已经完成了实例化，因此我们可以从这个类中获得Sql语句，返回值类型等信息
         */
//        返回值是Object类型，要通过强转为StatementHandler类型
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
//        使用mybatis通过的反射方法获得拦截对象的属性
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
       MappedStatement mappedStatement=(MappedStatement) metaObject.getValue("delegate.mappedStatement");

       if(mappedStatement.getId().matches(".+ByPage$")){
//           获得原生sql语句
           String sql = statementHandler.getBoundSql().getSql();
//           在原生的sql语句的基础上拼接出查询总记录数的语句
           String countSql="select count(*) from("+sql+")a";
//           调用参数Connection的方法执行sql语句
          Connection connection = (Connection) invocation.getArgs()[0];
           PreparedStatement countStatement = connection.prepareStatement(countSql);
//           注意：分离出来的sql语句执行之前也要为预编译参数赋值
           ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
           parameterHandler.setParameters(countStatement);
           ResultSet resultSet = countStatement.executeQuery();
//          获得sql语句的预编译参数类型
           Map parameterMap = (Map) statementHandler.getBoundSql().getParameterObject();
           Page page = (Page) parameterMap.get("page");
//           将sql语句查询到的结果封装到传入的参数上
           while (resultSet.next()){
               page.setTotalCapacity(resultSet.getInt(1));
           }
//           改造之后带分页功能的sql语句
           String pageSql=sql +"limit "+page.getDbPastSum()+","+page.getDbCurrentCapacity();
           metaObject.setValue("delegate.boundSql.sql",pageSql);

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
