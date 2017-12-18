/**
 * 
 */
package com.lorenzocipriani.scrap;

import java.lang.management.BufferPoolMXBean;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.PlatformLoggingMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.List;
import java.util.Map;

/**
 * @author lorencip
 *
 */
public class ManagementInterface {

	// A Java virtual machine has a single instance of the following management
	// interfaces:
	private static ClassLoadingMXBean classMxb;
	private static MemoryMXBean memoryMxb;
	private static ThreadMXBean threadMxb;
	private static RuntimeMXBean runtimeMxb;
	private static OperatingSystemMXBean systemMxb;
	private static PlatformLoggingMXBean loggingMxb;

	// A Java virtual machine has zero or a single instance of the following
	// management interfaces:
	private static CompilationMXBean compilationMxb;

	// A Java virtual machine may have one or more instances of the following
	// management interfaces:
	private static List<GarbageCollectorMXBean> garbageMxb;
	private static List<MemoryManagerMXBean> memoryManagerMxb;
	private static List<MemoryPoolMXBean> memoryPoolMxb;
	private static List<BufferPoolMXBean> bufferPoolMxp;

	public static void setClassMxb(ClassLoadingMXBean classMxb) {
		ManagementInterface.classMxb = classMxb;
	}

	public static void setMemoryMxb(MemoryMXBean memoryMxb) {
		ManagementInterface.memoryMxb = memoryMxb;
	}

	public static void setThreadMxb(ThreadMXBean threadMxb) {
		ManagementInterface.threadMxb = threadMxb;
	}

	public static void setRuntimeMxb(RuntimeMXBean runtimeMxb) {
		ManagementInterface.runtimeMxb = runtimeMxb;
	}

	public static void setSystemMxb(OperatingSystemMXBean systemMxb) {
		ManagementInterface.systemMxb = systemMxb;
	}

	public static void setLoggingMxb(PlatformLoggingMXBean loggingMxb) {
		ManagementInterface.loggingMxb = loggingMxb;
	}

	public static void setCompilationMxb(CompilationMXBean compilationMxb) {
		ManagementInterface.compilationMxb = compilationMxb;
	}

	public static void setGarbageMxb(List<GarbageCollectorMXBean> garbageMxb) {
		ManagementInterface.garbageMxb = garbageMxb;
	}

	public static void setMemoryManagerMxb(List<MemoryManagerMXBean> memoryManagerMxb) {
		ManagementInterface.memoryManagerMxb = memoryManagerMxb;
	}

	public static void setMemoryPoolMxb(List<MemoryPoolMXBean> memoryPoolMxb) {
		ManagementInterface.memoryPoolMxb = memoryPoolMxb;
	}

	public static void setBufferPoolMxp(List<BufferPoolMXBean> bufferPoolMxp) {
		ManagementInterface.bufferPoolMxp = bufferPoolMxp;
	}

	public static void showClassLoading() {
		System.out.println("\n\nSHOW: ClassLoadingMXBean");
		System.out.println("Unique MXBean ID within an MBeanServer is: " + classMxb.getObjectName().toString());
		System.out.println(
				"Classes currently loaded in the jvm: " + new Integer(classMxb.getLoadedClassCount()).toString());
		System.out.println("Classes loaded since the jvm has started: "
				+ new Long(classMxb.getTotalLoadedClassCount()).toString());
		System.out.println(
				"Classes unloaded since the jvm has started: " + new Long(classMxb.getUnloadedClassCount()).toString());
		System.out.println("Verbose output for the class loading system is enabled: "
				+ new Boolean(classMxb.isVerbose()).toString());
	}

	public static void showMemory() {
		System.out.println("\n\nSHOW: MemoryMXBean");
		System.out.println("Unique MXBean ID within an MBeanServer is: " + memoryMxb.getObjectName().toString());

		System.out.println("Current memory usage of the HEAP used for object allocation: "
				+ memoryMxb.getHeapMemoryUsage().toString());
		System.out.println("Heap - bytes committed for the jvm to use: "
				+ new Long(memoryMxb.getHeapMemoryUsage().getCommitted()).toString());
		System.out.println("Heap - bytes the jvm initially requests from the OS: "
				+ new Long(memoryMxb.getHeapMemoryUsage().getInit()).toString());
		System.out.println("Heap - maximum amount of bytes that can be used: "
				+ new Long(memoryMxb.getHeapMemoryUsage().getMax()).toString());
		System.out.println(
				"Heap - bytes of used memory: " + new Long(memoryMxb.getHeapMemoryUsage().getUsed()).toString());

		System.out.println(
				"Current memory usage of NON-HEAP used by the jvm: " + memoryMxb.getNonHeapMemoryUsage().toString());
		System.out.println("Non-Heap - bytes committed for the jvm to use: "
				+ new Long(memoryMxb.getNonHeapMemoryUsage().getCommitted()).toString());
		System.out.println("Non-Heap - bytes the jvm initially requests from the OS: "
				+ new Long(memoryMxb.getNonHeapMemoryUsage().getInit()).toString());
		System.out.println("Non-Heap - maximum amount of bytes that can be used: "
				+ new Long(memoryMxb.getNonHeapMemoryUsage().getMax()).toString());
		System.out.println(
				"Non-Heap - bytes of used memory: " + new Long(memoryMxb.getNonHeapMemoryUsage().getUsed()).toString());

		System.out.println("Approximate number of objects for which finalization is pending: "
				+ new Integer(memoryMxb.getObjectPendingFinalizationCount()).toString());
		System.out.println(
				"Verbose output for the memory system is enabled: " + new Boolean(memoryMxb.isVerbose()).toString());
	}

