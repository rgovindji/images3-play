/*******************************************************************************
 * Copyright 2014 Rui Sun
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.images3.rest.exceptions;

import java.util.HashMap;
import java.util.Map;

import com.images3.exceptions.IllegalTemplateNameLengthException;

import play.libs.Json;
import play.mvc.Result;
import play.mvc.Results;

public class IllegalTemplateNameLengthExceptionMapper extends
        PreciseExceptionMapper {

    public IllegalTemplateNameLengthExceptionMapper(
            ExceptionMapper successor) {
        super(IllegalTemplateNameLengthException.class, successor);
    }

    @Override
    protected Result getResult(Throwable t) {
        IllegalTemplateNameLengthException exception = (IllegalTemplateNameLengthException) t;
        Map<String, Object> details = new HashMap<String, Object>();
        details.put("name", exception.getName());
        details.put("minLength", exception.getMinLength());
        details.put("maxLength", exception.getMaxLength());
        ErrorResponse response = new ErrorResponse(
                ErrorResponse.ILLEGAL_TEMPLATE_NAME_LENGTH, 
                details, 
                exception.getMessage());
        return Results.badRequest(Json.toJson(response));
    }

}
