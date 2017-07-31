package com.hyx.common.extension.spi;

import com.hyx.common.extension.Activation;
import com.hyx.common.extension.Spi;

@Spi(name="one")
@Activation(sequence=2,key="one")
public class SpiTestOne implements SpiTest {

	public String hello(String name) {
		return "one"+name;
	}

}
