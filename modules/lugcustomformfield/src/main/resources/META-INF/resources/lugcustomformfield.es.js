import 'dynamic-data-mapping-form-field-type/FieldBase/FieldBase.es';
import './lugcustomformfieldRegister.soy.js';
import templates from './lugcustomformfield.soy.js';
import {Config} from 'metal-state';


/**
 * LUGCustomFormField Component
 */
class LUGCustomFormField extends Component {

	dispatchEvent(event, name, value) {
		this.emit(name, {
			fieldInstance: this,
			originalEvent: event,
			value
		});
	}

	_handleFieldChanged(event) {
		const {value} = event.target;

		this.setState(
			{
				value
			},
			() => this.dispatchEvent(event, 'fieldEdited', value)
		);
	}
}

LUGCustomFormField.STATE = {

	name: Config.string().required(),

	predefinedValue: Config.oneOfType([Config.number(), Config.string()]),

	required: Config.bool().value(false),

	showLabel: Config.bool().value(true),

	spritemap: Config.string(),

	value: Config.string().value('')
}

// Register component
Soy.register(LUGCustomFormField, templates);

