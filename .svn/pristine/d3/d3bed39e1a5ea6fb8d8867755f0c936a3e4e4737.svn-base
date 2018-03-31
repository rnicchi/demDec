package it.almavivaitalia.bilancio.commons.web.utils;


	import javax.crypto.Cipher;
	import javax.crypto.SecretKey;
	import javax.crypto.SecretKeyFactory;
	import javax.crypto.spec.DESKeySpec;
	
	public class SymmetricCipher {

		/**
		 * Metodo che esegue la cifratura simmetrica utilizzando
		 * una data chiave 
		 * 
		 * @@param inpBytes input da cifrare
		 * @@param privateKeyBytes chiave simmetrica utilizzata per la cifratura
		 * 
		 * @@return input cifrato
		 * 
		 * @@throws Exception
		 * 
		 */
		public static byte[] encrypt(byte[] inpBytes, byte[] privateKeyBytes)
			throws Exception {

			// Istanza dell'oggetto per cifrare 
			// con algoritmo DES
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

			// Crea il SecretKeyFactory per DES
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");

			//  Crea il DESKeySpec con la chiave specificata
			DESKeySpec desKeySpec = new DESKeySpec(privateKeyBytes);

			// Creazione di un oggetto contenente 
			// la chiave simmetrica per cifrare
			SecretKey privateKey = secretKeyFactory.generateSecret(desKeySpec);

			// Crea e inizializza per la cifratura
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);

			int outputLength = cipher.getOutputSize(inpBytes.length);
			byte[] ciphertext = new byte[outputLength];
			int lenght1 = cipher.update(inpBytes, 0, inpBytes.length, ciphertext);
			cipher.doFinal(ciphertext, lenght1);

			return ciphertext;
		}
		/**
		 * Metodo che esegue la decifratura simmetrica utilizzando
		 * una data chiave 
		 * 
		 * @@param inpBytes input da decifrare
		 * @@param privateKeyBytes chiave simmetrica utilizzata per la decifratura
		 * 
		 * @@return input decifrato
		 * 
		 * @@throws Exception
		 * 
		 */
		public static byte[] decrypt(byte[] inpBytes, byte[] privateKeyBytes)
			throws Exception {

			// Istanza dell'oggetto per decifrare 
			// con algoritmo DES
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

			// Crea il SecretKeyFactory per DES
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");

			//  Crea il DESKeySpec con la chiave specificata
			DESKeySpec desKeySpec = new DESKeySpec(privateKeyBytes);

			// Creazione di un oggetto contenente 
			// la chiave simmetrica per decifrare
			SecretKey privateKey = secretKeyFactory.generateSecret(desKeySpec);

			// Crea e inizializza per la decifratura
			cipher.init(Cipher.DECRYPT_MODE, privateKey);

			// Decifratura dell'input
			return cipher.doFinal(inpBytes);

		}
		/**
		 * Metodo che esegue la decifratura simmetrica utilizzando
		 * una data chiave e la 
		 * 
		 * @@param inpBytes input da decifrare
		 * @@param privateKeyBytes chiave simmetrica utilizzata per la decifratura
		 * @@param sizeOutput dimensione dell'output
		 * 
		 * @@return input decifrato
		 * 
		 * @@throws Exception
		 * 
		 */
		public static byte[] decrypt(byte[] inpBytes, byte[] privateKeyBytes,int sizeOutput)
			throws Exception {

			// Istanza dell'oggetto per decifrare 
			// con algoritmo DES
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

			// Crea il SecretKeyFactory per DES
			SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");

			//  Crea il DESKeySpec con la chiave specificata
			DESKeySpec desKeySpec = new DESKeySpec(privateKeyBytes);

			// Creazione di un oggetto contenente 
			// la chiave simmetrica per decifrare
			SecretKey privateKey = secretKeyFactory.generateSecret(desKeySpec);

			// Crea e inizializza per la decifratura
			cipher.init(Cipher.DECRYPT_MODE, privateKey);

			// Dimensione finale dell'output
			int outputLength = cipher.getOutputSize(sizeOutput);
			
			// Creazione dell'array di output
			byte[] deciphertext = new byte[outputLength];
			
			// aggiunta di blocchi per la decifratura 
			int lenght1 = cipher.update(inpBytes, 0, inpBytes.length, deciphertext);
			
			//	Decifratura dell'input
			cipher.doFinal(deciphertext, lenght1);
			return deciphertext;

		}

	}

