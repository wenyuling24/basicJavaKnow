一、Android基础
	1.基础组件
		1).Android四大组件
			a.Activity
			<1> Activity是用户操作的可视化界面；它为用户提供了一个完成操作指令的窗口。
			当我们创建完毕Activity之后，需要调用setContentView()方法来完成界面的显示；以此来为用户提供交互的入口。
			在Android App 中只要能看见的几乎都要依托于Activity，所以Activity是在开发中使用最频繁的一种组件。
			<2>一个Activity通常就是一个单独的屏幕（窗口）。
			<3>Activity之间通过Intent进行通信。
			<4>android应用中每一个Activity都必须要在AndroidManifest.xml配置文件中声明，否则系统将不识别也不执行该Activity。
			<5>Activity的生命周期:
			在Android中会维持一个Activity Stack（Activity栈），当一个新的Activity创建时，它就会放到栈顶，这个Activity就处于运行状态。当再有一个新的Activity被创建后，会重新压人栈顶，而之前的Activity则会在这个新的Activity底下，就像枪梭压入子弹一样。而且之前的Activity就会进入后台。
			个Activity实质上有四种状态：
			运行中(Running/Active):这时Activity位于栈顶，是可见的，并且可以用户交互。
			暂停(Paused):当Activity失去焦点，不能跟用户交互了，但依然可见，就处于暂停状态。当一个新的非全屏的Activity或者一个透明的Activity放置在栈顶，Activity就处于暂停状态；这个时候Activity的各种数据还被保持着；只有在系统内存在极低的状态下，系统才会自动的去销毁Activity。
			停止(Stoped):当一个Activity被另一个Activity完全覆盖，或者点击HOME键退入了后台，这时候Activity处于停止状态。这里有些是跟暂停状态相似的：这个时候Activity的各种数据还被保持着；当系统的别的地方需要用到内容时，系统会自动的去销毁Activity。
			销毁(Detroyed):当我们点击返回键或者系统在内存不够用的情况下就会把Activity从栈里移除销毁，被系统回收，这时候，Activity处于销毁状态。
			oncreate()->onstart()->onResume()->onRestart()->onPouse()->onStop()->onDestory()
			onCreate(): 
			当我们点击activity的时候，系统会调用activity的oncreate()方法，在这个方法中我们会初始化当前布局setContentLayout（）方法。 
			onStart(): 
			onCreate()方法完成后，此时activity进入onStart()方法,当前activity是用户可见状态，但没有焦点，与用户不能交互，一般可在当前方法做一些动画的初始化操作。 
			onResume(): 
			onStart()方法完成之后，此时activity进入onResume()方法中，当前activity状态属于运行状态 (Running)，可与用户进行交互。 
			onPouse() 
			当另外一个activity覆盖当前的acitivty时，此时当前activity会进入到onPouse()方法中，当前activity是可见的，但不能与用户交互状态。 
			onStop() 
			onPouse()方法完成之后，此时activity进入onStop()方法，此时activity对用户是不可见的，在系统内存紧张的情况下，有可能会被系统进行回收。所以一般在当前方法可做资源回收。 
			onDestory() 
			onStop()方法完成之后，此时activity进入到onDestory()方法中，结束当前activity。 
			onRestart() 
			onRestart()方法在用户按下home()之后，再次进入到当前activity的时候调用。调用顺序onPouse()->onStop()->onRestart()->onStart()->onResume().
			
			b.Service
			<1>service（服务）是安卓中的四大组件之一，它通常用作在后台处理耗时的逻辑，与Activity一样，它存在自己的生命周期，也需要在AndroidManifest.xml配置相关信息。
			服务（Service)是Android中实现程序后台运行的解决方案，它非常适合去执行那些不需要和用户交互而且还要求长期运行的任务。服务的运行不依赖于任何用户界面，即使程序被切换到后台，或者用户打开了另外一个应用程序，服务仍然能够保持正常运行。
			不过需要注意的是，服务并不是运行在一个独立的进程当中的，而是依赖于创建服务时所在的应用程序进程。
			与某个应用程序进程被杀掉时，所有依赖于该进程的服务也会停止运行。
			另外.也不要被服务的后台概念所迷惑，实际上服务并不会自动开启线程，所有的代码都是默认运行在主线程当中的。
			也就是说，我们需要在服务的内部手动创建子线程，并在这里执行具体的任务，否则就有可能出现主线程被阻塞住的情况。
			<2>startService()与bindService()区别:
			started service（启动服务）是由其他组件调用startService()方法启动的，这导致服务的onStartCommand()方法被调用。当服务是started状态时，其生命周期与启动它的组件无关，并且可以在后台无限期运行，即使启动服务的组件已经被销毁。因此，服务需要在完成任务后调用stopSelf()方法停止，或者由其他组件调用stopService()方法停止。
			使用bindService()方法启用服务，调用者与服务绑定在了一起，调用者一旦退出，服务也就终止，大有“不求同时生，必须同时死”的特点。
			<3>开发人员需要在应用程序配置文件中声明全部的service，使用<service></service>标签。
			<4>Service通常位于后台运行，它一般不需要与用户交互，因此Service组件没有图形用户界面。Service组件需要继承Service基类。
			<5>Android O 8.0（API 26之后） 之后不再允许后台service直接通过startService方式去启动， 具体行为变更 
			如果针对 Android 8.0 的应用尝试在不允许其创建后台服务的情况下使用 startService() 函数，则该函数将引发一个 IllegalStateException。新的 Context.startForegroundService() 函数将启动一个前台服务。 
			现在，即使应用在后台运行， 系统也允许其调用 Context.startForegroundService()。不过，应用必须在创建服务后的五秒内调用该服务的 startForeground() 函数。
			PS：要么带个前台进程 要么带个Notification()
			
			c.BroadcaseReceiver
			BroadcastReceiver 用于异步接收广播Intent。主要有两大类，用于接收广播的：
			<1>正常广播 Normal broadcasts（用 Context.sendBroadcast()发送）是全然异步的。它们都执行在一个没有定义的顺序，一般是在同一时间。这样会更有效，但意味着receiver不能包括所要使用的结果或中止的API。
			<2>有序广播 Ordered broadcasts（用 Context.sendOrderedBroadcast()发送）每次被发送到一个receiver。所谓有序，就是每一个receiver执行后能够传播到下一个receiver，也能够全然中止传播--不传播给其它receiver。 
			而receiver执行的顺序能够通过matched intent-filter 里面的android:priority来控制，当priority优先级同样的时候，Receiver以随意的顺序执行。
		
			d.ContentProvider
			ContentProvider（内容提供者）是Android中的四大组件之中的一个。主要用于对外共享数据，也就是通过ContentProvider把应用中的数据共享给其它应用訪问，其它应用能够通过ContentProvider对指定应用中的数据进行操作。ContentProvider分为系统的和自己定义的，系统的也就是比如联系人，图片等数据。
			下面这段是Google Doc中对ContentProvider的大致概述。
			内容提供者将一些特定的应用程序数据供给其他应用程序使用。数据能够存储于文件系统、SQLite数据库或其他方式。内容提供者继承于ContentProvider 基类，为其他应用程序取用和存储它管理的数据实现了一套标准方法。然而，应用程序并不直接调用这些方法，而是使用一个 ContentResolver 对象，调用它的方法作为替代。ContentResolver能够与随意内容提供者进行会话，与其合作来对全部相关交互通讯进行管理。
			主要用于不同的应用程序之间实现数据共享功能
			Uri（通用资源标识符 Universal Resource Identifer），代表数据操作的地址，每一个ContentProvider发布数据时都会有唯一的地址。 
			比如：content：//（固定写法）+com.android.contacts(包名，可变)+/contacts（path路径）
			
		2).Fragment
			a.Fragment基本概念
			Fragment，简称碎片，是Android 3.0（API 11）提出的，为了兼容低版本，support-v4库中也开发了一套Fragment API，最低兼容Android 1.6。
			如果想引入整个support-v4库，则compile 'com.android.support:support-v4:24.2.1'，
			如果只想引入support-fragment库，则com.android.support:support-fragment:24.2.1。
			因为support库是不断更新的，因此建议使用support库中的android.support.v4.app.Fragment，而不要用系统自带的android.app.Fragment。而如果要使用support库的Fragment，Activity必须要继承FragmentActivity（AppCompatActivity是FragmentActivity的子类）。
			Fragment是依赖于Activity的，不能独立存在的。
			一个Activity里可以有多个Fragment。
			一个Fragment可以被多个Activity重用。
			Fragment有自己的生命周期，并能接收输入事件。
			我们能在Activity运行时动态地添加或删除Fragment。
			<2>Fragment的优势
			模块化（Modularity）：我们不必把所有代码全部写在Activity中，而是把代码写在各自的Fragment中。
			可重用（Reusability）：多个Activity可以重用一个Fragment。
			可适配（Adaptability）：根据硬件的屏幕尺寸、屏幕方向，能够方便地实现不同的布局，这样用户体验更好
			<3>具体使用
			ViewPager+Fragment的使用：
			推荐使用FlycoTabLayout_Lib
			第一步 依赖implementation 'com.flyco.tablayout:FlycoTabLayout_Lib:2.1.2@aar'
			第二步 自定义ViewPager SViewPager.java
			public class SViewPager extends ViewPager {
			  private boolean canScroll = false;
			  public SViewPager(Context context) {
				super(context);
			  }

			  public SViewPager(Context context, AttributeSet attrs) {
				super(context, attrs);
			  }

			  @Override
			  public boolean onInterceptTouchEvent(MotionEvent ev) {
				if (canScroll) {
				  try {
					return super.onInterceptTouchEvent(ev);
				  } catch (IllegalArgumentException e) {
					e.printStackTrace();
					return false;
				  }
				}
				return false;
			  }

			  @Override
			  public boolean onTouchEvent(MotionEvent event) {
				if (canScroll) {
				  return super.onTouchEvent(event);
				}
				return false;
			  }

			  public void setCanScroll(boolean canScroll) {
				this.canScroll = canScroll;
			  }

			  public void toggleLock() {
				canScroll = !canScroll;
			  }

			  public boolean isCanScroll() {
				return canScroll;
			  }

			}


			第三步 test_main_layout.xml
			<?xml version="1.0" encoding="utf-8"?>
			<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
				xmlns:tl="http://schemas.android.com/apk/res-auto"
				android:orientation="vertical"
				android:layout_width="match_parent"
				android:layout_height="match_parent"
				>

				<com.ydjt.test.weight.SViewPager
					android:id="@+id/tab_viewPager"
					android:layout_width="match_parent"
					android:layout_height="wrap_content"
					android:layout_weight="1"
					android:background="#eee"/>


			  <com.flyco.tablayout.SlidingTabLayout
				  android:id="@+id/tab_tabLayout"
				  android:layout_width="match_parent"
				  android:layout_height="44dp"
				  android:background="@color/color_FF6767"
				  tl:tl_indicator_color="@color/color_ff7373"
				  tl:tl_indicator_height="2dp"
				  tl:tl_indicator_width="100dp"
				  tl:tl_indicator_width_equal_title="true"
				  tl:tl_tab_padding="5dp"
				  tl:tl_tab_space_equal="true"
				  tl:tl_textSelectColor="@color/color_FF6767"
				  tl:tl_textUnselectColor="@color/keyguard_text_color_decline"
				  tl:tl_textsize="18sp"
				  tl:tl_underline_color="#1A000000"
				  tl:tl_underline_height="1dp" />

			</LinearLayout>
		
			第四步 XXX_Fragment.java
			public class XXX_Fragment extends Fragment {
				
			  @Override protected int getLayoutId() {
				return 0;
			  }

			  @Override protected void initView() {

			  }

			  @Override public void onHandlerMessages(Message message, Context mContext) {

			  }
			}
			
			第五步 TestMainActivity.java
			public class TestMainActivity extends BaseActivity {

			  @BindView(R.id.tab_viewPager) SViewPager tabViewPager;
			  @BindView(R.id.tab_tabLayout) SlidingTabLayout tabTabLayout;

			  @Override protected int layoutId() {
				return R.layout.test_main_layout;
			  }

			  @Override protected void initView() {
				tabViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

				tabViewPager.setCanScroll(false);
				//设置viewpager保留界面不重新加载的页面数量
				tabViewPager.setOffscreenPageLimit(2);
				tabTabLayout.setViewPager(tabViewPager);
				tabViewPager.setCurrentItem(0);
			  }

			  private class MyPagerAdapter extends FragmentPagerAdapter {
				private String[] tabNames = {
				   "页面1",
					"页面2"
				};

				Fragment fragment = null;

				public MyPagerAdapter(FragmentManager fm) {
				  super(fm);
				}

				@Override public int getCount() {
				  return tabNames.length;
				}

				@Override public CharSequence getPageTitle(int position) {
				  return tabNames[position];
				}

				@Override public Fragment getItem(int position) {

				  switch (position) {
					case 0:
					  fragment = new XXX_Fragment();
					  break;
					case 1:
					  fragment = new XXX_Fragment();
					  break;
				  }
				  return fragment;
				}
			  }
			}
			
			具体使用2
			Activity里添加Fragment
			第一步 fragment_testadd_layout.xml
			<?xml version="1.0" encoding="utf-8"?>
			<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
				android:layout_width="match_parent"
				android:layout_height="match_parent"
				android:background="@color/colorAccent"
				android:orientation="vertical">
			  <TextView
				  android:layout_width="wrap_content"
				  android:layout_height="wrap_content"
				  android:layout_centerInParent="true"
				  android:textColor="#ffffff"
				  android:textSize="68dp"
				  android:text="我擦嘞"/>

			</RelativeLayout>
			第二步TestAddFragment.java
			public class TestAddFragment extends Fragment {
			  @Override
			  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
				  @Nullable Bundle savedInstanceState) {
				View view = inflater.inflate(R.layout.fragment_testadd_layout,container,false);
				return view;
			  }
			}
			第三步activity_main.xml
			<?xml version="1.0" encoding="utf-8"?>
			<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
				xmlns:tools="http://schemas.android.com/tools"
				android:layout_width="match_parent"
				android:layout_height="match_parent"
				android:orientation="vertical"
				tools:context=".ui.MainActivity">

			  <FrameLayout
				  android:id="@+id/container"
				  android:layout_width="match_parent"
				  android:layout_height="0dip"
				  android:layout_weight="1"></FrameLayout>
			</LinearLayout>
			第四步MainActivity.java
			public class MainActivity extends AppCompatActivity {
				
			  @Override protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				initFragment();
			  }

			  private void initFragment() {
				Fragment fragment = new TestAddFragment();
				FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
				transaction.add(R.id.container, fragment);
				transaction.commit();
			  }
			}
			
			<4>DialogFragment
			DialogFragment至少需要实现onCreateView或者onCreateDIalog方法中的一个。
			在onCreateView方法即使用定义的xml布局文件展示Dialog。onCreateDialog利用AlertDialog或者Dialog创建出Dialog
			MyDialogFragment.java
			public class MyDialogFragment extends DialogFragment implements android.content.DialogInterface.OnClickListener{

			  @Override
			  public Dialog onCreateDialog(Bundle savedInstanceState) {
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				builder.setTitle("用户申明")
					.setMessage("测试DialogFragment")
					.setPositiveButton("我同意", this)
					.setNegativeButton("不同意", this)
					.setCancelable(false);
				//.show(); // show cann't be use here

				return builder.create();
			  }

			  @Override
			  public void onClick(DialogInterface dialog, int which) {
				// TODO 自动生成的方法存根
				if(which == -1){
				  System.out.println("BUTTON_POSITIVE");
				} else if(which == -2){
				  System.out.println("BUTTON_NEGATIVE");
				}else if(which == -3){
				  System.out.println("BUTTON_NEUTRAL");
				}
			  }
			}
			
			MainActivity.java
			public class MainActivity extends AppCompatActivity {

			  @Override protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				//initFragment();

				MyDialogFragment myDialogFragment = new MyDialogFragment();
				myDialogFragment.show(getSupportFragmentManager(), "dsa");
			  }
			}

		3).Intent
			a.Intent的概念
			<1>Android中提供了Intent机制来协助应用间的交互与通讯；或者采用更准确的说法是，Intent不仅可用于应用程序之间，也可用于应用程序内部的activity, service和broadcast receiver之间的交互。
			<2>Intent是一种运行时绑定（runtime binding)机制，它能在程序运行的过程中连接两个不同的组件。通过Intent，你的程序可以向Android表达某种请求或者意愿，Android会根据意愿的内容选择适当的组件来响应。
			activity、service和broadcast receiver之间是通过Intent进行通信的，而另外一个组件Content Provider本身就是一种通信机制，不需要通过Intent。
			<3>对于向这三种组件发送intent有不同的机制：
			使用Context.startActivity() 或 Activity.startActivityForResult()，传入一个intent来启动一个activity。使用 Activity.setResult()，传入一个intent来从activity中返回结果。
			将intent对象传给Context.startService()来启动一个service或者传消息给一个运行的service。将intent对象传给 Context.bindService()来绑定一个service。
			将intent对象传给 Context.sendBroadcast()，Context.sendOrderedBroadcast()，或者Context.sendStickyBroadcast()等广播方法，则它们被传给 broadcast receiver。
			b.Intent的结构
			<1>ComponentName (组件名)
			处理Intent 的组件名称。此字段是一个 ComponentName object---它是目标的组件的完整限定名（包名+类名） 例如： “com.android,.test.TestActivity” .
			该字段是可选的。如果设置了此字段，那么 Intent Object 将会被传递到这个组件名所对应的类的实例中。 如果没有设置，Android 会用 Intent object 中的其它信息去定位到一个合适的目标组件中。 （称之为 : Intent 解析。。。这个稍后会讲到）
			设置Component name 可以通过 setComponent() , setClass() 或者 setClassName()进行设置。 可以通过 getComponent() 进行读取
			<2>Action
			一个字符串，代表要执行的动作。 -- 或者，对于 broadcase intents 来说，表示正在发生，并且被报告的动作。Intent 类中 定义了许多动作常量。 如下：
			例如：
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:"+ mobile));
			startActivity(intent);
			ACTION_MAIN：Android Application的入口，每个android应用必须且只能包含一个此类型的Action声 明。　 
			ACTION_VIEW：系统根据不同的Data类型，通过已注册的对应Application显示数据。 
			ACTION_EDIT：系统根据不同的Data类型，通过已注册的对应Application编辑示数据。　 
			ACTION_DIAL：打开系统默认的拨号程序，如果Data中设置了电话号码，则自动在拨号程序中输入此号码。　 
			ACTION_CALL：直接呼叫Data中所带的号码。　 
			ACTION_ANSWER：接听来电。　 
			ACTION_SEND：由用户指定发送方式进行数据发送操作。 
			ACTION_SENDTO：系统根据不同的Data类型，通过已注册的对应Application进行数据发送操作。　 
			ACTION_BOOT_COMPLETED：Android系统在启动完毕后发出带有此Action的广播（Broadcast）。　 
			ACTION_TIME_CHANGED：Android系统的时间发生改变后发出带有此Action的广播（Broadcast）。　 
			ACTION_PACKAGE_ADDED：Android系统安装了新的Application之后发出带有此Action的广播（Broadcast）。　 
			ACTION_PACKAGE_CHANGED：Android系统中已存在的Application发生改变之后（如应用更新操作）发出带有此Action的广播（Broadcast）。　 
			ACTION_PACKAGE_REMOVED：卸载了Android系统已存在的Application之后发出带有此Action的广播（Broadcast）。
			<3>Category(类别)
			一个字符串， 包含了处理该Intent的组件的种类信息, 起着对action的补充说明作用.
			一个Intent对象可以有任意多个 category。和action 一样， 在Intent class 中也定义了几个 category 常量。
			<activity  
            android:name=".MainActivity"  
	            android:label="@string/app_name" >  
	            <intent-filter>  
	                <action android:name="android.intent.action.MAIN" />  
	                <category android:name="android.intent.category.LAUNCHER"/>  
	                <category android:name="android.intent.category.HOME" />  
	            </intent-filter>  
	        </activity> 
			如下：
			CATEGORY_DEFAULT：Android系统中默认的执行方式，按照普通Activity的执行方式执行。　 
			CATEGORY_HOME：设置该组件为Home Activity。 
			CATEGORY_PREFERENCE：设置该组件为Preference。　 
			CATEGORY_LAUNCHER：设置该组件为在当前应用程序启动器中优先级最高的Activity，通常为入口ACTION_MAIN配合使用。　 
			CATEGORY_BROWSABLE：设置该组件可以使用浏览器启动。　 
			CATEGORY_GADGET：设置该组件可以内嵌到另外的Activity中。
			<4>Data(数据)：URI+Type
			Data属性有两部分构成： 数据URI 和 数据MIME type 。 action的定义往往决定了data该如何定义。 
			例如： 如果 一个Intent的 action 为 ACTION_EDIT 那么它对应的data 应该包含待编辑的数据的URI . 
			如果一个action 为：ACTION_CALL ，那么data 应该为 tel: 电话号码的URI . 
			类似的， 如果action 为 ACTION_VIEW 那么data 应该为： http: URI ， 接收到的activity 将会下载并显示相应的数据。
			当一个Intent 和 有能力处理此Intent的组件进行匹配时， 除了 data的URI以外，了解data的类型（MIME Type）也很重要。 
			例如： 一个显示图片的组件 不应该去播放声音文件。
			许多情况下，data type 可以从URI中推测出。 尤其是： URI = content: URIs这时候数据通常是位于本设备上而且是由某个content provider来控制的。即便如此，我们仍然可以明确的在 Intent object上设置一个 data type. setData() 方法只能设置URI, setType() 设置MIME type, setDataAndType() 可以对二者都进行设置， 获取URI 和 data type 可分别调用 getData() 和 getType() 方法。
			Demo:
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:"+ mobile));
			startActivity(intent);
			其中intent.setData表示获取数据
			Uri.parse("tel:"+ mobile));
			这里的parse方法返回的是一个URI类型，通过这个URI可以访问一个网络上或者是本地的资源，android中指定了uri是tel:+moblie是对应的打电话的资源。
			<5>Flag(标志)
			有各种各样的标志，许多指示Android系统如何去启动一个活动（例如，活动应该属于那个任务）和启动之后如何对待它（例如，它是否属于最近的活动列表）。
			所有这些标志都定义在Intent类中。
			intent.setFlag();
			intent.addFlag();
			常用的Task
			Intent的常用Flag参数：
			FLAG_ACTIVITY_CLEAR_TOP：
			例如现在的栈情况为：A B C D 。D此时通过intent跳转到B，如果这个intent添加FLAG_ACTIVITY_CLEAR_TOP标记，则栈情况变为：A B。如果没有添加这个标记，则栈情况将会变成：A B C D B。也就是说，如果添加了FLAG_ACTIVITY_CLEAR_TOP标记，并且目标Activity在栈中已经存在，则将会把位于该目标activity之上的activity从栈中弹出销毁。这跟上面把B的Launch mode设置成singleTask类似。
			FLAG_ACTIVITY_NEW_TASK：
			例如现在栈1的情况是：A B C。C通过intent跳转到D，并且这个intent添加了FLAG_ACTIVITY_NEW_TASK标记，如果D这个Activity在Manifest.xml中的声明中添加了Task affinity，并且和栈1的affinity不同，系统首先会查找有没有和D的Task affinity相同的task栈存在，如果有存在，将D压入那个栈，如果不存在则会新建一个D的affinity的栈将其压入。如果D的Task affinity默认没有设置，或者和栈1的affinity相同，则会把其压入栈1，变成：A B C D，这样就和不加FLAG_ACTIVITY_NEW_TASK标记效果是一样的了。注意如果试图从非activity的非正常途径启动一个activity，比如从一个service中启动一个activity，则intent必须要添加FLAG_ACTIVITY_NEW_TASK标记。
			FLAG_ACTIVITY_NO_HISTORY
			例如现在栈情况为：A B C。C通过intent跳转到D，这个intent添加FLAG_ACTIVITY_NO_HISTORY标志，则此时界面显示D的内容，但是它并不会压入栈中。如果按返回键，返回到C，栈的情况还是：A B C。如果此时D中又跳转到E，栈的情况变为：A B C E，此时按返回键会回到C，因为D根本就没有被压入栈中。
			<6>Extra(额外数据)
			为键-值对形式的附加信息. 例如ACTION_TIMEZONE_CHANGED的intent有一个"time-zone"附加信息来指明新的时区, 而ACTION_HEADSET_PLUG有一个"state"附加信息来指示耳机是被插入还是被拔出.
			intent对象有一系列put...()和set...()方法来设定和获取附加信息. 这些方法和Bundle对象很像. 事实上附加信息可以使用putExtras()和getExtras()作为Bundle来读和写.
			intent.putExtra("键", "值");
			传递对象
			实现Serializable接口 
			实现Parcelable接口 
			对象必须实现这两种接口才能传递
			
			传递数组
			** 两个Activity之间进行List Object传输 */
			Intent myIntent = new Intent();
			ArrayList<Person> personList = new ArrayList<Person>();
			 
			Parcel parcel = Parcel.obtain();
			Person person = Person.CREATOR.createFromParcel(parcel);
			person.setId(10);
			person.setName("bingbing");
			personList.add(person);
			parcel.recycle();
			 
			myIntent.putParcelableArrayListExtra("list", personList);
			myIntent.setClass(this, SecondActivity.class);
			startActivity(myIntent);

			ArrayList<Person> list = getIntent().getParcelableArrayListExtra("list");
			int fistOneId = list.get(0).getId();
			Log.i(TAG, "id : " + fistOneId);
			
			c.显示Intent和隐式Intent
			<1>显式Intent：Intent的意图非常明显
			Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
             //启动跳转   start goto 
             startActivity(intent);
			<2>隐式Intent的比较含蓄，他并不会明确指出将要启动的活动，而是指定一系列更为抽象的action和category等信息，然后由系统去分析intent的意图，最后找到合适的活动去启动。
			
			 <activity android:name=".ui.SecondActivity"><!--修改SecondActivity的启动方式   alter SecondActivity start mode-->
			  <intent-filter>
				<!--添加action标签，说明此活动只能被这个action启动-->
				<!--add action label ,explain activity only start by this action -->
				<action android:name="com.onepoint.r.myapplication.ui.ACTION_START"/>
				<!--添加category标签，两个标签同时满足，才能启动活动，但category.DEFAULT为默认category，因此启动时不需要指定-->
				<!--add category label,only two label satisfy,this activity can start,but category.DEFAULT is default,so not need point out-->
				<category android:name="android.intent.category.DEFAULT"/>
			  </intent-filter>
			</activity>
			
			//实现跳转
			// achieve goto
			//创建Intent对象 参数1：启动什么样的action
			// create Intent object (param1: start what action)
			Intent intent = new Intent("com.onepoint.r.myapplication.ui.ACTION_START");
			startActivity(intent);
			
		4).DiaLog
			a.基本介绍
			Android提供了丰富的Dialog函数，本文介绍最常用的8种对话框的使用方法，包括普通（包含提示消息和按钮）、列表、单选、多选、等待、进度条、编辑、自定义等多种形式。
			有时，我们希望在对话框创建或关闭时完成一些特定的功能，这需要复写Dialog的create()、show()、dismiss()等方法，将在第3部分介绍。
			系统自带的dialog基本上用AlertDialog类 
