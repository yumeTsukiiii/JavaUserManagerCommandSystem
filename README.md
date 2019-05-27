# JavaUserManagerCommandSystem
* 这是一个Java命令行登录注册的demo系统
* 仅供Java初学者学习使用，切勿在真实项目中模仿它

# 要点
* 使用了分层架构，将命令行的显示抽象为CommandView，逻辑层在Manager，数据层在Dao
* 使用了Java8中的Stream，lambda表达式，函数引用等。
* 文件读取抽取了FileUtil类，封装了有用的两个小工具
* 涉及到了一个反射小知识点。T.getClass().simpleName
