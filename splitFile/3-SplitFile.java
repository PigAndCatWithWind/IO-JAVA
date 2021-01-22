ad(flush))!=-1) {
            os.write(flush,0,len); //分段写出
        }
        os.flush();
        sis.close();
        os.close();
    }

    public static void main(String[] args) throws IOException {
        SplitFile sf =
                new SplitFile("src/IO/SplitFile.java","splitFile");
        sf.split();
        sf.merge("merger-split.java");
    }



}
