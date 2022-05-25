package com.udemy.basic.grpc.proto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.udemy.basic.grpc.json.JPerson;
import com.udemy.basic.grpc.utils.Utils;
import com.udemy.proto.Credentials;
import com.udemy.proto.Dealer;
import com.udemy.proto.EmailCredentials;
import com.udemy.proto.Person;
import com.udemy.proto.PhoneOTP;
import com.udemy.proto.Television;
import com.udemy.proto.Type;
import com.udemy.proto.Watch;
import com.udemy.proto.common.Address;
import com.udemy.proto.common.BodyStyle;
import com.udemy.proto.common.Car;

public class ProtobufImpl implements IProtobuf {

	/** Demo example protobuf */
	@Override
	public String demoExample() {

		return Utils.getPerson()
		        .toString();
	}

	/** .equals methods says either each field values are same or not */
	@Override
	public void equalsMethodExample() {
		Person p1 = Utils.getPerson();
		Person p2 = Utils.getPerson();

		Person p3 = Person.newBuilder()
		        .setAge(20)
		        .setName("abhimanyu") // lower case
		        .build();

		System.out.println(p1.toString() + " and " + p2.toString() + " are equal :" + p1.equals(p2));
		System.out.println("------X--------X--------");
		System.out.println(p1.toString() + " and " + p2.toString() + " are equal :" + p1.equals(p3));
	}

	/**
	 * Serialised and DeSerialised the data
	 * 
	 * @throws IOException
	 */
	@Override
	public void serDeserialisedExmpl() throws IOException {
		Person p = Utils.getPerson();

		Path path = Paths.get("abhi.ser");
		Files.write(path, p.toByteArray());

		byte[] bytes = Files.readAllBytes(path);
		Person rawPerson = Person.parseFrom(bytes);
		System.out.println(rawPerson);
	}

