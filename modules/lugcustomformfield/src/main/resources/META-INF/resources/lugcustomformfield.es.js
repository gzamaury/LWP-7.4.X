import React from 'react';
import {FieldBase} from 'dynamic-data-mapping-form-field-type/FieldBase/ReactFieldBase.es';

const HolaMundo = (props) => {
	console.log(props);
	return (
		<FieldBase {...props}>
			<h1>Hola Mundo!!!</h1>
		</FieldBase>
	)
}

export default HolaMundo;