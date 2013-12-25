// This is a generated file. Not intended for manual editing.
package com.goide.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.goide.GoTypes.*;
import com.goide.psi.*;

public class GoExprSwitchCaseImpl extends GoCompositeElementImpl implements GoExprSwitchCase {

  public GoExprSwitchCaseImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GoVisitor) ((GoVisitor)visitor).visitExprSwitchCase(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GoExpressionList getExpressionList() {
    return findChildByClass(GoExpressionList.class);
  }

  @Override
  @Nullable
  public PsiElement getCase() {
    return findChildByType(GO_CASE);
  }

  @Override
  @Nullable
  public PsiElement getDefault() {
    return findChildByType(GO_DEFAULT);
  }

}