package UF1;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Exemple2 {

	// GENERAR UNA PARAULA

	public static void main(String[] args) {

		SecretKey sKey = passwordKeyGeneration("hola", 128);

		String clau = Base64.getEncoder().encodeToString(sKey.getEncoded());

		System.out.println("La clau genereada en format String base 64 es " + "\n" + "\n" + clau);

	}

	public static SecretKey passwordKeyGeneration(String text, int keySize) {
		SecretKey sKey = null;
		if ((keySize == 128) || (keySize == 192) || (keySize == 256)) {
			try {
				byte[] data = text.getBytes("UTF-8");
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				byte[] hash = md.digest(data);
				byte[] key = Arrays.copyOf(hash, keySize / 8);
				sKey = new SecretKeySpec(key, "AES");
			} catch (Exception ex) {
				System.err.println("Error generant la clau:" + ex);
			}
		}
		return sKey;
	}

}
