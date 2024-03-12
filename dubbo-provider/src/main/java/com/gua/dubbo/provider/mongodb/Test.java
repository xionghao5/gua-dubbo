package com.gua.dubbo.provider.mongodb;

import com.mongodb.MongoNamespace;
import com.mongodb.client.*;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private static MongoClient mongoClient;

    static {
        try {
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            mongoClient = MongoClients.create("mongodb://localhost");
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * 创建集合
     *
     * @param args
     */
    public static void main(String[] args) {
        // 连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("xh");
        System.out.println("Connect to database successfully");
        MongoCollection<Document> collection = collCreate(mongoDatabase);

        insertAndPrintCollection(collection);
        printCollections(mongoDatabase);

        collUpdate(mongoDatabase);
        printCollections(mongoDatabase);

        collDelete(mongoDatabase);
        printCollections(mongoDatabase);
    }

    private static void insertAndPrintCollection(MongoCollection<Document> collection) {
        Document document = new Document();
        document.append("name", "老王");
        document.append("age", 1);
        collection.insertOne(document);

        List<Document> list = new ArrayList<>();
        list.add(new Document().append("name", "中华联合车辆保险").append("type", "车险"));
        list.add(new Document().append("time", "20240312").append("price", "2000"));
        list.add(new Document().append("_id", 1).append("name", "老王"));
        list.add(new Document().append("_id", 2).append("name", "老张"));
        collection.insertMany(list);

        collection.updateMany(new Document("name", "老王"), new Document("$set", new Document("name", "老赵")));

        collection.findOneAndDelete(new Document("_id", 2));


        FindIterable<Document> listDoucument = collection.find();
        for (Document douc : listDoucument) {
            System.out.println(douc.toString());
            System.out.println(douc.toJson());
        }
    }

    private static void printCollections(MongoDatabase mongoDatabase) {
        System.out.println("打印数据库中的集合名称");
        MongoIterable<String> listCollectionNames = mongoDatabase.listCollectionNames();
        for (String collectionName : listCollectionNames) {
            System.out.println(collectionName);
        }
    }

    private static MongoCollection<Document> collCreate(MongoDatabase mongoDatabase) {
        mongoDatabase.createCollection("coll_create");
        System.out.println("集合创建成功");
        return mongoDatabase.getCollection("coll_create");
    }

    private static void collDelete(MongoDatabase mongoDatabase) {
        mongoDatabase.getCollection("coll_create").drop();
        System.out.println("删除集合成功");
    }

    private static void collUpdate(MongoDatabase mongoDatabase) {
        mongoDatabase.createCollection("coll_update");
        mongoDatabase.getCollection("coll_update").renameCollection(new MongoNamespace("xh.coll_update_newName"));
        System.out.println("修改集合成功");
        mongoDatabase.getCollection("coll_update_newName").drop();
    }
}
