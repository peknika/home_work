package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify paarameters: <amount of test data> <file> <format>");
			return;
		}

		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];

		if (file.exists()) {
			System.out.println("File exists, please remove it manually: " + file);
			return;
		}
		List<ContactData> contacts = generateRandomContacts(amount);
		if ( "csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	public static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}

	public static List<ContactData> loadContactsFromXmlFile( File file) {
		XStream xstream = new XStream();
		xstream.alias("group", GroupData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress() + "," + contact.getHomeNumber() + "," + contact.getMobileNumber() + "," + contact.getWorkNumber() + "," + contact.getEmail1() + "," + contact.getEmail2() + "," + contact.getbDay() + "," + contact.getbMonth() + "," + contact.getbYear() + "," + contact.getAddress2() + "," + contact.getHomeNumber2() + "," + contact.getGroupName() +  ".!" + "\n");
		}
		writer.close();
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++){
			ContactData contact = new ContactData()
			.withFirstName (generateRandomStringForContact())
			.withLastName (generateRandomStringForContact())
			.withAddress (generateRandomStringForContact())
			.withHomeNumber (generateRandomStringForContact())
			.withMobileNumber (generateRandomStringForContact())
			.withWorkNumber (generateRandomStringForContact())
			.withEmail1 (generateRandomStringForContact())
			.withEmail2 (generateRandomStringForContact())
			.withBDay (generateRandomDayIndexForContact())
			.withBMonth (generateRandomMonthIndexForContact())
			.withBYear (generateRandomYearStringForContact())
			.withGroupName (generateRandomGoupIndexForContact())
			.withAddress2 (generateRandomStringForContact())
			.withHomeNumber2 (generateRandomStringForContact());
			list.add(contact);
		}
		return list;
	}

	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			.withFirstName (part[0])
			.withLastName (part[1])
			.withAddress (part[2])
			.withHomeNumber (part[3])
			.withMobileNumber (part[4])
			.withWorkNumber (part[5])
			.withEmail1 (part[6])
			.withEmail2 (part[7])
			.withBDay (getIntFromString(part[8]))
			.withBMonth (getIntFromString(part[9]))
			.withBYear (part[10])
			.withAddress2 (part[12])
			.withHomeNumber2 (part[13]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		reader.close();
		return list;
	}

	public static int getIntFromString(String s)
	{
		if (s == null)
			return 0;
		if (s.isEmpty())
			return 0;
		return Integer.parseInt(s);
	}


	public static int generateRandomGoupIndexForContact() {
		return 0;
	}

	public static String generateRandomYearStringForContact() {
		Random rnd = new Random();
		return String.valueOf(rnd.nextInt(200) +1900);
	}


	public static int generateRandomMonthIndexForContact() {
		Random rnd = new Random();

		return rnd.nextInt(11+1);
	}

	public static int generateRandomDayIndexForContact() {
		Random rnd = new Random();

		return rnd.nextInt(30);
	}

	public static String generateRandomStringForContact(){
		Random rnd = new Random();
		if (rnd.nextInt(10) == 0) {
			return "";
		}
		else {
			return "yupi!" + rnd.nextInt();
		}	
	}
}