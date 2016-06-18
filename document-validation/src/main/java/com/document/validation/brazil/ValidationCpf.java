package com.document.validation.brazil;

public class ValidationCpf {

	private String[] cpfExpected = new String[11];
	private String[] cpfReceived = new String[11];

	public boolean isValid(String cpf) {
		return logic(cpf);
	}

	private boolean logic(String cpf) {
		if (!verifyExistsElevenNumbers(cpf)) {
			return false;
		}
		if (verifySameNumber(cpf)) {
			return false;
		}

		cloneCpf(cpf);

		this.cpfReceived[9] = String.valueOf(verifyFirstDigitChecker());
		this.cpfReceived[10] = String.valueOf(verifySecondDigitChecker());

		return (this.cpfReceived[9].equals(this.cpfExpected[9]) && this.cpfReceived[10].equals(cpfExpected[10]));

	}

	private boolean verifyExistsElevenNumbers(String cpf) {
		if (cpf.length() == 11) {
			return true;
		} else {
			return false;
		}
	}

	private boolean verifySameNumber(String cpf) {
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999")) {
			return true;
		} else {
			return false;
		}
	}

	private void cloneCpf(String cpf) {

		this.cpfReceived = cpf.split("");

		for (int i = 0; i < this.cpfReceived.length; i++) {
			this.cpfExpected[i] = this.cpfReceived[i];
		}

	}

	private int verifyFirstDigitChecker() {
		int aux = 10;
		int result = 0;
		for (int i = 0; i < 9; i++) {
			result = aux * Integer.parseInt(cpfReceived[i]) + result;
			aux--;
		}
		int mod = result % 11;
		if (mod < 2) {
			return 0;
		} else {
			return 11 - mod;
		}
	}

	private int verifySecondDigitChecker() {
		int aux = 11;
		int result = 0;
		for (int i = 0; i < 10; i++) {
			result = aux * Integer.parseInt(cpfReceived[i]) + result;
			aux--;
		}
		int mod = result % 11;
		if (mod < 2) {
			return 0;
		} else {
			return 11 - mod;
		}
	}
}
