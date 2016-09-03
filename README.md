
参考网上的经典JAVA程序，自己重新将这些JAVA程序手动敲入实现了一边。
----------------------------------------------------------------------
本次实验中巩固了JAVA基础知识，了解了很多变量的规范命令，如何简单高效的实现一个函数的功能。

修正了部分错误代码:
```java
1.例3中的闰年的判断 
 	iPara % 4 == 0 && iPara % 100 != 0 || iPara % 400 == 0
  原代码为：iPara%100==0&&iPara%4==0;
2.例5中hash表中数据的修改
	rightList.remove(role);
	rightList.put(role, code);
  原代码为：this.insert(accRole,rightCode);
3.例13中InputStreamReader获取网页乱码
	InputStreamReader isr = new InputStreamReader(url.openStream(),"utf-8");//加入utf-8修复乱码问题
```
