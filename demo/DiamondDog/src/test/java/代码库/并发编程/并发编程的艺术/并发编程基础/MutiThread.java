package 代码库.并发编程.并发编程的艺术.并发编程基础;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MutiThread {
	public static void main(String[] args) {
		//获取Java现场管理 MXBean
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		//获取线程和线程堆栈信息
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
		//打印线程Id 和线程name
		for(ThreadInfo threadInfo : threadInfos){
			System.err.println("Thread ID："+threadInfo.getThreadId()+" Name："+threadInfo.getThreadName());
		}
	}
}
