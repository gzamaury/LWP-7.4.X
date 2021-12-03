package com.lug.dynamic.data.mapping.form.field.type.form.field;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.render.DDMFormFieldRenderingContext;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.WebKeys;

@Component(immediate = true, property = "ddm.form.field.type.name=lugcustomformfield", service = {
		DDMFormFieldTemplateContextContributor.class })
public class LUGCustomFormFieldDDMFormFieldTemplateContextContributor
		implements DDMFormFieldTemplateContextContributor {

	@Override
	public Map<String, Object> getParameters(DDMFormField ddmFormField,
			DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {

		return HashMapBuilder.<String, Object>put("userDataValue", getValue(ddmFormField, ddmFormFieldRenderingContext))
				.build();
	}

	protected String getValue(DDMFormField ddmFormField, DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {
		String userData = "";

		HttpServletRequest request = ddmFormFieldRenderingContext.getHttpServletRequest();

		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		if (td.isSignedIn()) {
			User currentUser = td.getUser();

			try {
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray((String) ddmFormField.getProperty("userData"));

				Method m = User.class.getMethod(jsonArray.getString(0));

				userData = (String) m.invoke(currentUser);

			} catch (JSONException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return userData;
	}
}
