package com.lug.dynamic.data.mapping.form.field.type.form.field;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeSettings;
import com.liferay.dynamic.data.mapping.form.field.type.DefaultDDMFormFieldTypeSettings;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author macgza
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.description=lugcustomformfield-description",
		"ddm.form.field.type.display.order:Integer=13",
		"ddm.form.field.type.group=customized",
		"ddm.form.field.type.icon=thumbs-up",
		"ddm.form.field.type.label=lugcustomformfield-label",
		"ddm.form.field.type.name=lugcustomformfield"
	},
	service = DDMFormFieldType.class
)
public class LUGCustomFormFieldDDMFormFieldType extends BaseDDMFormFieldType {
	
	@Override
	public Class<? extends DDMFormFieldTypeSettings>
		getDDMFormFieldTypeSettings() {  

		return LUGCustomFormFieldDDMFormFieldTypeSettings.class;
	}

	@Override
	public String getModuleName() {
		return _npmResolver.resolveModuleName(
			"dynamic-data-lugcustomformfield-form-field/lugcustomformfield.es");
	}

	@Override
	public String getName() {
		return "lugcustomformfield";
	}

	@Override
	public boolean isCustomDDMFormFieldType() {
		return true;
	}

	@Reference
	private NPMResolver _npmResolver;

}