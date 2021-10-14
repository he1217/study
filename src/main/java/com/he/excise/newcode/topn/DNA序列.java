package com.he.excise.newcode.topn;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/9/26 14:12
 */
public class DNA序列 {
    public static void main(String[] args) throws IOException {
        InputStream in = new ByteArrayInputStream("AACTGTGCACGACCTGA\n5".getBytes(StandardCharsets.UTF_8));
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));


        String str = null;

        while((str = bf.readLine())!=null){

            int num = Integer.parseInt(bf.readLine());
            int count = 1;

            int max = 1;
            int left = 0;
            for(int i = 1;i<str.length()-num;i++){
                char pre = str.charAt(i-1);
                char nex = str.charAt(i+num-1);
                if(pre=='G'||pre=='C')
                    count--;
                if(nex=='G'||nex=='C')
                    count++;
                if(count>max){
                    max = count;
                    left = i;
                }
            }

            System.out.println(str.substring(left,left+num));
        }
    }
}
