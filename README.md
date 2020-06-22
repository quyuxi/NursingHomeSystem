

[TOC]

### 说明

**文档内容**：**<u>服务端目前提供的HTTP接口定义及描述汇总。</u>**

**最后更新时间**：**<u>2020-06-22</u>**





### 一、老人相关API

#### 1、根据id查询老人

```
GET /elder/find/{id}
```


   **返回**：

```json
// 老人存在
{
  "id": 93010002,
  "name": "string",
  "sex": "string",
  "idCard": "12312321321",
  "birthday": "2020-05-30",
  "phone": "string",
  "area": "string",
  "joinTime": "2020-05-30",
  "relatives": [
    {
      "id": 8,
      "name": null,
      "sex": "1",
      "birthday": "2020-01-01",
      "phone": "1",
      "idCard": "1",
      "address": "1",
      "elderId": "93010002"
    },
    {
      "id": 9,
      "name": null,
      "sex": "2",
      "birthday": "2020-01-01",
      "phone": "2",
      "idCard": "2",
      "address": "2",
      "elderId": "93010002"
    },
    {
      "id": 10,
      "name": null,
      "sex": "3",
      "birthday": "2020-01-01",
      "phone": "3",
      "idCard": "3",
      "address": "3",
      "elderId": "93010002"
    }
  ]
}
//老人不存在
null
```

​    





#### 2、列举所有老人信息

```
GET /elder/listAll
```

```json
[
  {
    "id": 93010002,
    "name": "string",
    "sex": "string",
    "idCard": "12312321321",
    "birthday": "2020-05-30",
    "phone": "string",
    "area": "string",
    "joinTime": "2020-05-30",
    "relatives": [
      {
        "id": 8,
        "name": null,
        "sex": "1",
        "birthday": "2020-01-01",
        "phone": "1",
        "idCard": "1",
        "address": "1",
        "elderId": "93010002"
      },
      {
        "id": 9,
        "name": null,
        "sex": "2",
        "birthday": "2020-01-01",
        "phone": "2",
        "idCard": "2",
        "address": "2",
        "elderId": "93010002"
      },
      {
        "id": 10,
        "name": null,
        "sex": "3",
        "birthday": "2020-01-01",
        "phone": "3",
        "idCard": "3",
        "address": "3",
        "elderId": "93010002"
      }
    ]
  }
]
```



 **失败**

```
[]
```



#### 3、返回一个新的老人ID

```
   /elder/newID
```

   **GET**
   **参数**：无
   **返回**：

```
返回当前养老院最后一条elderId + 1。
如最后一条记录为93060001，那么返回93060002;
```



#### 4、新增老人信息

```
   /elder/create
```

   **POST**
   **参数**：

```json
{
  "area": "[ { \"lng\":101.1, \"lat\":100.2}, {\"lng\":101.3,\"lat\":100.4}, {\"lng\":101.5,\"lat\":100.6}]",
  "birthday": "2020-05-30",
  "id": 93010001,
  "idCard": "12312321321",
  "joinTime": "2020-05-30",
  "name": "name1",
  "phone": "12344444444",
  "sex": "男",
  "relatives": [
    {
      "address": "xxxxx",
      "birthday": "2020-01-01",
      "elderId": "93010001",
      "id": 0,
      "idCard": "1",
      "name": "1",
      "phone": "1",
      "sex": "1"
    },{
      "address": "2",
      "birthday": "2020-01-01",
      "elderId": "93010001",
      "id": 1,
      "idCard": "2",
      "name": "2",
      "phone": "2",
      "sex": "2"
    }
  ]
}
```

   **返回**：

```
ADD_SUCCESS    //添加成功

ADD_FAILD      //添加失败
```



#### 5、修改老人信息

   

```
/elder/update
```

   **POST**
  **参数**：

