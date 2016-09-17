/*
 *Author: Create by 李呈云
 *Description: 使用正则表达式匹配示例
 *Date: 2016-9-4 下午12:50:52  
 */ 
  
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCheckEmail
{
    public static void main( String args[] ){

      // 按指定模式在字符串查找
      String line = "This order was placed for QT3000! OK?";
      String pattern = "(.*)(\\d+)(.*)";

      // 创建 Pattern 对象
      Pattern r = Pattern.compile(pattern);

      // 现在创建 matcher 对象
      Matcher m = r.matcher(line);
      if (m.find( )) {
         System.out.println("Found value: " + m.group(0) );
         System.out.println("Found value: " + m.group(1) );
         System.out.println("Found value: " + m.group(2) );
      } else {
         System.out.println("NO MATCH");
      }
   }
}
