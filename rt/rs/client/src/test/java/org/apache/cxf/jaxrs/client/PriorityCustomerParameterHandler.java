/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.cxf.jaxrs.client;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;


@Priority(Priorities.USER - 1)
public class PriorityCustomerParameterHandler implements ParamConverterProvider, ParamConverter<Customer> {

    @SuppressWarnings("unchecked")
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> cls, Type arg1, Annotation[] arg2) {
        if (Customer.class == cls) {
            return (ParamConverter<T>)this;
        }
        return null;
    }

    public Customer fromString(String s) throws IllegalArgumentException {
        Customer c = new Customer();
        c.setName(s);
        return c;
    }

    @Override
    public String toString(Customer arg0) throws IllegalArgumentException {
        return null;
    }
}
