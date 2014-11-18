/**
 * 
 */
package com.xiter.igou.ui.base;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.xiter.igou.app.BaseApplication;
import com.xiter.igou.task.BaseAsyncTask.AsyncTaskListener;
import com.xiter.igou.task.DefaultAsyncTask;
import com.xiter.igou.widget.TopBar;

/**
 * Description:TODO
 * 
 * @author liufeihua
 * @date 2014-11-17上午11:58:54
 * @version 1.0
 * 
 */
public class BaseActivity extends Activity implements AsyncTaskListener {

	/**
	 * 请求的路径
	 */
	public String url;
	/**
	 * 请求的参数
	 */
	public Map<String, Object> params = new HashMap<String, Object>();

	/**
	 * 自定义bar
	 */
	public TopBar mTopBar;

	/**
	 * 查询界面存在的id
	 */
	public void findById() {

	}

	/**
	 * 初始化
	 */
	public void initView() {

	}

	/**
	 * 初始化自定义bar
	 */
	public void initBar() {

	}

	/**
	 * 设置布局文件
	 */
	public int setLayout() {
		return 0;
	}

	/**
	 * 日志
	 * 
	 * @param msg
	 */
	protected void log(String msg) {
		Log.d(this.getClass().getName(), msg);
	}

	/**
	 * 异步请求
	 * 
	 * @param task
	 * @param map
	 */
	protected void defaultTask() {
		new DefaultAsyncTask(this, params, url).startTask();
	}

	/**
	 * 异步请求
	 * 
	 * @param task
	 * @param map
	 */
	protected void defaultTask(AsyncTaskListener task, Map<String, Object> map) {
		new DefaultAsyncTask(task, map, url).startTask();
	}

	/**
	 * 异步请求
	 * 
	 * @param task
	 * @param path
	 * @param map
	 */
	protected void defaultTask(AsyncTaskListener task, String path,
			Map<String, Object> map) {
		new DefaultAsyncTask(task, map, path).startTask();
	}

	/**
	 * 获取编辑框值
	 * 
	 * @param str
	 * @return
	 */
	public String getText(EditText str) {
		return str.getText().toString();
	}

	/**
	 * 添加activity到自定义管理器中
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (0 != setLayout()) {
			setContentView(setLayout());
		}
		findById();
		initView();
		initBar();
		getAppContext().addActivity(this);
	}

	/**
	 * 销毁activity
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		getAppContext().finishActivity(this);
	}

	/**
	 * 获取application
	 */
	public BaseApplication getAppContext() {
		return (BaseApplication) getApplication();
	}

	/**
	 * 获取共享
	 * 
	 * @return
	 */
	public SharedPreferences getPrefrence() {

		SharedPreferences pre = getAppContext().getPrefrence();
		return pre;
	}

	/**
	 * toast显示text字符串
	 */
	public void toast(String text) {
		if (text == null) {
			text = "";
		}
		Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	public void taskResult(boolean status, String info, Object data) {

	}

}
