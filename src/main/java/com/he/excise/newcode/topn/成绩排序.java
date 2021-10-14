package com.he.excise.newcode.topn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/9/26 16:10
 */
public class 成绩排序 {
    /*
    *           查找和排序
            题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
        都按先录入排列在前的规则处理。

                例示：
            jack      70
            peter     96
            Tom       70
            smith     67

                从高到低  成绩
            peter     96
            jack      70
            Tom       70
            smith     67

                从低到高
            smith     67
            jack      70
            Tom       70
            peter     96

        注：0代表从高到低，1代表从低到高
    */
        public static void main(String[] args) throws IOException {
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            String str="";
            while((str=br.readLine())!=null){
                int n=Integer.parseInt(str.trim());

                int bool=Integer.parseInt(br.readLine().trim());
                String[] name =new String[n];
                int[] score=new int[n];
                for(int i=0;i<n;i++){
                    str=br.readLine().trim();
                    String[] temp= str.split(" ");
                    name[i]=temp[0];
                    score[i]=Integer.parseInt(temp[1]);
                }
                if(bool==0){  // 由高到低
                    for(int i=0;i<n;i++){

                        for(int j=0;j<n-1-i;j++){
                            if(score[j+1]>score[j]){
                                String na=name[j];
                                name[j]=name[j+1];
                                name[j+1]=na;
                                int t=score[j];
                                score[j]=score[j+1];
                                score[j+1]=t;
                            }

                        }

                    }
                }else{  // 由低到高
                    for(int i=0;i<n;i++){

                        for(int j=0;j<n-1-i;j++){
                            if(score[j+1]<score[j]){
                                String na=name[j];
                                name[j]=name[j+1];
                                name[j+1]=na;
                                int t=score[j];
                                score[j]=score[j+1];
                                score[j+1]=t;
                            }
                        }


                    }


                }
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<n;i++) {
                    sb.append(name[i] + " ");
                    sb.append(score[i]);
//                  if(i!=(n-1)) {
//                      sb.append("\n");
//                  }
                    sb.append("\n");
                }
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb.toString());
            }
        }


}
