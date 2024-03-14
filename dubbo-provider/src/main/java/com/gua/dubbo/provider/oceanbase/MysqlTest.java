package com.gua.dubbo.provider.oceanbase;


import java.sql.*;

public class MysqlTest {
    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            try{

                Connection connection = DriverManager.getConnection("jdbc:mysql://obmtkacftfjsja30-mi.cn-hangzhou.oceanbase.aliyuncs.com:3306/xh?user=admin&password=p2AcWimT7yaV3gJ");
                System.out.println(connection.getAutoCommit());
                Statement sm = connection.createStatement();
                //新建表 t_meta_form
                sm.executeUpdate("CREATE TABLE t_meta_form (name varchar(36) , id int)");
                //插入数据
                sm.executeUpdate("insert into t_meta_form values ('an','1')");
                //查询数据，并输出结果
                ResultSet rs = sm.executeQuery("select * from t_meta_form");
                while (rs.next()) {
                    String name = rs.getString("name");
                    String id = rs.getString("id");
                    System.out.println(name + ','+ id);
                }
                //删除表
//                sm.executeUpdate("drop table t_meta_form");

            }catch(SQLException se){
                System.out.println("error!");
                se.printStackTrace() ;
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
