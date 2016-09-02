/*
 *Author: Create by 李呈云
 *Description:演示继承抽象函数和实现接口 
 *Date: 2016-9-2 上午11:02:44  
 */

//接口 
interface player
{
 int flag = 1;
 void play();//播放
 void pause();//暂停
 void stop();//停止
}//end :)

//抽象类
abstract class playing
{
 public void display(Object oPara)
 {
   System.out.println(oPara);  
 }
 abstract void winRun();
}//end :)

//继承了playing抽象类和实现类player接口
public class NewPlay extends playing implements player
{
  public void play()
  {
    display("newPlay.play()");//这里只是演示，去掉了代码。
  }
  public void pause()
  {
     display("newPlay.pause()");//这里只是演示，去掉了代码。
  }
  public void stop()
  {
    display("newPlay.stop()");//这里只是演示，去掉了代码。
  }
  void winRun()
  {
    display("newPlay.winRun()");//这里只是演示，去掉了代码。
  }
  public static void main(String[] args)
  {
    NewPlay p = new NewPlay();
    p.play();
    p.pause();
    p.stop();
    p.winRun();
  }
}//end :)
