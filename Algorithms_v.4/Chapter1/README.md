# CH1
## 执行java的顺序 P5
执行一个java程序，首先用javac命令编译它，然后再用java命令运行它。
## Java 的加减乘除都被override了 P6
根据上下文，同样的运算符对不同的类型会执行不同的操作
## Java 中的模板记法 P8
```java
if (<boolean expression>) {<block statements>}
```
<>表示定义过的语法。
## 创建数组：P11
创建数组实际上包含了三个动作：
1. 声明数组
2. 创建数组 （new: java编译器不知道对非原始类型的数组预留多少空间，所以要使用new明确的创建数组)
3. 初始化数组
```java
double[] a = new double[N]
```
实际上包含了上述三个动作
## ArrayOutOfBoundsException异常: P11
使用一个N长度数组，但是超出了0~N-1的索引访问范围。