/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.abstractdocument;

import com.iluwatar.abstractdocument.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  1：不改变类的属性 扩展类任意属性集合
 *  2：扩展接口提供  不确定任意组件类型
 *  3：扩展接口 default 方法的使用，获取的是父类构造map中对应的key-value
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  public App() {
    LOGGER.info("Constructing parts and car");

    //对象本身具有的属性
    Map<String, Object> carProperties = new HashMap<>();
    carProperties.put(HasModel.PROPERTY, "300SL");
    carProperties.put(HasPrice.PROPERTY, 10000L);

    //额外扩展的属性
    Map<String, Object> wheelProperties = new HashMap<>();
    wheelProperties.put(HasType.PROPERTY, "wheel");
    wheelProperties.put(HasModel.PROPERTY, "15C");
    wheelProperties.put(HasPrice.PROPERTY, 100L);

    //额外扩展的属性
    Map<String, Object> doorProperties = new HashMap<>();
    doorProperties.put(HasType.PROPERTY, "door");
    doorProperties.put(HasModel.PROPERTY, "Lambo");
    doorProperties.put(HasPrice.PROPERTY, 300L);

    //对象扩展属性的集合
    carProperties.put(HasParts.PROPERTY, Arrays.asList(wheelProperties, doorProperties));

    Car car = new Car(carProperties);

    LOGGER.info("Here is our car:");
    LOGGER.info("->  model: {}", car.getModel().get());
    LOGGER.info("->  price: {}", car.getPrice().get());
    LOGGER.info("->  parts: ");

    Stream<Part> parts = car.getParts();
    parts.forEach(p -> LOGGER.info("\t {}/{}/{}", p.getType().get(), p.getModel().get(), p.getPrice().get()));

  }

  /**
   * Program entry point
   *
   * @param args command line args
   */
  public static void main(String[] args) {
    new App();
  }

}
