package br.com.project.report.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils implements Serializable{

	private static final long serialVersionUID = 1L;

	public static String getDateAtualReportName() { 
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(Calendar.getInstance().getTime());
	}
	
	public static String formatSql(Date data) {
		StringBuffer retorno = new StringBuffer();
		DateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
		retorno.append("'");
		retorno.append(dtf.format(data));
		retorno.append("'");
		return retorno.toString();
	}
}
