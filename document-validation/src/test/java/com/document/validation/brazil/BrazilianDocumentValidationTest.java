package com.document.validation.brazil;

import org.junit.Assert;
import org.junit.Test;

import com.document.validation.brazil.BrazilianDocumentValidation;

public class BrazilianDocumentValidationTest {

	@Test
	public void testValidCpf() {

		Assert.assertTrue(new BrazilianDocumentValidation().validationCpf("12929285737"));
	}

	@Test
	public void testInvalidCpf() {
		Assert.assertFalse(new BrazilianDocumentValidation().validationCpf("12312312312"));
	}

	@Test
	public void testSameNumberCpf() {
		Assert.assertFalse(new BrazilianDocumentValidation().validationCpf("11111111111"));
	}

	@Test
	public void testNumbersDifferentEleven() {
		Assert.assertFalse(new BrazilianDocumentValidation().validationCpf("1111111111111"));
	}

}