　			AlertDialog继承自Dialog类，对于Android内置的AlterDialog，它可以包含一个标题、一个内容消息或者一个选择列表、最多三个按钮。
			而创建AlterDialog推荐使用它的一个内部类AlterDialog.Builder创 建。
			使用Builder对象，可以设置AlterDialog的各种属性，最后通过Builder.create()就可以得到AlterDialog对 象，如果只是还需要显示这个AlterDialog，一般可以直接使用Builder.show()方法，它会返回一个AlterDialog对象，并且 显示它。 
			b.几种Dialog
			<1>普通的Dialog
			 /**
			   * 普通dialog
			   */
			  private void showAlterDialog(){
				final AlertDialog.Builder alterDiaglog = new AlertDialog.Builder(FirstActivity.this);
				alterDiaglog.setIcon(R.mipmap.ic_launcher);//图标
				alterDiaglog.setTitle("简单的dialog");//文字
				alterDiaglog.setMessage("生存还是死亡");//提示消息
				//积极的选择
				alterDiaglog.setPositiveButton("生存", new DialogInterface.OnClickListener() {
				  @Override
				  public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(FirstActivity.this,"点击了生存", Toast.LENGTH_SHORT).show();
				  }
				});
				//消极的选择
				alterDiaglog.setNegativeButton("死亡", new DialogInterface.OnClickListener() {
				  @Override
				  public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(FirstActivity.this,"点击了死亡",Toast.LENGTH_SHORT).show();
				  }
				});
				//中立的选择
				alterDiaglog.setNeutralButton("不生不死", new DialogInterface.OnClickListener() {
				  @Override
				  public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(FirstActivity.this,"点击了不生不死",Toast.LENGTH_SHORT).show();
				  }
				});

				//显示
				alterDiaglog.show();
			  }
			<2>列表Dialog
			 /**
			   * 列表Dialog
			   */
			  private void showListDialog(){
				final String[] items = {"我擦","我干","沃日","呵呵哒","去你妹"};
				AlertDialog.Builder listDialog = new AlertDialog.Builder(FirstActivity.this);
				listDialog.setIcon(R.mipmap.ic_launcher);//图标
				listDialog.setTitle("我就是个列表Dialog");
				listDialog.setItems(items, new DialogInterface.OnClickListener() {
				  @Override
				  public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(FirstActivity.this,"点击了"+items[which],Toast.LENGTH_SHORT).show();
				  }
				});
				listDialog.show();
			  }
			  
			<3>单选Dialog
			 /**
			   * 单选Dialog
			   */
			  int choice;
			  private void showSingDialog(){
				final String[] items = {"我是1","我是2","我是3"};
				AlertDialog.Builder singleChoiceDialog = new AlertDialog.Builder(context);
				singleChoiceDialog.setIcon(R.mipmap.ic_launcher);
				singleChoiceDialog.setTitle("我是单选Dialo");
				//第二个参数是默认的选项
				singleChoiceDialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
				  @Override
				  public void onClick(DialogInterface dialog, int which) {
					choice= which;
				  }
				});
				singleChoiceDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				  @Override
				  public void onClick(DialogInterface dialog, int which) {
					if (choice!=-1){
					  Toast.makeText(context,
						  "你选择了" + items[choice],
						  Toast.LENGTH_SHORT).show();
					}
				  }
				});
				singleChoiceDialog.show();
			  }
			<4>多选Dialog
			 /**
			   * 多选对话框
			   */
			  ArrayList<Integer> choices= new ArrayList<>();
			  private void showMultiChoiceDialog(){
				final String[] items = {"我是1","我是2","我是3"};
				//设置默认选择都是false
				final boolean initchoices[] = {false,false,false};
				choices.clear();
				AlertDialog.Builder multChoiceDialog = new AlertDialog.Builder(context);
				multChoiceDialog.setIcon(R.mipmap.ic_launcher);
				multChoiceDialog.setTitle("我是个多选Dialog");
				multChoiceDialog.setMultiChoiceItems(items, initchoices, new DialogInterface.OnMultiChoiceClickListener() {
				  @Override
				  public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					if (isChecked){
					  choices.add(which);
					}else {
					  choices.remove(which);
					}
				  }
				});
				multChoiceDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				  @Override
				  public void onClick(DialogInterface dialog, int which) {
					int size = choices.size();
					String str = "";
					for(int i = 0;i<size;i++){
					  str+=items[choices.get(i)]+"";
					}
					Toast.makeText(context,
						"你选中了" + str,
						Toast.LENGTH_SHORT).show();
				  }
				});
				multChoiceDialog.show();
			  }
			
			<5>等待Dialog
			等待Dialog具有屏蔽其他控件的交互能力 
			@setCancelable 为使屏幕不可点击，设置为不可取消(false)　 
			下载等事件完成后，主动调用函数关闭该Dialog 
			 /**
			   * 5S等待Dialog
			   */
			  private void showProgressDialog(){
				final ProgressDialog progressDialog = new ProgressDialog(this);
				progressDialog.setTitle("我是个等待的Dialog");
				progressDialog.setMessage("等待中");
				progressDialog.setIndeterminate(true);
				progressDialog.setCancelable(false);
				progressDialog.show();
				new Thread(new Runnable() {
				  @Override public void run() {
					try {
					  Thread.sleep(5000);
					} catch (InterruptedException e) {
					  e.printStackTrace();
					}
					progressDialog.cancel();
				  }
				}).start();
			  }
			<6>进度条Dialog
			 /**
			   * 进度条Dialog
			   */
			  private void showWhiteDialog(){
				/* @setProgress 设置初始进度
				 * @setProgressStyle 设置样式（水平进度条）
				 * @setMax 设置进度最大值
				 */
				final int Max = 100;
				final ProgressDialog progressDialog = new ProgressDialog(context);
				progressDialog.setProgress(0);
				progressDialog.setIcon(R.mipmap.ic_launcher);
				progressDialog.setTitle("我是一个进度条Dialog");
				progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				progressDialog.setMax(Max);
				progressDialog.show();
				/**
				 * 开个线程
				 */
				new Thread(new Runnable() {
				  @Override
				  public void run() {
					int p = 0;
					while (p < Max){
					  try {
						Thread.sleep(100);
						p++;
						progressDialog.setProgress(p);
					  }catch (InterruptedException e){
						e.printStackTrace();
					  }
					}
					progressDialog.cancel();//达到最大就消失
				  }

				}).start();
			  }
			<7>自定义Dialog
			先自定义style
			    <style name="MyDialog" parent="android:Theme.Dialog">
				<!-- 背景颜色及透明程度 -->
				<item name="android:windowBackground">@android:color/transparent</item>
				<!-- 是否半透明 -->
				<item name="android:windowIsTranslucent">false</item>
				<!-- 是否没有标题 -->
				<item name="android:windowNoTitle">true</item>
				<!-- 是否浮现在activity之上 -->
				<item name="android:windowIsFloating">true</item>
				<!-- 是否背景模糊 -->
				<item name="android:backgroundDimEnabled">false</item>
				<!-- 设置背景模糊的透明度-->
				<item name="android:backgroundDimAmount">0.5</item>
			  </style>
			 
			然后自定义Dialog
			public class MyDialog extends Dialog implements View.OnClickListener {

			  //在构造方法里提前加载了样式
			  private Context context;//上下文
			  private int layoutResID;//布局文件id
			  private int[] listenedItem;//监听的控件id

			  public MyDialog(Context context, int layoutResID, int[] listenedItem) {
				super(context, R.style.MyDialog);//加载dialog的样式
				this.context = context;
				this.layoutResID = layoutResID;
				this.listenedItem = listenedItem;
			  }

			  @Override protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				//提前设置Dialog的一些样式
				Window dialogWindow = getWindow();
				dialogWindow.setGravity(Gravity.CENTER);//设置dialog显示居中
				//dialogWindow.setWindowAnimations();设置动画效果
				setContentView(layoutResID);

				WindowManager windowManager = ((Activity) context).getWindowManager();
				Display display = windowManager.getDefaultDisplay();
				WindowManager.LayoutParams lp = getWindow().getAttributes();
				lp.width = display.getWidth() * 4 / 5;// 设置dialog宽度为屏幕的4/5
				getWindow().setAttributes(lp);
				setCanceledOnTouchOutside(true);//点击外部Dialog消失
				//遍历控件id添加点击注册
				for (int id : listenedItem) {
				  findViewById(id).setOnClickListener(this);
				}
			  }

			  public void setText(int id, String text){
				((TextView)findViewById(id)).setText(text);
			  }

			  private OnCenterItemClickListener listener;

			  public interface OnCenterItemClickListener {
				void OnCenterItemClick(MyDialog dialog, View view);
			  }

			  //很明显我们要在这里面写个接口，然后添加一个方法
			  public void setOnCenterItemClickListener(OnCenterItemClickListener listener) {
				this.listener = listener;
			  }

			  @Override public void onClick(View v) {
				dismiss();//注意：我在这里加了这句话，表示只要按任何一个控件的id,弹窗都会消失，不管是确定还是取消。
				listener.OnCenterItemClick(this, v);
			  }
			}
			
			布局layout_dialog.xml
			<?xml version="1.0" encoding="utf-8"?>
			<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
				android:layout_width="match_parent"
				android:layout_height="match_parent"
				>
			  <LinearLayout
				  android:layout_width="match_parent"
				  android:layout_height="300dp"
				  android:layout_centerInParent="true"
				  android:orientation="vertical"
				  android:background="#ed093a"
				  >

				<TextView
					android:id="@+id/dialog_text"
					android:layout_width="match_parent"
					android:layout_height="wrap_content"
					android:gravity="center"
					android:text="我是内容"
					android:textColor="#fff"
					/>


				<TextView
					android:id="@+id/dialog_btn"
					android:layout_width="match_parent"
					android:layout_height="match_parent"
					android:gravity="center"
					android:text="自定义加强版的dialog"
					android:textColor="#fff"
					/>
			  </LinearLayout>
			</RelativeLayout>
			
			Activity
			////定义一个自己的dialog

			  public void showMyDialog(){

				//实例化自定义的dialog
				MyDialog myDialog = new MyDialog(this,R.layout.layout_dialog,new int[]{R.id.dialog_btn});
				//绑定点击事件
				myDialog.setOnCenterItemClickListener(this);
				//显示
				myDialog.show();
				myDialog.setText(R.id.dialog_text, "fscdayhbnjmk,");
			  }

			  @Override public void OnCenterItemClick(MyDialog dialog, View view) {
				switch (view.getId()){
				  case R.id.dialog_btn:
					Toast.makeText(getApplicationContext(),"点击了",Toast.LENGTH_SHORT).show();

					break;
				}
			  }
			  
		5).Menu
		Android的菜单分为三种类型：选项菜单(Option Menu)、上下文菜单(Context Menu)、子菜单(Sub Menu)
		注：其中，Sub Menu就是将功能相同的操作分组显示，他作用在OptionsMenu上，是OptionsMenu的二级菜单
		
		a.选项菜单(OptionMenu)
		<1>通过在XML文件中添加控件来实现
		R.menu.main.xml
		<menu xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			tools:context="com.jiapeng.munedemo.MainActivity" >

		  <item
			  android:id="@+id/mune_enter"
			  android:orderInCategory="100"
			  android:title="登录"
			  app:showAsAction="never"/>
		  <item
			  android:id="@+id/mune_setting"
			  android:orderInCategory="100"
			  android:title="设置"
			  app:showAsAction="never"/>
		  <item
			  android:id="@+id/mune_out"
			  android:orderInCategory="100"
			  android:title="退出"
			  app:showAsAction="never"/>
		</menu>
		
		然后在Activity里添加如下代码
		 @Override
		  public boolean onCreateOptionsMenu(Menu menu) {
			//导入菜单布局
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		  }

		  public boolean onOptionsItemSelected(MenuItem item) {
			//创建菜单项的点击事件
			switch (item.getItemId()) {
			  case R.id.mune_enter:
				Toast.makeText(this, "点击了登录", Toast.LENGTH_SHORT).show();
				break;
			  case R.id.mune_setting:
				Toast.makeText(this, "点击了设置", Toast.LENGTH_SHORT).show();

				break;
			  case R.id.mune_out:
				Toast.makeText(this, "点击了退出", Toast.LENGTH_SHORT).show();
				break;

			  default:
				break;
			}

			return super.onOptionsItemSelected(item);
		  }
		  
		<2>通过动态代码实现
		  @Override
		  public boolean onCreateOptionsMenu(Menu menu) {
			// groupId--1:分组的id;itemId--100:菜单项的id;order--1:菜单项排序用的;title--"菜单1":菜单名称;
			MenuItem item = menu.add(1, 100, 1, "菜单项");
			item.setTitle("我是一个菜单");
			// 在API>=11时，是不显示图标的
			menu.add(1, 101, 1, "登录");
			menu.add(1, 102, 1, "设置");
			menu.add(1, 103, 1, "退出");

			return true;
		  }

		  public boolean onOptionsItemSelected(MenuItem item) {
			// 创建菜单项的点击事件
			switch (item.getItemId()) {
			  case 100:
				Toast.makeText(this, "你点击了我是一个菜单", Toast.LENGTH_SHORT).show();
				break;
			  case 101:
				Toast.makeText(this, "你点击了登录", Toast.LENGTH_SHORT).show();
				break;
			  case 102:
				Toast.makeText(this, "你点击了设置", Toast.LENGTH_SHORT).show();
				break;
			  case 103:
				Toast.makeText(this, "你点击了退出", Toast.LENGTH_SHORT).show();
				break;

			  default:
				break;
			}

			return super.onOptionsItemSelected(item);
		  }
		b.上下文菜单(ContextMenu)
		ContextMenu与OptionMenu的区别：
		<1>OptionMenu对应的是activity，一个activity只能拥有一个选项菜单；
		<2>ContextMenu对应的是view，每个view都可以设置上下文菜单；
		<3>一般情况下ContextMenu常用语ListView或者GridView

		实现步骤：
		<1>首先给View注册上下文菜单registerForContextMenu()
		this.registerForContextMenu(contextView);
		<2>添加上下文菜单的内容onCreateContextMenu()
		ListView + ContextMenu Demo
		R.menu.main.xml
		<menu xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:app="http://schemas.android.com/apk/res-auto"
			xmlns:tools="http://schemas.android.com/tools"
			tools:context=".ui.MainActivity" >

		  <item
			  android:id="@+id/mune_enter"
			  android:orderInCategory="100"
			  android:title="登录"
			  app:showAsAction="never"/>
		  <item
			  android:id="@+id/mune_setting"
			  android:orderInCategory="100"
			  android:title="设置"
			  app:showAsAction="never"/>
		  <item
			  android:id="@+id/mune_out"
			  android:orderInCategory="100"
			  android:title="退出"
			  app:showAsAction="never"/>
		</menu>
		
		布局文件
		<?xml version="1.0" encoding="utf-8"?>
		<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
			xmlns:tools="http://schemas.android.com/tools"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:orientation="vertical"
			tools:context=".ui.MainActivity"
			>

			<ListView
				android:id="@+id/menu_list"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				>
			</ListView>
		</LinearLayout>
		
		public class MainActivity extends AppCompatActivity {

		  ListView listview;
		  ArrayAdapter<String> adapter;

		  @Override protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			//initFragment();

			//MyDialogFragment myDialogFragment = new MyDialogFragment();
			//myDialogFragment.show(getSupportFragmentManager(), "dsa");

			showListView();
			// 注册上下文菜单
			this.registerForContextMenu(listview);

		  }


		  /**
		   * 加载数据
		   */
		  private void showListView() {
			listview =  findViewById(R.id.menu_list);
			adapter = new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_1, getDate());
			listview.setAdapter(adapter);
		  }

		  /**
		   * 创建数据源
		   *
		   * @return list
		   */
		  private ArrayList<String> getDate() {
			ArrayList<String> list = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
			  list.add("菜单" + i);
			}
			return list;
		  }

		  /**
		   * 添加上下文菜单的菜单项
		   */
		  public void onCreateContextMenu(ContextMenu menu, View v,
			  ContextMenu.ContextMenuInfo menuInfo) {
			getMenuInflater().inflate(R.menu.main, menu);
			super.onCreateContextMenu(menu, v, menuInfo);
		  }

		  /**
		   * 创建单击事件
		   */
		  public boolean onContextItemSelected(MenuItem item) {
			AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();  //获得AdapterContextMenuInfo,以此来获得选择的listview项目

			Log.d("onContextItemSelected ", adapter.getItem(menuInfo.position));
			switch (item.getItemId()) {
			  case R.id.mune_enter:
				Toast.makeText(this, "点击了登录", Toast.LENGTH_SHORT).show();
				break;
			  case R.id.mune_setting:
				Toast.makeText(this, "点击了设置", Toast.LENGTH_SHORT).show();

				break;
			  case R.id.mune_out:
				Toast.makeText(this, "点击了退出", Toast.LENGTH_SHORT).show();
				break;

			  default:
				break;
			}
			return super.onContextItemSelected(item);
		  }

		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		c.子菜单
		
	2.常用UI组件
		1).Layout布局
		2).ImageView
		3).CardView
		4).其他布局
	3.网络操作
		1).Thread
		2).Handler
		3).AsyncTask
		4).Socket
		5).Http
	4.本地储存操作
		1).SQLite
		2).SharePreferences
		3).SDCard
	5.系统核心组件
		1).AIDL
		2).NDK开发
		3).Application

二、Android进阶篇
	1.进阶技能
		1).兼容性
			a.Android系统适配
			b.屏幕适配
		2).编译插桩技术
			a.AspectJ
			b.ASM
			c.ReDex
		3).跨平台技术
			a.Flutter
			b.ReactNative
	2.性能优化篇
		1).稳定性优化
		2).卡顿优化
		3).启动优化
		4).储存优化
		5).网络优化
		6).耗电量优化
		7).UI性能优化
		8).包体积优化
		9).内存优化
	3.开源项目篇
		1)OkHttp
		2).Retrofit
		3).ReactX
		4).热修复技术和选型
		5).插件化开发
		6).JsBridge框架