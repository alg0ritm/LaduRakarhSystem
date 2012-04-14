package ttu.rakarh1.backend.model.service;

import java.util.HashMap;
import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.web.forms.ProductForm;

public class InputFieldsServiceImpl implements InputFieldsService
{

	@Override
	public HashMap<String, String> getErrorsForUpdate(List<FormAttribute> formAttributes,
			ProductForm productForm)
	{
		
		HashMap <String, String> result = new HashMap<String, String>();
		Iterator it = (Iterator) formAttributes.iterator();
		while (it.hasNext()){
			FormAttribute curr = formAttributes.get(it.next());
			
			
			

		}

		return null;
	}

}
