package com.he.study.designexample.structure.flyweight;

/**
 * @author he.xuelong
 * @Description 黑色棋子类：具体享元类
 * @ClassName BlackIgoChessman
 * @Date 2020年03月20日 16:24
 */
public class BlackIgoChessman extends IgoChessman {
    @Override
    public String getColor() {
        return "黑色";
    }

}
/**
 *  @Description 白色棋子类：具体享元类
 *  @ClassName WhiteIgoChessman
 *  @author he.xuelong
 *  @Date 2020年03月20日 17:19
 * 
 */
class WhiteIgoChessman extends IgoChessman {
    @Override
    public String getColor() {
        return "白色";
    }
}
