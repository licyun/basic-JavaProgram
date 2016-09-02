/*
 *Author: Create by 李呈云
 *Description: 使用继承类，柳树就是树
 *Date: 2016-9-2 上午10:38:55  
 */

class tree{
	/*
	 *方法说明：树的树根
	 *输入参数：
	 *返回类型：
	 */
	public void root(){
	    String sSite = "土壤中";
	    String sFunction = "吸收养份";
	    System.out.println("位置："+sSite);
	    System.out.println("功能："+sFunction);
	}
	/*
	 *方法说明：树的树干
	 *输入参数：
	 *返回类型：
	 */
    public void bolo()
    {
      String sSite = "地面";
      String sFunction = "传递养份";
      System.out.println("位置："+sSite);
      System.out.println("功能："+sFunction);
    }
   /*
    *方法说明：树的树枝
    *输入参数：
    *返回类型：
    */
    public void branch()
    {
      String sSite = "树干上";
      String sFunction = "传递养份";
      System.out.println("位置："+sSite);
      System.out.println("功能："+sFunction);
    }
   /*
    *方法说明：树的叶子
    *输入参数：
    *返回类型：
    */
   public void leaf()
   {
     String sSite = "树梢";
     String sFunction = "光合作用";
     String sColor = "绿色";
     System.out.println("位置："+sSite);
     System.out.println("功能："+sFunction);
     System.out.println("颜色："+sColor);
   }
  /*
   *方法说明：显示信息
   *输入参数：Object oPara 显示的信息
   *返回类型：
   */
    public void print(Object oParam)
    {
      System.out.println(oParam);
    }
    /*
     *方法说明：主方法
     *输入参数：
     *返回类型：
     */
     public static void  main(String[] arges)
     {
       tree t = new tree();
       t.print("描述一棵树：");
       t.print("树根：");
       t.root();
       t.print("树干：");
       t.bolo();
       t.print("树枝：");
       t.branch();
       t.print("树叶：");
       t.leaf();
     }
}

class Osier extends tree {
	 /*
	 *方法说明：过载树的树叶
	 *输入参数：
	 *返回类型：
	 */
	 public void leaf()
	 {
	   super.leaf();
	   String sShape = "长形";
	   super.print("形状："+sShape);
	 }
	 /*
	  * 方法说明：扩展树的花
	  * 输入参数：
	  * 返回类型：
	  */
	 public void flower(){
		 print("柳树没有花");
	 }
	 /*
	  *方法说明：主方法
	  *输入参数：
	  *返回类型：
	  */
	   public static void  main(String[] args)
	   {
	     Osier o = new Osier();
	     o.print("柳树树根：");
	     o.root();
	     o.print("柳树树干：");
	     o.bolo();
	     o.print("柳树树枝：");
	     o.branch();
	     o.print("柳树树叶：");
	     o.leaf();
	     o.print("柳树花：");
	     o.flower();
	   }
}
