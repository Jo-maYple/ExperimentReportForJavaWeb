import main.Utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

public class UseDBUtils {

    public static void main(String[] args) throws SQLException, PropertyVetoException {
        QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
        //runner.update("use jdbc;");
        List<StudentInfo> studentInfos = (List) runner.query("select * from jdbc.users", new BeanListHandler(StudentInfo.class));
        for (StudentInfo stu:studentInfos){
            System.out.println(stu.toString());
        }
        if (runner.update("insert into jdbc.users (name, password, email, birthday) values('王五','456','王五@xyc.edu.cn',DATE('2002-02-28'))")>0){
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        for (StudentInfo stu:(List<StudentInfo>)runner.query("select * from jdbc.users", new BeanListHandler(StudentInfo.class))){
            System.out.println(stu.toString());
        }
        if (runner.update("delete from jdbc.users where id=5")>0){
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        for (StudentInfo stu:(List<StudentInfo>)runner.query("select * from jdbc.users", new BeanListHandler(StudentInfo.class))){
            System.out.println(stu.toString());
        }
    }
}

