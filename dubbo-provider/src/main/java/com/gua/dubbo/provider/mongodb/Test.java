package com.gua.dubbo.provider.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Test {

    private static MongoClient mongoClient;
    static {
        try {
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            mongoClient = MongoClients.create("mongodb://localhost");
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    /**
     * 创建集合
     * @param args
     */
    public static void main(String[] args) {
        // 连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        System.out.println("Connect to database successfully");
        mongoDatabase.createCollection("tb_role");
        System.out.println("集合创建成功");
    }
}
