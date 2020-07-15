package br.com.project.report.util;


import java.util.Calendar;

import org.junit.Test;

import junit.framework.TestCase;

public class testeJunit extends TestCase{

	@Test
	public void testData() {
		System.out.println(DateUtils.getDateAtualReportName());
		System.out.println(DateUtils.formatSql(Calendar.getInstance().getTime()));
	}

}
