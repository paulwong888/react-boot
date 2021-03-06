/*
 * Copyright 2015 Sebastian Gil.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.create.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * HTTP error handler.
 */
@Controller
public class ErrorController {
    public static String NOT_FOUND_TEMPLATE = "error/404";

    public static String INTERNAL_SERVER_ERROR_TEMPLATE = "error/error";

    @RequestMapping(value = "/error/404", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String showNotFound() {
        return NOT_FOUND_TEMPLATE;
    }

    @RequestMapping(value = "/error/error", method = RequestMethod.GET)
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String showInternalServerError() {
        return INTERNAL_SERVER_ERROR_TEMPLATE;
    }
}
