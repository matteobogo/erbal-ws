//package com.erbal.validation;
//
//import com.erbal.domain.TerrainNodeData;
//import com.erbal.utils.SensorsDataParams;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//@Component
//public class TerrainSensorsDataValidator implements Validator {
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return TerrainNodeData.class.equals(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        //
//        ValidationUtils.rejectIfEmptyOrWhitespace(
//                errors,
//                SensorsDataParams.SENSOR_TYPE,
//                SensorsDataParams.SENSOR_TYPE+".required");
//    }
//}