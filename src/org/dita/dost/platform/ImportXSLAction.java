/*
 * This file is part of the DITA Open Toolkit project hosted on
 * Sourceforge.net. See the accompanying license.txt file for 
 * applicable licenses.
 */
package org.dita.dost.platform;

import org.dita.dost.util.Constants;
import org.dita.dost.util.FileUtils;
import org.dita.dost.util.StringUtils;
/**
 * ImportXSLAction class.
 *
 */
public class ImportXSLAction extends ImportAction {

	private final StringBuffer retBuf;
	/**
	 * Constructor.
	 */
	public ImportXSLAction() {
		super();
		retBuf = new StringBuffer(Constants.INT_1024);
	}
	/**
	 * get result.
	 * @return result
	 */
	@Override
	public String getResult() {
		final String templateFilePath = paramTable.get(FileGenerator.PARAM_TEMPLATE);
		for (final String value: valueSet) {
			retBuf.append(Constants.LINE_SEPARATOR);
			retBuf.append("<xsl:import href=\"");				
			retBuf.append(StringUtils.escapeXML(
					FileUtils.getRelativePathFromMap(
							templateFilePath, value)));
			retBuf.append("\"/>");
		}
		return retBuf.toString();
	}

}