	public static void showThread() {
		System.out.println("\n\nSHOW: ThreadMXBean");
		System.out.println("Unique MXBean ID within an MBeanServer is: " + threadMxb.getObjectName().toString());

		long[] allThreadIds = threadMxb.getAllThreadIds();
		System.out.print("Live threads: " + new Integer(threadMxb.getThreadCount()).toString() + " -");
		for (long threadId : allThreadIds) {
			System.out.print(" " + new Long(threadId).toString());
		}
		System.out.println("");

		System.out.println(
				"Current number of live daemon threads: " + new Integer(threadMxb.getDaemonThreadCount()).toString());
		System.out.println("Peak live thread count since jvm start or peak reset: "
				+ new Integer(threadMxb.getPeakThreadCount()).toString());
		System.out.println("Threads created & started since jvm started: "
				+ new Long(threadMxb.getTotalStartedThreadCount()).toString());

		boolean lockedMonitors = threadMxb.isCurrentThreadCpuTimeSupported();
		boolean lockedSynchronizers = threadMxb.isSynchronizerUsageSupported();

		ThreadInfo[] threadDump = threadMxb.dumpAllThreads(lockedMonitors, lockedSynchronizers);
		System.out.println("");
		for (ThreadInfo thread : threadDump) {
			// System.out.println("\nThread ID and name: [" + new
			// Long(thread.getThreadId()).toString() + "] " + thread.getThreadName());
			System.out.println("Thread Info: " + thread.toString());
		}
	}

	public static void showRuntime() {
		System.out.println("\n\nSHOW: RuntimeMXBean");
		System.out.println("Unique MXBean ID within an MBeanServer is: " + runtimeMxb.getObjectName().toString());

		System.out.println("Running JVM name: " + runtimeMxb.getName());
		System.out.println("Running JVM start time: " + new Long(runtimeMxb.getStartTime()).toString());
		System.out.println("Running JVM uptime: " + new Long(runtimeMxb.getUptime()).toString());
		System.out.println("JVM specification name, vendor, version: " + runtimeMxb.getSpecName() + ", "
				+ runtimeMxb.getSpecVendor() + ", " + runtimeMxb.getSpecVersion());
		System.out.println("JVM implementation name, vendor, version: " + runtimeMxb.getVmName() + ", "
				+ runtimeMxb.getVmVendor() + ", " + runtimeMxb.getVmVersion());
		System.out.println("JVM management interface specification version: " + runtimeMxb.getManagementSpecVersion());

		Map<String, String> systemProperties = runtimeMxb.getSystemProperties();
		System.out.println("\nSYSTEM PROPERTIES");
		for (Map.Entry<String, String> entry : systemProperties.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	public static void showOperatingSystem() {
		System.out.println("\n\nSHOW: OperatingSystemMXBean");
		System.out.println("Unique MXBean ID within an MBeanServer is: " + systemMxb.getObjectName().toString());

		System.out.println("Operating system architecture: " + systemMxb.getArch());
		System.out.println(
				"Processors available to the jvm: " + new Integer(systemMxb.getAvailableProcessors()).toString());
		System.out.println("Operating system name: " + systemMxb.getName());
		System.out.println(
				"System load average for the last minute: " + new Double(systemMxb.getSystemLoadAverage()).toString());
		System.out.println("Operating system version: " + systemMxb.getVersion());
	}

	public static void showPlatformLogging() {
		System.out.println("\n\nSHOW: PlatformLoggingMXBean");
		System.out.println("Unique MXBean ID within an MBeanServer is: " + loggingMxb.getObjectName().toString());

		List<String> loggerNames = loggingMxb.getLoggerNames();
		System.out.println("List of the currently registered logger names:");
		for (String loggerName : loggerNames) {
			System.out.println("Name, parent, level: " + loggerName + ", " + loggingMxb.getParentLoggerName(loggerName)
					+ ", " + loggingMxb.getLoggerLevel(loggerName));
		}
	}
}
