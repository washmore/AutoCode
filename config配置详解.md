一份全量的配置文件内容如下:
```
{
  "autoTypes": ["model","service","dao","mapper"],
  "project": {
    "path": "",
    "encoding": "UTF8",
    "subModule": "autocode.test",
    "javaRoot": "src/main/java",
    "resourcesRoot": "src/main/resources",
    "testJavaRoot": "src/test/java/",
    "testResourcesRoot": "src/main/resources",
    "underline2Camel": true,
    "generateOgnl": false,
    "exclude": ["t_test_add_table"],
    "include": []
  },
  "model": {
    "summary": "",
    "packageName": "washmore.model",
    "visitorWithDoc": false,
    "toString": true
  },
  "dataFile": {
    "service": {
      "packageName": "washmore.service",
      "baseSuffix": "BaseService",
      "abstractBase": true,
      "batchLimit": 100,
      "suffix": "Service"
    },
    "dao": {
      "packageName": "washmore.dao",
      "baseSuffix": "BaseDao",
      "suffix": "Dao"
    },
    "mapper": {
      "fullParams": false,
      "usekeyProperty": true,
      "path": "mappers",
      "baseSuffix": "BaseMapper",
      "suffix": "Mapper"
    },
    "methodInclude": [],
    "methodExclude": []
  },
  "db": {
    "tableNamePrefix": ["t_","x_"],
    "driver": "com.mysql.jdbc.Driver",
    "url": "jdbc:mysql://localhost:3306/EmployeeCare",
    "username": "root",
    "password": ""
  },
  "doc": {
    "summary":"",
    "userGeneratorClass": "",
    "author": "Washmore",
    "version": "V1",
    "copyright": "(c) 2018, Washmore All Rights Reserved."
  },
  "dataType": {
    "date": ["timestamp","datetime"],
    "string": ["char","varchar","text"],
    "integer": ["int","smallint","tinyint"],
    "longL": ["bigint"],
    "doubleD": ["double","float"]
  }
}
```

## autoTypes
配置需要生成的文件种类,目前支持的有dao,service,mapper,model;

## project 项目基础配置
### path
指定文件生成的根目录,默认为当前项目跟目录
### encoding
指定生成文件的编码格式,此配置项优先级低于从`pom.xml`中获取
```
    <properties>
        <project.build.sourceEncoding>UTF8</project.build.sourceEncoding>
    </properties>
```
### subModule
子模块名,适用于maven多module项目生成文件到指定子项目
### javaRoot
即maven项目build节点的
```
    <sourceDirectory>.../src/main/java</sourceDirectory>
```
中的结尾内容,默认为`src/main/java`
### resourcesRoot,testJavaRoot,testResourcesRoot
参考javaRoot理解,略
### underline2Camel
是否开启下划线转驼峰命名,默认true
### generateOgnl
暂未启用
### include,exclude
表名列表,  
如果include不为空,则生成include指定的表相关代码,  
如果include为空的情况下exclude不为空,则生成排除掉exclude后剩下表的相关代码  
如果都为空,则默认生成全部表相关代码

## model
### summary
生成的实体类类注释
### packageName
生成的实体类包名
### visitorWithDoc
是否生成getter方法注释,默认false
### toString
是否生成toString方法,默认true

## dataFile
### methodInclude,methodExclude
方法名列表,目前支持的方法名包含
``` 
    selectByParams,
    countByParams,

    batchInsert,
    batchInsertSelective,
    batchUpdateByPrimaryKeySelective,
    batchDeleteByPrimaryKey,

    insert,
    insertSelective,
    updateByPrimaryKey,
    updateByPrimaryKeySelective,
    deleteByPrimaryKey,

    selectByPrimaryKey,
    selectByExample,
    countByExample;
```
配置项的意义参考include,exclude项
### mapper
#### fullParams
是否生成全参数查询,默认false
如果开启则生成的selectByParams方法包含所有字段作为条件,
如果不开启则生成的selectByParams方法仅包含主键(如果有的话)列作为条件,
#### usekeyProperty
是否在insert相关xml生成keyProperty,用于插入操作为对象注入主键属性,默认true
#### path
在`resourcesRoot`下的相对路径,默认`mappers`
#### baseSuffix
生成的基础mapper后缀,默认`BaseMapper`
#### suffix
生成的扩展mapper后缀,默认`Mapper`
### service
#### batchLimit
针对大数据量批量操作时设置分批,默认为空,如需要开启,推荐100
#### abstractBase 
暂未启用
#### 其他参考mapper,model
### dao
参考mapper,model,service

## db
### tableNamePrefix
表名前缀列表,默认为空,如配置,则生成的表相关代码中会移除前缀
### driver,url,username,password
看着写吧

## dataType
就用默认值不要改吧,瞎j8改也没啥大问题,仅影响生成的代码风格,自行摸索

## doc
### userGeneratorClass 
用户自定义注释生成器类名,此类需继承自
`tech.washmore.autocode.core.generator.base.JavaDocAbstractGenerator`,
然后重写你想要自定义注释对应的方法
### 其他的用于生成类注释里面的东西,自行摸索
