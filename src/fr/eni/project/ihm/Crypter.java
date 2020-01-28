package fr.eni.project.ihm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypter {

	public static String Crypt(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("erreur de codage du mot de passe");
		}
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// convertir le tableau de bits en une format hexadécimal - méthode 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}
}