```json
{
  "area": "[ { \"lng\":101.1, \"lat\":100.2}, {\"lng\":101.3,\"lat\":100.4}, {\"lng\":101.5,\"lat\":100.6}]",
  "birthday": "2020-05-30",
  "id": 93010001,
  "idCard": "12312321321",
  "joinTime": "2020-05-30",
  "name": "name1",
  "phone": "12344444444",
  "sex": "男",
  "relatives": [
    {
      "address": "xxxxx",
      "birthday": "2020-01-01",
      "elderId": "93010001",
      "id": 0,
      "idCard": "1",
      "name": "1",
      "phone": "1",
      "sex": "1"
    },{
      "address": "2",
      "birthday": "2020-01-01",
      "elderId": "93010001",
      "id": 1,
      "idCard": "2",
      "name": "2",
      "phone": "2",
      "sex": "2"
    }
  ]
}
```

​    **返回**：

```
UPDATE_SUCCESS     //添加成功

UPDATE_FAILD       //添加失败

null               //未找到对应老人
```



#### 6、删除老人信息

  

```
POST  /elder/delete/{id}
```

**返回**

```
DEL_SUCCESS    //添加成功

DEL_FAILD      //添加失败
```







### 二、系统用户API：

#### 1、登录    //修改url, 修改参数携带方式

  

```
 /user/login
```

   **POST**
   **参数**：username={username}&password={password}
   **返回**：

```

1.NOPERMISSION    //没有该用户
2.WRONGPASSWORD   //用户存在但密码错误
3.USERPERMIT      //登陆成功、普通用户用
4.ADMINISTRATOR   //登陆成功、管理员
```



#### 2、根据用户名查询用户信息

   /user/find/{userName}
   **GET**
   **参数**：{userName}    //username具有唯一性
   **返回**：

```json
1、
    {
      "id": 0,
      "nid": "string",
      "password": "string",
      "phone": "string",
      "role": {},
      "userName": "string"
    }   //查询成功
    
2、null               //查不到username
```



#### 3、查询所有用户信息

  

```
 /user/listAll
```

   **GET**
   **参数**：无
   **返回**：

```json
 //查询成功。————不能存在列表为空的情况
 [
      {
          "id": 0,
          "nid": "string",
          "password": "string",
          "phone": "string",
          "role": {},
          "userName": "string"
        },
        {
          "id": 0,
          "nid": "string",
          "password": "string",
          "phone": "string",
          "role": {},
          "userName": "string"
        }  
 
 ]
```



#### 4、新建用户

   

```shell
/user/create
```

   **POST**
   **参数**：

```
{
  "birthday": "2020-05-05",
  "id": "string",
  "nursHomeId": 0,
  "password": "string",
  "phone": "string",
  "realName": "string",
  "role": "string",
  "sex": "string"
}
```



   **返回**：

```
1、REPEATNAME    //用户名重复
2、ADD_SUCCESS   //新建成功
3、ADD_FAILD     //新建失败
```



#### 5、修改用户信息

```
   /user/update
```

   **POST**
   参数：LogUser（json）  //目前只修改realname和password
   **返回**：

```
1、null              //无法查到用户
2、UPDATE_SUCCESS    //修改成功
3、UPDATE_FAILD      //修改失败
```



#### 6、修改用户密码

   

```
/user/password
```

   **POST**
   **参数**：LogUser（json） //目前采用update()方法修改
   **返回**：

```
1、UPDATE_FAILD     //无法查到用户
2、UPDATE_FAILD     //修改失败
3、UPDATE_SUCCESS   //修改成功
```



#### 7、删除用户

   

```
/user/delete/{name}
```

   **GET**
   **参数**：{name}     //只有管理员有权限，过滤
   **返回**：

```
1、DEL_SUCCESS    //删除成功，
2、DEL_FAILD      //删除失败，
```







### 三、手环数据相关

#### 1、查询指定老人的最后一条数据（最新位置信息）

```
 /ring/queryLastRingData/{elderID
```

   **GET**
   **参数**：{elderID}
   **返回**：

```
1、null     //查找失败，或者没有数据
2、RingRecord（json）
```



#### 2、查询指定老人某时间段内的所有数据

```
/ring/queryRingDataByTime/{elderID}/{startTime}/{endTime}
```

   GET
   参数：{elderID}、{startTime}、{endTime}
   返回：

```
1、null    //查找失败，或没有数据，
2、list<RingRecord> （json）
```






