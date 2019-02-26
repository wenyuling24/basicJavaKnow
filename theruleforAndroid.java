一. java知识
 1.java 基础语法
  1).标识符和关键字 主要是在命名的时候注意别用到了
  2).Java基本数据类型、常量和变量
   
	常量
	变量：变量其实就是内存中的一块小区域
	   变量的分类：
	       按位置划分：局部变量 成员变量
		   按数据类型划分: 基本数据类型 引用数据类型 

   3).运算符 （++ -- 三目运算：a? b:c 等）
   4).流程控制
        条件语句 if() else{} switch(){}

		循环语句 for循环 
		while(判断的条件)
		{
		执行的语句
		}
		while循环 先判断 后执行 条件为true则执行 然后再次判断 一直到为false为止 

		do
		{ 执行的语句
		}
		while (判断的条件); 
		先执行 在判断 先执行do 再判断 条件为true则继续执行 直到为false为止
		
		break语句和continue语句
		break 强行中断
		continue 跳出当前条件 继续执行
		
		方法 
		   方法就是完成特定功能的代码片段
		   递归：内自我调用的方法
		 
		 程序的执行过程
		    见图
	  
	  5). 注释和分隔符
	 
  2.面向对象思想
	   1).作为面向对象的思维来说，当你拿到一个问题时，你分析这个问题不再是第一步先做什么，第二步再做什么，
	   这是面向过程的思维，
	   你应该分析这个问题里面有哪些类和对象，这是第一点，
	   然后再分析这些类和对象应该具有哪些属性和方法。这是第二点。
	   最后分析类和类之间具体有什么关系，这是第三点。
       面向对象有一个非常重要的设计思维：合适的方法应该出现在合适的类里面

	   2).类: 对某类事物的普遍一致性特征、功能的抽象、描述和封装，是构造对象的模版或蓝图，用 Java 编写的代码都会在某些类的内部。类之间主要有：依赖、聚合、继承等关系。 
		  类的三大特性：封装、继承、多态
		
		  封装:
		  Java Bean的一般封装  
		  private String obj;
		  public void set(String obj)
	      {
			this.obj = obj;
	      }
		  poublic String get(){
			  return this.obj;
		  }
		  注意布尔值的get方法一般是isXXX()

		  继承: extends 多个不同类中抽取出共性的数据和逻辑，然后把这些抽取出来的内容封装成一个新的类，然后之前的类extends这个类
			java里继承是单继承，即一个子类只能有一个直接父类 PS:实在不行连续继承就是了
			super关键字:子类可以使用super调用父类的成员变量和方法,前提是父类的该变量or方法能被调用 不是private修饰的
			显式调用调用和隐式调用: 
			super和this super()用于该类显示调用父类构造器 this()用于该类显式调用本类中其他构造器 如果一个构造器中无super()调用 则会隐式调用父类的无参构造器，super和this不会出现在同一构造器中
			
			子类创建时调用父类构造方法：子类需要使用父类的成员变量和方法，所以就要调用父类构造方法来初始化，之后再进行子类成员变量和方法的初始化。因此，构造方法是无法覆盖的。
			
			当子类需要扩展父类的某个方法时，可以覆盖父类方法，但是子类方法访问权限必须大于或等于父类权限
			
			在实际开发、程序设计过程中，并非先有的父类，而是先有了子类中通用的数据和逻辑，然后再抽取封装出来的父类。


			类实例化的过程: 注意是类实例化对象!! 
				无论新实例化多少个对象，该类的所有 父类以及自身 的静态初始化块只执行一次，而且是最先执行的初始化，称作类的初始化。之后的初始化会依次执行父类的非静态初始化块、父类的构造器和子类的非静态初始化块、子类的构造器来完成初始化称为对象初始化；在子类的构造器中可以通过super来显式调用父类的构造器，可以通过this来调用该类重载的其他构造器，而具体调用哪个构造器决定于调用时的参数类型。
				执行顺序 父类and本类的静态代码模块 > 父类and本类的非静态代码模块 > 父类and本类的构造器 

		  多态:多态指的是对象的多种形态, 继承是多态的实现基础
			   java程序中定义的引用变量所指向的具体类型和通过该引用类型发出的方法在调用时不确定，该引用变量发出的方法到底调用哪个类的实现的方法，必须在程序运行期间才能决定，这就是多态。
		       简单说多态就是在编程时不知道变量的类型或者方法，运行时才知道
			   
			   多态的三个前提
			       A.必须有子类和父类，具有继承或实现（继承）
				   B.子类必须重写父类的方法（重写）
				   C.父类的引用变量指向子类的对象（向上转型）
				Demo:
				
				public class Wine{
					public void fun1(){
						System.out.println("Wine 的Fun.....");
						fun2();
					}
					
					public void fun2(){
						System.out.prinltn("Wine 的Fun2");
					}
				}
				
				public class JNC extends Wine{
					 /**
					 * @desc 子类重载父类方法
					 *        父类中不存在该方法，向上转型后，父类是不能引用该方法的
					 * @param a
					 * @return void
					 */
					public void fun1(String a){
						System.out.println("JNC 的 Fun1...");
						fun2();
					}
					
					/**
					 * 子类重写父类方法
					 * 指向子类的父类引用调用fun2时，必定是调用该方法
					 */
					public void fun2(){
						System.out.println("JNC 的Fun2...");
					}
				}
				
				public class Test {
					public static void main(String[] args) {
						Wine a = new JNC();
						a.fun1();
					}
				}
				-------------------------------------------------
					Output:
					Wine 的Fun.....
					JNC 的Fun2...
					
					从程序的运行结果中我们发现，a.fun1()首先是运行父类Wine中的fun1().然后再运行子类JNC中的fun2()。

					分析：在这个程序中子类JNC重载了父类Wine的方法fun1()，重写fun2()，而且重载后的fun1(String a)与 fun1()不是同一个方法，由于父类中没有该方法，向上转型后会丢失该方法，所以执行JNC的Wine类型引用是不能引用fun1(String a)方法。而子类JNC重写了fun2() ，那么指向JNC的Wine引用会调用JNC中fun2()方法。
				Java实现多态有三个必要条件：继承、重写、向上转型。
				
					继承：在多态中必须存在有继承关系的子类和父类。

					重写：子类对父类中某些方法进行重新定义，在调用这些方法时就会调用子类的方法。

					向上转型：在多态中需要将子类的引用赋给父类对象，只有这样该引用才能够具备技能调用父类的方法和子类的方法。
		
		3).抽象类和接口
		   a.抽象类
		       抽象方法：它只有声明，而没有具体的实现。抽象方法的声明格式为：
			   abstract void fun();
			   
			   如果一个类含有抽象方法，则称这个类为抽象类，抽象类必须在类前用abstract关键字修饰。因为抽象类中含有无具体实现的方法，所以不能用抽象类创建对象
			   public abstract class ClassName{
				   abstract void fun();
			   }
			   
			   public class Test() extends ClassName{
				   @Override void fun() {
					}
			   }
			   
			   抽象类就是为了继承而存在的！！ extends
			   对于一个父类，如果它的某个方法在父类中实现出来没有任何意义，必须根据子类的实际需求来进行不同的实现，那么就可以将这个方法声明为abstract方法，此时这个类也就成为abstract类了
			   
			   抽象类里也可以存在成员变量和普通的方法
			   public abstract class Testabs {
				  abstract void fun();

				  public void fun1(){
					System.out.println("Testabs 的fun....");
					fun2();
				  }

				  public void fun2(){
					System.out.println("Testabs 的fun2....");
				  }
				}
				
				继承抽象类的子类必须实现抽象方法！
				public class Test() extends ClassName{
				   @Override void fun() {
					}
				}
			
			b.接口 interface
		      Java接口是一系列方法的声明，是一些方法特征的集合，一个接口只有方法的特征没有方法的实现，因此这些方法可以在不同的地方被不同的类实现，而这些实现可以具有不同的行为（功能）。 
			  接口无法被实例化，但是可以被实现。
			  一个实现接口的类，必须实现接口内所描述的所有方法。
			  如果不想全部实现，那么这个类必须是个抽象类，而且这抽象类的子类必须实现它未实现的方法。
			  
			  public interface Testabs {
			   void fun();
			   void setType(boolean flag);
			  }
			  
			  public abstract class Test implements Testabs {
				@Override public void fun() {
					System.out.println("Test fun....");
				}
			  }
				
			public class Wine extends Test{
			  @Override public void setType(boolean flag) {
			  }

			  public static void main(String[] args){
				Testabs w = new Wine();
				w.fun();
			  }
			}
			  
			  一个接口则无法实现其他的接口。
			  接口通常被使用在Java编程语言，用来做回调函数使用 
			
			c.抽象类和接口的区别和使用场景
			 1.语法层面上的区别
			　　抽象类可以提供成员方法的实现细节，而接口中只能存在public abstract 方法；
			　　抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是public static final类型的；
			　　接口中不能含有静态代码块以及静态方法，而抽象类可以有静态代码块和静态方法；
			　　一个类只能继承一个抽象类，而一个类却可以实现多个接口。

			  2.设计层面上的区别
			　　抽象类是对一种事物的抽象，即对类抽象，而接口是对行为的抽象。
				抽象类是对整个类整体进行抽象，包括属性、行为，但是接口却是对类局部（行为）进行抽象。举个简单的例子，飞机和鸟是不同类的事物，但是它们都有一个共性，就是都会飞。那么在设计的时候，可以将飞机设计为一个类Airplane，将鸟设计为一个类Bird，但是不能将 飞行 这个特性也设计为类，因此它只是一个行为特性，并不是对一类事物的抽象描述。此时可以将 飞行 设计为一个接口Fly，包含方法fly( )，然后Airplane和Bird分别根据自己的需要实现Fly这个接口。然后至于有不同种类的飞机，比如战斗机、民用飞机等直接继承Airplane即可，对于鸟也是类似的，不同种类的鸟直接继承Bird类即可。从这里可以看出，继承是一个 "是不是"的关系，而 接口 实现则是 "有没有"的关系。如果一个类继承了某个抽象类，则子类必定是抽象类的种类，而接口实现则是有没有、具备不具备的关系，比如鸟是否能飞（或者是否具备飞行这个特点），能飞行则可以实现这个接口，不能飞行就不实现这个接口。

			　　设计层面不同，抽象类作为很多子类的父类，它是一种模板式设计。而接口是一种行为规范，它是一种辐射式设计。什么是模板式设计？最简单例子，大家都用过ppt里面的模板，如果用模板A设计了ppt B和ppt C，ppt B和ppt C公共的部分就是模板A了，如果它们的公共部分需要改动，则只需要改动模板A就可以了，不需要重新对ppt B和ppt C进行改动。而辐射式设计，比如某个电梯都装了某种报警器，一旦要更新报警器，就必须全部更新。也就是说对于抽象类，如果需要添加新的方法，可以直接在抽象类中添加具体的实现，子类可以不进行变更；而对于接口则不行，如果接口进行了变更，则所有实现这个接口的类都必须进行相应的改动。
			　　
				下面看一个网上流传最广泛的例子：门和警报的例子：门都有open( )和close( )两个动作，此时我们可以定义通过抽象类和接口来定义这个抽象概念：

				abstract class Door {
					public abstract void open();
					public abstract void close();
				}
				或者：

				interface Door {
					public abstract void open();
					public abstract void close();
				}
				
			　　但是现在如果我们需要门具有报警alarm( )的功能，那么该如何实现？下面提供两种思路：

			　　1）将这三个功能都放在抽象类里面，但是这样一来所有继承于这个抽象类的子类都具备了报警功能，但是有的门并不一定具备报警功能；

			　　2）将这三个功能都放在接口里面，需要用到报警功能的类就需要实现这个接口中的open( )和close( )，也许这个类根本就不具备open( )和close( )这两个功能，比如火灾报警器。

			　　从这里可以看出， Door的open() 、close()和alarm()根本就属于两个不同范畴内的行为，open()和close()属于门本身固有的行为特性，而alarm()属于延伸的附加行为。因此最好的解决办法是单独将报警设计为一个接口，包含alarm()行为,Door设计为单独的一个抽象类，包含open和close两种行为。再设计一个报警门继承Door类和实现Alarm接口。


				interface Alram {
					void alarm();
				}
				 
				abstract class Door {
					void open();
					void close();
				}
				 
				class AlarmDoor extends Door implements Alarm {
					void oepn() {
					  //....
					}
					void close() {
					  //....
					}
					void alarm() {
					  //....
					}
				}
				
			总结起来：抽象类描述的是类的特性，而接口描述的是类的补充方法
		
		4).内部类	 
		   广泛意义上的内部类一般来说包括这四种：成员内部类、静态内部类、匿名内部类和局部内部类。
		   
		   成员内部类和静态内部类的区别：
		   Demo
		   public class Test {

			  class Bean1 { //成员内部类
				public int I = 0;
			  }

			  static class Bean2 {//静态内部类
				public int J = 0;
			  }

			  public static void main(String[] args){

				Test test = new Test();
				Bean1 bean1 = test.new Bean1();
				bean1.I++;

				Bean2 bean2 = new Bean2();
				bean2.J++;

				Bean bean = new Test().new Bean();
				Bean.Bean3 bean3  = bean.new Bean3();
				bean3.K++;
			  }

			  class Bean {
				class Bean3 {
				  public int K = 0;
				}
			  }
			}
			
			创建静态内部类对象的一般形式为：  外部类类名.内部类类名 xxx = new 外部类类名.内部类类名()
