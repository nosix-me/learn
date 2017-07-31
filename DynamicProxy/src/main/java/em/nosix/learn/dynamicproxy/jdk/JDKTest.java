package em.nosix.learn.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class JDKTest {
	
    public static void main(String[] args) { 
		UserService userService = new UserServiceImpl();  
		InvocationHandler invocationHandler = new UserServiceHandler(userService); 
		UserService userServiceProxy = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),  
                userService.getClass().getInterfaces(), invocationHandler);  
        System.out.println(userServiceProxy.getName());  
        System.out.println(userServiceProxy.getAge());  
	}

}
interface UserService {
	String getName();
	String getAge();
}
class UserServiceImpl implements UserService{

	@Override
	public String getName() {
		System.out.println("----getName----");
		return "nosix";
	}

	@Override
	public String getAge() {
		System.out.println("----getAge----");
		return "18";
	}
}

class UserServiceHandler implements InvocationHandler {

	private Object target;
	public UserServiceHandler() {
		super();
	}
	public UserServiceHandler(Object target) {
		this.target = target;
	}
	@Override
	public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
		if("getName".equals(method.getName())) {
			System.out.println("++++++before " + method.getName() + "++++++");  
            Object result = method.invoke(target, args);  
            System.out.println("++++++after " + method.getName() + "++++++");  
            return result;  
		} else {
			 Object result = method.invoke(target, args);  
	            return result; 
		}
	}
	
}


