package com.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class FirestAccess {
    public static void main(String[] args) {
        save();
        delete();
    }


    //保存数据到搜了，主键字段ID唯一就是新增，不唯一就是覆盖更新
    public static void save() {
        HttpSolrClient client = null;
        try {
            //创建客户端
            String url = "http://192.168.0.110:8983/solr/testcore";
            client = new HttpSolrClient.Builder(url).build();

            //创建要保存的数据对象
            SolrInputDocument doc = new SolrInputDocument();
            doc.addField("id", "3");
            doc.addField("myname", "gx");

            //执行数据保存
            client.add(doc);

            //事务管理
            client.commit();//提交当前URL指向的core
            //提供core名称，指定提交事务
            //client.commit("testcore")

//            //回收资源
//            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //删除数据
    public static void delete(){
        HttpSolrClient client = null;
        try {
            //创建客户端
            String url = "http://192.168.0.110:8983/solr/testcore";
            client = new HttpSolrClient.Builder(url).build();
            //删除数据
            client.deleteById("1"); //删除单条数据
            client.deleteById(Arrays.asList("2","3")); //删除多条数据
            client.deleteByQuery(""); //条件删除 格式--字段名:条件数据
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //搜索数据
    public static void search(){
        HttpSolrClient client = null;
        try {
            //创建客户端
            String url = "http://192.168.0.110:8983/solr/testcore";
            client = new HttpSolrClient.Builder(url).build();
            //创建搜索对象
            SolrQuery params = new SolrQuery();
            //搜索关键字
            params.setQuery("");
            //排序
            params.setSort("id",SolrQuery.ORDER.asc);
            // 分页
            params.setStart(0); // 第几行开始查询
            params.setRows(3); // 查询多少行

            // 高亮
            // 开启高亮
            params.setHighlight(true);
            // 设置高亮字段，如果有多个高亮字段，多次调用当前方法。
            params.addHighlightField("title_zh_cn");
            // 设置高亮前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            // 设置高亮后缀
            params.setHighlightSimplePost("</span>");

            // 搜索数据
            QueryResponse response = client.query(params);

            // 从响应中获取高亮结果数据集合 {主键:{字段名:["高亮数据", "高亮数据"]}}
            Map<String, Map<String, List<String>>> highlightMap = response.getHighlighting();

            // 获取搜索返回结果集合  SolrDocumentList 是List接口的实现。 固定泛型是 SolrDocument
            SolrDocumentList docList = response.getResults();
            System.out.println("本次查询返回数据行数" + docList.size());
            System.out.println("本次搜索总计数据行数" + docList.getNumFound());
            for(SolrDocument doc : docList){
                System.out.print(doc + "【 id = " + doc.getFieldValue("id")
                        + "， title_zh_cn = " + doc.getFieldValue("title_zh_cn") + "】");

                // 输出高亮
                // 根据当前文档主键查询高亮数据
                Map<String, List<String>> entry = highlightMap.get(doc.getFieldValue("id"));
                if(null != entry && entry.size() > 0){
                    // 有高亮数据
                    List<String> hlStrList = entry.get("title_zh_cn");
                    System.out.println(" 高亮数据内容是：【" + hlStrList + "】");
                }

                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
