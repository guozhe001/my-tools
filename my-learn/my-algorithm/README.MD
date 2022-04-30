# 算法


### 依赖的algs4包找不到的解决方法

因为依赖《算法4》的jar包不能从mvn repository中获取，因此需要把jar包直接cpoy到本地的仓库，具体方法：

```shell
cp my-tools/my-learn/my-algorithm/src/main/resources/algs4.jar ~/.m2/repository/edu/princeton/cs/algs4/1.0.0.0/algs4.jar
```

```xml
    <dependency>
        <groupId>edu.princeton.cs</groupId>
        <artifactId>algs4</artifactId>
        <version>1.0.0.0</version>
    </dependency>
```