# 算法


### 依赖的algs4包找不到的解决方法

因为依赖《算法4》的jar包不能从mvn repository中获取，因此需要把jar包直接cpoy到本地的仓库，具体方法：

```shell
# 在my-tools/practice/my-learn/my-algorithm目录下执行
mvn install:install-file -DgroupId=edu.princeton.cs -DartifactId=algs4 -Dversion=1.0.0.0 -Dfile=lib/algs4.jar -Dpackaging=jar -DgeneratePom=true
```

```xml
    <dependency>
        <groupId>edu.princeton.cs</groupId>
        <artifactId>algs4</artifactId>
        <version>1.0.0.0</version>
    </dependency>
```