	/** proto Vs Json performance part 1 */
	public void performanceTest(Runnable runnable, String type, int n) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			runnable.run();
		}
		long endTime = System.currentTimeMillis();

		System.out.println(type + " takes :" + (endTime - startTime) + "ms");

	}

	@SuppressWarnings("unused")
	@Override
	public void protoVsJsonPerformance() {
		JPerson jPerson = new JPerson();
		jPerson.setAge(20);
		jPerson.setName("Abhimanyu");

		ObjectMapper mapper = new ObjectMapper();
		// Json
		Runnable jRun = () ->
			{

				try {
					byte[] bytes = mapper.writeValueAsBytes(jPerson);
					JPerson jpNew = mapper.readValue(bytes, JPerson.class);
				} catch (Exception e) {
					e.printStackTrace();
				}
			};

		// proto
		Person person = Utils.getPerson();
		Runnable pRun = () ->
			{

				try {
					byte[] bytes = person.toByteArray();
					Person pNew = Person.parseFrom(bytes);
				} catch (InvalidProtocolBufferException e) {
					e.printStackTrace();
				}
			};

		performanceTest(jRun, "JSON", 1000000);
		performanceTest(pRun, "PROTO", 1000000);
	}

	/** Composition demo */
	@Override
	public void compositionExmpl() {

		Address address = Address.newBuilder()
		        .setPostbox(123)
		        .setStreet("Main Street")
		        .setCity("Bangalore")
		        .build();

		Car car = Car.newBuilder()
		        .setMake("Honda")
		        .setModel("Accord")
		        .setYear(2020)
		        .build();

		Person person = Person.newBuilder()
		        .setName("Abhimanyu")
		        .setAge(2)
		        .setCar(car)
		        .setAddress(address)
		        .build();
		System.out.println(person);
	}

	/** Collection Demo */
	public void collectionExample() {
		Watch watch1 = Watch.newBuilder()
		        .setModel(2000)
		        .build();
		Watch watch2 = Watch.newBuilder()
		        .setModel(2001)
		        .build();
		Watch watch3 = Watch.newBuilder()
		        .setModel(2002)
		        .build();
		Watch watch4 = Watch.newBuilder()
		        .setModel(2003)
		        .build();

		List<Watch> watchList = new ArrayList<>();
		watchList.add(watch3);
		watchList.add(watch4);
		Person person = Person.newBuilder()
		        .setName("Abhimanyu")
		        .setAge(20)
		        .addWatch(watch1)
		        .addWatch(watch2)
		        .addAllWatch(watchList)
		        .build();
		System.out.println(person);
	}

	/** Map Demo */
	@Override
	public void mapExample() {
		Car accord = Car.newBuilder()
		        .setMake("Honda")
		        .setModel("Accord")
		        .setYear(2020)
		        .build();

		Car civic = Car.newBuilder()
		        .setMake("Honda")
		        .setModel("Civic")
		        .setYear(2005)
		        .build();

		Dealer delear = Dealer.newBuilder()
		        .putModel(2020, accord)
		        .putModel(2005, civic)
		        .build();

		System.out.println(delear.getModelOrThrow(2020));
		// it throw no key present
		// System.out.println(delear.getModelOrThrow(2000));
		System.out.println(delear.getModelOrDefault(3000, civic));
		System.out.println("------X------------X----------");
		System.out.println(delear.getModelMap());

	}

	/** Enum Demo */
	@Override
	public void enumExample() {
		Car accord = Car.newBuilder()
		        .setMake("Honda")
		        .setModel("Accord")
		        .setBodyStyle1(BodyStyle.COUPE)
		        .setYear(2020)
		        .build();

		Car civic = Car.newBuilder()
		        .setMake("Honda")
		        .setModel("Civic")
		        .setBodyStyle1(BodyStyle.SEDAN)
		        .setYear(2005)
		        .build();

		Dealer delear = Dealer.newBuilder()
		        .putModel(2020, accord)
		        .putModel(2005, civic)
		        .build();

		System.out.println(delear.getModelOrThrow(2020)
		        .getBodyStyle1());

	}

	/** Default Value Example */
	@Override
	public void defaultValueExmpl() {
		Person p = Person.newBuilder()
		        .build();
		System.out.println("Should access Address vlaues or not: " + p.hasAddress());
		System.out.println(" City: " + p.getAddress()
		        .getCity());
	}

	/** oneof Demo Example */
	public void loginCredential(Credentials credentials) {
		switch (credentials.getModeCase()) {
		case EMIALMODE:
			System.out.println(credentials.getEmialMode());
			break;
		case PHONEMODE:
			System.out.println(credentials.getPhoneMode());
			break;
		default:
			break;
		}

	}

	@Override
	public void oneOfExammple() {

		EmailCredentials emailMode = EmailCredentials.newBuilder()
		        .setEmail("abcd@gmail.com")
		        .setPassword("1234")
		        .build();

		PhoneOTP phoneMode = PhoneOTP.newBuilder()
		        .setNumber(1029835567)
		        .setCode(1234)
		        .build();

		Credentials credentials = Credentials.newBuilder()
		        .setEmialMode(emailMode)
		        .setPhoneMode(phoneMode)// last set taking in to account
		        .build();
		loginCredential(credentials);
	}

	/** how proto works so take less time then JSON */
	@Override
	@SuppressWarnings("unused")
	public void protoBettterPerformance() {
		JPerson jPerson = new JPerson();
		jPerson.setAge(20);
		jPerson.setName("Sam");

		ObjectMapper mapper = new ObjectMapper();
		// Json
		Runnable jRun = () ->
			{

				try {
					byte[] bytes = mapper.writeValueAsBytes(jPerson);
					System.out.println(" JSON bytes Lenth: " + bytes.length);
					JPerson jpNew = mapper.readValue(bytes, JPerson.class);
				} catch (Exception e) {
					e.printStackTrace();
				}
			};

		// proto

		Person person = Person.newBuilder()
		        .setAge(20)
		        .setName("Sam")
		        .build();
		Runnable pRun = () ->
			{

				try {
					byte[] bytes = person.toByteArray();
					System.out.println(" PROTO bytes Lenth: " + bytes.length);
					Person pNew = Person.parseFrom(bytes);
				} catch (InvalidProtocolBufferException e) {
					e.printStackTrace();
				}
			};

		performanceTest(jRun, "JSON", 1);
		performanceTest(pRun, "PROTO", 1);
	}

	/** Version compitiability test */
	@Override
	public void versinCompitiablity() {
		Path pathV1 = Paths.get("tv-v1");
		Path pathV2 = Paths.get("tv-v2");

		Television televisionV1 = Television.newBuilder()
		        .setBrand("Sony")
		        // .setYear(2019) for V1
		        .setModel(2019) // for v2
		        .build();

		Television televisionV2 = Television.newBuilder()
		        .setBrand("Sony")
		        .setModel(2019)
		        .setType(Type.OLED)
		        .build();

		try {
			// serialize
			Files.write(pathV1, televisionV1.toByteArray());
			Files.write(pathV2, televisionV2.toByteArray());
			// deserialize
			byte[] bytes = Files.readAllBytes(pathV1);
			System.out.println(Television.parseFrom(bytes)
			        .getType());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
