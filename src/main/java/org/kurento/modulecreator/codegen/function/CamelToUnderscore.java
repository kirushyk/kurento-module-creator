/*
 * (C) Copyright 2016 Kurento (http://kurento.org/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.kurento.modulecreator.codegen.function;

import java.util.List;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class CamelToUnderscore implements TemplateMethodModelEx {

  @Override
  public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {

    Object typeName = arguments.get(0);

    String regex = "([a-z])([A-Z])";
    String replacement = "$1_$2";
    // return ((String) typeName).replaceAll(regex, replacement);
    return typeName.toString().replaceAll(regex, replacement).toUpperCase();
  }

}
