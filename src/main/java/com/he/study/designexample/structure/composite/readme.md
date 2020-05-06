# 组合模式概述(设计中使用)
对于树形结构，当容器对象（如文件夹）的某一个方法被调用时，将遍历整个树形结构，寻 找也包含这个方法的成员对象（可以是容器对象，也可以是叶子对象）并调用执行，牵一而 动百，其中使用了递归调用的机制来对整个结构进行处理。由于容器对象和叶子对象在功能 上的区别，在使用这些对象的代码中必须有区别地对待容器对象和叶子对象，而实际上大多 数情况下我们希望一致地处理它们，因为对于这些对象的区别对待将会使得程序非常复杂。 组合模式为解决此类问题而诞生，它可以让叶子对象和容器对象的使用具有一致性。

组合模式定义如下：

组合模式(Composite Pattern)：组合多个对象形成树形结构以表示具有“整体—部分”关系的层 次结构。组合模式对单个对象（即叶子对象）和组合对象（即容器对象）的使用具有一致 性，组合模式又可以称为“整体—部分”(Part-Whole)模式，它是一种对象结构型模式。


在组合模式结构图中包含如下几个角色：

● Component（抽象构件）：它可以是接口或抽象类，为叶子构件和容器构件对象声明接口， 在该角色中可以包含所有子类共有行为的声明和实现。在抽象构件中定义了访问及管理它的子构件的方法，如增加子构件、删除子构件、获取子构件等

● Leaf（叶子构件）：它在组合结构中表示叶子节点对象，叶子节点没有子节点，它实现了在 抽象构件中定义的行为。对于那些访问及管理子构件的方法，可以通过异常等方式进行处 理。

● Composite（容器构件）：它在组合结构中表示容器节点对象，容器节点包含子节点，其子 节点可以是叶子节点，也可以是容器节点，它提供一个集合用于存储子节点，实现了在抽象 构件中定义的行为，包括那些访问及管理子构件的方法，在其业务方法中可以递归调用其子 节点的业务方法。

## 透明组合模式与安全组合模式
由于在AbstractFile中声明了大量用于管理和访问成员构件的方法，例如add()、remove()等方 法，我们不得不在新增的文件类中实现这些方法，提供对应的错误提示和异常处理。为了简 化代码，我们有以下两个解决方案：

- 解决方案一：将叶子构件的add()、remove()等方法的实现代码移至AbstractFile类中，由 AbstractFile提供统一的默认实现，代码如下所示：

```java
//提供默认实现的抽象构件类 
abstract class AbstractFile { 
    public void add(AbstractFile file) { 
        System.out.println("对不起，不支持该方法！"); 
    }
    public void remove(AbstractFile file) { 
        System.out.println("对不起，不支持该方法！"); 
    }
    public AbstractFile getChild(int i) { 
        System.out.println("对不起，不支持该方法！"); 
        return null;
    }
    public abstract void killVirus(); }
```
在调用文件对象的这些方法时将出现错误提 示。如果不希望出现任何错误提示，我们可以在客户端定义文件对象时不使用抽象层，而直 接使用具体叶子构件本身，客户端代码片段如下所示：

```java
class Client {
    public static void main(String args[]) { 
        //不能透明处理叶子构件 
        ImageFile file1,file2; 
        TextFile file3,file4; 
        VideoFile file5; 
        AbstractFile folder1,folder2,folder3,folder4;
        //其他代码省略
        }
}

```

- 解决方案二：除此之外，还有一种解决方法是在抽象构件AbstractFile中不声明任何用于访问 和管理成员构件的方法，代码如下所示：
```java
abstract class AbstractFile { 
    public abstract void killVirus();
}
```

容器构件根据需要增加访问和管理成员的方法，但这时候也存在一 个问题：客户端不得不使用容器类本身来声明容器构件对象，否则无法访问其中新增的 add()、remove()等方法，如果客户端一致性地对待叶子和容器，将会导致容器构件的新增对客 户端不可见，客户端代码对于容器构件无法再使用抽象构件来定义

## 组合模式总结
组合模式使用面向对象的思想来实现树形结构的构建与处理，描述了如何将容器对象和叶子 对象进行递归组合，实现简单，灵活性好。

1. 主要优点

(1) 组合模式可以清楚地定义分层次的复杂对象，表示对象的全部或部分层次，它让客户端忽 略了层次的差异，方便对整个层次结构进行控制。

(2) 客户端可以一致地使用一个组合结构或其中单个对象，不必关心处理的是单个对象还是整 个组合结构，简化了客户端代码。

(3) 在组合模式中增加新的容器构件和叶子构件都很方便，无须对现有类库进行任何修改，符 合“开闭原则”。

(4) 组合模式为树形结构的面向对象实现提供了一种灵活的解决方案，通过叶子对象和容器对 象的递归组合，可以形成复杂的树形结构，但对树形结构的控制却非常简单。

1. 主要缺点

在增加新构件时很难对容器中的构件类型进行限制。有时候我们希望一个容器中只能有某些 特定类型的对象，例如在某个文件夹中只能包含文本文件，使用组合模式时，不能依赖类型 系统来施加这些约束，因为它们都来自于相同的抽象层，在这种情况下，必须通过在运行时 进行类型检查来实现，这个实现过程较为复杂。

1. 适用场景

(1) 在具有整体和部分的层次结构中，希望通过一种方式忽略整体与部分的差异，客户端可以 一致地对待它们

(2) 在一个使用面向对象语言开发的系统中需要处理一个树形结构。

(3) 在一个系统中能够分离出叶子对象和容器对象，而且它们的类型不固定，需要增加一些新 的类型