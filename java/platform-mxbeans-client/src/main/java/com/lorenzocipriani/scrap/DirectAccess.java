/**
 * 
 */
package com.lorenzocipriani.scrap;

import java.lang.management.BufferPoolMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.PlatformLoggingMXBean;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author lorencip
 *
 */
public class DirectAccess {

	public static void printClassDefinedFields(Field[] fields) {
		for (Field field : fields) {
			try {
				System.out.println(field.getName() + ": " + field.get(field.getName()).toString());
			} catch (IllegalAccessException ex) {
				System.out.println(ex);
			}
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// A Java virtual machine has a single instance of the following management
		// interfaces:
		ManagementInterface.setClassMxb(ManagementFactory.getClassLoadingMXBean());
		ManagementInterface.setMemoryMxb(ManagementFactory.getMemoryMXBean());
		ManagementInterface.setThreadMxb(ManagementFactory.getThreadMXBean());
		ManagementInterface.setRuntimeMxb(ManagementFactory.getRuntimeMXBean());
		ManagementInterface.setSystemMxb(ManagementFactory.getOperatingSystemMXBean());
		ManagementInterface.setLoggingMxb(ManagementFactory.getPlatformMXBean(PlatformLoggingMXBean.class));

		// A Java virtual machine has zero or a single instance of the following
		// management interfaces:
		ManagementInterface.setCompilationMxb(ManagementFactory.getCompilationMXBean());

		// A Java virtual machine may have one or more instances of the following
		// management interfaces:
		ManagementInterface.setGarbageMxb(ManagementFactory.getGarbageCollectorMXBeans());
		ManagementInterface.setMemoryManagerMxb(ManagementFactory.getMemoryManagerMXBeans());
		ManagementInterface.setMemoryPoolMxb(ManagementFactory.getMemoryPoolMXBeans());
		ManagementInterface.setBufferPoolMxp(ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class));

		printClassDefinedFields(ManagementFactory.class.getDeclaredFields());
		Set managementInterfaces = ManagementFactory.getPlatformManagementInterfaces();

		ManagementInterface.showClassLoading();
		ManagementInterface.showMemory();
		ManagementInterface.showThread();
		ManagementInterface.showRuntime();
		ManagementInterface.showOperatingSystem();
		ManagementInterface.showPlatformLogging();
	}

}
