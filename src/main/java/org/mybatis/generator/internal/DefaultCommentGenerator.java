/*
 *  Copyright 2008 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.mybatis.generator.internal;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;

/**
 * The Class DefaultCommentGenerator.
 *
 * @author Jeff Butler
 */
public class DefaultCommentGenerator implements CommentGenerator {

	/** The properties. */
	private Properties properties;

	/** The suppress date. */
	private boolean suppressDate;

	/** The suppress all comments. */
	private boolean suppressAllComments;

	/**
	 * Instantiates a new default comment generator.
	 */
	public DefaultCommentGenerator() {
		super();
		properties = new Properties();
		suppressDate = false;
		suppressAllComments = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addJavaFileComment(org.mybatis
	 * .generator.api.dom.java.CompilationUnit)
	 */
	public void addJavaFileComment(CompilationUnit compilationUnit) {
		// add no file level comments by default
		return;
	}

	/**
	 * Adds a suitable comment to warn users that the element was generated, and
	 * when it was generated.
	 *
	 * @param xmlElement
	 *        the xml element
	 */
	public void addComment(XmlElement xmlElement) {
		if (suppressAllComments) {
			return;
		}

		xmlElement.addElement(new TextElement("<!--")); //$NON-NLS-1$

		StringBuilder sb = new StringBuilder();
//		sb.append("  WARNING - "); //$NON-NLS-1$
//		sb.append(MergeConstants.NEW_ELEMENT_TAG);
//		xmlElement.addElement(new TextElement(sb.toString()));
		xmlElement.addElement(new TextElement(" WARNING -  该映射文件为自动生成, 请勿修改.")); //$NON-NLS-1$

		String s = getDateString();
		if (s != null) {
			sb.setLength(0);
			sb.append("  This element was generated on "); //$NON-NLS-1$
			sb.append(s);
			sb.append('.');
			xmlElement.addElement(new TextElement(sb.toString()));
		}

		xmlElement.addElement(new TextElement("-->")); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addRootComment(org.mybatis
	 * .generator.api.dom.xml.XmlElement)
	 */
	public void addRootComment(XmlElement rootElement) {
		// add no document level comments by default
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addConfigurationProperties
	 * (java.util.Properties)
	 */
	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);

		suppressDate = isTrue(properties
						.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));

		suppressAllComments = isTrue(properties
						.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
	}

	/**
	 * This method adds the custom javadoc tag for. You may do nothing if you do
	 * not wish to include the Javadoc tag - however, if you do not include the
	 * Javadoc tag then the Java merge capability of the eclipse plugin will
	 * break.
	 *
	 * @param javaElement
	 *        the java element
	 * @param markAsDoNotDelete
	 *        the mark as do not delete
	 */
	protected void addJavadocTag(JavaElement javaElement,
					boolean markAsDoNotDelete) {
		//		javaElement.addJavaDocLine(" *"); //$NON-NLS-1$
		StringBuilder sb = new StringBuilder();
		sb.append(" * "); //$NON-NLS-1$
		// sb.append(MergeConstants.NEW_ELEMENT_TAG);
		// if (markAsDoNotDelete) {
		//			sb.append(" do_not_delete_during_merge"); //$NON-NLS-1$
		// }

		// String s = getDateString();
		// if (s != null) {
		// sb.append(' ');
		// sb.append(s);
		// }
//		sb.append("创建时间 : ");
//		sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//						.format(new Date()));
		javaElement.addJavaDocLine(sb.toString());
	}

	/**
	 * This method returns a formated date string to include in the Javadoc tag
	 * and XML comments. You may return null if you do not want the date in
	 * these documentation elements.
	 * 
	 * @return a string representing the current timestamp, or null
	 */
	protected String getDateString() {
		if (suppressDate) {
			return null;
		} else {
			return new Date().toString();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addClassComment(org.mybatis
	 * .generator.api.dom.java.InnerClass,
	 * org.mybatis.generator.api.IntrospectedTable)
	 */
	public void addClassComment(InnerClass innerClass,
					IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		innerClass.addJavaDocLine("/**"); //$NON-NLS-1$
//		innerClass.addJavaDocLine(" * This class was generated by MyBatis Generator."); //$NON-NLS-1$
//
//		sb.append(" * This class corresponds to the database table "); //$NON-NLS-1$
//		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append(" * "+introspectedTable.getFullyQualifiedTable()+"表的操作类"); //$NON-NLS-1$
		innerClass.addJavaDocLine(sb.toString());

		addJavadocTag(innerClass, false);

		innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addEnumComment(org.mybatis
	 * .generator.api.dom.java.InnerEnum,
	 * org.mybatis.generator.api.IntrospectedTable)
	 */
	public void addEnumComment(InnerEnum innerEnum,
					IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		innerEnum.addJavaDocLine("/**"); //$NON-NLS-1$
		innerEnum
						.addJavaDocLine(" * This enum was generated by MyBatis Generator."); //$NON-NLS-1$

		sb.append(" * This enum corresponds to the database table "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTable());
		innerEnum.addJavaDocLine(sb.toString());

		addJavadocTag(innerEnum, false);

		innerEnum.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addFieldComment(org.mybatis
	 * .generator.api.dom.java.Field,
	 * org.mybatis.generator.api.IntrospectedTable,
	 * org.mybatis.generator.api.IntrospectedColumn)
	 */
	public void addFieldComment(Field field,
					IntrospectedTable introspectedTable,
					IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		field.addJavaDocLine("/**"); //$NON-NLS-1$
		if (StringUtils.isEmpty(introspectedColumn.getRemarks())) {
			field.addJavaDocLine(" * This field was generated by MyBatis Generator."); //$NON-NLS-1$
			sb.append(" * This field corresponds to the database column "); //$NON-NLS-1$
		} else {
			sb.append(" * " + introspectedColumn.getRemarks() + " -- "); //$NON-NLS-1$
		}
		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append('.');
		sb.append(introspectedColumn.getActualColumnName());
		field.addJavaDocLine(sb.toString());

		addJavadocTag(field, false);

		field.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addFieldComment(org.mybatis
	 * .generator.api.dom.java.Field,
	 * org.mybatis.generator.api.IntrospectedTable)
	 */
	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		field.addJavaDocLine("/**"); //$NON-NLS-1$
		//		field.addJavaDocLine(" * This field was generated by MyBatis Generator."); //$NON-NLS-1$
		//		sb.append(" * This field corresponds to the database table "); //$NON-NLS-1$
		// sb.append(introspectedTable.getFullyQualifiedTable());

		sb.append(" * " + introspectedTable.getFullyQualifiedTable() + "表的操作属性:" + field.getName()); //$NON-NLS-1$
		field.addJavaDocLine(sb.toString());

		addJavadocTag(field, false);

		field.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addGeneralMethodComment(org
	 * .mybatis.generator.api.dom.java.Method,
	 * org.mybatis.generator.api.IntrospectedTable)
	 */
	public void addGeneralMethodComment(Method method,
					IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		method.addJavaDocLine("/**"); //$NON-NLS-1$
		//		method.addJavaDocLine(" * This method was generated by MyBatis Generator."); //$NON-NLS-1$
		//
		//		sb.append(" * This method corresponds to the database table "); //$NON-NLS-1$
		// sb.append(introspectedTable.getFullyQualifiedTable());

		sb.append(" * " + introspectedTable.getFullyQualifiedTable());
		sb.append("数据表的操作方法: " + method.getName() + "  "); //$NON-NLS-1$

		method.addJavaDocLine(sb.toString());
		
		if(introspectedTable.getLastInsertIdStatementId().equals(method.getName())){
			method.addJavaDocLine(" * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）");
			method.addJavaDocLine(" * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。");
		}

		addJavadocTag(method, false);

		method.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addGetterComment(org.mybatis
	 * .generator.api.dom.java.Method,
	 * org.mybatis.generator.api.IntrospectedTable,
	 * org.mybatis.generator.api.IntrospectedColumn)
	 */
	public void addGetterComment(Method method,
					IntrospectedTable introspectedTable,
					IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		method.addJavaDocLine("/**"); //$NON-NLS-1$
//		method.addJavaDocLine(" * This method was generated by MyBatis Generator."); //$NON-NLS-1$

//		sb.append(" * This method returns the value of the database column "); //$NON-NLS-1$
//		sb.append(introspectedTable.getFullyQualifiedTable());
//		sb.append('.');
//		sb.append(introspectedColumn.getActualColumnName());
		
		sb.append(" * 数据字段 "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append('.');
		sb.append(introspectedColumn.getActualColumnName());
		sb.append("的get方法 "); //$NON-NLS-1$
		method.addJavaDocLine(sb.toString());

//		method.addJavaDocLine(" *"); //$NON-NLS-1$

//		sb.setLength(0);
//		sb.append(" * @return the value of "); //$NON-NLS-1$
//		sb.append(introspectedTable.getFullyQualifiedTable());
//		sb.append('.');
//		sb.append(introspectedColumn.getActualColumnName());
//		method.addJavaDocLine(sb.toString());

		addJavadocTag(method, false);

		method.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addSetterComment(org.mybatis
	 * .generator.api.dom.java.Method,
	 * org.mybatis.generator.api.IntrospectedTable,
	 * org.mybatis.generator.api.IntrospectedColumn)
	 */
	public void addSetterComment(Method method,
					IntrospectedTable introspectedTable,
					IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		method.addJavaDocLine("/**"); //$NON-NLS-1$
//		method.addJavaDocLine(" * This method was generated by MyBatis Generator."); //$NON-NLS-1$
//
//		sb.append(" * This method sets the value of the database column "); //$NON-NLS-1$
//		sb.append(introspectedTable.getFullyQualifiedTable());
//		sb.append('.');
//		sb.append(introspectedColumn.getActualColumnName());
		sb.append(" * 数据字段 "); //$NON-NLS-1$
		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append('.');
		sb.append(introspectedColumn.getActualColumnName());
		sb.append("的set方法");
		method.addJavaDocLine(sb.toString());

//		method.addJavaDocLine(" *"); //$NON-NLS-1$

//		Parameter parm = method.getParameters().get(0);
//		sb.setLength(0);
//		sb.append(" * @param "); //$NON-NLS-1$
//		sb.append(parm.getName());
//		sb.append(" the value for "); //$NON-NLS-1$
//		sb.append(introspectedTable.getFullyQualifiedTable());
//		sb.append('.');
//		sb.append(introspectedColumn.getActualColumnName());
//		method.addJavaDocLine(sb.toString());

		addJavadocTag(method, false);

		method.addJavaDocLine(" */"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.generator.api.CommentGenerator#addClassComment(org.mybatis
	 * .generator.api.dom.java.InnerClass,
	 * org.mybatis.generator.api.IntrospectedTable, boolean)
	 */
	public void addClassComment(InnerClass innerClass,
					IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
		if (suppressAllComments) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		innerClass.addJavaDocLine("/**"); //$NON-NLS-1$
//		innerClass
//						.addJavaDocLine(" * This class was generated by MyBatis Generator."); //$NON-NLS-1$
//
//		sb.append(" * This class corresponds to the database table "); //$NON-NLS-1$
//		sb.append(introspectedTable.getFullyQualifiedTable());
		sb.append(" * "+introspectedTable.getFullyQualifiedTable()+"表的操作类"); //$NON-NLS-1$
		innerClass.addJavaDocLine(sb.toString());

		addJavadocTag(innerClass, markAsDoNotDelete);

		innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
	}
}
