/*
 * Copyright 2013-2014 Sergey Ignatov, Alexander Zolotov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.goide.inspections.unresolved;

import com.goide.psi.GoFile;
import com.goide.psi.GoTopLevelDeclaration;
import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class GoUnresolvedFixBase extends LocalQuickFixAndIntentionActionOnPsiElement {
  @NotNull protected final String myName;
  @NotNull protected final String myWhat;

  public GoUnresolvedFixBase(@NotNull PsiElement element, @NotNull String name, @NotNull String what) {
    super(element);
    myName = name;
    myWhat = what;
  }

  @Nullable
  protected static GoTopLevelDeclaration getTopLevelDeclaration(PsiElement startElement) {
    GoTopLevelDeclaration decl = PsiTreeUtil.getTopmostParentOfType(startElement, GoTopLevelDeclaration.class);
    if (decl == null || !(decl.getParent() instanceof GoFile)) return null;
    return decl;
  }

  @NotNull
  @Override
  public String getText() {
    return "Create " + myWhat + " '" + myName + "'";
  }

  @NotNull
  @Override
  public String getFamilyName() {
    return "Go";
  }
}