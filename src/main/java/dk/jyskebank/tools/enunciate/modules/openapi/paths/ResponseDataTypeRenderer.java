/*
 * Copyright © 2017-2018 Jyske Bank
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
 */
package dk.jyskebank.tools.enunciate.modules.openapi.paths;

import com.webcohesion.enunciate.EnunciateLogger;
import com.webcohesion.enunciate.api.datatype.DataTypeReference;

import dk.jyskebank.tools.enunciate.modules.freemarker.Typed1ArgTemplateMethod;
import dk.jyskebank.tools.enunciate.modules.openapi.DataTypeReferenceRenderer;
import dk.jyskebank.tools.enunciate.modules.openapi.yaml.IndententationPrinter;

public class ResponseDataTypeRenderer extends Typed1ArgTemplateMethod<String, String> {
  @SuppressWarnings("unused") private final EnunciateLogger logger;
  private final DataTypeReference dataType;
  private String description;

  public ResponseDataTypeRenderer(EnunciateLogger logger, DataTypeReference dataType, String description) {
    super(String.class);
    this.logger = logger;
    this.dataType = dataType;
    this.description = description;
  }

  @Override
  protected String exec(String nextLineIndent) {
    IndententationPrinter ip = new IndententationPrinter(nextLineIndent);

    DataTypeReferenceRenderer.render(ip, dataType, description);
    return ip.toString();
  }
}