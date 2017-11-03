package com.yancy.gateway;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import rx.Observer;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public abstract class MyGateWay extends HystrixCommand<String>{

	private String content;
	
	public MyGateWay(String content) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("hystrix.command.hx"))
				.andCommandKey(HystrixCommandKey.Factory.asKey("hystrix.command.hx"))
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("hystrix.command.hx"))
				.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(500))
				.andCommandPropertiesDefaults(
						HystrixCommandProperties.Setter().withCircuitBreakerRequestVolumeThreshold(100)
						.withCircuitBreakerErrorThresholdPercentage(1)
						.withCircuitBreakerSleepWindowInMilliseconds(60*1000)
						.withFallbackEnabled(true)
						.withExecutionIsolationThreadInterruptOnTimeout(true)
						.withExecutionTimeoutInMilliseconds(1000)));
		this.content = content;
		
	}
	
	@Override
	protected String run() throws Exception{
		return doWork(content);
	}
	
	public abstract String doWork(String request);
	
	public String syncInvoke() {
		return execute();
	}
	
	public String asynInvoke(String request){
		Future<String> future = queue();
		try{
			return future.get(100, TimeUnit.MILLISECONDS);
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return getFallback();
	}
	
	public abstract void subscribeOnCompleted();
	
	public abstract void subscribeOnError();
	
	public abstract void subscribeOnNext();
	
	public void callback() {
		rx.Observable<String> ob = this.observe();
		ob.subscribe(new Observer<String>() {

			public void onCompleted() {
				// onNext/onError 完成之后最后调用
				subscribeOnCompleted();
			}

			public void onError(Throwable arg0) {
				subscribeOnError();
			}

			public void onNext(String arg0) {
				// 获取结果后回调
				subscribeOnNext();
			}
		});
	}
	@Override
	protected String getFallback() {
		return "fall down "+ this.getClass().getName();
	}
}
