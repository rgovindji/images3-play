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

import com.images3.exceptions.DuplicateImageVersionException;

import play.libs.Json;
import play.mvc.Result;
import play.mvc.Results;

public class DuplicateImageVersionExceptionMapper extends
        PreciseExceptionMapper {

    public DuplicateImageVersionExceptionMapper(
            ExceptionMapper successor) {
        super(DuplicateImageVersionException.class, successor);
    }

    @Override
    protected Result getResult(Throwable t) {
        DuplicateImageVersionException exception = (DuplicateImageVersionException) t;
        Map<String, Object> details = new HashMap<String, Object>();
        details.put("version", exception.getVersion());
        ErrorResponse response = new ErrorResponse(
                ErrorResponse.DUPLICATE_IMAGE_VERSION, 
                details, 
                exception.getMessage());
        return Results.badRequest(Json.toJson(response));
    }

}
