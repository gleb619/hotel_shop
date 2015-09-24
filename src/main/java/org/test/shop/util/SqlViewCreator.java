/*
 * 
 */
package org.test.shop.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;



import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
//@Component
/**
 * The Class SqlViewCreator.
 */
public class SqlViewCreator {

	/**
	 * Instantiates a new sql view creator.
	 */
	public SqlViewCreator() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("SqlViewCreator: " +
			this.toString()
		);
		
	}

//	@Autowired
	/** The data source. */
private DataSource dataSource;
	
	/** The is init. */
	private Boolean isInit = true;
	
	/**
	 * Inits the.
	 *
	 * @return the sql view creator
	 */
	public SqlViewCreator init() {
		System.out.println("SqlViewCreator#init: " +
				"start at " + new Date().toInstant().toString()
		);
		
		Thread thread = new Thread(() -> {
			System.out.println("SqlViewCreator#init#thread: " +
					this.toString()
			);
			
			try {
				InputStream in = this.getClass().getClassLoader()
				        .getResourceAsStream("ddl_view.sql");
				String text = IOUtils.toString(in, "UTF-8");
				System.out.println("text.length(): " +
					text.length()
				);
				executeSqlScript(dataSource.getConnection(), text);
				
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		/*
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("SqlViewCreator#init#thread: " +
						this.toString()
				);
				
				try {
					InputStream in = this.getClass().getClassLoader()
					        .getResourceAsStream("ddl_view.sql");
					String text = IOUtils.toString(in, "UTF-8");
					System.out.println("text.length(): " +
						text.length()
					);
					executeSqlScript(dataSource.getConnection(), text);
					
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		*/
		
		if(!isInit){
			thread.start();
		}
		
		isInit = true;
		
		return this;
	}
	
	/**
	 * Execute sql script.
	 *
	 * @param conn the conn
	 * @param inputText the input text
	 */
	public void executeSqlScript(Connection conn, String inputText) {
		System.out.println("executeSqlScript: " +
				"start: " + conn
		);
		inputText = inputText.replaceAll(";", "#END;");
	    
	    List<String> list = Arrays.asList(inputText.split(";"));
	    System.out.println("prepare statements: " +
	    		list.size()
		);
	    
	    list.parallelStream().forEach(it -> {
	    	Statement currentStatement = null;
	    	String rawStatement = it.replaceAll("#END", ";");
	    	System.out.println("statement: \n" +
	    			rawStatement
			);
	    	
	        try {
	            currentStatement = conn.createStatement();
	            currentStatement.execute(rawStatement);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Release resources
	            if (currentStatement != null) {
	                try {
	                    currentStatement.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            currentStatement = null;
	        }
	    });
	    
	    /*
	    for (String string : list) {
	    	System.out.println("statement: " +
	    			string
			);
	    	String rawStatement = string.replaceAll("#END", ";");
	        try {
	            // Execute statement
	            currentStatement = conn.createStatement();
	            currentStatement.execute(rawStatement);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Release resources
	            if (currentStatement != null) {
	                try {
	                    currentStatement.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            
	            currentStatement = null;
	        }
		}
	    */
	}
	
}
