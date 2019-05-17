/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.acyclicvisitor;

/**
 *再议访问者模式
 * 1：Visitor 接口扩展  方法
 * 2：具体Visitor接口实现扩展不同的行为
 * 3：适用于对象内部方法新增或变动频繁，针对扩展Visitor接口实现 来动态扩展对象方法
 *
 */
public class App {

  public static void main(String[] args) {
    EncryptVisitor md5EncryptVisitor = new MD5EncryptVisitor();
    EncryptVisitor hexEncryptVisitor = new HexEncryptVisitor();

    MobileClient mobileClient = new MobileClient();
    mobileClient.accept(md5EncryptVisitor);
    mobileClient.accept(hexEncryptVisitor);

    System.out.println("----分割线----");

    WebClient webClient = new WebClient();
    webClient.accept(md5EncryptVisitor);
    webClient.accept(hexEncryptVisitor);
  }
}
