package com.udemy.basic.grpc.proto;

import java.io.IOException;

import com.udemy.proto.Credentials;

public interface IProtobuf {

	/** Demo example protobuf */
	public String demoExample();

	/** .equals methods says either each field values are same or not */
	public void equalsMethodExample();

	/** Serialised and DeSerialised the data */
	public void serDeserialisedExmpl() throws IOException;

	/** proto Vs Json performance */
	public void performanceTest(Runnable runnable, String type, int n);

	public void protoVsJsonPerformance();

	/** Composition demo */
	public void compositionExmpl();

	/** Collection List Demo */
	public void collectionExample();

	/** Map Demo */
	public void mapExample();

	/** Enum Demo */
	public void enumExample();

	/** Default Value Example */
	public void defaultValueExmpl();

	/** oneof Demo Example */
	public void loginCredential(Credentials credentials);

	public void oneOfExammple();

	/** how PROTO works so take less time then JSON */
	public void protoBettterPerformance();

	/** Version compitiability test */
	public void versinCompitiablity();
}
