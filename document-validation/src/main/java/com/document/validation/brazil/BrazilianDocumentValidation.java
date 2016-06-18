package com.document.validation.brazil;

public class BrazilianDocumentValidation {

	public boolean validationCpf(String cpf) {
		return new ValidationCpf().isValid(cpf);
	}

}
