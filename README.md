# dynamic-datasource
### 基于AbstractRoutingDataSource和Mybatis Plus, 支持动态切换数据源
- 运行中动态新增、删除数据源
- 从默认数据库中添加租户数据源

### 如何使用
- 添加项目依赖
```xml
        <dependency>
            <groupId>com.github.fangyk-rel</groupId>
            <artifactId>dynamic-datasource</artifactId>
            <version>1.0.0</version>
        </dependency>
```
- 配置文件
```yaml
tenant:
  tenant-field-name: tenantId
  tenant-separator: _

primary-data-source:
  driver-class-name: com.mysql.cj.jdbc.Driver
  username: root
  password: fangyk
  url: jdbc:mysql://localhost:13306/main?accountUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&allowMultiQueries=true
  type: com.zaxxer.hikari.HikariDataSource
```