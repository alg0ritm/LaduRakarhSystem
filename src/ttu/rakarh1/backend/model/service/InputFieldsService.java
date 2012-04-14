package ttu.rakarh1.backend.model.service;

import java.util.HashMap;
import java.util.List;

import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.web.forms.ProductForm;

public interface InputFieldsService
{
	HashMap<String, String> getErrorsForUpdate(List<FormAttribute> formAttribute, ProductForm productForm);

}
