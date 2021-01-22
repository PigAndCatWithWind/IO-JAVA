"-"+this.src.getName());
        }
    }

    public void split() throws IOException {
        //总长度
        long len = src.length();
        //起始位置和实际大小
        int beginPos = 0;
        int actualSize = (int)(blockSize>len?len:blockSize);
        for(int i=0;i<size;i++) {
            beginPos = i*blockSize;
            if(i==size-1) { //最后一块
                actualSize = (int)len;
            }else {
                actualSize = blockSize;
                len -=actualSize; //剩余量
            }
            splitDetail(i,beginPos,actualSize);
        }
    }

    private  void splitDetail(int i,int beginPos,int actualSize ) throws IOException, IOException {
        RandomAccessFile raf =new RandomAccessFile(this.src,"r");
        RandomAccessFile raf2 =new RandomAccessFile(this.destPaths.get(i),"rw");
        //随机读取
        raf.seek(beginPos);
        //读取
        //3、操作 (分段读取)
        byte[] flush = new byte[1024]; //缓冲容器
        int len =