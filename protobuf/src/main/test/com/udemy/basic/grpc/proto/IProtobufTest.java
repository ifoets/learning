package com.udemy.basic.grpc.proto;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class IProtobufTest {

	private IProtobuf ipf;

	@Before
	public void init() {
		ipf = new ProtobufImpl();
	}

	/** Demo example protobuf */
	@Test
	public void demoExampleTest() {
		System.out.println(ipf.demoExample());
	}

	/** .equals methods says either each field values are same or not */
	@Test
	public void equalsMethodExampleTest() {
		ipf.equalsMethodExample();
	}

	/** Serialised and DeSerialised the data */
	@Test
	public void serDeserialisedExmplTest() throws IOException {
		ipf.serDeserialisedExmpl();
	}

	/** proto Vs Json performance 1 */
	@Test
	public void protoVsJsonPerformanceTest() {
		for (int i = 0; i < 5; i++)
			ipf.protoVsJsonPerformance();
	}

	/** Composition demo */
	@Test
	public void compositionExmplTest() {
		ipf.compositionExmpl();
	}

	/** Collection Demo */
	@Test
	public void collectionExampleTest() {
		ipf.collectionExample();
	}

	/** Map Demo */
	@Test
	public void mapExampleTest() {
		ipf.mapExample();
	}

	/** Enum Demo */
	@Test
	public void enumExampleTest() {
		ipf.enumExample();
	}

	/** Default Value Example */
	@Test
	public void defaultValueExmplTest() {
		ipf.defaultValueExmpl();
	}

	/** oneof Demo Example */
	@Test
	public void oneOfExammpleTest() {
		ipf.oneOfExammple();
	}

	/** how PROTO works so take less time then JSON */
	@Test
	public void protoBettterPerformanceTest() {
		ipf.protoBettterPerformance();
	}

	/** Version compitiability test */
	@Test
	public void versinCompitiablityTest() { 
		ipf.versinCompitiablity();
	}
}