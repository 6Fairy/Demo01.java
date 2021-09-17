import java.sql.*;

public class Demo02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //  1  注册成功
        Class.forName("com.mysql.jdbc.Driver");
        //  2  获取链接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicoding=true&characterEncoding=utf-8", "root", "123456");
        //  3准备状态  传输器
        String sql01 = " select * from  book  where  author  = ?  ";
        String sql02 = "insert into book  values(null,?,?,?)";
        String sql03 = "delete from book where author =?";
        String sql04 = "update book set  name=?  ,author = ?  where  id =?";
        // PreparedStatement preparedStatement= connection.prepareStatement(sql01);
        //PreparedStatement preparedStatement= connection.prepareStatement(sql02);
        //PreparedStatement preparedStatement= connection.prepareStatement(sql03);
        PreparedStatement preparedStatement = connection.prepareStatement(sql04);
        //preparedStatement.setInt(1  ,6);
            /*preparedStatement.setString(2,"东北查寝故事");
            preparedStatement.setString(3,"美玉");
            preparedStatement.setString(4,"99.99");*/
        //  preparedStatement.setString(1,"罗贯中");
        //  preparedStatement.setString(1,"美玉");
        preparedStatement.setString(1, "Java基础");
        preparedStatement.setString(2, "大佬");
        preparedStatement.setInt(3, 5);


        int result = preparedStatement.executeUpdate();
        if (result != -1) {
            System.out.println("执行成功");
        } else {
            System.out.println("执行失败");
        }
        // ResultSet  resultSet = preparedStatement.executeQuery();
        //while (resultSet.next()) {
        //  System.out.println(resultSet.getInt(1) + "" + resultSet.getString(2)
        //        + resultSet.getString(3) + resultSet.getDouble(4)
        //);
        //   }
        //5 获取结果并遍历
        // resultSet.close();
        preparedStatement.close();
        connection.close();


    }


}
