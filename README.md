# RuoYi-WMS 仓储管理系统

> 基于 RuoYi（v3.7.0）企业级开发底座构建的开源仓储管理系统，覆盖从物料建档、出入库作业到库存核算的完整仓配业务闭环。

![首页](https://oscimg.oschina.net/oscnet/up-89f751967b4145f7da92e23536bf231fbe8.jpg)

## 简介

RuoYi-WMS 是一套面向中小型制造、贸易与第三方物流企业的仓储管理系统（WMS），采用前后端分离架构，支持 Lodop 和网页打印入库单、出库单。

- 前端采用 Vue、Element UI（ant design 正在开发中）
- 后端采用 Spring Boot、Spring Security、Redis & JWT
- 权限认证使用 JWT，支持多终端认证系统

更详细的技术说明请参阅 [白皮书](docs/白皮书.md)。

## 功能一览

### 仓储业务

1. **首页**：库存预警与到期提醒、基础数据报表展示
2. **仓库 / 库区 / 货架**：管理维护仓库基础数据
3. **物料**：管理维护物料基础数据
4. **客户 / 供应商 / 承运商**：管理维护联系人基础数据
5. **入库**：状态包含未发货、在途（已发货未入库）、部分入库、作废、入库完成；类型包含采购入库、外协入库、退货入库；支持 Lodop 和网页打印
6. **出库**：状态包含未发货、部分发货、已发货、作废；类型包含销售出库、外协出库、调拨出库；支持 Lodop 和网页打印
7. **移库**：状态包含未操作、部分移动、操作完毕、作废
8. **库存看板**：查看当前物料库存数量
9. **库存记录**：查看当前物料库存操作记录
10. **库存盘点**：已完成
11. **库存月结**：已完成
12. **各类报表**：已完成

### 系统管理（RuoYi 内置）

1. 用户管理：系统用户配置
2. 部门管理：组织机构（公司、部门、小组），树结构展现支持数据权限
3. 岗位管理：用户所属职务配置
4. 菜单管理：系统菜单、操作权限、按钮权限标识
5. 角色管理：角色菜单权限分配、数据范围权限划分
6. 字典管理：固定数据维护
7. 参数管理：系统动态配置常用参数
8. 通知公告：通知公告信息发布维护
9. 操作日志：正常与异常操作日志记录和查询
10. 登录日志：系统登录日志记录查询
11. 在线用户：活跃用户状态监控
12. 定时任务：在线任务调度（添加、修改、删除）及执行日志
13. 代码生成：前后端代码生成（java、html、xml、sql），支持 CRUD 下载
14. 系统接口：根据业务代码自动生成 API 接口文档
15. 服务监控：CPU、内存、磁盘、堆栈等监控
16. 缓存监控：缓存信息查询、命令统计
17. 在线构建器：拖动表单元素生成相应 HTML 代码
18. 连接池监视：数据库连接池状态、SQL 分析

## 状态流转

#### 入库状态流转
![入库状态流转](https://oscimg.oschina.net/oscnet/up-6bdb5ad6d8ab236f763300b71cf175d9a99.jpg)

#### 出库状态流转
![出库状态流转](https://oscimg.oschina.net/oscnet/up-55cad3f077f914e357efeaae0b3feecf942.jpg)

## 演示图

![支持两种打印方式](https://oscimg.oschina.net/oscnet/up-6daf90ef19571c7f0e7641ae59c403d8272.jpg)
![lodop 打印](https://oscimg.oschina.net/oscnet/up-146d2105ae31a27e497323ad19f8bd0d7bd.jpg)
![网页打印](https://oscimg.oschina.net/oscnet/up-5664440042861199d1f3e60928e0700a9ce.jpg)
![仓库列表](https://oscimg.oschina.net/oscnet/up-a00eb79bee48e481249a12cb5e6c476aaa3.jpg)
![库存看板](https://oscimg.oschina.net/oscnet/up-78990915dfba902384ed4b09e3dc0f0fe05.jpg)

## 项目结构

```
RuoYi-ERP/
├── ruo-yi-wms-vue/   # 前端工程（Vue + Element UI）
└── wms-ruoyi/        # 后端工程（Spring Boot 多模块）
```

## 快速开始

### 环境要求

- JDK 1.8
- MySQL 5.7+（建议 8.0）
- Redis 5.0+
- Maven 3.6+
- Node.js 14+

### 后端

```bash
# 导入初始化数据
mysql -u root -p wms < wms-ruoyi/sql/结构和数据.sql

# 修改数据库与 Redis 连接
# wms-ruoyi/ruoyi-admin/src/main/resources/application-druid.yml
# wms-ruoyi/ruoyi-admin/src/main/resources/application.yml

cd wms-ruoyi
mvn clean package -DskipTests
java -jar ruoyi-admin/target/ruoyi-admin.jar
```

### 前端

```bash
cd ruo-yi-wms-vue
npm install --registry=https://registry.npmmirror.com
npm run dev          # 开发模式
npm run build:prod   # 生产构建
```

## 许可证

遵循原 RuoYi MIT 许可证，详见仓库 `LICENSE` 文件。
