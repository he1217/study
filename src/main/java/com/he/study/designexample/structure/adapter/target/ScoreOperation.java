package com.he.study.designexample.structure.adapter.target;
/**
 *  @Description 抽象成绩操作类接口:目标接口
 *  @ClassName ScoreOperation
 *  @author he.xuelong
 *  @Date 2020年03月18日 15:47
 * 
 */
public interface ScoreOperation {
     int[] sort(int array[]); //成绩排序

     int search(int array[], int key); //成绩查找
}
