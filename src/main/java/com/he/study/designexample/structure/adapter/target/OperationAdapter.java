package com.he.study.designexample.structure.adapter.target;

/**
 * @author he.xuelong
 * @Description 操作适配器:适配器
 * @ClassName OperationAdapter
 * @Date 2020年03月18日 15:50
 */
public class OperationAdapter {
    private QuickSort sortObj; //定义适配者QuickSort对象
    private BinarySearch searchObj; //定义适配者BinarySearch对象

    public OperationAdapter() {
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }

    public int[] sort(int array[]) {
        //调用适配者类QuickSort的排序方法
        return sortObj.quickSort(array);
    }

    public int search(int array[], int key) {
        //调用适配者类BinarySearch的查找方法
        return searchObj.binarySearch(array, key);
    }
}