　　		创建成员内部类对象的一般形式为：  外部类类名.内部类类名 xxx = 外部类对象名.new 内部类类名()

			匿名内部类：一般的按钮点击事件OnClickListener就是匿名内部类
			
			局部内部类：局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。
			经典Demo
			public class Test {
				public static void main(String[] args)  {
					Outter outter = new Outter();
					outter.new Inner().print();
				}
			}
			 
			class Outter
			{
				private int a = 1;
				class Inner {
					private int a = 2;
					public void print() {
						int a = 3;
						System.out.println("局部变量：" + a);
						System.out.println("内部类变量：" + this.a);
						System.out.println("外部类变量：" + Outter.this.a);
					}
				}
			}
			-------------
			Output
			3
			2
			1
			
  3.java常用API	   
    Object类是java语言中的根类，它所描述的所有方法子类都可以使用，所有类在创建对象的时候，最终找的父类就是Object。在Objec类中，最常见的就是euqals方法和toString方法。equals方法用于比较两个对象是否相同，实质是比较两个对象的内存地址。在复写Object中的equals方法时，一定要注意public boolean equals(Object obj)的参数是Object类型。在调用对象的属性时，一定要进行类型转换，转换之前一定要进行类型判断。toString方法返回该对象的字符串表示。其实该字符串内容就是对象的类型+@+内存地址值。
	1).String和StringBuilder、StringBuffer的区别：
		主要是在运行速度和线程安全上区分：
		a.运行速度的快慢上 StringBuilder > StringBuffer > String
		  String最慢的原因：String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的
		  Java中对String对象进行的操作实际上是一个不断创建新的对象并且将旧的对象回收的一个过程。
		  而StringBuilder和StringBuffer的对象是变量，对变量进行操作就是直接对该对象进行更改，而不进行创建和回收的操作，所以速度要比String快很多。
		  
		  字符串拼接时 String的"+" 和StringBuilder append 的比较
		  String s = "a" + "b" + "c" + "d";
		  StringBuilder s = new StringBuilder();
		  s.append("a").append("b").append("c").append("d");
		  这两种方式其实效率一样， String在"+"的时候底层也是创建了个StringBuilder来append
		  String a = b + c + d 处理成a = new StringBuilder(b).append(c).append(d)
		  
		  只是说在循环里：
		  Demo
		  public class Test {

			  public static void main(String[] args) {fun2();
				fun1();
				fun2();
			  }

			  public static void fun1() {
				System.out.println("String时间： " + System.currentTimeMillis());
				String str = "s";

				for (int a = 0; a < 100000; a++) {
				  str += "a";
				}

				System.out.println("String时间： " + System.currentTimeMillis());
			  }

			  public static void fun2() {
				System.out.println("StringBuilder时间： " + System.currentTimeMillis());
				StringBuilder str = new StringBuilder("s");

				for (int a = 0; a < 100000; a++) {

				  str.append("a");
				}
				System.out.println("StringBuilder时间： " + System.currentTimeMillis());
			  }
			  
			}
			-------------
			Output
			StringBuilder时间： 1550656068839
			StringBuilder时间： 1550656068845
			String时间： 1550656068845
			String时间： 1550656073184
			循环里String的效率确实比StringBuilder低
			

		  
		b.线程安全上
		在线程安全上，StringBuilder是线程不安全的，而StringBuffer是线程安全的
	　　如果一个StringBuffer对象在字符串缓冲区被多个线程使用时，StringBuffer中很多方法可以带有synchronized关键字，所以可以保证线程是安全的，但StringBuilder的方法则没有该关键字，所以不能保证线程安全，有可能会出现一些错误的操作。所以如果要进行的操作是多线程的，那么就要使用StringBuffer，但是在单线程的情况下，还是建议使用速度比较快的StringBuilder。
	　　3. 总结一下
	　　String：适用于少量的字符串操作的情况
	　　StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
	　　StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况
		
	2).Date、DateFormat
		DateFormat是日期/时间格式化子类的抽象类，用来解析日期或时间。DateFormate是抽象类，一般需要使用子类SimpleDateFormat来创建对象
		Date类表示特定的瞬间，精确到毫秒。
		Demo
		时间戳转一般的时间格式yyyy-MM-dd HH:mm:ss
		public static void fun1() {
			//创建日期格式化对象,在获取格式化对象时可以指定风格
			DateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//对日期进行格式化
			Date date = new Date(System.currentTimeMillis());// 当前时间的Date对象
			String str_time = df.format(date);
			System.out.println("当前时间: " + str_time);
		  }
		  
		一般时间格式yyyy-MM-dd HH:mm:ss转时间戳
		private static void fun2(){
			String strTime = "2019-02-21 09:56:44";
			DateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//对日期进行格式化
			try {
			  Date date = df.parse(strTime);
			  long longTime = date.getTime();
			  System.out.println("时间戳: " + longTime/ 1000);
			} catch (ParseException e) {
			  e.printStackTrace();
			}
		  }
		  
	3).Calendar
	   Calendar是日历类，替换了许多Date的方法。将所有可能用到的时间信息封装为静态成员变量，方便获取。另一方面，Calendar是抽象类，在创建对象时并非直接创建，而是通过静态方法创建，将语言敏感内容处理好，再返回子类对象
	   Demo
	   private static void fun2(){
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE);//-----------------------当天 1-31
		int day_if_month = cal.get(Calendar.DAY_OF_MONTH);//---------------当天 1-31
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);//----------------从星期天开始计算，如果今天星期二，那么返回3
		int day_of_year = cal.get(Calendar.DAY_OF_YEAR);//----------------本年的第几天
		int hour = cal.get(Calendar.HOUR);//-----------------------12小时制
		int hour_of_day = cal.get(Calendar.HOUR_OF_DAY);//----------------24小时制，一般使用这个属性赋值
		int millisecond = cal.get(Calendar.MILLISECOND);//---------------- 当前毫秒
		int minute = cal.get(Calendar.MINUTE);//---------------------当前分钟
		int second = cal.get(Calendar.SECOND);//---------------------当前秒
		int week_of_month = cal.get(Calendar.WEEK_OF_MONTH);//--------------本月的第几周
		int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);//---------------本年的第几周
		int month = cal.get(Calendar.MONTH) + 1;//-----------------------月份获取需要 +1，那么，赋值时需要 -1
		int year = cal.get(Calendar.YEAR); //-----------------年份

		System.out.println("year:" + year + " month:"+ month + " day:" + day);
		System.out.println("day_of_year: " + day_of_year + " day_if_month:" + day_if_month + " day_of_week:" + day_of_week);
		System.out.println("week_of_year:" + week_of_year + " week_of_month:" + week_of_month);
		System.out.println("hour_of_day:" + hour_of_day + " hour:" + hour + " minute:" + minute + " second:" + second + " millisecond:" + millisecond);
	  }
	  
	   // 返回某月最后一天
	  public static void  getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		String lastDay = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		System.out.println("该月最后一天 :" + lastDay);
	  }
	  
	4).Math 
	   Math类是包含用于执行基本数学运算的方法的数学工具类，像初等函数、对数、平方根等。其所有方法均为静态方法，并且一般不会创建对象。比较常见的有：
	   abs方法,结果都为正数；ceil方法，结果为比参数值大的最小整数的double值；floor方法，结果为比参数值小的最大整数的double值；max方法，返回两个参数值中较大的值；min方法，返回两个参数值中较小的值；pow方法，返回第一个参数的第二个参数次幂的值；round方法，返回参数值四舍五入的结果；random方法，产生一个大于等于0.0且小于1.0的double小数。

	5).System
	   System 类中提供了一些系统级的操作方法，常用的方法有 arraycopy()、currentTimeMillis()、exit()、gc() 和 getProperty()。
		a. arraycopy() 方法
			该方法的作用是数组复制，即从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。该方法的具体定义如下：   
			public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
			其中，src 表示源数组，srcPos 表示从源数组中复制的起始位置，dest 表示目标数组，destPos 表示要复制到的目标数组的起始位置，length 表示复制的个数。
  
		b.currentTimeMillis() 方法
			该方法的作用是返回当前的计算机时间，时间的格式为当前计算机时间与 1970 年 1 月 1 日 0 时 0 分 0 秒所差的毫秒数
  
		c.exit() 方法
			该方法的作用是终止当前正在运行的 Java 虚拟机
			public static void exit(int status)
			其中，status 的值为 0 时表示正常退出，非零时表示异常退出。使用该方法可以在图形界面编程中实现程序的退出功能等
			System.exit(0);
		d.gc() 方法
			该方法的作用是请求系统进行垃圾回收
			System.gc();
		e.getProperty() 方法。
			该方法的作用是获得系统中属性名为 key 的属性对应的值
		 public static void fun1() {
			String jversion=System.getProperty("java.version");
			String oName=System.getProperty("os.name");
			String user=System.getProperty("user.name");
			System.out.println("Java 运行时环境版本："+jversion);
			System.out.println("当前操作系统是："+oName);
			System.out.println("当前用户是："+user);
		  }
		  
	6).Arrays类
	   Arrays类一般用来操作数组(比如排序和搜索)的各种方法，比较常见的方法有：
	    a. Arrays.sort()	//对数组元素进行排序（串行排序）
		   public static void fun1() {
			String[] data = {"1", "4", "3", "2"};
			System.out.println(Arrays.toString(data)); // [1, 4, 3, 2]
			Arrays.sort(data);
			System.out.println(Arrays.toString(data)); // [1, 2, 3, 4]
		  }
		  
		  延伸出来Arrays.sort(Object[] array, int fromIndex, int toIndex)
		  对数组元素的指定范围进行排序（串行排序）
		   public static void fun1() {
			String[] data = {"1", "4", "3", "2"};
			System.out.println(Arrays.toString(data)); // [1, 4, 3, 2]
			// 对下标[0, 3)的元素进行排序，即对1，4，3进行排序，2保持不变
			Arrays.sort(data, 0, 3);
			System.out.println(Arrays.toString(data)); // [1, 3, 4, 2]
		  }
		  
		b.Arrays.sort(T[] array, Comparator<? super T> comparator)
		  使用自定义比较器，对数组元素进行排序（串行排序）array 目标数组 
		  Interface Comparator<T> 对任意类型集合对象进行整体排序，排序时将此接口的实现传递给Collections.sort方法或者Arrays.sort方法排序.
		  实现int compare(T o1, T o2);方法，返回正数，零，负数各代表大于，等于，小于
		  如果指定的数与参数相等返回0。
		  如果指定的数小于参数返回 -1。
		  如果指定的数大于参数返回 1。
		  Demo
		   public static void fun1() {
			// 排序
			String demos[] = { "hello", "我擦嘞", "test", "CSDN" };
			//
			//		static <T> void
			//		 sort(T[] a, Comparator<? super T> c)
			//		          根据指定比较器产生的顺序对指定对象数组进行排序。

			Arrays.sort(demos, new Comparator<String>() {
			  @Override public int compare(String s, String t1) {
				return s.compareTo(t1);
			  }
			});

			  System.out.print(Arrays.toString(demos));
		  }
			------------------------------
			[CSDN, hello, test, 我擦嘞]
			
		c.Arrays.asList(T… data) 转数组
			public static void fun2(){
				List<Integer> list = Arrays.asList(1, 2, 3,18,11);
				System.out.println(Arrays.toString(list.toArray()));
			  }
			  ------------------------------
			  [1, 2, 3, 18, 11]
			  
		d.Arrays.fill(Object[] array, Object obj)
			用指定元素填充整个数组（会替换掉数组中原来的元素）
			Integer[] data = {1, 2, 3, 4};
			Arrays.fill(data, 9);
			System.out.println(Arrays.toString(data)); // [9, 9, 9, 9]
			
			延伸出来Arrays.fill(Object[] array, int fromIndex, int toIndex, Object obj)
			Integer[] data = {1, 2, 3, 4};
			Arrays.fill(data, 0, 2, 9);
			System.out.println(Arrays.toString(data)); // [9, 9, 3, 4]
			
		e.Arrays.parallelSort(T[] array)
			和Array.sort()一样，对数组元素进行排序（并行排序），当数据规模较大时，会有更好的性能
			  
		f.Arrays.binarySearch() 	  
			注意：在调用该方法之前，必须先调用sort()方法进行排序，如果数组没有排序， 
			那么结果是不确定的，此外如果数组中包含多个指定元素，则无法保证将找到哪个元素
			Arrays.binarySearch(Object[] array, Object key)
			使用 二分法 查找数组内指定元素的索引值
			Integer[] data = {1, 3, 5, 7};
			Arrays.sort(data);
			System.out.println(Arrays.binarySearch(data, 1)); // 0
			
			Arrays.binarySearch(Object[] array, int fromIndex, int toIndex, Object obj)
			使用 二分法 查找数组内指定范围内的指定元素的索引值
			Integer[] data = {1, 3, 5, 7};
			Arrays.sort(data);
			// {1, 3}，3的索引值为1
			System.out.println(Arrays.binarySearch(data, 0, 2, 3)); // 1
		
		g. Arrays.hashCode(Object[] array)
			返回数组的哈希值
			Integer[] data = {1, 2, 3};
			System.out.println(Arrays.hashCode(data)); // 30817
			
			Arrays.deepHashCode(Object[] array)
			返回多维数组的哈希值
			Integer[][] data = {{1, 2, 3}, {1, 2, 3}};
			System.out.println(Arrays.deepHashCode(data)); // 987105
		
		h.Arrays.deepEquals(Object[] array1, Object[] array2)
			判断两个多维数组是否相等，实际上比较的是两个数组的哈希值，
			即 Arrays.hashCode(data1) == Arrays.hashCode(data2)
			Integer[][] data1 = {{1,2,3}, {1,2,3}};
			Integer[][] data2 = {{1,2,3}, {1,2,3}};
			System.out.println(Arrays.deepEquals(data1, data2)); // true	
			
	
