package com.he.study.designexample.structure.composite;

/**
 *  @Description 抽象文件类：抽象构件
 *  @ClassName AbstractFile
 *  @author he.xuelong
 *  @Date 2020年03月19日 17:37
 * 
 */
abstract class AbstractFile {

    public abstract void add(AbstractFile file);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile getChild(int i);

    public abstract void killVirus();
}
