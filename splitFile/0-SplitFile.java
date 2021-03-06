package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitFile {
    //源头
    private File src;
    //目的地(文件夹)
    private String destDir;
    //所有分割后的文件存储路径
    private List<String> destPaths;
    //每块大小
    private int blockSize;
    //块数: 多少块
    private int size;

    public SplitFile(String srcPath,String destDir) {
        this(srcPath,destDir,1024);
    }
    public SplitFile(String srcPath,String destDir,int blockSize) {
        this.src =new File(srcPath);
        this.destDir =destDir;
        this.blockSize =blockSize;
        this.destPaths =new ArrayList<String>();

        //初始化
        init();
    }

    private void init() {
        //总长度
        long len = this.src.length();
        //块数: 多少块
        this.size =(int) Math.ceil(len*1.0/blockSize);
        //路径
        for(int i=0;i<size;i++) {
            this.destPaths.add(this.destDir +"/"+i+