二.集合框架
	两大基类Collection与Map
	1.Collection是一个接口，是高度抽象出来的集合，它包含了集合的基本操作和属性。Collection包含了List和Set两大分支。
		1).List是一个有序的队列，每一个元素都有它的索引。第一个元素的索引值是0。List的实现类有LinkedList, ArrayList, Vector, Stack。
		  a.ArrayList:ArrayList是基于数组实现的，是一个数组队列。可以动态的增加容量！
		  b.LinkedList:LinkedList是基于链表实现的，是一个双向循环列表。可以被当做堆栈使用！
		  c.Vector:Vector是基于数组实现的，是一个矢量队列，是线程安全的！
		  d.Stack:Stack是基于数组实现的，是栈，它继承与Vector，特性是FILO(先进后出)!
		  一个Demo来看4中List的插入，查找，删除效率
		  private static final int COUNT = 100000; //十万
		  private static ArrayList<Object> arrayList = new ArrayList<Object>();
		  private static LinkedList<Object> linkedList = new LinkedList<Object>();
		  private static Vector<Object> vector = new Vector<Object>();
		  private static Stack<Object> stack = new Stack<Object>();

		  public static void fun3(){
			System.out.println("....开始测试插入元素..........");

			// 插入元素测试
			insertData(arrayList,"ArrayList") ;
			insertData(linkedList,"LinkedList") ;
			insertData(vector,"Vector") ;
			insertData(stack,"Stack") ;

			System.out.println("....开始测试读取元素..........");

			// 随机读取元素测试
			readAccessData(arrayList,"ArrayList") ;
			readAccessData(linkedList,"LinkedList") ;
			readAccessData(vector,"Vector") ;
			readAccessData(stack,"Stack") ;

			System.out.println("....开始测试删除元素..........");

			// 随机读取元素测试
			deleteData(arrayList,"ArrayList") ;
			deleteData(linkedList,"LinkedList") ;
			deleteData(vector,"Vector") ;
			deleteData(stack,"Stack") ;
		  }
		  /**
		   * 指定的List 的子类中插入元素，并统计插入的时间
		   * @param list List 的子类
		   * @param name 子类的名称
		   */
		  private static void insertData(List<Object> list,String name) {
			long startTime = System.currentTimeMillis();

			// 向list的位置0插入COUNT个数
			for (int i=0; i<COUNT; i++){
			  list.add(0, i);
			}

			long endTime = System.currentTimeMillis();
			long interval = endTime - startTime;
			System.out.println(name + " : 插入 "+COUNT+"元素， 使用的时间是 " + interval+" ms");
		  }

		  /**
		   * 指定的List 的子类中删除元素，并统计删除的时间
		   * @param list List 的子类
		   * @param name 子类的名称
		   */
		  private static void deleteData(List<Object> list,String name) {
			long startTime = System.currentTimeMillis();

			// 删除list第一个位置元素
			for (int i=0; i<COUNT; i++)
			  list.remove(0);

			long endTime = System.currentTimeMillis();
			long interval = endTime - startTime;
			System.out.println(name + " : 删除 "+COUNT+"元素， 使用的时间是 " + interval+" ms");
		  }

		  /**
		   * 指定的List 的子类中读取元素，并统计读取的时间
		   * @param list List 的子类
		   * @param name 子类的名称
		   */
		  private static void readAccessData(List<Object> list,String name) {
			long startTime = System.currentTimeMillis();

			// 读取list元素
			for (int i = 0; i < COUNT; i++)
			  list.get(i);

			long endTime = System.currentTimeMillis();
			long interval = endTime - startTime;
			System.out.println(name + " : 随机读取 "+COUNT+"元素， 使用的时间是 " + interval+" ms");
		  }
		  --------------------------------------
		  Output
		    ....开始测试插入元素..........
			ArrayList : 插入 100000元素， 使用的时间是 1280 ms
			LinkedList : 插入 100000元素， 使用的时间是 5 ms
			Vector : 插入 100000元素， 使用的时间是 1099 ms
			Stack : 插入 100000元素， 使用的时间是 1100 ms
			
			....开始测试读取元素..........
			ArrayList : 随机读取 100000元素， 使用的时间是 3 ms
			LinkedList : 随机读取 100000元素， 使用的时间是 4567 ms
			Vector : 随机读取 100000元素， 使用的时间是 3 ms
			Stack : 随机读取 100000元素， 使用的时间是 3 ms
			
			....开始测试删除元素..........
			ArrayList : 删除 100000元素， 使用的时间是 1040 ms
			LinkedList : 删除 100000元素， 使用的时间是 3 ms
			Vector : 删除 100000元素， 使用的时间是 1040 ms
			Stack : 删除 100000元素， 使用的时间是 1028 ms
			
			由上Demo可得出结论 LinkedList的插入、删除效率最高10万个数据只需要3-5ms;
			查找元素时ArrayList、Vector、Stack的效率差不多，均为1s左右
			原因：
			读取元素时:ArrayList随机读取的时候采用的是get(index),根据指定位置读取元素，而LinkedList则采用size/2 ,二分法去加速一次读取元素
			而插入或者删除元素时:ArrayList插入时候要判断容量，删除时候要将数组移位，有一个复制操作！而LinkedList直接插入，不用判断容量，删除的时候也是直接删除跳转指针节点，没有复制的操作！ 
			
			所以对于需要快速插入，删除元素，应该使用LinkedList。
			对于需要快速随机访问元素，应该使用ArrayList。
			
		2).Set是一种不包括重复元素的Collection。它维持它自己的内部排序，所以随机访问没有任何意义。与List一样，它同样允许null的存在但是仅有一个。由于Set接口的特殊性，所有传入Set集合中的元素都必须不同，同时要注意任何可变对象，如果在对集合中元素进行操作时，导致e1.equals(e2)==true，则必定会产生某些问题。Set接口有三个具体实现类，分别是散列集HashSet、链式散列集LinkedHashSet和树形集TreeSet。
		   需要注意的是:虽然Set中元素没有顺序，但是元素在set中的位置是由该元素的HashCode决定的，其具体位置其实是固定的。
			此外需要说明一点，在set接口中的不重复是有特殊要求的。
			举一个例子:对象A和对象B，本来是不同的两个对象，正常情况下它们是能够放入到Set里面的，但是如果对象A和B的都重写了hashcode和equals方法，并且重写后的hashcode和equals方法是相同的话。那么A和B是不能同时放入到Set集合中去的，也就是Set集合中的去重和hashcode与equals方法直接相关。 
			set底层数据结构是哈希表：
			特点：存储取出都比较快
			原理：具体省略，简单说就是链表数组结合体
			a.HashSet
			 1.无序集合
			 2.可以存入空(null),但是有且只有一个
			 3.不可以存在重复元素
			b.LinkedHashSet
			  LinkedHashSet继承自HashSet，其底层是基于LinkedHashMap来实现的，有序，非同步。LinkedHashSet集合同样是根据元素的hashCode值来决定元素的存储位置，但是它同时使用链表维护元素的次序。这样使得元素看起来像是以插入顺序保存的，也就是说，当遍历该集合时候，LinkedHashSet将会以元素的添加顺序访问集合的元素。
			c.TreeSet
			  TreeSet是一个有序集合，其底层是基于TreeMap实现的，非线程安全。TreeSet可以确保集合元素处于排序状态。TreeSet支持两种排序方式，自然排序和定制排序，其中自然排序为默认的排序方式。当我们构造TreeSet时，若使用不带参数的构造函数，则TreeSet的使用自然比较器；若用户需要使用自定义的比较器，则需要使用带比较器的参数。
              注意：TreeSet集合不是通过hashcode和equals函数来比较元素的.它是通过compare或者comparaeTo函数来判断元素是否相等.compare函数通过判断两个对象的id，相同的id判断为重复元素，不会被加入到集合中。	
	
	2.Map是一个映射接口，即key—value键值对。Map中的每一个元素包含“一个key”和“key对应的value”。AbstractMap是个抽象类，它实现了Map接口中的大部分API。而HashMap，TreeMap，WeakHashMap都是继承于AbstractMap。Hashtable虽然继承于Dictionary，但它实现了Map接口。
	  在Map中它保证了key与value之间的一一对应关系。也就是说一个key对应一个value
	    1).HashMap
		   HashMap 底层就是一个数组结构，数组中的每一项又是一个链表。当新建一个HashMap的时候，就会初始化一个数组
		   HashMap是基于Hash表的Map实现，可操作null键和null值，是非线程安全的；LinkedHashMap是线程安全的
		   储存方式：HashMap其内部定义了一个hash表数组key所对应的value值链接成一个链表，而数组中储存的是链表的第一个节点的地址值，所以HashMap又叫做链表的数组。
		   HashMap的性能受两个因素的影响，初始容量和加载因子，如果Hash表中的条目数超过了初始容量和加载因子的乘积，那么hash表讲做出自我调整，把容量扩充为原来的两倍，并将原有的数据重新映射到表中，这个过程叫做rehash;容量扩充，重新映射，所以说rehash必然会造成时间和空间的开销，所以说初始容量和加载因子会影响HashMap的性能
		2).LinkedHashMap
		   LinkedHashMap是HashMap的一个子类，它保留插入的顺序，如果需要输出的顺序和输入时的相同，那么就选用LinkedHashMap。
		   LinkedHashMap实现与HashMap的不同之处在于，后者维护着一个运行于所有条目的双重链接列表。此链接列表定义了迭代顺序，该迭代顺序可以是插入顺序或者是访问顺序。
		   根据链表中元素的顺序可以分为：按插入顺序的链表，和按访问顺序(调用get方法)的链表。默认是按插入顺序排序，如果指定按访问顺序排序，那么调用get方法后，会将这次访问的元素移至链表尾部，不断访问可以形成按访问顺序排序的链表。
		   注意，此实现不是同步的。如果多个线程同时访问链接的哈希映射，而其中至少一个线程从结构上修改了该映射，则它必须保持外部同步。
		   由于LinkedHashMap需要维护元素的插入顺序，因此性能略低于HashMap的性能，但在迭代访问Map里的全部元素时将有很好的性能，因为它以链表来维护内部顺序。
		3).TreeMap
		   TreeMap是基于红黑树（二叉树）数据结构实现的，特点：会对元素的键进行排序存储。
		   TreeMap 要注意的事项：
			a. 往TreeMap添加元素的时候，如果元素的键具备自然顺序，那么就会按照键的自然顺序特性进行排序存储。PS：比如按照英文字母顺序给请求参数排序等
			b. 往TreeMap添加元素的时候，如果元素的键不具备自然顺序特性，那么键所属的类必须要实现Comparable接口。
		4).value()方法与keySet()、entrySet()区别:
		   values():方法是获取集合中的所有的值----没有键，没有对应关系，
		   KeySet():将Map中所有的键存入到set集合中。因为set具备迭代器。所有可以迭代方式取出所有的键，再根据get方法。获取每一个键对应的值。keySet():迭代后只能通过get()取key 
		   entrySet()：Set<Map.Entry<K,V>> entrySet() //返回此映射中包含的映射关系的 Set 视图。 Map.Entry表示映射关系。entrySet()：迭代后可以e.getKey()，e.getValue()取key和value。返回的是Entry接口 。
		   Demo：
		   public static void fun1(){
			Map<String,String> map = new HashMap<String,String>();

			map.put("01", "zhangsan");
			map.put("02", "lisi");
			map.put("03", "wangwu");


			Set<String> keySet = map.keySet();//先获取map集合的所有键的Set集合

			Iterator<String> it = keySet.iterator();//有了Set集合，就可以获取其迭代器。

			while(it.hasNext()){
			  String key = it.next();
			  String value = map.get(key);//有了键可以通过map集合的get方法获取其对应的值。

			  System.out.println("key: "+key+"-->value: "+value);//获得key和value值
			}
		  }

		  public static void fun2(){
			Map<String,String> map = new HashMap<String,String>();

			map.put("01", "zhangsan");
			map.put("02", "lisi");
			map.put("03", "wangwu");

			//通过entrySet()方法将map集合中的映射关系取出（这个关系就是Map.Entry类型）
			Set<Map.Entry<String, String>> entrySet = map.entrySet();

			//将关系集合entrySet进行迭代，存放到迭代器中
			Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();

			while(it2.hasNext()){
			  Map.Entry<String, String> me = it2.next();//获取Map.Entry关系对象me
			  String key2 = me.getKey();//通过关系对象获取key
			  String value2 = me.getValue();//通过关系对象获取value

			  System.out.println("key: "+key2+"-->value: "+value2);
			}
		  }
		  
		  HashMap和TreeMap。keySet和entrySet在Map元素数较少时（小于10000）在查询速度上的区别不大，它们对于程序性能的影响可以忽略不计。但在元素较多时（大于100000）时entrySet的速度要明显快于keySet，尤其是TreeMap更明显。
		  So建议大家使用entrySet

		
	3.接下来，再看Iterator。它是遍历集合的工具，即我们通常通过Iterator迭代器来遍历集合。
	  我们说Collection依赖于Iterator，是因为Collection的实现类都要实现iterator()函数，返回一个Iterator对象。ListIterator是专门为遍历List而存在的。
	  Java中的Iterator功能比较简单，并且只能单向移动：
	　　1).使用方法iterator()要求容器返回一个Iterator。第一次调用Iterator的next()方法时，它返回序列的第一个元素。注意：iterator()方法是java.lang.Iterable接口,被Collection继承。
	　　2).使用next()获得序列中的下一个元素。
	　　3).使用hasNext()检查序列中是否还有元素。
	　　4).使用remove()将迭代器新返回的元素删除。
	    Iterator的接口定义：
		public interface Iterator {  
		　　boolean hasNext();  
		　　Object next();  
		　　void remove();  
		} 
		
		使用：　
		Object next()：返回迭代器刚越过的元素的引用，返回值是Object，需要强制转换成自己需要的类型
