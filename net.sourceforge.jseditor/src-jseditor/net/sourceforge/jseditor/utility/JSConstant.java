package net.sourceforge.jseditor.utility;

public class JSConstant {
	public static boolean isFirstTime=true;
	public static boolean isDoubleClicked=false;
	//每次调用JSDoubleClickStrategy的函数的时候，将doubleClickTag设置成0;
	public static int doubleClickTag=1;
	public static final int stringOffsetLength =600;
	public static String load_pattern_tag="default";
	//default innerClassLevel=0,when meet push,innerClassLevel++,when pop,innerClassLevel--
	public static int innerClassLevel =0;
	//when scan the document from the beginning,judge whether it is the first class of the document
	public static boolean isFirstClass=true;
	public static final String Keyword_declarePackage="Clazz.declarePackage";
	public static final String Keyword_load="Clazz.load";
	public static final String Keyword_declareType="Clazz.declareType";
	public static final String Keyword_makeConstructor="Clazz.makeConstructor";
	public static final String Keyword_defineMethod="Clazz.defineMethod";
	public static final String Keyword_overrideMethod="Clazz.overrideMethod";
	public static final String Keyword_decorateasclass="Clazz.instantialize";
	

}
