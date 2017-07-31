package com.hyx.common.extension.spi;

import java.util.List;

import org.junit.Test;

import com.hyx.common.extension.SpiLoader;

public class SpiTestCase {
	
	@Test
	public void test() {
//		SpiTest spiTest = SpiLoader.getInstance(SpiTest.class).getExtension("two");
//		
		 List<SpiTest> spiTest = SpiLoader.getExtensionLoader(SpiTest.class).getExtensions("one");
		System.out.println(spiTest.size());
//		assertEquals(spiTest.getClass(), Spi);
	}
}