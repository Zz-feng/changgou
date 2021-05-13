package com.feng.util;

import com.feng.file.FastDFSFile;
import entity.Result;
import entity.StatusCode;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class FastDFSUtil {

    //加载tracker连接信息
    static {
        try{
            //查找classpath下的文件路径
            String filename = new ClassPathResource("fdfs_client.conf").getPath();
            //加载tracker连接信息
            ClientGlobal.init(filename);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //文件上传
    public static String[] upload(FastDFSFile fastDFSFile) throws Exception {
        //创建TrackerClient客户端对象
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient对象获取TrackerServer信息
        TrackerServer trackerServer = trackerClient.getConnection();
        //通过TrackerServer信息创建StorageClient对象
        StorageClient storageClient = new StorageClient(trackerServer, null);
        //通过StorageClient访问Storage,实现文件上传,并且获取文件上传后的存储信息

        String[] uploads = storageClient.upload_file(fastDFSFile.getContent(), fastDFSFile.getExt(), null);
        return uploads;
    }

}
