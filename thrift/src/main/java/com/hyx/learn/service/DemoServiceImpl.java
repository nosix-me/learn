package com.hyx.learn.service;

import org.apache.thrift.TException;

public class DemoServiceImpl implements DemoService.Iface {

	@Override
	public String sayHi(String name) throws TException {
		return "Hi," + name + " I am petter";
	}

}
