一份全量的配置文件内容如下:
```
{
  "autoTypes": ["model","service","dao","mapper"],
  "project": {
    "path": "",
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
      "summary": "",
      "packageName": "washmore.service",
      "baseSuffix": "BaseService",
      "abstractBase": true,
      "batchLimit": 100,
      "suffix": "Service"
    },
    "dao": {
      "summary": "",
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