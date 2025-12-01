# 多模块正确管项目
## 根pom文件应该如何写
1. 版本统一管理 → properties + dependencyManagement 统一管理依赖版本 但不真正引入依赖。只有子模块显式引用时才生效

2. 插件统一管理 → pluginManagement

3. 模块聚合 → modules

4. 全局构建规则 → 编码、JDK、资源过滤等

5. 不引入具体业务依赖 → dependencies 留给子模块按需引用# bc-game
