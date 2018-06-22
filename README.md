# AutoCode

### 项目介绍

参考`mybatis-generator(plus)`功能列表的复刻版,
- 更灵活的配置选项,
- 更强大的批量操作支持,
- 当然最重要的是更符合我司的编码规范和本人的代码风格~手动斜眼~
- 目前支持model,dao,mapper,service文件的生成,并且自动生成的代码和用户写的代码完全分离,魔改表的结构然后重新生成代码不会影响用户已经写的代码    

**tip:改表名什么的,相关类名会跟着变,当然会影响依赖**

### 软件架构

项目分为三个module:
- **autocode.core:** 核心功能代码,含各种代码生成的逻辑
- **autocode.test:** 用于放置生成的文件进行测试
- **maven-autocode-plugin:** maven插件,开箱即用

### 安装教程

#### 1.clone本项目(代码还在整理中,本周内上架)
```
git clone --depth 1 https://github.com/1102568869/AutoCode.git
```
#### 2.install根目录到本地仓库
```
cd AutoCode 
mvn clean install -X -e -Dmaven.test.skip=true
```
如果构建失败,请提供详细构建日志提issue反馈,3q~

### 使用说明(maven工程)
#### 1.在`pom.xml`中配置plugin仓库地址:(如果已经执行过安装教程,此步骤跳过)
```
<pluginRepositories>    
    <pluginRepository>    
        <id>washmore</id>    
        <name>washmore's Maven plugin</name>    
        <url>http://maven.washmore.tech/nexus/content/groups/public/</url>    
        <snapshots>    
            <enabled>true</enabled>    
        </snapshots>    
        <releases>    
            <enabled>true</enabled>    
        </releases>    
    </pluginRepository>    
</pluginRepositories>
```
#### 2.添加插件依赖
```
<plugin>
    <groupId>tech.washmore</groupId>
    <artifactId>maven-autocode-plugin</artifactId>
    <version>1.0.4-RELEASE</version>
    <configuration>
        <!-- 此处可选,指定配置文件路径,默认为本项目根目录下的config.json -->
        <configLocation>
        </configLocation>
        <!-- 下面的配置项(优先)与上面的配置二选一,免配置文件版本,
        并且会在根目录下生成一份对应的config.json供参考修改 -->
        <!-- 参考
        https://blog.washmoretech.com/articles/2018/06/15/1529054506993.html
        中的db项配置,自己猜着改... -->
        <databaseDriver>com.mysql.jdbc.Driver</databaseDriver>
        <databaseUrl>jdbc:mysql://localhost:3306/EmployeeCare</databaseUrl>
        <databaseUsername>root</databaseUsername>
        <databasePassword></databasePassword> 
        <!-- 指定表名前缀,如有多个,用逗号,分割-->
        <databaseTablePrefix></databaseTablePrefix>
    </configuration>
</plugin>
```
#### 3.在上一步指定的位置编写`config.json`文件(可选,如不配置此文件,则仅需要在插件配置数据库相关内容,其他应用默认配置),内容可参考git仓库根目录的`confi_example.json`文件,只需修改db相关配置,其他使用默认值即可;`config.json`各配置项意义详情参考博文:[详解AutoCode插件的配置文件](https://blog.washmoretech.com/articles/2018/06/15/1529054506993.html)
#### 4.执行插件命令生成代码
```
mvn autocode:code
```

### 参与贡献
1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request
