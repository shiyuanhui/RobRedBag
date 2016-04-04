package com.shiyuanhui.robredbag;

import java.io.IOException;
import java.util.List;

import android.accessibilityservice.AccessibilityService;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class RobberService extends AccessibilityService{
	
	private AccessibilityNodeInfo mRootNodeInfo = null;//����������ͼ�Ŀ���

	@Override
	public void onAccessibilityEvent(AccessibilityEvent event) {
		mRootNodeInfo = event.getSource();
		if(mRootNodeInfo == null)
		{
			return;
		}
		//��ǰ�������ݱ仯���ж��Ƿ��к������
		if(event.getEventType() == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED)
		{
			List<AccessibilityNodeInfo> redbaglist = mRootNodeInfo.findAccessibilityNodeInfosByText("΢�ź��");
			if(redbaglist.size() > 0)
			{
				AccessibilityNodeInfo currentInfo = redbaglist.get(redbaglist.size()-1);
				currentInfo.getParent().performAction(AccessibilityNodeInfo.ACTION_CLICK);
				//redbaglist.remove(redbaglist.size()-1);
			}
		}
		if(event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED)
		{
			List<AccessibilityNodeInfo> clickwindowlist = mRootNodeInfo.findAccessibilityNodeInfosByText("����");
			if(clickwindowlist.size() > 0)
			{
				AccessibilityNodeInfo currentInfo = clickwindowlist.get(clickwindowlist.size()-1);
				currentInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
			}
			Runtime runtime = Runtime.getRuntime();//���ز���
			try {
				runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onInterrupt() {
		stopSelf();
	}

}
