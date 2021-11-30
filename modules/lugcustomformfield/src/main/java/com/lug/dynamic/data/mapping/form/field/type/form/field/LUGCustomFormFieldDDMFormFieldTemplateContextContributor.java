 package com.lug.dynamic.data.mapping.form.field.type.form.field;

import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.render.DDMFormFieldRenderingContext;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

@Component(
	immediate = true,
	property = "ddm.form.field.type.name=lugcustomformfield",
	service = {
			DDMFormFieldTemplateContextContributor.class
	}
)
public class LUGCustomFormFieldDDMFormFieldTemplateContextContributor
		implements DDMFormFieldTemplateContextContributor {

	@Override
	public Map<String, Object> getParameters(DDMFormField ddmFormField,
			DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {
		// TODO Auto-generated method stub
		return HashMapBuilder.<String, Object>put("sayHelloTo", getValue(ddmFormField)).build();
	}
	
	protected String getValue(DDMFormField ddmFormField) {
		String sayHelloTo = "";
		try {
			JSONArray jsonArray  = JSONFactoryUtil.createJSONArray((String) ddmFormField.getProperty("sayHelloTo"));
			sayHelloTo = jsonArray.getString(0);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sayHelloTo;
	}
	

}