　　　　boolean hasNext()：判断容器内是否还有可供访问的元素
　　　　void remove()：删除迭代器刚越过的元素
		迭代使用方法：（迭代其实可以简单地理解为遍历，是一个标准化遍历各类容器里面的所有对象的方法类）
		for(Iterator it = c.iterator(); it.hasNext(); ) {  
		　　Object o = it.next();  
		　　 //do something  
		}
		
	4.最后，看Arrays和Collections。它们是操作数组、集合的两个工具类。
		1).Arrays见一-1-6)
		2).Collections:
		   a.Java中Collection和Collections的区别：
		   Collection：java.util.Collection 是一个集合接口（集合类的一个顶级接口）。它提供了对集合对象进行基本操作的通用接口方法。Collection接口在Java 类库中有很多具体的实现。Collection接口的意义是为各种具体的集合提供了最大化的统一操作方式，其直接继承接口有List与Set。
		   Collections: Collections则是集合类的一个工具类/帮助类，其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作。
		   Collections提供以下方法对List进行排序操作
			void reverse(List list)：反转
			void shuffle(List list),随机排序
			void sort(List list),按自然排序的升序排序
			void sort(List list, Comparator c);定制排序，由Comparator控制排序逻辑
			void swap(List list, int i , int j),交换两个索引位置的元素
			void rotate(List list, int distance),旋转。当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将 list的前distance个元素整体移到后面。
			Demo:
			   public static void fun1(){

				List<Integer> list = new ArrayList<>();
				list.add(12);
				list.add(-15);
				list.add(7);
				list.add(4);
				list.add(35);
				list.add(9);

				System.out.println("源列表：" + list);
				// 逆序
				Collections.reverse(list);
				System.out.println("逆序：" + list);

				// 排序（自然顺序）
				Collections.sort(list);
				System.out.println("自然序：" + list);

				// 随机排序
				Collections.shuffle(list);
				System.out.println("随机序：" + list);

				// 定制排序的用法，将int类型转成string进行比较
				Collections.sort(list, new Comparator<Object>() {
				  @Override
				  public int compare(Object o1, Object o2) {
					String str1 = String.valueOf(o1);
					String str2 = String.valueOf(o2);

					return str1.compareTo(str2);
				  }
				});
				System.out.println("定制序：" + list);

				// 旋转
				Collections.rotate(list, 3);
				System.out.println("旋转3：" + list);

				Collections.rotate(list, -3);
				System.out.println("旋转-3：" + list);
			  }
			  -------------------------------------------------------
			  Output:
			  源列表：[12, -15, 7, 4, 35, 9]
			  逆序：[9, 35, 4, 7, -15, 12]
			  自然序：[-15, 4, 7, 9, 12, 35]
			  随机序：[9, 12, 4, 7, -15, 35]
			  定制序：[-15, 12, 35, 4, 7, 9]
			  旋转3：[4, 7, 9, -15, 12, 35]
			  旋转-3：[-15, 12, 35, 4, 7, 9]
		   
		   
		   查找，替换操作
			int binarySearch(List list, Object key), 对List进行二分查找，返回索引，注意List必须是有序的
			int max(Collection coll),根据元素的自然顺序，返回最大的元素。 类比int min(Collection coll)
			int max(Collection coll, Comparator c)，根据定制排序，返回最大元素，排序规则由Comparatator类控制。类比int min(Collection coll, Comparator c)
			void fill(List list, Object obj),用元素obj填充list中所有元素
			int frequency(Collection c, Object o)，统计元素出现次数
			int indexOfSubList(List list, List target), 统计targe在list中第一次出现的索引，找不到则返回-1，类比int lastIndexOfSubList(List source, list target).
			boolean replaceAll(List list, Object oldVal, Object newVal), 用新元素替换旧元素。
		   
		   public static void fun1(){

			List<Integer> list = new ArrayList<>();
			list.add(12);
			list.add(-15);
			list.add(7);
			list.add(4);
			list.add(35);
			list.add(9);

			System.out.println("源列表：" + list);
			System.out.println("最大的元素: " + Collections.max(list));
			System.out.println("最小元素: " + Collections.min(list));
			Collections.replaceAll(list,-15, 35);
			System.out.println("用新元素替换旧元素: " + list);
			System.out.println("统计元素出现次数: " + Collections.frequency(list, 35));
			Collections.sort(list);
			System.out.println("先sort排序，然后对List进行二分查找，得到的是索引： " + Collections.binarySearch(list, 35));

			int index = Collections.binarySearch(list, 35, new Comparator<Integer>() {
			  @Override public int compare(Integer int1, Integer int2) {
				return int1.compareTo(int2);
			  }
			});

			System.out.println("先sort排序，然后对List进行二分查找，得到的是索引： " + index);
		  }

  
		   Collections同步控制
		   Collections中几乎对每个集合都定义了同步控制方法，例如 SynchronizedList(), SynchronizedSet()等方法，来将集合包装成线程安全的集合。下面是Collections将普通集合包装成线程安全集合的用法，
		   Collection c = Collections.synchronizedCollection(new ArrayList());
		   List list = Collections.synchronizedList(new ArrayList());
           Set s = Collections.synchronizedSet(new HashSet());
           Map m = Collections.synchronizedMap(new HashMap());
  三.异常
  四.多线程
  五.IO
  六.网络编程
  七.java高级技术
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
    
			  
			  