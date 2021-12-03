import React,{useState, useEffect} from 'react';
import {FieldBase} from 'dynamic-data-mapping-form-field-type/FieldBase/ReactFieldBase.es';
import {ClayInput} from '@clayui/form';

const LUGCustomFormField = ({disabled, name, onInput, value}) => (
	<ClayInput
		className = "ddm-field-text"
		disabled = {disabled}
		name = {name}
		onInput = {onInput}
		type = "text"
		value = {value}
	/>
);

const Main = (props) => {
	const {
		lable,
		name,
		onChange,
		readOnly,
		userData,
		userDataValue,
		value,
		...otherProps
	} = props;
	
	const [currentValue, setCurrentValue] = useState(value ? value : userDataValue);

	useEffect(() => {
		if (Array.isArray(userData)) {
			switch (userData[0]){
				case 'getFullName':
					setCurrentValue(Liferay.ThemeDisplay.getUserName());
					break;
				case 'getEmailAddress':
					setCurrentValue(Liferay.ThemeDisplay.getUserEmailAddress());
					break;
			}
		}
	}), [userData];
	
	return (
		<FieldBase
			label={lable}
			name={name}
			{...otherProps}
		>
			<LUGCustomFormField
				disabled = {readOnly}
				name = {name}
				onInput = {onChange}
				value = {currentValue}
			/>
		</FieldBase>
	);
}

export default Main;