package UF1;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Exemple1 {


//hola em dic ventsi
	public static void main(String[] args) {

		// GENERAR UN CLAU
		SecretKey clau = passwordKeyGeneration("hola", 128);

		SecretKey sKey = keygenKeyGeneration(128);

		String clau = Base64.getEncoder().encodeToString(sKey.getEncoded());

		System.out.println("La clau genereada en format String base 64 es " + "\n" + clau);

	}

	public static SecretKey keygenKeyGeneration(int keySize) {
		SecretKey sKey = null;
		if ((keySize == 128) || (keySize == 192) || (keySize == 256)) {
			try {
				KeyGenerator kgen = KeyGenerator.getInstance("AES");
				kgen.init(keySize);
				sKey = kgen.generateKey();

			} catch (NoSuchAlgorithmException ex) {
				System.err.println("Generador no disponible.");
			}
		}
		return sKey;
	}

}
