package com.hyx.common.extension.spi;

import com.hyx.common.extension.Activation;
import com.hyx.common.extension.Spi;

@Spi(name="two")
@Activation(sequence=1,key="one")
public class SpiTestTwo implements SpiTest {

	public String hello(String name) {
		return "two"+name;
	}

}
