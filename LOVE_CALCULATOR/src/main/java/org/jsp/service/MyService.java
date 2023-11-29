package org.jsp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.jsp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Autowired
	private JavaMailSender sender;

	public String doProcess(User user) {
		String n1 = user.getFname();
		n1 = n1.toLowerCase();
		String n2 = user.getSname();
		n2 = n2.toLowerCase();

		char[] ar1 = n1.toCharArray();
		char[] ar2 = n2.toCharArray();

		List<Character> al1 = new ArrayList<>();
		for (char c : ar1) {
			al1.add(c);
		}

		List<Character> al2 = new ArrayList<>();
		for (char c : ar2) {
			al2.add(c);
		}

		Iterator<Character> itr = al1.iterator();
		while (itr.hasNext()) {
			Character c = itr.next();
			if (al2.contains(c)) {
				al2.remove(c);
				itr.remove();
			}
		}

		int size = al1.size() + al2.size();

		List<Character> al = new ArrayList<>(Arrays.asList('f', 'l', 'a', 'm', 'e', 's'));
		while (al.size() != 1) {
			int i = size % al.size();
			if (i != 0) {
				i = i - 1;
				al.remove(i);
			} else {
				i = al.size() - 1;
				al.remove(i);
			}

		}
//		Character res = al.get(0);
//		System.out.println(res);
		String result = null;
		switch (al.get(0)) {
		case 'f':
			result = "friends";
			break;
		case 'l':
			result = "lovers";
			break;
		case 'a':
			result = "affectionate";
			break;
		case 'm':
			result = "marrage";
			break;
		case 'e':
			result = "enemys";
			break;
		case 's':
			result = "siblings";
		}
		return result;
	}

	public void sendMail(String email, String fname, String sname, String result) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("FLAMES RESULTS :  ");

		// Concatenate the text into a single message
		String mailText = "Hey " + fname + ", Results Are Predicted Below\n\n" + fname + " & " + sname + " will become "
				+ result + " !!!\n";

		message.setText(mailText);
		sender.send(message);

	}

}
