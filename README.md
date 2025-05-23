# Springboot3 Template

# 简介
个人Springboot3项目模板，包含了常用的功能模块，方便快速搭建项目。

# 依赖以及版本 （2025.05.23)
- Springboot 3.4.6
- SpringData Redis 3.4.6 (未写模板)
- jjwt 0.12.6
- MybatisPlus 3.5.12
- MybatisPlus JSqlParser 3.5.12
- Lombok
- Knife4j 4.5.0(由于Knife4j目前并未支持到SpringBoot3.4.5版本，所以依赖添加了Springdoc 2.7.0版本)
- Springdoc OpenAPI 2.7.0
- Springdoc OpenAPI UI 2.7.0

# 注意

1. 修改application.yml中的数据库连接信息。如果需要更改名字，需要把配置的包名也改了
2. 如果不喜欢用MybatisPlus，可以把相关的依赖去掉，使用原生的Mybatis
