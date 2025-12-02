# 多模块正确管项目
## 根pom文件应该如何写
1. 版本统一管理 → properties + dependencyManagement 统一管理依赖版本 但不真正引入依赖。只有子模块显式引用时才生效

2. 插件统一管理 → pluginManagement

3. 模块聚合 → modules

4. 全局构建规则 → 编码、JDK、资源过滤等

5. 不引入具体业务依赖 → dependencies 留给子模块按需引用# bc-game
### scope范围
1. runtime 适用于那些在编译时只需要其接口或抽象，但运行时需要加载具体实现的库
   场景：接口和具体实现分离 举例：JDBC 驱动,日志实现
2. provided 意味着该依赖由您部署代码的运行时环境提供。
   场景：容器或运行环境提供的 API  举例：javax.servlet-api Lombok使用了注解处理器技术，在内部编译了多个round 
3. compile 默认 依赖项在编译、测试和运行的所有阶段都必须存在。
   场景：核心业务逻辑和通用库 举例：Guava、Apache Commons
##### app----->core------>api------->bean
app实现了api core写具体service
    

