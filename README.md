# Gershwin Programming Language #

[![Build Status](http://gershwinlang.net:8998/jenkins/buildStatus/icon?job=gershwin)](http://gershwinlang.net:8998/jenkins/job/gershwin/)

Gershwin is a stack-based, concatenative programming language with a Clojure runtime that targets the JVM. It features a fusion of Clojure data structures, namespaces and concurrency semantics with an API inspired by the Factor concatenative programming language. With seamless Clojure interop, Gershwin can leverage all the power and reach of the Clojure/JVM ecosystem while also providing the unique features of stack-based, concatenative languages: composition by code concatenation, point-free expressions, data-flow combinators, and simple, powerful code factoring.

As an extension to Clojure, all legal Clojure code is legal Gershwin code. Gershwin changes to the Clojure reader, compiler, and public API are primarily additive and, as such, should not create compatibility conflicts with existing Clojure code bases. Please report any incompatibilities as bugs. The language versions of Gershwin and Clojure are both tracked in the Maven `pom.xml` file and available programmatically via the `gershwin-version` and `clojure-version` functions respectively.

## Open Source Tools ##

I would like to thank the following companies for providing their tools free of charge to Gershwin developers as part of their contribution to the Open Source community.

### JetBrains: Intellij IDEA ###

When I need to do Java, Scala, or JRuby development, I rely on Intellij IDEA's excellent support for JVM languages. I would like to thank JetBrains for granting Gershwin developers a free license to Intellij IDEA Ultimate.

<a href="http://www.jetbrains.com/idea/features/javascript.html" style="display:block; background:#0d3a9e url(http://www.jetbrains.com/idea/opensource/img/all/banners/idea468x60_blue.gif) no-repeat 10px 50%; border:solid 1px #0d3a9e; margin:0;padding:0;text-decoration:none;text-indent:0;letter-spacing:-0.001em; width:466px; height:58px" alt="Java IDE with advanced HTML/CSS/JS editor for hardcore web-developers" title="Intellij IDEA: Java IDE with advanced HTML/CSS/JS editor for hardcore web-developers"><span style="margin:0 0 0 205px;padding:18px 0 2px 0; line-height:13px;font-size:11px;cursor:pointer;  background-image:none;border:0;display:block; width:255px; color: #acc4f9; font-family: trebuchet ms,arial,sans-serif;font-weight: normal;text-align:left;">Intellij IDEA: Java IDE with advanced HTML/CSS/JS editor for hardcore web-developers</span></a>

## Licenses ##

This program uses the ASM bytecode engineering library which is distributed
with the following notice:

```
Copyright (c) 2000-2005 INRIA, France Telecom
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.

3. Neither the name of the copyright holders nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
THE POSSIBILITY OF SUCH DAMAGE.
```

--------------------------------------------------------------------------

This code base is a fork of the Clojure code base, and as such copyright and licensing notices have been left in place for Clojure code. The following notice applies to code developed for Clojure itself, but not to additions made for the Gershwin programming language.

```
 *   Clojure
 *   Copyright (c) Rich Hickey. All rights reserved.
 *   The use and distribution terms for this software are covered by the
 *   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *   which can be found in the file epl-v10.html at the root of this distribution.
 *   By using this software in any fashion, you are agreeing to be bound by
 * 	 the terms of this license.
 *   You must not remove this notice, or any other, from this software.
```

--------------------------------------------------------------------------

The following notice pertains to all additions to the Clojure code base unique to the Gershwin programming language:

```
 *   Gershwin
 *   Copyright (c) Daniel Gregoire. All rights reserved.
 *   The use and distribution terms for this software are covered by the
 *   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *   which can be found in the file epl-v10.html at the root of this distribution.
 *   By using this software in any fashion, you are agreeing to be bound by
 * 	 the terms of this license.
 *   You must not remove this notice, or any other, from this software.
```
