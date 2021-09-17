import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {

    public static void main(String[] args) throws  ClassNotFoundException, SQLException {
        //  1  注册成功
        Class.forName("com.mysql.jdbc.Driver");
        //  2  获取链接
        Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123456");
        //  3准备状态  传输器
        Statement statement =connection.createStatement();
        //  4  准备sql 执行
        // String  sql = "select *from book";
        // String  sql2 ="insert into book values (null  ,'如何让富婆看上我','切割拉瓦',999)";
        String sql3 = "delete  from  book  where  author = '切割拉瓦' " ;
        String  sql4 = "update book  set  prices  = 99  where  id= 5 ";
        int  result  =  statement.executeUpdate(sql4);
        System.out.println(result);
        //5 获取结果并遍历
        statement.close();
        connection.close();


    }
}
