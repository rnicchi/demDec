package it.almavivaitalia.bilancio.commons.utils;

import static it.almavivaitalia.bilancio.commons.utils.BooleanUtil.isNull;
import static it.almavivaitalia.bilancio.commons.utils.BooleanUtil.isZero;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class NumberUtil {

	/*
	 * restituisce una stringa con il numero preceduto da zeri, se necessario,
	 * per raggiungere il numero di cifre specificato
	 */
	public static String normalizza(String s, int numeroCifre) {
		return normalizza(s, numeroCifre, "0");
	}

	/*
	 * restituisce una stringa con il numero preceduto da un valore, se
	 * necessario, per raggiungere il numero di cifre specificato
	 */
	public static String normalizza(String s, int numeroCifre, String value) {
		String norma = "";
		int delta = numeroCifre - s.length();
		for (int i = 0; i < delta; i++) {
			norma += value;
		}
		return norma + s;
	}


	
	/*
	 * Metodo null safe che crea un big decimal
	 *  a partire da un'altro ("intValue")
	 * */
	public static BigDecimal makeBigDecimal(BigDecimal initValue) {
		BigDecimal newValue = new BigDecimal(0);
		newValue = newValue.add(convertNullToZero(initValue));
		return newValue;
	}

	/*
	 * Metodo che restituisce il numero di cifre 
	 * di cui è composto umn big decimal ("newValue")
	 * */
	private static int getNumeroCifre(BigDecimal newValue) {
		int nCifreInt = 0;

		if (newValue.toString().indexOf(".") != -1) {
			nCifreInt = newValue.toString()
					.substring(0, newValue.toString().indexOf(".")).length();
		} else {
			nCifreInt = newValue.toString().length();
		}

		return nCifreInt;
	}

	/*
	 * Metodo che arrotonda il big decimal dato ("value")
	 * secondo l'algoritmo di arrotondamento dato ("roundingMode"):
	 * questo può essere DOWN, per difetto,
	 * oppure UP, per eccesso
	 * */
	public static BigDecimal round(BigDecimal value, RoundingMode roundingMode) {

		BigDecimal newValue = makeBigDecimal(value);
		int nCifreInt = getNumeroCifre(newValue);
		MathContext mc = new MathContext(nCifreInt, roundingMode);
		newValue = newValue.round(mc);
		return newValue;
	}

	
	/*
	 * Metodo che arrotonda il big decimal dato ("value")
	 * per difetto,
	 * */
	public static BigDecimal roundingDown(BigDecimal value) {

		BigDecimal newValue = makeBigDecimal(value);
		int nCifreInt = getNumeroCifre(newValue);
		MathContext mc = new MathContext(nCifreInt, RoundingMode.DOWN);
		newValue = newValue.round(mc);
		return newValue;
	}

	/*
	 * Metodo che arrotonda il big decimal dato ("value")
	 * per eccesso,
	 * */
	public static BigDecimal roundingUp(BigDecimal value) {

		BigDecimal newValue = makeBigDecimal(value);
		int nCifreInt = getNumeroCifre(newValue);
		MathContext mc = new MathContext(nCifreInt, RoundingMode.HALF_UP);
		newValue = newValue.round(mc);
		return newValue;
	}

	/*
	 * Metodo che dati due big decimal calcola la percentuale 
	 * del secondo ("importo") rispetto al primo ("variazione")
	 * 
	 * formula --> percentuale=variazione*100/importo
	 * 
	 *  arrotondato a due cifre decimali
	 * */
	public static BigDecimal calcolaPercentuale(BigDecimal variazione,
			BigDecimal importo) {
		BigDecimal misuPercCp = new BigDecimal(0.0).setScale(2);

		if (isZero(importo)) {
			return misuPercCp;
		}

		BigDecimal cento = new BigDecimal(100).setScale(2);
		misuPercCp = misuPercCp.add(variazione);
		misuPercCp = misuPercCp.multiply(cento);
		misuPercCp = misuPercCp.divide(importo, 2, RoundingMode.HALF_UP);

		return misuPercCp;
	}

	
	/*
	 * metodo che somma due big decimal null safe:
	 * se il valore è 'null' somma 0.
	 * */
	public static BigDecimal add(BigDecimal from, BigDecimal to) {
		return convertNullToZero(to).add(convertNullToZero(from));
	}

	/*
	 * Metodo che converte i valori big decimal
	 *  'null' a big decimal '0'
	 * */
	public static BigDecimal convertNullToZero(BigDecimal number) {
		return isNull(number) ? BigDecimal.ZERO : number;
	}

	//TODO commento
	public static BigDecimal getNotNullImpo(BigDecimal a, BigDecimal b) {
		return isNull(a) || isZero(a) ? b : a;
	}

	public static String padRight(String s, int size) {
		return String.format("%1$-" + size + "s", s);
	}

	public static String padLeft(int value, int size) {
		return String.format("%0" + size + "d", value);
	}

}
