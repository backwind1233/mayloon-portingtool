package com.intel.ide.eclipse.mpt.ast;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;

/**
 * Records changes to an AST using {@link ASTRewrite}.
 *
 */
public class ASTRewriteBasedManipulator extends AbstractManipulator {
	private ASTRewrite mRewrite;
	private AST mAST;
	private CompilationUnit mUnit;
	
	public ASTRewriteBasedManipulator(CompilationUnit unit) {
		// create the rewrite instance for "unit"
		mAST = unit.getAST();
		mRewrite = ASTRewrite.create(mAST);
		mUnit = unit;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.sourceforge.earticleast.app.AbstractManipulator#beforeManipulate(org.eclipse.jdt.core.dom.CompilationUnit)
	 */
	@Override
	protected void beforeManipulate(CompilationUnit unit) {
		super.beforeManipulate(unit);
		
	}

	/*
	 * (non-Javadoc)
	 *
	 */
	@Override
	protected void afterManipulate(CompilationUnit unit) {
		super.afterManipulate(unit);
		try {
			// write changes back to Java source code
			ManipulatorHelper.saveASTRewriteContents(unit, mRewrite);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * (non-Javadoc)
	 *
	 */
	@Override
	protected void addNewNativeMethodDeclaration(NativeMethodBindingManager manager) {
		
		MethodDeclaration methodDecl = manager.getNativeMethodDeclarationNode();		
		
		MethodDeclaration methodStub = createNewMethodDeclaration(
				manager, mAST, mRewrite);
		
//		ListRewrite listRewrite  = mRewrite.getListRewrite(methodDecl, MethodDeclaration.MODIFIERS2_PROPERTY);
		
//		listRewrite.insertAt(methodStub, 0, null);
		mRewrite.replace(methodDecl, methodStub, null);
	}

	/*
	 * (non-Javadoc)
	 *
	 */
	@Override
	protected void deleteOldNativeMethodDeclaration(NativeMethodBindingManager manager) {		
		mRewrite.remove(manager.getNativeMethodDeclarationNode(), null);	
	}

	@Override
	protected void addNewStubMethodDeclaration(StubMethodBindingManager manager) {
		
		MethodDeclaration methodDecl = manager.getStubMethodDeclarationNode();		
		
		MethodDeclaration methodStub = createNewMethodDeclaration4Normal(
				manager, mAST, mRewrite);
		
//		ListRewrite listRewrite  = mRewrite.getListRewrite(methodDecl, MethodDeclaration.MODIFIERS2_PROPERTY);
		
		mRewrite.replace(methodDecl, methodStub, null);
//		listRewrite.insertAt(methodStub, 0, null);
		
	}

	@Override
	protected void deleteOldStubMethodDeclaration(
			StubMethodBindingManager manager) {
		mRewrite.remove(manager.getStubMethodDeclarationNode(), null);
		
	}
	
}