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
			<4>
			
			
			
			
			
			
			
		4).DiaLog
		5).Menu
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