package com.gua.dubbo.provider.oceanbase;

import java.sql.Connection;
import java.sql.DriverManager;

public class OceanBaseDriver {
    public static void main(String[] args) {
        try {
            String url = "jdbc:oceanbase://obmtkacftfjsja30-mi.cn-hangzhou.oceanbase.aliyuncs:3306/xh?pool=false";
            String user = "admin";
            String password = "p2AcWimT7yaV3gJ";
            Class.forName("com.oceanbase.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}